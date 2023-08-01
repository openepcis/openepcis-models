/*
 * Copyright 2022-2023 benelog GmbH & Co. KG
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
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import lombok.*;

@XmlType(
    name = "TransactionEvent",
    namespace = "urn:epcglobal:epcis:xsd:2",
    propOrder = {
      "eventTime",
      "recordTime",
      "eventTimeZoneOffset",
      "eventID",
      "errorDeclaration",
      "certificationInfo",
      "baseExtension",
      "bizTransactionList",
      "parentID",
      "epcList",
      "action",
      "bizStep",
      "disposition",
      "readPoint",
      "bizLocation",
      "quantityList",
      "sourceList",
      "destinationList",
      "sensorElementList",
      "persistentDisposition",
      "extension",
      "anyElements"
    },
    factoryClass = ObjectFactory.class,
    factoryMethod = "createTransactionEvent")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "type")
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@JsonTypeName("TransactionEvent")
@XmlRootElement(name = "TransactionEvent")
@JsonPropertyOrder({
  "contextInfo",
  "type",
  "eventTime",
  "recordTime",
  "eventTimeZoneOffset",
  "eventID",
  "certificationInfo",
  "errorDeclaration",
  "bizTransactionList",
  "parentID",
  "epcList",
  "action",
  "bizStep",
  "disposition",
  "readPoint",
  "bizLocation",
  "quantityList",
  "sourceList",
  "destinationList",
  "sensorElementList",
  "persistentDisposition",
  "userExtensions"
})
public class TransactionEvent extends EPCISEvent implements XmlSupportExtension {

  @JsonProperty(required = true)
  @XmlElement(name = "action", required = true)
  private Action action;

  @XmlElementWrapper(name = "bizTransactionList", required = true)
  @XmlElement(name = "bizTransaction", required = true)
  private List<BizTransactionList> bizTransactionList;

  private String parentID;

  @XmlElementWrapper(name = "epcList", required = true)
  @XmlElement(name = "epc", required = true)
  private List<String> epcList;

  @XmlElementWrapper(name = "quantityList")
  @XmlElement(name = "quantityElement")
  private List<QuantityList> quantityList;

  @Builder(builderMethodName = "transactionEventBuilder")
  public TransactionEvent(
      String type,
      String eventID,
      String hash,
      String eventTimeZoneOffset,
      OffsetDateTime eventTime,
      OffsetDateTime recordTime,
      Action action,
      String bizStep,
      String disposition,
      PersistentDisposition persistentDisposition,
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
      int sequenceInEPCISDoc,
      String captureId,
      List<BizTransactionList> bizTransactionList,
      String parentID,
      List<String> epcList,
      List<QuantityList> quantityList) {
    super(
        type,
        eventID,
        hash,
        eventTimeZoneOffset,
        eventTime,
        recordTime,
        bizStep,
        disposition,
        persistentDisposition,
        readPoint,
        bizLocation,
        errorDeclaration,
        sourceList,
        destinationList,
        sensorElementList,
        sequenceInEPCISDoc,
        captureId,
        extension,
        userExtensions,
        innerUserExtensions,
        contextInfo,
        certificationInfo,
        null);
    this.action = action;
    this.quantityList = quantityList;
    this.epcList = epcList;
    this.parentID = parentID;
    this.bizTransactionList = bizTransactionList;
  }

  @Override
  public TransactionEvent xmlSupport() {
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
