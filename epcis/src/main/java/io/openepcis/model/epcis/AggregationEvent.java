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
import io.openepcis.identifiers.converter.util.ConverterUtil;
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

@XmlType(name = "AggregationEvent", namespace = "urn:epcglobal:epcis:xsd:2", propOrder = {"eventTime", "recordTime", "eventTimeZoneOffset", "eventID", "errorDeclaration", "certificationInfo", "baseExtension", "parentID", "childEPCs", "action", "bizStep", "disposition", "readPoint", "bizLocation", "bizTransactionList", "childQuantityList", "sourceList", "destinationList", "sensorElementList", "extension", "anyElements"}, factoryClass = ObjectFactory.class, factoryMethod = "createAggregationEvent")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "type")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("AggregationEvent")
@XmlRootElement(name = "AggregationEvent")
@JsonPropertyOrder({"contextInfo", "type", "eventTime", "recordTime", "eventTimeZoneOffset", "eventID", "certificationInfo", "errorDeclaration", "parentID", "childEPCs", "action", "bizStep", "disposition", "readPoint", "bizLocation", "bizTransactionList", "childQuantityList", "sourceList", "destinationList", "sensorElementList", "userExtensions"})
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

  public AggregationEvent(String type, String eventID, String eventTimeZoneOffset, OffsetDateTime eventTime, OffsetDateTime recordTime, Action action, String bizStep, String disposition, ReadPoint readPoint, BizLocation bizLocation, ErrorDeclaration errorDeclaration, Map<String, Object> extension, Map<String, Object> userExtensions, Map<String, Object> innerUserExtensions, List<Object> contextInfo, Object certificationInfo, List<SourceList> sourceList, List<DestinationList> destinationList, List<SensorElementList> sensorElementList, List<QuantityList> childQuantityList, String parentID, List<String> childEPCs, List<BizTransactionList> bizTransactionList, OpenEPCISExtension openEPCISExtension) {
    super(type, eventID, eventTimeZoneOffset, eventTime, recordTime, bizStep, disposition, readPoint, bizLocation, errorDeclaration, sourceList, destinationList, sensorElementList, extension, userExtensions, innerUserExtensions, contextInfo, certificationInfo, null, openEPCISExtension);
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
      bizTransactionList.forEach(bizTransaction -> {
        if (bizTransaction.getType() != null && !bizTransaction.getType().equals("")) {
          bizTransaction.setType(bizTransaction.getType().contains("http") || bizTransaction.getType().contains(":") ? bizTransaction.getType() : ConverterUtil.toCbvVocabulary(bizTransaction.getType(), "bizTransactionList", "URN"));
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
      bizTransactionList.forEach(bizTransaction -> {
        if (bizTransaction.getType() != null && !bizTransaction.getType().equals("")) {
          bizTransaction.setType(ConverterUtil.toBareStringVocabulary(bizTransaction.getType()));
        }
      });
    }
    // Call the parent class afterUnmarshal method to modify the values
    super.afterUnmarshal(m, parent);
  }


  public static class AggregationEventBuilder {
    private String type;
    private String eventID;
    private String eventTimeZoneOffset;
    private OffsetDateTime eventTime;
    private OffsetDateTime recordTime;
    private Action action;
    private String bizStep;
    private String disposition;
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
    private List<QuantityList> childQuantityList;
    private String parentID;
    private List<String> childEPCs;
    private List<BizTransactionList> bizTransactionList;
    private OpenEPCISExtension openEPCISExtension;

    AggregationEventBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder eventID(String eventID) {
      this.eventID = eventID;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder eventTimeZoneOffset(String eventTimeZoneOffset) {
      this.eventTimeZoneOffset = eventTimeZoneOffset;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder eventTime(OffsetDateTime eventTime) {
      this.eventTime = eventTime;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder recordTime(OffsetDateTime recordTime) {
      this.recordTime = recordTime;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder action(Action action) {
      this.action = action;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder bizStep(String bizStep) {
      this.bizStep = bizStep;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder disposition(String disposition) {
      this.disposition = disposition;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder readPoint(ReadPoint readPoint) {
      this.readPoint = readPoint;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder bizLocation(BizLocation bizLocation) {
      this.bizLocation = bizLocation;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder errorDeclaration(ErrorDeclaration errorDeclaration) {
      this.errorDeclaration = errorDeclaration;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder extension(Map<String, Object> extension) {
      this.extension = extension;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder userExtensions(Map<String, Object> userExtensions) {
      this.userExtensions = userExtensions;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder innerUserExtensions(Map<String, Object> innerUserExtensions) {
      this.innerUserExtensions = innerUserExtensions;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder contextInfo(List<Object> contextInfo) {
      this.contextInfo = contextInfo;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder certificationInfo(Object certificationInfo) {
      this.certificationInfo = certificationInfo;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder sourceList(List<SourceList> sourceList) {
      this.sourceList = sourceList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder destinationList(List<DestinationList> destinationList) {
      this.destinationList = destinationList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder sensorElementList(List<SensorElementList> sensorElementList) {
      this.sensorElementList = sensorElementList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder childQuantityList(List<QuantityList> childQuantityList) {
      this.childQuantityList = childQuantityList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder parentID(String parentID) {
      this.parentID = parentID;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder childEPCs(List<String> childEPCs) {
      this.childEPCs = childEPCs;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder bizTransactionList(List<BizTransactionList> bizTransactionList) {
      this.bizTransactionList = bizTransactionList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public AggregationEvent.AggregationEventBuilder openEPCISExtension(OpenEPCISExtension openEPCISExtension) {
      this.openEPCISExtension = openEPCISExtension;
      return this;
    }

    public AggregationEvent build() {
      return new AggregationEvent(this.type, this.eventID, this.eventTimeZoneOffset, this.eventTime, this.recordTime, this.action, this.bizStep, this.disposition, this.readPoint, this.bizLocation, this.errorDeclaration, this.extension, this.userExtensions, this.innerUserExtensions, this.contextInfo, this.certificationInfo, this.sourceList, this.destinationList, this.sensorElementList, this.childQuantityList, this.parentID, this.childEPCs, this.bizTransactionList, this.openEPCISExtension);
    }

    @Override
    public String toString() {
      return "AggregationEvent.AggregationEventBuilder(type=" + this.type + ", eventID=" + this.eventID + ", eventTimeZoneOffset=" + this.eventTimeZoneOffset + ", eventTime=" + this.eventTime + ", recordTime=" + this.recordTime + ", action=" + this.action + ", bizStep=" + this.bizStep + ", disposition=" + this.disposition + ", readPoint=" + this.readPoint + ", bizLocation=" + this.bizLocation + ", errorDeclaration=" + this.errorDeclaration + ", extension=" + this.extension + ", userExtensions=" + this.userExtensions + ", innerUserExtensions=" + this.innerUserExtensions + ", contextInfo=" + this.contextInfo + ", certificationInfo=" + this.certificationInfo + ", sourceList=" + this.sourceList + ", destinationList=" + this.destinationList + ", sensorElementList=" + this.sensorElementList + ", childQuantityList=" + this.childQuantityList + ", parentID=" + this.parentID + ", childEPCs=" + this.childEPCs + ", bizTransactionList=" + this.bizTransactionList + ", openEPCISExtension=" + this.openEPCISExtension + ")";
    }
  }

  public static AggregationEvent.AggregationEventBuilder aggregationEventBuilder() {
    return new AggregationEvent.AggregationEventBuilder();
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof AggregationEvent)) return false;
    AggregationEvent other = (AggregationEvent) o;
    if (!other.canEqual((Object) this)) return false;
    if (!super.equals(o)) return false;
    Object this$action = this.getAction();
    Object other$action = other.getAction();
    if (this$action == null ? other$action != null : !this$action.equals(other$action)) return false;
    Object this$childQuantityList = this.getChildQuantityList();
    Object other$childQuantityList = other.getChildQuantityList();
    if (this$childQuantityList == null ? other$childQuantityList != null : !this$childQuantityList.equals(other$childQuantityList)) return false;
    Object this$parentID = this.getParentID();
    Object other$parentID = other.getParentID();
    if (this$parentID == null ? other$parentID != null : !this$parentID.equals(other$parentID)) return false;
    Object this$childEPCs = this.getChildEPCs();
    Object other$childEPCs = other.getChildEPCs();
    if (this$childEPCs == null ? other$childEPCs != null : !this$childEPCs.equals(other$childEPCs)) return false;
    Object this$bizTransactionList = this.getBizTransactionList();
    Object other$bizTransactionList = other.getBizTransactionList();
    if (this$bizTransactionList == null ? other$bizTransactionList != null : !this$bizTransactionList.equals(other$bizTransactionList)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof AggregationEvent;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = super.hashCode();
    Object $action = this.getAction();
    result = result * PRIME + ($action == null ? 43 : $action.hashCode());
    Object $childQuantityList = this.getChildQuantityList();
    result = result * PRIME + ($childQuantityList == null ? 43 : $childQuantityList.hashCode());
    Object $parentID = this.getParentID();
    result = result * PRIME + ($parentID == null ? 43 : $parentID.hashCode());
    Object $childEPCs = this.getChildEPCs();
    result = result * PRIME + ($childEPCs == null ? 43 : $childEPCs.hashCode());
    Object $bizTransactionList = this.getBizTransactionList();
    result = result * PRIME + ($bizTransactionList == null ? 43 : $bizTransactionList.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "AggregationEvent(super=" + super.toString() + ", action=" + this.getAction() + ", childQuantityList=" + this.getChildQuantityList() + ", parentID=" + this.getParentID() + ", childEPCs=" + this.getChildEPCs() + ", bizTransactionList=" + this.getBizTransactionList() + ")";
  }

  public Action getAction() {
    return this.action;
  }

  public List<QuantityList> getChildQuantityList() {
    return this.childQuantityList;
  }

  public String getParentID() {
    return this.parentID;
  }

  public List<String> getChildEPCs() {
    return this.childEPCs;
  }

  public List<BizTransactionList> getBizTransactionList() {
    return this.bizTransactionList;
  }

  public void setAction(Action action) {
    this.action = action;
  }

  public void setChildQuantityList(List<QuantityList> childQuantityList) {
    this.childQuantityList = childQuantityList;
  }

  public void setParentID(String parentID) {
    this.parentID = parentID;
  }

  public void setChildEPCs(List<String> childEPCs) {
    this.childEPCs = childEPCs;
  }

  public void setBizTransactionList(List<BizTransactionList> bizTransactionList) {
    this.bizTransactionList = bizTransactionList;
  }

  public AggregationEvent() {
  }
}
