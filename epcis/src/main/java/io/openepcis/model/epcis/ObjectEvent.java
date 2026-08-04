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

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "type")
@XmlRootElement(name = "ObjectEvent")
@XmlType(name = "ObjectEvent", namespace = "urn:epcglobal:epcis:xsd:2", propOrder = {"eventTime", "recordTime", "eventTimeZoneOffset", "eventID", "errorDeclaration", "certificationInfo", "baseExtension", "epcList", "action", "bizStep", "disposition", "readPoint", "bizLocation", "bizTransactionList", "quantityList", "sourceList", "destinationList", "sensorElementList", "persistentDisposition", "ilmdXml", "extension", "anyElements"}, factoryClass = ObjectFactory.class, factoryMethod = "createObjectEvent")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"contextInfo", "type", "eventTime", "recordTime", "eventTimeZoneOffset", "eventID", "certificationInfo", "errorDeclaration", "epcList", "action", "bizStep", "disposition", "readPoint", "bizLocation", "bizTransactionList", "quantityList", "sourceList", "destinationList", "sensorElementList", "persistentDisposition", "ilmd", "userExtensions"})
public class ObjectEvent extends EPCISEvent implements XmlSupportExtension {
  private PersistentDisposition persistentDisposition;
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

  public ObjectEvent(String type, String eventID, String eventTimeZoneOffset, OffsetDateTime eventTime, OffsetDateTime recordTime, Action action, String bizStep, String disposition, PersistentDisposition persistentDisposition, ReadPoint readPoint, BizLocation bizLocation, ErrorDeclaration errorDeclaration, Map<String, Object> extension, Map<String, Object> userExtensions, Map<String, Object> innerUserExtensions, List<Object> contextInfo, Object certificationInfo, List<SourceList> sourceList, List<DestinationList> destinationList, List<SensorElementList> sensorElementList, List<QuantityList> quantityList, List<String> epcList, List<BizTransactionList> bizTransactionList, Ilmd ilmd, Map<String, Object> ilmdXml, OpenEPCISExtension openEPCISExtension) {
    super(type, eventID, eventTimeZoneOffset, eventTime, recordTime, bizStep, disposition, readPoint, bizLocation, errorDeclaration, sourceList, destinationList, sensorElementList, extension, userExtensions, innerUserExtensions, contextInfo, certificationInfo, null, openEPCISExtension);
    this.action = action;
    this.quantityList = quantityList;
    this.epcList = epcList;
    this.ilmd = ilmd;
    this.bizTransactionList = bizTransactionList;
    this.persistentDisposition = persistentDisposition;
    this.ilmdXml = ilmdXml;
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


  public static class ObjectEventBuilder {
    private String type;
    private String eventID;
    private String eventTimeZoneOffset;
    private OffsetDateTime eventTime;
    private OffsetDateTime recordTime;
    private Action action;
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
    private List<QuantityList> quantityList;
    private List<String> epcList;
    private List<BizTransactionList> bizTransactionList;
    private Ilmd ilmd;
    private Map<String, Object> ilmdXml;
    private OpenEPCISExtension openEPCISExtension;

    ObjectEventBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder eventID(String eventID) {
      this.eventID = eventID;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder eventTimeZoneOffset(String eventTimeZoneOffset) {
      this.eventTimeZoneOffset = eventTimeZoneOffset;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder eventTime(OffsetDateTime eventTime) {
      this.eventTime = eventTime;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder recordTime(OffsetDateTime recordTime) {
      this.recordTime = recordTime;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder action(Action action) {
      this.action = action;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder bizStep(String bizStep) {
      this.bizStep = bizStep;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder disposition(String disposition) {
      this.disposition = disposition;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder persistentDisposition(PersistentDisposition persistentDisposition) {
      this.persistentDisposition = persistentDisposition;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder readPoint(ReadPoint readPoint) {
      this.readPoint = readPoint;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder bizLocation(BizLocation bizLocation) {
      this.bizLocation = bizLocation;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder errorDeclaration(ErrorDeclaration errorDeclaration) {
      this.errorDeclaration = errorDeclaration;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder extension(Map<String, Object> extension) {
      this.extension = extension;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder userExtensions(Map<String, Object> userExtensions) {
      this.userExtensions = userExtensions;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder innerUserExtensions(Map<String, Object> innerUserExtensions) {
      this.innerUserExtensions = innerUserExtensions;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder contextInfo(List<Object> contextInfo) {
      this.contextInfo = contextInfo;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder certificationInfo(Object certificationInfo) {
      this.certificationInfo = certificationInfo;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder sourceList(List<SourceList> sourceList) {
      this.sourceList = sourceList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder destinationList(List<DestinationList> destinationList) {
      this.destinationList = destinationList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder sensorElementList(List<SensorElementList> sensorElementList) {
      this.sensorElementList = sensorElementList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder quantityList(List<QuantityList> quantityList) {
      this.quantityList = quantityList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder epcList(List<String> epcList) {
      this.epcList = epcList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder bizTransactionList(List<BizTransactionList> bizTransactionList) {
      this.bizTransactionList = bizTransactionList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder ilmd(Ilmd ilmd) {
      this.ilmd = ilmd;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder ilmdXml(Map<String, Object> ilmdXml) {
      this.ilmdXml = ilmdXml;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ObjectEvent.ObjectEventBuilder openEPCISExtension(OpenEPCISExtension openEPCISExtension) {
      this.openEPCISExtension = openEPCISExtension;
      return this;
    }

    public ObjectEvent build() {
      return new ObjectEvent(this.type, this.eventID, this.eventTimeZoneOffset, this.eventTime, this.recordTime, this.action, this.bizStep, this.disposition, this.persistentDisposition, this.readPoint, this.bizLocation, this.errorDeclaration, this.extension, this.userExtensions, this.innerUserExtensions, this.contextInfo, this.certificationInfo, this.sourceList, this.destinationList, this.sensorElementList, this.quantityList, this.epcList, this.bizTransactionList, this.ilmd, this.ilmdXml, this.openEPCISExtension);
    }

    @Override
    public String toString() {
      return "ObjectEvent.ObjectEventBuilder(type=" + this.type + ", eventID=" + this.eventID + ", eventTimeZoneOffset=" + this.eventTimeZoneOffset + ", eventTime=" + this.eventTime + ", recordTime=" + this.recordTime + ", action=" + this.action + ", bizStep=" + this.bizStep + ", disposition=" + this.disposition + ", persistentDisposition=" + this.persistentDisposition + ", readPoint=" + this.readPoint + ", bizLocation=" + this.bizLocation + ", errorDeclaration=" + this.errorDeclaration + ", extension=" + this.extension + ", userExtensions=" + this.userExtensions + ", innerUserExtensions=" + this.innerUserExtensions + ", contextInfo=" + this.contextInfo + ", certificationInfo=" + this.certificationInfo + ", sourceList=" + this.sourceList + ", destinationList=" + this.destinationList + ", sensorElementList=" + this.sensorElementList + ", quantityList=" + this.quantityList + ", epcList=" + this.epcList + ", bizTransactionList=" + this.bizTransactionList + ", ilmd=" + this.ilmd + ", ilmdXml=" + this.ilmdXml + ", openEPCISExtension=" + this.openEPCISExtension + ")";
    }
  }

  public static ObjectEvent.ObjectEventBuilder objectEventBuilder() {
    return new ObjectEvent.ObjectEventBuilder();
  }

  public PersistentDisposition getPersistentDisposition() {
    return this.persistentDisposition;
  }

  public Action getAction() {
    return this.action;
  }

  public List<String> getEpcList() {
    return this.epcList;
  }

  public List<QuantityList> getQuantityList() {
    return this.quantityList;
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

  public void setAction(Action action) {
    this.action = action;
  }

  public void setEpcList(List<String> epcList) {
    this.epcList = epcList;
  }

  public void setQuantityList(List<QuantityList> quantityList) {
    this.quantityList = quantityList;
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

  public ObjectEvent() {
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof ObjectEvent)) return false;
    ObjectEvent other = (ObjectEvent) o;
    if (!other.canEqual((Object) this)) return false;
    if (!super.equals(o)) return false;
    Object this$persistentDisposition = this.getPersistentDisposition();
    Object other$persistentDisposition = other.getPersistentDisposition();
    if (this$persistentDisposition == null ? other$persistentDisposition != null : !this$persistentDisposition.equals(other$persistentDisposition)) return false;
    Object this$action = this.getAction();
    Object other$action = other.getAction();
    if (this$action == null ? other$action != null : !this$action.equals(other$action)) return false;
    Object this$epcList = this.getEpcList();
    Object other$epcList = other.getEpcList();
    if (this$epcList == null ? other$epcList != null : !this$epcList.equals(other$epcList)) return false;
    Object this$quantityList = this.getQuantityList();
    Object other$quantityList = other.getQuantityList();
    if (this$quantityList == null ? other$quantityList != null : !this$quantityList.equals(other$quantityList)) return false;
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
    return other instanceof ObjectEvent;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = super.hashCode();
    Object $persistentDisposition = this.getPersistentDisposition();
    result = result * PRIME + ($persistentDisposition == null ? 43 : $persistentDisposition.hashCode());
    Object $action = this.getAction();
    result = result * PRIME + ($action == null ? 43 : $action.hashCode());
    Object $epcList = this.getEpcList();
    result = result * PRIME + ($epcList == null ? 43 : $epcList.hashCode());
    Object $quantityList = this.getQuantityList();
    result = result * PRIME + ($quantityList == null ? 43 : $quantityList.hashCode());
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
    return "ObjectEvent(super=" + super.toString() + ", persistentDisposition=" + this.getPersistentDisposition() + ", action=" + this.getAction() + ", epcList=" + this.getEpcList() + ", quantityList=" + this.getQuantityList() + ", bizTransactionList=" + this.getBizTransactionList() + ", ilmd=" + this.getIlmd() + ", ilmdXml=" + this.getIlmdXml() + ")";
  }
}
