/*
 * Copyright 2022-2026 benelog GmbH & Co. KG
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */
package io.openepcis.model.epcis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.openepcis.constants.EPCISVersion;
import io.openepcis.model.epcis.constants.CommonConstants;
import io.openepcis.model.epcis.modifier.CommonExtensionModifier;
import io.openepcis.model.epcis.modifier.CustomInstantAdapter;
import io.openepcis.model.epcis.modifier.OffsetDateTimeSerializer;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static io.openepcis.model.epcis.constants.CommonConstants.CONTEXT_URLS;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "EPCISQueryDocument", namespace = "urn:epcglobal:epcis-query:xsd:2")
@XmlType(propOrder = {"epcisHeader", "epcisBody"})
@XmlAccessorType(XmlAccessType.FIELD)
public class EPCISQueryDocument {
    @JsonProperty("@context")
    @XmlTransient
    private List<Object> context;
    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @XmlTransient
    private String id;
    @JsonProperty("type")
    @XmlTransient
    private String type;
    @JsonProperty("schemaVersion")
    @XmlAttribute
    private String schemaVersion;
    @JsonProperty("creationDate")
    @XmlAttribute(name = "creationDate")
    @XmlJavaTypeAdapter(CustomInstantAdapter.class)
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime creationDate;
    @JsonProperty("epcisBody")
    @XmlElement(name = "EPCISBody", required = true)
    private EPCISQueryBody epcisBody;
    @JsonIgnore
    @XmlElement(name = "EPCISHeader")
    private EPCISHeader epcisHeader;
    @JsonIgnore
    @XmlTransient
    private String epcisVersionMax;
    // Regex to detect versioned GS1 EPCIS context URLs
    private static final Pattern EPCIS_CTX_PATTERN = Pattern.compile("^https://ref\\.gs1\\.org/standards/epcis/([0-9]+\\.[0-9]+\\.[0-9]+)/epcis-context\\.jsonld$");

    public EPCISQueryDocument(EPCISQueryBody epcisBody, Optional<String> epcisVersionMax) {
        this.epcisBody = epcisBody;
        this.type = CommonConstants.EPCIS_QUERY_DOC;
        this.schemaVersion = CommonConstants.SCHEMA_VERSION;
        this.creationDate = OffsetDateTime.now();
        this.epcisVersionMax = epcisVersionMax.orElse(null);
        this.context = getContextInfoFromEventList(epcisBody.getQueryResults().getResultsBody().getEventList(), this.epcisVersionMax);
        // Populating the namespaces directly from context during xml query
        CommonExtensionModifier.populateNamespaces(context, null);
    }

    /**
     * Constructor for backward compatibility.
     * @param epcisBody the EPCIS query body
     * @deprecated Use {@link #EPCISQueryDocument(EPCISQueryBody, Optional)} instead.
     *             This constructor will be removed in a future version.
     */
    @Deprecated(forRemoval = true)
    public EPCISQueryDocument(EPCISQueryBody epcisBody) {
        this(epcisBody, Optional.empty());
    }

    private static String resolveContextUrl(final String url, final String epcisVersionMax) {
        final Matcher m = EPCIS_CTX_PATTERN.matcher(url);
        if (!m.matches()) {
            return url; // not a recognized GS1 EPCIS context URL
        }
        if (StringUtils.isBlank(epcisVersionMax)) {
            return url;
        }
        final String capturedVersion = m.group(1);
        // Normalise to the unversioned (latest) URL whenever the platform
        // supports at least the captured version. Strict equality was too
        // narrow: a 2.0.0 captured URL on a 2.0.1 platform should still
        // collapse to the canonical unversioned form, otherwise mixed-vintage
        // result sets emit both `.../epcis/epcis-context.jsonld` and
        // `.../epcis/<version>/epcis-context.jsonld` side by side.
        final Optional<EPCISVersion> captured = EPCISVersion.fromString(capturedVersion);
        final Optional<EPCISVersion> platform = EPCISVersion.fromString(epcisVersionMax);
        if (captured.isPresent() && platform.isPresent() && captured.get().compareTo(platform.get()) <= 0) {
            return CommonConstants.EPCIS_DEFAULT_NAMESPACE;
        }
        // Unknown / future version: keep the versioned URL as is.
        return url;
    }

    private List<Object> getContextInfoFromEventList(List<? extends EPCISEvent> events, String epcisVersionMax) {
        final List<Object> result = new ArrayList<>();
        // If no events → return default context
        if (CollectionUtils.isEmpty(events)) {
            result.add(CommonConstants.EPCIS_DEFAULT_NAMESPACE);
            return result;
        }
        final Set<String> urlContexts = new LinkedHashSet<>();
        final List<Map<String, Object>> mapContexts = new ArrayList<>();
        // Extract context info from each event
        for (EPCISEvent event : events) {
            if (event.getContextInfo() == null) continue;
            for (Object ctx : event.getContextInfo()) {
                if (ctx instanceof String s) {
                    urlContexts.add(s);
                    continue;
                }
                Map<String, Object> map = extractMapContext(ctx);
                if (map == null) continue;
                extractUrlContexts(map, urlContexts);
                // remove synthetic key
                map.remove(CONTEXT_URLS);
                if (!map.isEmpty()) {
                    mapContexts.add(map);
                }
            }
        }
        // Add default context when no URL context is present
        if (urlContexts.isEmpty()) {
            result.add(normalizeDefaultContext(epcisVersionMax));
        }
        // Add normalized URL contexts without duplication
        urlContexts.stream().map(url -> resolveContextUrl(url, epcisVersionMax)).filter(url -> !result.contains(url)).forEach(result::add);
        // Add map-based contexts
        result.addAll(mapContexts);
        // Clear event-level context data
        events.forEach(e -> e.setContextInfo(null));
        return result;
    }

    private void extractUrlContexts(Map<String, Object> map, Set<String> urlContexts) {
        Object value = map.get(CONTEXT_URLS);
        if (value instanceof List<?> list) {
            list.stream().filter(item -> item instanceof String).map(String.class::cast).forEach(urlContexts::add);
        }
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> extractMapContext(Object ctx) {
        // Direct Map → convert keys to String
        if (ctx instanceof Map<?, ?> m) {
            Map<String, Object> result = new LinkedHashMap<>();
            m.forEach((k, v) -> result.put(String.valueOf(k), v));
            return result;
        }
        // Convert unknown object type via Jackson
        try {
            return new ObjectMapper().convertValue(ctx, LinkedHashMap.class);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private String normalizeDefaultContext(String epcisVersionMax) {
        if (epcisVersionMax == null || epcisVersionMax.isEmpty()) {
            return CommonConstants.EPCIS_DEFAULT_NAMESPACE;
        }
        return resolveContextUrl(CommonConstants.EPCIS_DEFAULT_NAMESPACE, epcisVersionMax);
    }

    public List<Object> getContext() {
        return this.context;
    }

    public String getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public String getSchemaVersion() {
        return this.schemaVersion;
    }

    public OffsetDateTime getCreationDate() {
        return this.creationDate;
    }

    public EPCISQueryBody getEpcisBody() {
        return this.epcisBody;
    }

    public EPCISHeader getEpcisHeader() {
        return this.epcisHeader;
    }

    public String getEpcisVersionMax() {
        return this.epcisVersionMax;
    }

    public void setContext(List<Object> context) {
        this.context = context;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSchemaVersion(String schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    public void setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setEpcisBody(EPCISQueryBody epcisBody) {
        this.epcisBody = epcisBody;
    }

    public void setEpcisHeader(EPCISHeader epcisHeader) {
        this.epcisHeader = epcisHeader;
    }

    public void setEpcisVersionMax(String epcisVersionMax) {
        this.epcisVersionMax = epcisVersionMax;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof EPCISQueryDocument)) return false;
        EPCISQueryDocument other = (EPCISQueryDocument) o;
        if (!other.canEqual((Object) this)) return false;
        Object this$context = this.getContext();
        Object other$context = other.getContext();
        if (this$context == null ? other$context != null : !this$context.equals(other$context)) return false;
        Object this$id = this.getId();
        Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        Object this$schemaVersion = this.getSchemaVersion();
        Object other$schemaVersion = other.getSchemaVersion();
        if (this$schemaVersion == null ? other$schemaVersion != null : !this$schemaVersion.equals(other$schemaVersion)) return false;
        Object this$creationDate = this.getCreationDate();
        Object other$creationDate = other.getCreationDate();
        if (this$creationDate == null ? other$creationDate != null : !this$creationDate.equals(other$creationDate)) return false;
        Object this$epcisBody = this.getEpcisBody();
        Object other$epcisBody = other.getEpcisBody();
        if (this$epcisBody == null ? other$epcisBody != null : !this$epcisBody.equals(other$epcisBody)) return false;
        Object this$epcisHeader = this.getEpcisHeader();
        Object other$epcisHeader = other.getEpcisHeader();
        if (this$epcisHeader == null ? other$epcisHeader != null : !this$epcisHeader.equals(other$epcisHeader)) return false;
        Object this$epcisVersionMax = this.getEpcisVersionMax();
        Object other$epcisVersionMax = other.getEpcisVersionMax();
        if (this$epcisVersionMax == null ? other$epcisVersionMax != null : !this$epcisVersionMax.equals(other$epcisVersionMax)) return false;
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof EPCISQueryDocument;
    }

    @Override
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $context = this.getContext();
        result = result * PRIME + ($context == null ? 43 : $context.hashCode());
        Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        Object $schemaVersion = this.getSchemaVersion();
        result = result * PRIME + ($schemaVersion == null ? 43 : $schemaVersion.hashCode());
        Object $creationDate = this.getCreationDate();
        result = result * PRIME + ($creationDate == null ? 43 : $creationDate.hashCode());
        Object $epcisBody = this.getEpcisBody();
        result = result * PRIME + ($epcisBody == null ? 43 : $epcisBody.hashCode());
        Object $epcisHeader = this.getEpcisHeader();
        result = result * PRIME + ($epcisHeader == null ? 43 : $epcisHeader.hashCode());
        Object $epcisVersionMax = this.getEpcisVersionMax();
        result = result * PRIME + ($epcisVersionMax == null ? 43 : $epcisVersionMax.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EPCISQueryDocument(context=" + this.getContext() + ", id=" + this.getId() + ", type=" + this.getType() + ", schemaVersion=" + this.getSchemaVersion() + ", creationDate=" + this.getCreationDate() + ", epcisBody=" + this.getEpcisBody() + ", epcisHeader=" + this.getEpcisHeader() + ", epcisVersionMax=" + this.getEpcisVersionMax() + ")";
    }

    public EPCISQueryDocument() {
    }

    public EPCISQueryDocument(List<Object> context, String id, String type, String schemaVersion, OffsetDateTime creationDate, EPCISQueryBody epcisBody, EPCISHeader epcisHeader, String epcisVersionMax) {
        this.context = context;
        this.id = id;
        this.type = type;
        this.schemaVersion = schemaVersion;
        this.creationDate = creationDate;
        this.epcisBody = epcisBody;
        this.epcisHeader = epcisHeader;
        this.epcisVersionMax = epcisVersionMax;
    }
}
