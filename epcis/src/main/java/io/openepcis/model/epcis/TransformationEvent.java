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
package io.openepcis.model.epcis;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.openepcis.identifiers.converter.util.ConverterUtil;
import io.openepcis.model.epcis.extension.OpenEPCISExtension;
import io.openepcis.model.epcis.modifier.CustomExtensionAdapter;
import io.openepcis.model.epcis.modifier.CustomExtensionsSerializer;
import io.openepcis.model.epcis.modifier.DefaultNamespaceDeserializer;
import io.openepcis.model.epcis.modifier.UserExtensions;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;

@XmlType(name = "TransformationEvent", namespace = "urn:epcglobal:epcis:xsd:2", propOrder = {"eventTime", "recordTime", "eventTimeZoneOffset", "eventID", "errorDeclaration", "certificationInfo", "baseExtension", "inputEPCList", "inputQuantityList", "outputEPCList", "outputQuantityList", "transformationID", "bizStep", "disposition", "readPoint", "bizLocation", "bizTransactionList", "sourceList", "destinationList", "sensorElementList", "persistentDisposition", "ilmdXml", "extension", "anyElements"}, factoryClass = ObjectFactory.class, factoryMethod = "createTransformationEvent")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, visible = true, property = "type")
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "TransformationEvent")
@JsonPropertyOrder({"contextInfo", "type", "eventTime", "recordTime", "eventTimeZoneOffset", "eventID", "certificationInfo", "errorDeclaration", "inputEPCList", "inputQuantityList", "outputEPCList", "outputQuantityList", "transformationID", "bizStep", "disposition", "readPoint", "bizLocation", "bizTransactionList", "sourceList", "destinationList", "ilmd", "sensorElementList", "persistentDisposition", "userExtensions"})
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
  @XmlTransient
  @JsonIgnore
  private Ilmd ilmd;
  // To avoid issues conflicting Ilmd type, this variable has been created. This will also avoid
  // making changes to CustomExtensionAdapter class.
  @XmlJavaTypeAdapter(CustomExtensionAdapter.class)
  @JsonDeserialize(using = DefaultNamespaceDeserializer.class)
  @JsonSerialize(using = CustomExtensionsSerializer.class)
  @UserExtensions(extension = "ilmd")
  @JsonProperty("ilmd")
  @XmlElement(name = "ilmd")
  private Map<String, Object> ilmdXml;

  public TransformationEvent(String type, String eventID, String hash, String eventTimeZoneOffset, OffsetDateTime eventTime, OffsetDateTime recordTime, String bizStep, String disposition, PersistentDisposition persistentDisposition, ReadPoint readPoint, BizLocation bizLocation, ErrorDeclaration errorDeclaration, Map<String, Object> extension, Map<String, Object> userExtensions, Map<String, Object> innerUserExtensions, List<Object> contextInfo, Object certificationInfo, List<SourceList> sourceList, List<DestinationList> destinationList, List<SensorElementList> sensorElementList, int sequenceInEPCISDoc, String captureId, List<String> inputEPCList, List<String> outputEPCList, List<QuantityList> inputQuantityList, List<QuantityList> outputQuantityList, String transformationID, List<BizTransactionList> bizTransactionList, Map<String, Object> ilmdXml, Ilmd ilmd, OpenEPCISExtension openEPCISExtension) {
    super(type, eventID, eventTimeZoneOffset, eventTime, recordTime, bizStep, disposition, readPoint, bizLocation, errorDeclaration, sourceList, destinationList, sensorElementList, extension, userExtensions, innerUserExtensions, contextInfo, certificationInfo, null, openEPCISExtension);
    this.persistentDisposition = persistentDisposition;
    this.inputEPCList = inputEPCList;
    this.outputEPCList = outputEPCList;
    this.inputQuantityList = inputQuantityList;
    this.outputQuantityList = outputQuantityList;
    this.transformationID = transformationID;
    this.bizTransactionList = bizTransactionList;
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
      bizTransactionList.forEach(bizTransaction -> {
        if (bizTransaction.getType() != null && !bizTransaction.getType().equals("")) {
          bizTransaction.setType(bizTransaction.getType().contains("http") || bizTransaction.getType().contains(":") ? bizTransaction.getType() : ConverterUtil.toCbvVocabulary(bizTransaction.getType(), "bizTransactionList", "URN"));
        }
      });
    }
    // Check if Persistent Disposition has value if so convert to CBV formatted value.
    if (persistentDisposition != null) {
      // If Set elements are present then add it to List
      if (persistentDisposition.getSet() != null && !persistentDisposition.getSet().isEmpty()) {
        final List<String> setList = new ArrayList<>();
        persistentDisposition.getSet().forEach(set -> setList.add(set.contains("http") || set.contains(":") ? set : ConverterUtil.toCbvVocabulary(set, "persistentDisposition", "URN")));
        persistentDisposition.setSet(setList);
      }
      // If Unset elements are present then add it to List
      if (persistentDisposition.getUnset() != null && !persistentDisposition.getUnset().isEmpty()) {
        final List<String> unsetList = new ArrayList<>();
        persistentDisposition.getUnset().forEach(unset -> unsetList.add(unset.contains("http") || unset.contains(":") ? unset : ConverterUtil.toCbvVocabulary(unset, "persistentDisposition", "URN")));
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
      bizTransactionList.forEach(bizTransaction -> {
        if (bizTransaction.getType() != null && !bizTransaction.getType().equals("")) {
          bizTransaction.setType(ConverterUtil.toBareStringVocabulary(bizTransaction.getType()));
        }
      });
    }
    // Check if Persistent Disposition has value if so convert to BareString
    if (persistentDisposition != null) {
      // If Set elements are present then add it to List
      if (persistentDisposition.getSet() != null && !persistentDisposition.getSet().isEmpty()) {
        final List<String> setList = new ArrayList<>();
        persistentDisposition.getSet().forEach(set -> setList.add(ConverterUtil.toBareStringVocabulary(set)));
        persistentDisposition.setSet(setList);
      }
      // If Unset elements are present then add it to List
      if (persistentDisposition.getUnset() != null && !persistentDisposition.getUnset().isEmpty()) {
        final List<String> unsetList = new ArrayList<>();
        persistentDisposition.getUnset().forEach(unset -> unsetList.add(ConverterUtil.toBareStringVocabulary(unset)));
        persistentDisposition.setUnset(unsetList);
      }
    }
    // Call the parent class afterUnmarshal method to modify the values
    super.afterUnmarshal(m, parent);
  }


  public static class TransformationEventBuilder {
    private String type;
    private String eventID;
    private String hash;
    private String eventTimeZoneOffset;
    private OffsetDateTime eventTime;
    private OffsetDateTime recordTime;
    private String bizStep;
    private String disposition;
    private PersistentDisposition persistentDisposition;
    private ReadPoint readPoint;
    private BizLocation bizLocation;
    private ErrorDeclaration errorDeclaration;
    private Map<String, Object> extension;
    private Map<String, Object> userExtensions;
    private Map<String, Object> innerUserExtensions;
    private List<Object> contextInfo;
    private Object certificationInfo;
    private List<SourceList> sourceList;
    private List<DestinationList> destinationList;
    private List<SensorElementList> sensorElementList;
    private int sequenceInEPCISDoc;
    private String captureId;
    private List<String> inputEPCList;
    private List<String> outputEPCList;
    private List<QuantityList> inputQuantityList;
    private List<QuantityList> outputQuantityList;
    private String transformationID;
    private List<BizTransactionList> bizTransactionList;
    private Map<String, Object> ilmdXml;
    private Ilmd ilmd;
    private OpenEPCISExtension openEPCISExtension;

    TransformationEventBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder eventID(String eventID) {
      this.eventID = eventID;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder hash(String hash) {
      this.hash = hash;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder eventTimeZoneOffset(String eventTimeZoneOffset) {
      this.eventTimeZoneOffset = eventTimeZoneOffset;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder eventTime(OffsetDateTime eventTime) {
      this.eventTime = eventTime;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder recordTime(OffsetDateTime recordTime) {
      this.recordTime = recordTime;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder bizStep(String bizStep) {
      this.bizStep = bizStep;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder disposition(String disposition) {
      this.disposition = disposition;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder persistentDisposition(PersistentDisposition persistentDisposition) {
      this.persistentDisposition = persistentDisposition;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder readPoint(ReadPoint readPoint) {
      this.readPoint = readPoint;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder bizLocation(BizLocation bizLocation) {
      this.bizLocation = bizLocation;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder errorDeclaration(ErrorDeclaration errorDeclaration) {
      this.errorDeclaration = errorDeclaration;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder extension(Map<String, Object> extension) {
      this.extension = extension;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder userExtensions(Map<String, Object> userExtensions) {
      this.userExtensions = userExtensions;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder innerUserExtensions(Map<String, Object> innerUserExtensions) {
      this.innerUserExtensions = innerUserExtensions;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder contextInfo(List<Object> contextInfo) {
      this.contextInfo = contextInfo;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder certificationInfo(Object certificationInfo) {
      this.certificationInfo = certificationInfo;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder sourceList(List<SourceList> sourceList) {
      this.sourceList = sourceList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder destinationList(List<DestinationList> destinationList) {
      this.destinationList = destinationList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder sensorElementList(List<SensorElementList> sensorElementList) {
      this.sensorElementList = sensorElementList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder sequenceInEPCISDoc(int sequenceInEPCISDoc) {
      this.sequenceInEPCISDoc = sequenceInEPCISDoc;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder captureId(String captureId) {
      this.captureId = captureId;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder inputEPCList(List<String> inputEPCList) {
      this.inputEPCList = inputEPCList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder outputEPCList(List<String> outputEPCList) {
      this.outputEPCList = outputEPCList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder inputQuantityList(List<QuantityList> inputQuantityList) {
      this.inputQuantityList = inputQuantityList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder outputQuantityList(List<QuantityList> outputQuantityList) {
      this.outputQuantityList = outputQuantityList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder transformationID(String transformationID) {
      this.transformationID = transformationID;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder bizTransactionList(List<BizTransactionList> bizTransactionList) {
      this.bizTransactionList = bizTransactionList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder ilmdXml(Map<String, Object> ilmdXml) {
      this.ilmdXml = ilmdXml;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder ilmd(Ilmd ilmd) {
      this.ilmd = ilmd;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransformationEvent.TransformationEventBuilder openEPCISExtension(OpenEPCISExtension openEPCISExtension) {
      this.openEPCISExtension = openEPCISExtension;
      return this;
    }

    public TransformationEvent build() {
      return new TransformationEvent(this.type, this.eventID, this.hash, this.eventTimeZoneOffset, this.eventTime, this.recordTime, this.bizStep, this.disposition, this.persistentDisposition, this.readPoint, this.bizLocation, this.errorDeclaration, this.extension, this.userExtensions, this.innerUserExtensions, this.contextInfo, this.certificationInfo, this.sourceList, this.destinationList, this.sensorElementList, this.sequenceInEPCISDoc, this.captureId, this.inputEPCList, this.outputEPCList, this.inputQuantityList, this.outputQuantityList, this.transformationID, this.bizTransactionList, this.ilmdXml, this.ilmd, this.openEPCISExtension);
    }

    @Override
    public String toString() {
      return "TransformationEvent.TransformationEventBuilder(type=" + this.type + ", eventID=" + this.eventID + ", hash=" + this.hash + ", eventTimeZoneOffset=" + this.eventTimeZoneOffset + ", eventTime=" + this.eventTime + ", recordTime=" + this.recordTime + ", bizStep=" + this.bizStep + ", disposition=" + this.disposition + ", persistentDisposition=" + this.persistentDisposition + ", readPoint=" + this.readPoint + ", bizLocation=" + this.bizLocation + ", errorDeclaration=" + this.errorDeclaration + ", extension=" + this.extension + ", userExtensions=" + this.userExtensions + ", innerUserExtensions=" + this.innerUserExtensions + ", contextInfo=" + this.contextInfo + ", certificationInfo=" + this.certificationInfo + ", sourceList=" + this.sourceList + ", destinationList=" + this.destinationList + ", sensorElementList=" + this.sensorElementList + ", sequenceInEPCISDoc=" + this.sequenceInEPCISDoc + ", captureId=" + this.captureId + ", inputEPCList=" + this.inputEPCList + ", outputEPCList=" + this.outputEPCList + ", inputQuantityList=" + this.inputQuantityList + ", outputQuantityList=" + this.outputQuantityList + ", transformationID=" + this.transformationID + ", bizTransactionList=" + this.bizTransactionList + ", ilmdXml=" + this.ilmdXml + ", ilmd=" + this.ilmd + ", openEPCISExtension=" + this.openEPCISExtension + ")";
    }
  }

  public static TransformationEvent.TransformationEventBuilder transformationEventBuilder() {
    return new TransformationEvent.TransformationEventBuilder();
  }

  public PersistentDisposition getPersistentDisposition() {
    return this.persistentDisposition;
  }

  public List<String> getInputEPCList() {
    return this.inputEPCList;
  }

  public List<String> getOutputEPCList() {
    return this.outputEPCList;
  }

  public List<QuantityList> getInputQuantityList() {
    return this.inputQuantityList;
  }

  public List<QuantityList> getOutputQuantityList() {
    return this.outputQuantityList;
  }

  public String getTransformationID() {
    return this.transformationID;
  }

  public List<BizTransactionList> getBizTransactionList() {
    return this.bizTransactionList;
  }

  public Ilmd getIlmd() {
    return this.ilmd;
  }

  public Map<String, Object> getIlmdXml() {
    return this.ilmdXml;
  }

  public void setPersistentDisposition(PersistentDisposition persistentDisposition) {
    this.persistentDisposition = persistentDisposition;
  }

  public void setInputEPCList(List<String> inputEPCList) {
    this.inputEPCList = inputEPCList;
  }

  public void setOutputEPCList(List<String> outputEPCList) {
    this.outputEPCList = outputEPCList;
  }

  public void setInputQuantityList(List<QuantityList> inputQuantityList) {
    this.inputQuantityList = inputQuantityList;
  }

  public void setOutputQuantityList(List<QuantityList> outputQuantityList) {
    this.outputQuantityList = outputQuantityList;
  }

  public void setTransformationID(String transformationID) {
    this.transformationID = transformationID;
  }

  public void setBizTransactionList(List<BizTransactionList> bizTransactionList) {
    this.bizTransactionList = bizTransactionList;
  }

  public void setIlmd(Ilmd ilmd) {
    this.ilmd = ilmd;
  }

  public void setIlmdXml(Map<String, Object> ilmdXml) {
    this.ilmdXml = ilmdXml;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof TransformationEvent)) return false;
    TransformationEvent other = (TransformationEvent) o;
    if (!other.canEqual((Object) this)) return false;
    if (!super.equals(o)) return false;
    Object this$persistentDisposition = this.getPersistentDisposition();
    Object other$persistentDisposition = other.getPersistentDisposition();
    if (this$persistentDisposition == null ? other$persistentDisposition != null : !this$persistentDisposition.equals(other$persistentDisposition)) return false;
    Object this$inputEPCList = this.getInputEPCList();
    Object other$inputEPCList = other.getInputEPCList();
    if (this$inputEPCList == null ? other$inputEPCList != null : !this$inputEPCList.equals(other$inputEPCList)) return false;
    Object this$outputEPCList = this.getOutputEPCList();
    Object other$outputEPCList = other.getOutputEPCList();
    if (this$outputEPCList == null ? other$outputEPCList != null : !this$outputEPCList.equals(other$outputEPCList)) return false;
    Object this$inputQuantityList = this.getInputQuantityList();
    Object other$inputQuantityList = other.getInputQuantityList();
    if (this$inputQuantityList == null ? other$inputQuantityList != null : !this$inputQuantityList.equals(other$inputQuantityList)) return false;
    Object this$outputQuantityList = this.getOutputQuantityList();
    Object other$outputQuantityList = other.getOutputQuantityList();
    if (this$outputQuantityList == null ? other$outputQuantityList != null : !this$outputQuantityList.equals(other$outputQuantityList)) return false;
    Object this$transformationID = this.getTransformationID();
    Object other$transformationID = other.getTransformationID();
    if (this$transformationID == null ? other$transformationID != null : !this$transformationID.equals(other$transformationID)) return false;
    Object this$bizTransactionList = this.getBizTransactionList();
    Object other$bizTransactionList = other.getBizTransactionList();
    if (this$bizTransactionList == null ? other$bizTransactionList != null : !this$bizTransactionList.equals(other$bizTransactionList)) return false;
    Object this$ilmd = this.getIlmd();
    Object other$ilmd = other.getIlmd();
    if (this$ilmd == null ? other$ilmd != null : !this$ilmd.equals(other$ilmd)) return false;
    Object this$ilmdXml = this.getIlmdXml();
    Object other$ilmdXml = other.getIlmdXml();
    if (this$ilmdXml == null ? other$ilmdXml != null : !this$ilmdXml.equals(other$ilmdXml)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof TransformationEvent;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = super.hashCode();
    Object $persistentDisposition = this.getPersistentDisposition();
    result = result * PRIME + ($persistentDisposition == null ? 43 : $persistentDisposition.hashCode());
    Object $inputEPCList = this.getInputEPCList();
    result = result * PRIME + ($inputEPCList == null ? 43 : $inputEPCList.hashCode());
    Object $outputEPCList = this.getOutputEPCList();
    result = result * PRIME + ($outputEPCList == null ? 43 : $outputEPCList.hashCode());
    Object $inputQuantityList = this.getInputQuantityList();
    result = result * PRIME + ($inputQuantityList == null ? 43 : $inputQuantityList.hashCode());
    Object $outputQuantityList = this.getOutputQuantityList();
    result = result * PRIME + ($outputQuantityList == null ? 43 : $outputQuantityList.hashCode());
    Object $transformationID = this.getTransformationID();
    result = result * PRIME + ($transformationID == null ? 43 : $transformationID.hashCode());
    Object $bizTransactionList = this.getBizTransactionList();
    result = result * PRIME + ($bizTransactionList == null ? 43 : $bizTransactionList.hashCode());
    Object $ilmd = this.getIlmd();
    result = result * PRIME + ($ilmd == null ? 43 : $ilmd.hashCode());
    Object $ilmdXml = this.getIlmdXml();
    result = result * PRIME + ($ilmdXml == null ? 43 : $ilmdXml.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "TransformationEvent(super=" + super.toString() + ", persistentDisposition=" + this.getPersistentDisposition() + ", inputEPCList=" + this.getInputEPCList() + ", outputEPCList=" + this.getOutputEPCList() + ", inputQuantityList=" + this.getInputQuantityList() + ", outputQuantityList=" + this.getOutputQuantityList() + ", transformationID=" + this.getTransformationID() + ", bizTransactionList=" + this.getBizTransactionList() + ", ilmd=" + this.getIlmd() + ", ilmdXml=" + this.getIlmdXml() + ")";
  }

  public TransformationEvent() {
  }

  public TransformationEvent(PersistentDisposition persistentDisposition, List<String> inputEPCList, List<String> outputEPCList, List<QuantityList> inputQuantityList, List<QuantityList> outputQuantityList, String transformationID, List<BizTransactionList> bizTransactionList, Ilmd ilmd, Map<String, Object> ilmdXml) {
    this.persistentDisposition = persistentDisposition;
    this.inputEPCList = inputEPCList;
    this.outputEPCList = outputEPCList;
    this.inputQuantityList = inputQuantityList;
    this.outputQuantityList = outputQuantityList;
    this.transformationID = transformationID;
    this.bizTransactionList = bizTransactionList;
    this.ilmd = ilmd;
    this.ilmdXml = ilmdXml;
  }
}
