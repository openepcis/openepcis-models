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
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;

@XmlType(name = "TransactionEvent", namespace = "urn:epcglobal:epcis:xsd:2", propOrder = {"eventTime", "recordTime", "eventTimeZoneOffset", "eventID", "errorDeclaration", "certificationInfo", "baseExtension", "bizTransactionList", "parentID", "epcList", "action", "bizStep", "disposition", "readPoint", "bizLocation", "quantityList", "sourceList", "destinationList", "sensorElementList", "extension", "anyElements"}, factoryClass = ObjectFactory.class, factoryMethod = "createTransactionEvent")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "type")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("TransactionEvent")
@XmlRootElement(name = "TransactionEvent")
@JsonPropertyOrder({"contextInfo", "type", "eventTime", "recordTime", "eventTimeZoneOffset", "eventID", "certificationInfo", "errorDeclaration", "bizTransactionList", "parentID", "epcList", "action", "bizStep", "disposition", "readPoint", "bizLocation", "quantityList", "sourceList", "destinationList", "sensorElementList", "userExtensions"})
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

  public TransactionEvent(String type, String eventID, String eventTimeZoneOffset, OffsetDateTime eventTime, OffsetDateTime recordTime, Action action, String bizStep, String disposition, ReadPoint readPoint, BizLocation bizLocation, ErrorDeclaration errorDeclaration, Map<String, Object> extension, Map<String, Object> userExtensions, Map<String, Object> innerUserExtensions, List<Object> contextInfo, Object certificationInfo, List<SourceList> sourceList, List<DestinationList> destinationList, List<SensorElementList> sensorElementList, List<BizTransactionList> bizTransactionList, String parentID, List<String> epcList, List<QuantityList> quantityList, OpenEPCISExtension openEPCISExtension) {
    super(type, eventID, eventTimeZoneOffset, eventTime, recordTime, bizStep, disposition, readPoint, bizLocation, errorDeclaration, sourceList, destinationList, sensorElementList, extension, userExtensions, innerUserExtensions, contextInfo, certificationInfo, null, openEPCISExtension);
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


  public static class TransactionEventBuilder {
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
    private List<BizTransactionList> bizTransactionList;
    private String parentID;
    private List<String> epcList;
    private List<QuantityList> quantityList;
    private OpenEPCISExtension openEPCISExtension;

    TransactionEventBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder eventID(String eventID) {
      this.eventID = eventID;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder eventTimeZoneOffset(String eventTimeZoneOffset) {
      this.eventTimeZoneOffset = eventTimeZoneOffset;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder eventTime(OffsetDateTime eventTime) {
      this.eventTime = eventTime;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder recordTime(OffsetDateTime recordTime) {
      this.recordTime = recordTime;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder action(Action action) {
      this.action = action;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder bizStep(String bizStep) {
      this.bizStep = bizStep;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder disposition(String disposition) {
      this.disposition = disposition;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder readPoint(ReadPoint readPoint) {
      this.readPoint = readPoint;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder bizLocation(BizLocation bizLocation) {
      this.bizLocation = bizLocation;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder errorDeclaration(ErrorDeclaration errorDeclaration) {
      this.errorDeclaration = errorDeclaration;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder extension(Map<String, Object> extension) {
      this.extension = extension;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder userExtensions(Map<String, Object> userExtensions) {
      this.userExtensions = userExtensions;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder innerUserExtensions(Map<String, Object> innerUserExtensions) {
      this.innerUserExtensions = innerUserExtensions;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder contextInfo(List<Object> contextInfo) {
      this.contextInfo = contextInfo;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder certificationInfo(Object certificationInfo) {
      this.certificationInfo = certificationInfo;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder sourceList(List<SourceList> sourceList) {
      this.sourceList = sourceList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder destinationList(List<DestinationList> destinationList) {
      this.destinationList = destinationList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder sensorElementList(List<SensorElementList> sensorElementList) {
      this.sensorElementList = sensorElementList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder bizTransactionList(List<BizTransactionList> bizTransactionList) {
      this.bizTransactionList = bizTransactionList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder parentID(String parentID) {
      this.parentID = parentID;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder epcList(List<String> epcList) {
      this.epcList = epcList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder quantityList(List<QuantityList> quantityList) {
      this.quantityList = quantityList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public TransactionEvent.TransactionEventBuilder openEPCISExtension(OpenEPCISExtension openEPCISExtension) {
      this.openEPCISExtension = openEPCISExtension;
      return this;
    }

    public TransactionEvent build() {
      return new TransactionEvent(this.type, this.eventID, this.eventTimeZoneOffset, this.eventTime, this.recordTime, this.action, this.bizStep, this.disposition, this.readPoint, this.bizLocation, this.errorDeclaration, this.extension, this.userExtensions, this.innerUserExtensions, this.contextInfo, this.certificationInfo, this.sourceList, this.destinationList, this.sensorElementList, this.bizTransactionList, this.parentID, this.epcList, this.quantityList, this.openEPCISExtension);
    }

    @Override
    public String toString() {
      return "TransactionEvent.TransactionEventBuilder(type=" + this.type + ", eventID=" + this.eventID + ", eventTimeZoneOffset=" + this.eventTimeZoneOffset + ", eventTime=" + this.eventTime + ", recordTime=" + this.recordTime + ", action=" + this.action + ", bizStep=" + this.bizStep + ", disposition=" + this.disposition + ", readPoint=" + this.readPoint + ", bizLocation=" + this.bizLocation + ", errorDeclaration=" + this.errorDeclaration + ", extension=" + this.extension + ", userExtensions=" + this.userExtensions + ", innerUserExtensions=" + this.innerUserExtensions + ", contextInfo=" + this.contextInfo + ", certificationInfo=" + this.certificationInfo + ", sourceList=" + this.sourceList + ", destinationList=" + this.destinationList + ", sensorElementList=" + this.sensorElementList + ", bizTransactionList=" + this.bizTransactionList + ", parentID=" + this.parentID + ", epcList=" + this.epcList + ", quantityList=" + this.quantityList + ", openEPCISExtension=" + this.openEPCISExtension + ")";
    }
  }

  public static TransactionEvent.TransactionEventBuilder transactionEventBuilder() {
    return new TransactionEvent.TransactionEventBuilder();
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof TransactionEvent)) return false;
    TransactionEvent other = (TransactionEvent) o;
    if (!other.canEqual((Object) this)) return false;
    if (!super.equals(o)) return false;
    Object this$action = this.getAction();
    Object other$action = other.getAction();
    if (this$action == null ? other$action != null : !this$action.equals(other$action)) return false;
    Object this$bizTransactionList = this.getBizTransactionList();
    Object other$bizTransactionList = other.getBizTransactionList();
    if (this$bizTransactionList == null ? other$bizTransactionList != null : !this$bizTransactionList.equals(other$bizTransactionList)) return false;
    Object this$parentID = this.getParentID();
    Object other$parentID = other.getParentID();
    if (this$parentID == null ? other$parentID != null : !this$parentID.equals(other$parentID)) return false;
    Object this$epcList = this.getEpcList();
    Object other$epcList = other.getEpcList();
    if (this$epcList == null ? other$epcList != null : !this$epcList.equals(other$epcList)) return false;
    Object this$quantityList = this.getQuantityList();
    Object other$quantityList = other.getQuantityList();
    if (this$quantityList == null ? other$quantityList != null : !this$quantityList.equals(other$quantityList)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof TransactionEvent;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = super.hashCode();
    Object $action = this.getAction();
    result = result * PRIME + ($action == null ? 43 : $action.hashCode());
    Object $bizTransactionList = this.getBizTransactionList();
    result = result * PRIME + ($bizTransactionList == null ? 43 : $bizTransactionList.hashCode());
    Object $parentID = this.getParentID();
    result = result * PRIME + ($parentID == null ? 43 : $parentID.hashCode());
    Object $epcList = this.getEpcList();
    result = result * PRIME + ($epcList == null ? 43 : $epcList.hashCode());
    Object $quantityList = this.getQuantityList();
    result = result * PRIME + ($quantityList == null ? 43 : $quantityList.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "TransactionEvent(super=" + super.toString() + ", action=" + this.getAction() + ", bizTransactionList=" + this.getBizTransactionList() + ", parentID=" + this.getParentID() + ", epcList=" + this.getEpcList() + ", quantityList=" + this.getQuantityList() + ")";
  }

  public Action getAction() {
    return this.action;
  }

  public List<BizTransactionList> getBizTransactionList() {
    return this.bizTransactionList;
  }

  public String getParentID() {
    return this.parentID;
  }

  public List<String> getEpcList() {
    return this.epcList;
  }

  public List<QuantityList> getQuantityList() {
    return this.quantityList;
  }

  public void setAction(Action action) {
    this.action = action;
  }

  public void setBizTransactionList(List<BizTransactionList> bizTransactionList) {
    this.bizTransactionList = bizTransactionList;
  }

  public void setParentID(String parentID) {
    this.parentID = parentID;
  }

  public void setEpcList(List<String> epcList) {
    this.epcList = epcList;
  }

  public void setQuantityList(List<QuantityList> quantityList) {
    this.quantityList = quantityList;
  }

  public TransactionEvent() {
  }
}
