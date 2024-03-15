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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.openepcis.epc.translator.util.ConverterUtil;
import io.openepcis.model.epcis.extension.OpenEPCISExtension;
import io.openepcis.model.epcis.modifier.CustomExtensionAdapter;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import lombok.*;

@XmlType(
    name = "TransformationEvent",
    namespace = "urn:epcglobal:epcis:xsd:2",
    propOrder = {
      "eventTime",
      "recordTime",
      "eventTimeZoneOffset",
      "eventID",
      "errorDeclaration",
      "certificationInfo",
      "baseExtension",
      "inputEPCList",
      "inputQuantityList",
      "outputEPCList",
      "outputQuantityList",
      "transformationID",
      "bizStep",
      "disposition",
      "readPoint",
      "bizLocation",
      "bizTransactionList",
      "sourceList",
      "destinationList",
      "sensorElementList",
      "persistentDisposition",
      "ilmdXml",
      "extension",
      "anyElements"
    },
    factoryClass = ObjectFactory.class,
    factoryMethod = "createTransformationEvent")
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    visible = true,
    property = "type")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "TransformationEvent")
@JsonPropertyOrder({
  "contextInfo",
  "type",
  "eventTime",
  "recordTime",
  "eventTimeZoneOffset",
  "eventID",
  "certificationInfo",
  "errorDeclaration",
  "inputEPCList",
  "inputQuantityList",
  "outputEPCList",
  "outputQuantityList",
  "transformationID",
  "bizStep",
  "disposition",
  "readPoint",
  "bizLocation",
  "bizTransactionList",
  "sourceList",
  "destinationList",
  "ilmd",
  "sensorElementList",
  "persistentDisposition",
  "userExtensions"
})
public class TransformationEvent extends EPCISEvent implements XmlSupportExtension {

  private PersistentDisposition persistentDisposition;

  @XmlElementWrapper(name = "inputEPCList")
  @XmlElement(name = "epc")
  private List<String> inputEPCList;

  @XmlElementWrapper(name = "outputEPCList")
  @XmlElement(name = "epc")
  private List<String> outputEPCList;

  @XmlElementWrapper(name = "inputQuantityList")
  @XmlElement(name = "quantityElement")
  private List<QuantityList> inputQuantityList;

  @XmlElementWrapper(name = "outputQuantityList")
  @XmlElement(name = "quantityElement")
  private List<QuantityList> outputQuantityList;

  private String transformationID;

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

  @Builder(builderMethodName = "transformationEventBuilder")
  public TransformationEvent(
      String type,
      String eventID,
      String hash,
      String eventTimeZoneOffset,
      OffsetDateTime eventTime,
      OffsetDateTime recordTime,
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
      List<String> inputEPCList,
      List<String> outputEPCList,
      List<QuantityList> inputQuantityList,
      List<QuantityList> outputQuantityList,
      String transformationID,
      Map<String, Object> ilmdXml,
      Ilmd ilmd,
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
    this.persistentDisposition = persistentDisposition;
    this.inputEPCList = inputEPCList;
    this.outputEPCList = outputEPCList;
    this.inputQuantityList = inputQuantityList;
    this.outputQuantityList = outputQuantityList;
    this.transformationID = transformationID;
    this.ilmd = ilmd;
    this.ilmdXml = ilmdXml;
    if (ilmd != null) {
      this.ilmdXml = ilmd.getUserExtensions();
    }
  }

  @Override
  public TransformationEvent xmlSupport() {
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

    // Check if Persistent Disposition has value if so convert to CBV formatted value.
    if (persistentDisposition != null) {
      // If Set elements are present then add it to List
      if (persistentDisposition.getSet() != null && !persistentDisposition.getSet().isEmpty()) {
        final List<String> setList = new ArrayList<>();
        persistentDisposition
                .getSet()
                .forEach(
                        set ->
                                setList.add(
                                        set.contains("http") || set.contains(":")
                                                ? set
                                                : ConverterUtil.toCbvVocabulary(set, "persistentDisposition", "URN")));
        persistentDisposition.setSet(setList);
      }

      // If Unset elements are present then add it to List
      if (persistentDisposition.getUnset() != null && !persistentDisposition.getUnset().isEmpty()) {
        final List<String> unsetList = new ArrayList<>();
        persistentDisposition
                .getUnset()
                .forEach(
                        unset ->
                                unsetList.add(
                                        unset.contains("http") || unset.contains(":")
                                                ? unset
                                                : ConverterUtil.toCbvVocabulary(
                                                unset, "persistentDisposition", "URN")));
        persistentDisposition.setUnset(unsetList);
      }
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

    // Check if Persistent Disposition has value if so convert to BareString
    if (persistentDisposition != null) {
      // If Set elements are present then add it to List
      if (persistentDisposition.getSet() != null && !persistentDisposition.getSet().isEmpty()) {
        final List<String> setList = new ArrayList<>();
        persistentDisposition
                .getSet()
                .forEach(set -> setList.add(ConverterUtil.toBareStringVocabulary(set)));
        persistentDisposition.setSet(setList);
      }

      // If Unset elements are present then add it to List
      if (persistentDisposition.getUnset() != null && !persistentDisposition.getUnset().isEmpty()) {
        final List<String> unsetList = new ArrayList<>();
        persistentDisposition
                .getUnset()
                .forEach(unset -> unsetList.add(ConverterUtil.toBareStringVocabulary(unset)));
        persistentDisposition.setUnset(unsetList);
      }
    }
    // Call the parent class afterUnmarshal method to modify the values
    super.afterUnmarshal(m, parent);
  }
}
