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

import static com.fasterxml.jackson.annotation.JsonFormat.Feature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE;
import static com.fasterxml.jackson.annotation.JsonFormat.Feature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.openepcis.epc.translator.ConverterUtil;
import io.openepcis.model.epcis.modifier.*;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = ObjectEvent.class, name = "ObjectEvent"),
  @JsonSubTypes.Type(value = TransformationEvent.class, name = "TransformationEvent"),
  @JsonSubTypes.Type(value = AggregationEvent.class, name = "AggregationEvent"),
  @JsonSubTypes.Type(value = AssociationEvent.class, name = "AssociationEvent"),
  @JsonSubTypes.Type(value = TransactionEvent.class, name = "TransactionEvent")
})
@JsonInclude(Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlTransient
@Builder
public class EPCISEvent implements Serializable {

  @XmlTransient private String type;

  private String eventID;

  @XmlTransient private String hash;

  @JsonProperty(required = true)
  @XmlElement(name = "eventTimeZoneOffset", required = true)
  private String eventTimeZoneOffset;

  @JsonProperty(required = true)
  @XmlElement(name = "eventTime", required = true)
  @XmlJavaTypeAdapter(CustomInstantAdapter.class)
  @JsonFormat(without = {ADJUST_DATES_TO_CONTEXT_TIME_ZONE, WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS})
  private OffsetDateTime eventTime;

  @XmlJavaTypeAdapter(CustomInstantAdapter.class)
  @JsonFormat(without = {ADJUST_DATES_TO_CONTEXT_TIME_ZONE, WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS})
  private OffsetDateTime recordTime;

  private String bizStep;
  private String disposition;
  private PersistentDisposition persistentDisposition;

  private ReadPoint readPoint;

  private BizLocation bizLocation;
  private ErrorDeclaration errorDeclaration;

  @XmlElementWrapper(name = "sourceList")
  @XmlElement(name = "source")
  private List<SourceList> sourceList;

  @XmlElementWrapper(name = "destinationList")
  @XmlElement(name = "destination")
  private List<DestinationList> destinationList;

  @XmlElementWrapper(name = "sensorElementList")
  @XmlElement(name = "sensorElement")
  private List<SensorElementList> sensorElementList;

  @XmlTransient @JsonIgnore private Integer sequenceInEPCISDoc;

  @XmlTransient private String captureID;

  @XmlTransient private Map<String, Object> userExtensions;

  @JsonIgnore @XmlTransient private Map<String, Object> innerUserExtensions;

  @JsonProperty("@context")
  @JsonDeserialize(using = CustomContextDeserialize.class)
  @XmlTransient
  private List<Object> contextInfo;

  private String certificationInfo;

  @JsonIgnore @XmlTransient private String expandedJSONLDString;

  public EPCISEvent(
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
      List<SourceList> sourceList,
      List<DestinationList> destinationList,
      List<SensorElementList> sensorElementList,
      Integer sequenceInEPCISDoc,
      String captureId,
      Map<String, Object> userExtensions,
      Map<String, Object> innerUserExtensions,
      List<Object> contextInfo,
      String certificationInfo,
      String expandedJSONLDString) {
    this.type = type;
    this.eventID = eventID;
    this.hash = hash;
    this.eventTimeZoneOffset = eventTimeZoneOffset;
    this.eventTime = eventTime;
    this.recordTime = recordTime;
    this.bizStep = bizStep;
    this.disposition = disposition;
    this.persistentDisposition = persistentDisposition;
    this.readPoint = readPoint;
    this.bizLocation = bizLocation;
    this.errorDeclaration = errorDeclaration;
    this.sourceList = sourceList;
    this.destinationList = destinationList;
    this.sensorElementList = sensorElementList;
    this.sequenceInEPCISDoc = sequenceInEPCISDoc;
    this.captureID = captureId;
    this.userExtensions = userExtensions;
    this.innerUserExtensions = innerUserExtensions;
    this.contextInfo = contextInfo;
    this.certificationInfo = certificationInfo;
    this.expandedJSONLDString = expandedJSONLDString;
  }

  @JsonAnyGetter
  @JsonSerialize(using = CustomExtensionsSerializer.class)
  @UserExtensions(extension = "userExtensions")
  public Map<String, Object> getUserExtensions() {
    return userExtensions;
  }

  @XmlJavaTypeAdapter(CustomExtensionAdapter.class)
  @JsonIgnore
  private Map<String, Serializable> baseExtension;

  @XmlJavaTypeAdapter(CustomExtensionAdapter.class)
  @JsonIgnore
  private Map<String, Serializable> extension;

  @XmlAnyElement(lax = true)
  @JsonIgnore
  private List<Object> anyElements;

  @JsonAnySetter
  public void setUserExtensions(String key, Object value) {
    if (userExtensions == null) {
      userExtensions = new HashMap<>();
    }
    userExtensions.put(key, value);
  }

  public void beforeMarshal(Marshaller m) throws ParserConfigurationException {
    // Add all elements from UserExtensions to AnyElements before Marshaling & creating XML
    if (userExtensions != null) {
      final ExtensionsModifier extensionsModifier = new ExtensionsModifier();
      anyElements = extensionsModifier.Marshalling(userExtensions);
      userExtensions = new HashMap<>();
    }

    // Call the method to convert the BearStrings during JSON->XML conversion
    if (errorDeclaration != null
        && errorDeclaration.getReason() != null
        && !errorDeclaration.getReason().equals("")) {
      errorDeclaration.setReason(
          errorDeclaration.getReason().contains("http")
                  || errorDeclaration.getReason().contains(":")
              ? errorDeclaration.getReason()
              : ConverterUtil.toCbvVocabulary(errorDeclaration.getReason(), "reason", "URN"));
    }

    // Check if bizStep has value if so convert to CBV formatted value.
    if (bizStep != null && !bizStep.equals("")) {
      bizStep =
          bizStep.contains("http") || bizStep.contains(":")
              ? bizStep
              : ConverterUtil.toCbvVocabulary(bizStep, "bizStep", "URN");
    }

    // Check if Disposition has value if so convert to CBV formatted value.
    if (disposition != null && !disposition.equals("")) {
      disposition =
          disposition.contains("http") || disposition.contains(":")
              ? disposition
              : ConverterUtil.toCbvVocabulary(disposition, "disposition", "URN");
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

    // Check if Source has value if so convert it to CBV formatted value
    if (sourceList != null && !sourceList.isEmpty()) {
      sourceList.forEach(
          source -> {
            if (source.getType() != null && !source.getType().equals("")) {
              source.setType(
                  source.getType().contains("http") || source.getType().contains(":")
                      ? source.getType()
                      : ConverterUtil.toCbvVocabulary(source.getType(), "sourceList", "URN"));
            }
          });
    }

    // Check if Destination has value if so convert it to CBV formatted value
    if (destinationList != null && !destinationList.isEmpty()) {
      destinationList.forEach(
          destination -> {
            if (destination.getType() != null && !destination.getType().equals("")) {
              destination.setType(
                  destination.getType().contains("http") || destination.getType().contains(":")
                      ? destination.getType()
                      : ConverterUtil.toCbvVocabulary(
                          destination.getType(), "destinationList", "URN"));
            }
          });
    }
  }

  public void afterUnmarshal(Unmarshaller m, Object parent) throws ParserConfigurationException {
    // Add all elements from AnyElements to UserExtensions after Unmarshalling before creating JSON
    if (anyElements != null) {
      final ExtensionsModifier extensionsModifier = new ExtensionsModifier();
      userExtensions = extensionsModifier.Unmarshalling(anyElements);
      anyElements = new ArrayList<>();
    }

    // If there are elements in Extension after Unmarshalling then add it to UserExtensions before
    // creating JSON
    if (extension != null) {
      userExtensions.putAll(extension);
      extension = new HashMap<>();
    }

    // If there are elements in BaseExtension after Unmarshalling then add it to UserExtensions
    // before creating JSON
    if (baseExtension != null) {
      userExtensions.putAll(baseExtension);
      baseExtension = new HashMap<>();
    }

    // Call the method to convert the values to BareStrings during XML->JSON conversion

    // Check if Error reason is present if so convert to BareString
    if (errorDeclaration != null
        && errorDeclaration.getReason() != null
        && !errorDeclaration.getReason().equals("")) {
      errorDeclaration.setReason(
          ConverterUtil.toBareStringVocabulary(errorDeclaration.getReason()));
    }

    // Check if bizStep has value if so convert to BareString
    if (bizStep != null && !bizStep.equals("")) {
      bizStep = ConverterUtil.toBareStringVocabulary(bizStep);
    }

    // Check if Disposition has value if so convert to BareString
    if (disposition != null && !disposition.equals("")) {
      disposition = ConverterUtil.toBareStringVocabulary(disposition);
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

    // Check if Source has value if so convert it to BareString value
    if (sourceList != null && !sourceList.isEmpty()) {
      sourceList.forEach(
          source -> {
            if (source.getType() != null && !source.getType().equals("")) {
              source.setType(ConverterUtil.toBareStringVocabulary(source.getType()));
            }
          });
    }

    // Check if Destination has value if so convert it to BareString value
    if (destinationList != null && !destinationList.isEmpty()) {
      destinationList.forEach(
          destination -> {
            if (destination.getType() != null && !destination.getType().equals("")) {
              destination.setType(ConverterUtil.toBareStringVocabulary(destination.getType()));
            }
          });
    }
  }
}
