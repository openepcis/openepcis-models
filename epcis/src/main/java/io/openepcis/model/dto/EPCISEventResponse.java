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
package io.openepcis.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.openepcis.model.epcis.EPCISEvent;
import io.openepcis.model.epcis.constants.CommonConstants;
import io.openepcis.model.epcis.exception.QueryExecutionException;
import io.openepcis.model.epcis.modifier.CommonExtensionModifier;
import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Slf4j
@XmlType(factoryClass = ObjectFactory.class, factoryMethod = "createEpcisEventResponse")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public class EPCISEventResponse {

  @JsonProperty("@context")
  @XmlTransient
  private List<Object> contextInfo;

  @JsonProperty("event")
  @XmlElement
  private EPCISEvent epcisEvent;

  public EPCISEventResponse(final EPCISEvent epcisEvent) {
    this.epcisEvent = epcisEvent;
    this.contextInfo = getContextInfoFromEvent(epcisEvent);

    // Populating the namespaces directly from context during xml query
    CommonExtensionModifier.populateNamespaces(contextInfo);
  }

  private List<Object> getContextInfoFromEvent(EPCISEvent epcisEvent) {
    List<Object> contextInfoList = new ArrayList<>();
    contextInfoList.add(CommonConstants.EPCIS_DEFAULT_NAMESPACE);
    HashMap<String, Object> contextInfoMap = convertContextInfoToMap(epcisEvent);
    contextInfoMap.forEach((k, v) -> contextInfoList.add(Map.of(k, v)));
    return contextInfoList;
  }

  private HashMap<String, Object> convertContextInfoToMap(EPCISEvent epcisEvent) {
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
