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

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.openepcis.model.epcis.modifier.*;
import io.openepcis.model.epcis.util.ConversionNamespaceContext;
import io.openepcis.model.epcis.util.NamespaceContextAware;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.NONE)
public class SensorMetadata implements Serializable, NamespaceContextAware {
  @XmlAttribute
  @XmlJavaTypeAdapter(CustomInstantAdapter.class)
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  private OffsetDateTime time;
  @XmlAttribute
  private URI deviceID;
  @XmlAttribute
  private URI deviceMetadata;
  @XmlAttribute
  private URI rawData;
  @XmlAttribute
  @XmlJavaTypeAdapter(CustomInstantAdapter.class)
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  private OffsetDateTime startTime;
  @XmlAttribute
  @XmlJavaTypeAdapter(CustomInstantAdapter.class)
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  private OffsetDateTime endTime;
  @XmlAttribute
  private URI dataProcessingMethod;
  @XmlAttribute
  private URI bizRules;
  @JsonIgnore
  @XmlTransient
  private Map<String, Object> innerUserExtensions;
  @JsonIgnore
  @XmlTransient
  private Map<String, Object> userExtensions;
  @XmlAnyAttribute
  @JsonIgnore
  private Map<QName, Object> anyAttributes;
  @JsonIgnore
  @XmlTransient
  private ConversionNamespaceContext namespaceContext;

  @Override
  public void setNamespaceContext(ConversionNamespaceContext context) {
    this.namespaceContext = context;
  }

  @Override
  public ConversionNamespaceContext getNamespaceContext() {
    return this.namespaceContext;
  }

  @JsonAnySetter
  public void setUserExtensions(String key, Object value) {
    anyAttributes.put(new QName(key), value);
  }

  @JsonAnyGetter
  @JsonSerialize(using = CustomExtensionsSerializer.class)
  @UserExtensions(extension = "userExtensions")
  public Map<String, Object> getUserExtensions() {
    return userExtensions;
  }

  public void afterUnmarshal(Unmarshaller m, Object parent) {
    // If there are any user-defined attributes in Sensor Metadata then read them and write to
    // User-Extensions MAP
    if (anyAttributes != null) {
      userExtensions = new HashMap<>();
      anyAttributes.forEach((key, value) -> userExtensions.put(CommonExtensionModifier.getNamespacePrefix(key, namespaceContext), value));
      anyAttributes = new HashMap<>();
    }
  }

  private static Map<String, Object> $default$userExtensions() {
    return new HashMap<>();
  }

  private static Map<QName, Object> $default$anyAttributes() {
    return new HashMap<>();
  }


  public static class SensorMetadataBuilder {
    private OffsetDateTime time;
    private URI deviceID;
    private URI deviceMetadata;
    private URI rawData;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private URI dataProcessingMethod;
    private URI bizRules;
    private Map<String, Object> innerUserExtensions;
    private boolean userExtensions$set;
    private Map<String, Object> userExtensions$value;
    private boolean anyAttributes$set;
    private Map<QName, Object> anyAttributes$value;
    private ConversionNamespaceContext namespaceContext;

    SensorMetadataBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public SensorMetadata.SensorMetadataBuilder time(OffsetDateTime time) {
      this.time = time;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorMetadata.SensorMetadataBuilder deviceID(URI deviceID) {
      this.deviceID = deviceID;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorMetadata.SensorMetadataBuilder deviceMetadata(URI deviceMetadata) {
      this.deviceMetadata = deviceMetadata;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorMetadata.SensorMetadataBuilder rawData(URI rawData) {
      this.rawData = rawData;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorMetadata.SensorMetadataBuilder startTime(OffsetDateTime startTime) {
      this.startTime = startTime;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorMetadata.SensorMetadataBuilder endTime(OffsetDateTime endTime) {
      this.endTime = endTime;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorMetadata.SensorMetadataBuilder dataProcessingMethod(URI dataProcessingMethod) {
      this.dataProcessingMethod = dataProcessingMethod;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorMetadata.SensorMetadataBuilder bizRules(URI bizRules) {
      this.bizRules = bizRules;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public SensorMetadata.SensorMetadataBuilder innerUserExtensions(Map<String, Object> innerUserExtensions) {
      this.innerUserExtensions = innerUserExtensions;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public SensorMetadata.SensorMetadataBuilder userExtensions(Map<String, Object> userExtensions) {
      this.userExtensions$value = userExtensions;
      userExtensions$set = true;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public SensorMetadata.SensorMetadataBuilder anyAttributes(Map<QName, Object> anyAttributes) {
      this.anyAttributes$value = anyAttributes;
      anyAttributes$set = true;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public SensorMetadata.SensorMetadataBuilder namespaceContext(ConversionNamespaceContext namespaceContext) {
      this.namespaceContext = namespaceContext;
      return this;
    }

    public SensorMetadata build() {
      Map<String, Object> userExtensions$value = this.userExtensions$value;
      if (!this.userExtensions$set) userExtensions$value = SensorMetadata.$default$userExtensions();
      Map<QName, Object> anyAttributes$value = this.anyAttributes$value;
      if (!this.anyAttributes$set) anyAttributes$value = SensorMetadata.$default$anyAttributes();
      return new SensorMetadata(this.time, this.deviceID, this.deviceMetadata, this.rawData, this.startTime, this.endTime, this.dataProcessingMethod, this.bizRules, this.innerUserExtensions, userExtensions$value, anyAttributes$value, this.namespaceContext);
    }

    @Override
    public String toString() {
      return "SensorMetadata.SensorMetadataBuilder(time=" + this.time + ", deviceID=" + this.deviceID + ", deviceMetadata=" + this.deviceMetadata + ", rawData=" + this.rawData + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", dataProcessingMethod=" + this.dataProcessingMethod + ", bizRules=" + this.bizRules + ", innerUserExtensions=" + this.innerUserExtensions + ", userExtensions$value=" + this.userExtensions$value + ", anyAttributes$value=" + this.anyAttributes$value + ", namespaceContext=" + this.namespaceContext + ")";
    }
  }

  public static SensorMetadata.SensorMetadataBuilder builder() {
    return new SensorMetadata.SensorMetadataBuilder();
  }

  public OffsetDateTime getTime() {
    return this.time;
  }

  public URI getDeviceID() {
    return this.deviceID;
  }

  public URI getDeviceMetadata() {
    return this.deviceMetadata;
  }

  public URI getRawData() {
    return this.rawData;
  }

  public OffsetDateTime getStartTime() {
    return this.startTime;
  }

  public OffsetDateTime getEndTime() {
    return this.endTime;
  }

  public URI getDataProcessingMethod() {
    return this.dataProcessingMethod;
  }

  public URI getBizRules() {
    return this.bizRules;
  }

  public Map<String, Object> getInnerUserExtensions() {
    return this.innerUserExtensions;
  }

  public Map<QName, Object> getAnyAttributes() {
    return this.anyAttributes;
  }

  public void setTime(OffsetDateTime time) {
    this.time = time;
  }

  public void setDeviceID(URI deviceID) {
    this.deviceID = deviceID;
  }

  public void setDeviceMetadata(URI deviceMetadata) {
    this.deviceMetadata = deviceMetadata;
  }

  public void setRawData(URI rawData) {
    this.rawData = rawData;
  }

  public void setStartTime(OffsetDateTime startTime) {
    this.startTime = startTime;
  }

  public void setEndTime(OffsetDateTime endTime) {
    this.endTime = endTime;
  }

  public void setDataProcessingMethod(URI dataProcessingMethod) {
    this.dataProcessingMethod = dataProcessingMethod;
  }

  public void setBizRules(URI bizRules) {
    this.bizRules = bizRules;
  }

  public void setInnerUserExtensions(Map<String, Object> innerUserExtensions) {
    this.innerUserExtensions = innerUserExtensions;
  }

  public void setUserExtensions(Map<String, Object> userExtensions) {
    this.userExtensions = userExtensions;
  }

  public void setAnyAttributes(Map<QName, Object> anyAttributes) {
    this.anyAttributes = anyAttributes;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof SensorMetadata)) return false;
    SensorMetadata other = (SensorMetadata) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$time = this.getTime();
    Object other$time = other.getTime();
    if (this$time == null ? other$time != null : !this$time.equals(other$time)) return false;
    Object this$deviceID = this.getDeviceID();
    Object other$deviceID = other.getDeviceID();
    if (this$deviceID == null ? other$deviceID != null : !this$deviceID.equals(other$deviceID)) return false;
    Object this$deviceMetadata = this.getDeviceMetadata();
    Object other$deviceMetadata = other.getDeviceMetadata();
    if (this$deviceMetadata == null ? other$deviceMetadata != null : !this$deviceMetadata.equals(other$deviceMetadata)) return false;
    Object this$rawData = this.getRawData();
    Object other$rawData = other.getRawData();
    if (this$rawData == null ? other$rawData != null : !this$rawData.equals(other$rawData)) return false;
    Object this$startTime = this.getStartTime();
    Object other$startTime = other.getStartTime();
    if (this$startTime == null ? other$startTime != null : !this$startTime.equals(other$startTime)) return false;
    Object this$endTime = this.getEndTime();
    Object other$endTime = other.getEndTime();
    if (this$endTime == null ? other$endTime != null : !this$endTime.equals(other$endTime)) return false;
    Object this$dataProcessingMethod = this.getDataProcessingMethod();
    Object other$dataProcessingMethod = other.getDataProcessingMethod();
    if (this$dataProcessingMethod == null ? other$dataProcessingMethod != null : !this$dataProcessingMethod.equals(other$dataProcessingMethod)) return false;
    Object this$bizRules = this.getBizRules();
    Object other$bizRules = other.getBizRules();
    if (this$bizRules == null ? other$bizRules != null : !this$bizRules.equals(other$bizRules)) return false;
    Object this$innerUserExtensions = this.getInnerUserExtensions();
    Object other$innerUserExtensions = other.getInnerUserExtensions();
    if (this$innerUserExtensions == null ? other$innerUserExtensions != null : !this$innerUserExtensions.equals(other$innerUserExtensions)) return false;
    Object this$userExtensions = this.getUserExtensions();
    Object other$userExtensions = other.getUserExtensions();
    if (this$userExtensions == null ? other$userExtensions != null : !this$userExtensions.equals(other$userExtensions)) return false;
    Object this$anyAttributes = this.getAnyAttributes();
    Object other$anyAttributes = other.getAnyAttributes();
    if (this$anyAttributes == null ? other$anyAttributes != null : !this$anyAttributes.equals(other$anyAttributes)) return false;
    Object this$namespaceContext = this.getNamespaceContext();
    Object other$namespaceContext = other.getNamespaceContext();
    if (this$namespaceContext == null ? other$namespaceContext != null : !this$namespaceContext.equals(other$namespaceContext)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof SensorMetadata;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $time = this.getTime();
    result = result * PRIME + ($time == null ? 43 : $time.hashCode());
    Object $deviceID = this.getDeviceID();
    result = result * PRIME + ($deviceID == null ? 43 : $deviceID.hashCode());
    Object $deviceMetadata = this.getDeviceMetadata();
    result = result * PRIME + ($deviceMetadata == null ? 43 : $deviceMetadata.hashCode());
    Object $rawData = this.getRawData();
    result = result * PRIME + ($rawData == null ? 43 : $rawData.hashCode());
    Object $startTime = this.getStartTime();
    result = result * PRIME + ($startTime == null ? 43 : $startTime.hashCode());
    Object $endTime = this.getEndTime();
    result = result * PRIME + ($endTime == null ? 43 : $endTime.hashCode());
    Object $dataProcessingMethod = this.getDataProcessingMethod();
    result = result * PRIME + ($dataProcessingMethod == null ? 43 : $dataProcessingMethod.hashCode());
    Object $bizRules = this.getBizRules();
    result = result * PRIME + ($bizRules == null ? 43 : $bizRules.hashCode());
    Object $innerUserExtensions = this.getInnerUserExtensions();
    result = result * PRIME + ($innerUserExtensions == null ? 43 : $innerUserExtensions.hashCode());
    Object $userExtensions = this.getUserExtensions();
    result = result * PRIME + ($userExtensions == null ? 43 : $userExtensions.hashCode());
    Object $anyAttributes = this.getAnyAttributes();
    result = result * PRIME + ($anyAttributes == null ? 43 : $anyAttributes.hashCode());
    Object $namespaceContext = this.getNamespaceContext();
    result = result * PRIME + ($namespaceContext == null ? 43 : $namespaceContext.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "SensorMetadata(time=" + this.getTime() + ", deviceID=" + this.getDeviceID() + ", deviceMetadata=" + this.getDeviceMetadata() + ", rawData=" + this.getRawData() + ", startTime=" + this.getStartTime() + ", endTime=" + this.getEndTime() + ", dataProcessingMethod=" + this.getDataProcessingMethod() + ", bizRules=" + this.getBizRules() + ", innerUserExtensions=" + this.getInnerUserExtensions() + ", userExtensions=" + this.getUserExtensions() + ", anyAttributes=" + this.getAnyAttributes() + ", namespaceContext=" + this.getNamespaceContext() + ")";
  }

  public SensorMetadata() {
    this.userExtensions = SensorMetadata.$default$userExtensions();
    this.anyAttributes = SensorMetadata.$default$anyAttributes();
  }

  public SensorMetadata(OffsetDateTime time, URI deviceID, URI deviceMetadata, URI rawData, OffsetDateTime startTime, OffsetDateTime endTime, URI dataProcessingMethod, URI bizRules, Map<String, Object> innerUserExtensions, Map<String, Object> userExtensions, Map<QName, Object> anyAttributes, ConversionNamespaceContext namespaceContext) {
    this.time = time;
    this.deviceID = deviceID;
    this.deviceMetadata = deviceMetadata;
    this.rawData = rawData;
    this.startTime = startTime;
    this.endTime = endTime;
    this.dataProcessingMethod = dataProcessingMethod;
    this.bizRules = bizRules;
    this.innerUserExtensions = innerUserExtensions;
    this.userExtensions = userExtensions;
    this.anyAttributes = anyAttributes;
    this.namespaceContext = namespaceContext;
  }
}
