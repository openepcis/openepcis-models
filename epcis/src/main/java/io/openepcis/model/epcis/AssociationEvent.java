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
import jakarta.xml.bind.annotation.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import lombok.*;

@XmlType(
    name = "AssociationEvent",
    namespace = "urn:epcglobal:epcis:xsd:2",
    propOrder = {
      "eventTime",
      "eventTimeZoneOffset",
      "recordTime",
      "eventID",
      "errorDeclaration",
      "certificationInfo",
      "baseExtension",
      "parentID",
      "childEPCs",
      "childQuantityList",
      "action",
      "bizStep",
      "disposition",
      "readPoint",
      "bizLocation",
      "bizTransactionList",
      "sourceList",
      "destinationList",
      "sensorElementList",
      "extension",
      "anyElements"
    },
    factoryClass = ObjectFactory.class,
    factoryMethod = "createAssociationEvent")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "type")
@JsonTypeName("AssociationEvent")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AssociationEvent")
@JsonPropertyOrder({
  "contextInfo",
  "type",
  "eventTime",
  "eventTimeZoneOffset",
  "recordTime",
  "eventID",
  "errorDeclaration",
  "certificationInfo",
  "parentID",
  "childEPCs",
  "childQuantityList",
  "action",
  "bizStep",
  "disposition",
  "readPoint",
  "bizLocation",
  "bizTransactionList",
  "sourceList",
  "destinationList",
  "sensorElementList",
  "userExtensions"
})
public class AssociationEvent extends EPCISEvent implements XmlSupportExtension {

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

  @Builder(builderMethodName = "associationEventBuilder")
  public AssociationEvent(
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
      String certificationInfo,
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
  public AssociationEvent xmlSupport() {
    return this;
  }

  @Override
  public void beforeMarshal(Marshaller m) throws ParserConfigurationException {
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
