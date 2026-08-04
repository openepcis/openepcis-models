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

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlType(factoryClass = ObjectFactory.class, factoryMethod = "createEpcisEventResponse")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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
    CommonExtensionModifier.populateNamespaces(contextInfo, null);
  }

  private List<Object> getContextInfoFromEvent(EPCISEvent epcisEvent) {
    List<Object> contextInfoList = new ArrayList<>();
    contextInfoList.add(CommonConstants.EPCIS_DEFAULT_NAMESPACE);
    HashMap<String, Object> contextInfoMap = convertContextInfoToMap(epcisEvent);
    contextInfoMap.forEach((k, v) -> contextInfoList.add(Map.of(k, v)));
    return contextInfoList;
  }

  private HashMap<String, Object> convertContextInfoToMap(EPCISEvent epcisEvent) {
    return epcisEvent.getContextInfo().stream().map(m -> new ObjectMapper().convertValue(m, HashMap.class)).toList().stream().reduce((firstMap, secondMap) -> {
      firstMap.putAll(secondMap);
      return firstMap;
    }).orElseThrow(() -> new QueryExecutionException("Error while collecting context Information"));
  }

  public List<Object> getContextInfo() {
    return this.contextInfo;
  }

  public EPCISEvent getEpcisEvent() {
    return this.epcisEvent;
  }

  public void setContextInfo(List<Object> contextInfo) {
    this.contextInfo = contextInfo;
  }

  public void setEpcisEvent(EPCISEvent epcisEvent) {
    this.epcisEvent = epcisEvent;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof EPCISEventResponse)) return false;
    EPCISEventResponse other = (EPCISEventResponse) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$contextInfo = this.getContextInfo();
    Object other$contextInfo = other.getContextInfo();
    if (this$contextInfo == null ? other$contextInfo != null : !this$contextInfo.equals(other$contextInfo)) return false;
    Object this$epcisEvent = this.getEpcisEvent();
    Object other$epcisEvent = other.getEpcisEvent();
    if (this$epcisEvent == null ? other$epcisEvent != null : !this$epcisEvent.equals(other$epcisEvent)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof EPCISEventResponse;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $contextInfo = this.getContextInfo();
    result = result * PRIME + ($contextInfo == null ? 43 : $contextInfo.hashCode());
    Object $epcisEvent = this.getEpcisEvent();
    result = result * PRIME + ($epcisEvent == null ? 43 : $epcisEvent.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "EPCISEventResponse(contextInfo=" + this.getContextInfo() + ", epcisEvent=" + this.getEpcisEvent() + ")";
  }

  public EPCISEventResponse() {
  }
}
