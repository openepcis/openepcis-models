/*
 * Copyright 2022 benelog GmbH & Co. KG
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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.openepcis.epc.translator.ConverterUtil;
import io.openepcis.model.epcis.modifier.CustomExtensionAdapter;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import lombok.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "type")
@XmlRootElement(name = "ObjectEvent")
@XmlType(
    name = "ObjectEvent",
    propOrder = {
      "eventTime",
      "recordTime",
      "eventTimeZoneOffset",
      "eventID",
      "errorDeclaration",
      "certificationInfo",
      "baseExtension",
      "epcList",
      "action",
      "bizStep",
      "disposition",
      "readPoint",
      "bizLocation",
      "bizTransactionList",
      "quantityList",
      "sourceList",
      "destinationList",
      "sensorElementList",
      "persistentDisposition",
      "ilmdXml",
      "extension",
      "anyElements"
    },
    factoryClass = ObjectFactory.class,
    factoryMethod = "createObjectEvent")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "contextInfo",
  "type",
  "eventTime",
  "recordTime",
  "eventTimeZoneOffset",
  "eventID",
  "certificationInfo",
  "errorDeclaration",
  "epcList",
  "action",
  "bizStep",
  "disposition",
  "readPoint",
  "bizLocation",
  "bizTransactionList",
  "quantityList",
  "sourceList",
  "destinationList",
  "sensorElementList",
  "persistentDisposition",
  "ilmd",
  "userExtensions"
})
public class ObjectEvent extends EPCISEvent implements XmlSupportExtension {

  @JsonProperty(required = true)
  @XmlElement(name = "action", required = true)
  private Action action;

  @XmlElementWrapper(name = "epcList", required = true)
  @XmlElement(name = "epc", required = true)
  private List<String> epcList;

  @XmlElementWrapper(name = "quantityList")
  @XmlElement(name = "quantityElement")
  private List<QuantityList> quantityList;

  @XmlElementWrapper(name = "bizTransactionList")
  @XmlElement(name = "bizTransaction")
  private List<BizTransactionList> bizTransactionList;

  // TODO: check if removal of the annotations is valid or if special ILMD Adapter or Serializer is
  // required
  @XmlTransient @JsonIgnore private Ilmd ilmd;

  // To avoid issues conflicting Ilmd type, this variable has been created. This will also avoid
  // making changes to CustomExtensionAdapter class.
  @XmlJavaTypeAdapter(CustomExtensionAdapter.class)
  @JsonSerialize(using = CustomExtensionsSerializer.class)
  @UserExtensions(extension = "ilmd")
  @JsonProperty("ilmd")
  @XmlElement(name = "ilmd")
  private Map<String, Object> ilmdXml;

  @Builder(builderMethodName = "objectEventBuilder")
  public ObjectEvent(
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
      Map<String, Object> userExtensions,
      Map<String, Object> innerUserExtensions,
      List<Object> contextInfo,
      String certificationInfo,
      List<SourceList> sourceList,
      List<DestinationList> destinationList,
      List<SensorElementList> sensorElementList,
      int sequenceInEPCISDoc,
      String captureId,
      List<QuantityList> quantityList,
      List<String> epcList,
      List<BizTransactionList> bizTransactionList,
      Ilmd ilmd) {
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
        userExtensions,
        innerUserExtensions,
        contextInfo,
        certificationInfo,
        null);
    this.action = action;
    this.quantityList = quantityList;
    this.epcList = epcList;
    this.ilmd = ilmd;
    this.bizTransactionList = bizTransactionList;
    if (ilmd != null) {
      this.ilmdXml = ilmd.getUserExtensions();
    }
  }

  // Used for adding the Extension and Inner Extension tag during JAXB Marshalling
  @Override
  public ObjectEvent xmlSupport() {
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
