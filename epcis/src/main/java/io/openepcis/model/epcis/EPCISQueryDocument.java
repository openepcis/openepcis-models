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
import io.openepcis.model.epcis.exception.QueryExecutionException;
import io.openepcis.model.epcis.modifier.CommonExtensionModifier;
import io.openepcis.model.epcis.modifier.CustomInstantAdapter;
import io.openepcis.model.epcis.modifier.OffsetDateTimeSerializer;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

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

  public EPCISQueryDocument(EPCISQueryBody epcisBody) {
    this.epcisBody = epcisBody;
    this.type = CommonConstants.EPCIS_QUERY_DOC;
    this.schemaVersion = CommonConstants.SCHEMA_VERSION;
    this.creationDate = OffsetDateTime.now();
    this.context =
        getContextInfoFromEventList(epcisBody.getQueryResults().getResultsBody().getEventList());

    // Populating the namespaces directly from context during xml query
    CommonExtensionModifier.populateNamespaces(context);
  }

  private List<Object> getContextInfoFromEventList(List<? extends EPCISEvent> epcisEvents) {
    final List<Object> contextInfoList = new ArrayList<>();

    contextInfoList.add(CommonConstants.EPCIS_DEFAULT_NAMESPACE);
    if (CollectionUtils.isEmpty(epcisEvents)) {
      return contextInfoList;
    }

    final Map<String, Object> contextInfoMap =
        epcisEvents.stream()
            .map(this::convertContextInfoToMap)
            .filter(map -> !map.isEmpty())
            .flatMap(map -> map.entrySet().stream())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a));

    // Avoid adding the empty map into the context
    if (!contextInfoMap.isEmpty()) {
      contextInfoMap.entrySet().stream()
          .forEach(entry -> contextInfoList.add(Map.of(entry.getKey(), entry.getValue())));
    }

    epcisEvents.forEach(epcisEvent -> epcisEvent.setContextInfo(null));
    return contextInfoList;
  }

  private HashMap<String, Object> convertContextInfoToMap(EPCISEvent epcisEvent) {
    // If context is null or empty then return the empty HashMap to avoid  exception.
    if (epcisEvent.getContextInfo() == null || epcisEvent.getContextInfo().isEmpty()) {
      return new HashMap<>();
    }

    return epcisEvent.getContextInfo().stream()
        .map(m -> new ObjectMapper().convertValue(m, HashMap.class))
        .toList()
        .stream()
        .reduce(
            (firstMap, secondMap) -> {
              firstMap.putAll(secondMap);
              return firstMap;
            })
        .orElseThrow(
            () -> new QueryExecutionException("Error while collecting context Information"));
  }
}
