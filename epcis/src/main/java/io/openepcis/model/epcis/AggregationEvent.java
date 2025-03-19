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

import com.fasterxml.jackson.annotation.*;
import io.openepcis.epc.translator.util.ConverterUtil;
import io.openepcis.model.epcis.extension.OpenEPCISExtension;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import lombok.*;

@XmlType(
    name = "AggregationEvent",
    namespace = "urn:epcglobal:epcis:xsd:2",
    propOrder = {
      "eventTime",
      "recordTime",
      "eventTimeZoneOffset",
      "eventID",
      "errorDeclaration",
      "certificationInfo",
      "baseExtension",
      "parentID",
      "childEPCs",
      "action",
      "bizStep",
      "disposition",
      "readPoint",
      "bizLocation",
      "bizTransactionList",
      "childQuantityList",
      "sourceList",
      "destinationList",
      "sensorElementList",
      "extension",
      "anyElements"
    },
    factoryClass = ObjectFactory.class,
    factoryMethod = "createAggregationEvent")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "type")
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@JsonTypeName("AggregationEvent")
@XmlRootElement(name = "AggregationEvent")
@JsonPropertyOrder({
  "contextInfo",
  "type",
  "eventTime",
  "recordTime",
  "eventTimeZoneOffset",
  "eventID",
  "certificationInfo",
  "errorDeclaration",
  "parentID",
  "childEPCs",
  "action",
  "bizStep",
  "disposition",
  "readPoint",
  "bizLocation",
  "bizTransactionList",
  "childQuantityList",
  "sourceList",
  "destinationList",
  "sensorElementList",
  "userExtensions"
})
public class AggregationEvent extends EPCISEvent implements XmlSupportExtension {

  @JsonProperty(required = true)
  @XmlElement(name = "action", required = true)
  private Action action;

  @XmlElementWrapper(name = "childQuantityList")
  @XmlElement(name = "quantityElement")
  private List<QuantityList> childQuantityList;

  private String parentID;

  @XmlElementWrapper(name = "childEPCs", required = true)
  @XmlElement(name = "epc", required = true)
  private List<String> childEPCs;

  @XmlElementWrapper(name = "bizTransactionList")
  @XmlElement(name = "bizTransaction")
  private List<BizTransactionList> bizTransactionList;

  @Builder(builderMethodName = "aggregationEventBuilder")
  public AggregationEvent(
      String type,
      String eventID,
      String eventTimeZoneOffset,
      OffsetDateTime eventTime,
      OffsetDateTime recordTime,
      Action action,
      String bizStep,
      String disposition,
      ReadPoint readPoint,
      BizLocation bizLocation,
      ErrorDeclaration errorDeclaration,
      Map<String, Object> extension,
      Map<String, Object> userExtensions,
      Map<String, Object> innerUserExtensions,
      List<Object> contextInfo,
      Object certificationInfo,
      List<SourceList> sourceList,
      List<DestinationList> destinationList,
      List<SensorElementList> sensorElementList,
      List<QuantityList> childQuantityList,
      String parentID,
      List<String> childEPCs,
      List<BizTransactionList> bizTransactionList,
      OpenEPCISExtension openEPCISExtension) {
    super(
        type,
        eventID,
        eventTimeZoneOffset,
        eventTime,
        recordTime,
        bizStep,
        disposition,
        readPoint,
        bizLocation,
        errorDeclaration,
        sourceList,
        destinationList,
        sensorElementList,
        extension,
        userExtensions,
        innerUserExtensions,
        contextInfo,
        certificationInfo,
        null,
        openEPCISExtension);
    this.action = action;
    this.childQuantityList = childQuantityList;
    this.parentID = parentID;
    this.childEPCs = childEPCs;
    this.bizTransactionList = bizTransactionList;
  }

  @Override
  public AggregationEvent xmlSupport() {
    return this;
  }

  @Override
  public void beforeMarshal(Marshaller m) throws ParserConfigurationException {
    // For AggregationEvent during conversion from JSON->XML if action is DELETE then add the empty
    // childEPCs array to conform with standards
    if (childEPCs == null && action.toString().equalsIgnoreCase("DELETE")) {
      childEPCs = new ArrayList<>();
    }

    // Check if bizTransactionList has value if so convert to CBV formatted value.
    if (bizTransactionList != null && !bizTransactionList.isEmpty()) {
      bizTransactionList.forEach(
          bizTransaction -> {
            if (bizTransaction.getType() != null && !bizTransaction.getType().equals("")) {
              bizTransaction.setType(
                  bizTransaction.getType().contains("http")
                          || bizTransaction.getType().contains(":")
                      ? bizTransaction.getType()
                      : ConverterUtil.toCbvVocabulary(
                          bizTransaction.getType(), "bizTransactionList", "URN"));
            }
          });
    }

    // Call the parent class afterUnmarshal method to modify the values
    super.beforeMarshal(m);
  }

  @Override
  public void afterUnmarshal(Unmarshaller m, Object parent) throws ParserConfigurationException {
    // Check if bizTransactionList has value if so convert to BareString
    if (bizTransactionList != null && !bizTransactionList.isEmpty()) {
      bizTransactionList.forEach(
          bizTransaction -> {
            if (bizTransaction.getType() != null && !bizTransaction.getType().equals("")) {
              bizTransaction.setType(
                  ConverterUtil.toBareStringVocabulary(bizTransaction.getType()));
            }
          });
    }

    // Call the parent class afterUnmarshal method to modify the values
    super.afterUnmarshal(m, parent);
  }
}
