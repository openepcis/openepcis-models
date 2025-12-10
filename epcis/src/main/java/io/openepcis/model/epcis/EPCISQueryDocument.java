/*
 * Copyright 2022-2024 benelog GmbH & Co. KG
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
import io.openepcis.model.epcis.constants.CommonConstants;
import io.openepcis.model.epcis.modifier.CommonExtensionModifier;
import io.openepcis.model.epcis.modifier.CustomInstantAdapter;
import io.openepcis.model.epcis.modifier.OffsetDateTimeSerializer;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.openepcis.model.epcis.constants.CommonConstants.CONTEXT_URLS;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private static final Pattern EPCIS_CTX_PATTERN = Pattern.compile(
            "^https://ref\\.gs1\\.org/standards/epcis/([0-9]+\\.[0-9]+\\.[0-9]+)/epcis-context\\.jsonld$");


    public EPCISQueryDocument(EPCISQueryBody epcisBody, Optional<String> epcisVersionMax) {
        this.epcisBody = epcisBody;
        this.type = CommonConstants.EPCIS_QUERY_DOC;
        this.schemaVersion = CommonConstants.SCHEMA_VERSION;
        this.creationDate = OffsetDateTime.now();
        this.epcisVersionMax = epcisVersionMax.orElse(null);
        this.context = getContextInfoFromEventList(epcisBody.getQueryResults().getResultsBody().getEventList(), this.epcisVersionMax);

        // Populating the namespaces directly from context during xml query
        CommonExtensionModifier.populateNamespaces(context);
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

        final String capturedVersion = m.group(1);

        if (StringUtils.isNotBlank(epcisVersionMax) &&
                capturedVersion.equals(epcisVersionMax)) {
            return CommonConstants.EPCIS_DEFAULT_NAMESPACE;
        }
        // otherwise keep the versioned URL as is
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
        urlContexts.stream()
                .map(url -> resolveContextUrl(url, epcisVersionMax))
                .filter(url -> !result.contains(url))
                .forEach(result::add);

        // Add map-based contexts
        result.addAll(mapContexts);

        // Clear event-level context data
        events.forEach(e -> e.setContextInfo(null));

        return result;
    }

    private void extractUrlContexts(Map<String, Object> map, Set<String> urlContexts) {
        Object value = map.get(CONTEXT_URLS);
        if (value instanceof List<?> list) {
            list.stream()
                    .filter(item -> item instanceof String)
                    .map(String.class::cast)
                    .forEach(urlContexts::add);
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
        if (epcisVersionMax.isEmpty()) {
            return CommonConstants.EPCIS_DEFAULT_NAMESPACE;
        }
        return resolveContextUrl(CommonConstants.EPCIS_DEFAULT_NAMESPACE, epcisVersionMax);
    }

}
