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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.openepcis.model.epcis.modifier.*;
import io.openepcis.model.epcis.util.ConversionNamespaceContext;
import io.openepcis.model.epcis.util.NamespaceContextAware;
import jakarta.xml.bind.Marshaller;
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
public class SensorReport implements Serializable, NamespaceContextAware {
  @XmlAttribute
  private URI type;
  @XmlAttribute
  private String exception;
  @XmlAttribute
  private String coordinateReferenceSystem;
  @XmlAttribute
  private URI microorganism;
  @XmlAttribute
  private URI chemicalSubstance;
  @XmlAttribute
  @XmlJavaTypeAdapter(CustomInstantAdapter.class)
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  private OffsetDateTime time;
  @XmlAttribute
  private Double value;
  @XmlAttribute
  private String component;
  @XmlAttribute
  private String stringValue;
  @XmlAttribute
  private Boolean booleanValue;
  @XmlAttribute
  private String hexBinaryValue;
  @XmlAttribute
  private URI uriValue;
  @XmlAttribute
  private Double minValue;
  @XmlAttribute
  private Double maxValue;
  @XmlAttribute
  private Double meanValue;
  @XmlAttribute
  private Double sDev;
  @XmlAttribute
  private Double percRank;
  @XmlAttribute
  private Double percValue;
  @XmlAttribute
  private URI deviceID;
  @XmlAttribute
  private URI deviceMetadata;
  @XmlAttribute
  private URI rawData;
  @XmlAttribute
  private URI dataProcessingMethod;
  @XmlAttribute
  private String uom;
  @XmlAttribute
  private String bizRules;
  @JsonIgnore
  private Map<String, Object> innerUserExtensions;
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

  // Explicit getter annotated with the exact JSON name so Jackson does NOT derive a second property "sdev" from Lombok's getSDev().
  @JsonProperty("sDev")
  public Double getSDev() {
    return sDev;
  }

  private static final String EXAMPLE = "example:";

  public void afterUnmarshal(Unmarshaller m, Object parent) {
    // If there are any user-defined attributes in Sensor Metadata then read them and write to
    // User-Extensions MAP
    if (anyAttributes != null) {
      userExtensions = new HashMap<>();
      anyAttributes.forEach((key, value1) -> this.userExtensions.put(CommonExtensionModifier.getNamespacePrefix(key, namespaceContext), value1));
      anyAttributes = new HashMap<>();
    }
    // If type value contains the GS1:MT- then remove it during XML->JSON conversion
    if (type != null && (type.toString().contains("gs1:MT-") || type.toString().contains("gs1:AT-"))) {
      type = URI.create(type.toString().substring(type.toString().lastIndexOf("-") + 1));
    } else if (type != null && type.toString().contains("gs1:")) {
      type = URI.create(type.toString().substring(type.toString().lastIndexOf(":") + 1));
    }
    // If component value is present then remove the namespaces before it
    if (component != null && component.contains(EXAMPLE)) {
      component = component.substring(component.lastIndexOf(":") + 1);
    }
  }

  public void beforeMarshal(Marshaller m) {
    // if type does not contain gs1: then add it during JSON->XML conversion
    if (type != null && !type.toString().contains("gs1")) {
      type = URI.create("gs1:" + type);
    }
    // If component does not contain the example: then add it during JSON->XML conversion
    if (component != null && !component.contains(EXAMPLE)) {
      component = EXAMPLE + component;
    }
  }

  private static Map<String, Object> $default$userExtensions() {
    return new HashMap<>();
  }

  private static Map<QName, Object> $default$anyAttributes() {
    return new HashMap<>();
  }


  public static class SensorReportBuilder {
    private URI type;
    private String exception;
    private String coordinateReferenceSystem;
    private URI microorganism;
    private URI chemicalSubstance;
    private OffsetDateTime time;
    private Double value;
    private String component;
    private String stringValue;
    private Boolean booleanValue;
    private String hexBinaryValue;
    private URI uriValue;
    private Double minValue;
    private Double maxValue;
    private Double meanValue;
    private Double sDev;
    private Double percRank;
    private Double percValue;
    private URI deviceID;
    private URI deviceMetadata;
    private URI rawData;
    private URI dataProcessingMethod;
    private String uom;
    private String bizRules;
    private Map<String, Object> innerUserExtensions;
    private boolean userExtensions$set;
    private Map<String, Object> userExtensions$value;
    private boolean anyAttributes$set;
    private Map<QName, Object> anyAttributes$value;
    private ConversionNamespaceContext namespaceContext;

    SensorReportBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder type(URI type) {
      this.type = type;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder exception(String exception) {
      this.exception = exception;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder coordinateReferenceSystem(String coordinateReferenceSystem) {
      this.coordinateReferenceSystem = coordinateReferenceSystem;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder microorganism(URI microorganism) {
      this.microorganism = microorganism;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder chemicalSubstance(URI chemicalSubstance) {
      this.chemicalSubstance = chemicalSubstance;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder time(OffsetDateTime time) {
      this.time = time;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder value(Double value) {
      this.value = value;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder component(String component) {
      this.component = component;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder stringValue(String stringValue) {
      this.stringValue = stringValue;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder booleanValue(Boolean booleanValue) {
      this.booleanValue = booleanValue;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder hexBinaryValue(String hexBinaryValue) {
      this.hexBinaryValue = hexBinaryValue;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder uriValue(URI uriValue) {
      this.uriValue = uriValue;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder minValue(Double minValue) {
      this.minValue = minValue;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder maxValue(Double maxValue) {
      this.maxValue = maxValue;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder meanValue(Double meanValue) {
      this.meanValue = meanValue;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder sDev(Double sDev) {
      this.sDev = sDev;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder percRank(Double percRank) {
      this.percRank = percRank;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder percValue(Double percValue) {
      this.percValue = percValue;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder deviceID(URI deviceID) {
      this.deviceID = deviceID;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder deviceMetadata(URI deviceMetadata) {
      this.deviceMetadata = deviceMetadata;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder rawData(URI rawData) {
      this.rawData = rawData;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder dataProcessingMethod(URI dataProcessingMethod) {
      this.dataProcessingMethod = dataProcessingMethod;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder uom(String uom) {
      this.uom = uom;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder bizRules(String bizRules) {
      this.bizRules = bizRules;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public SensorReport.SensorReportBuilder innerUserExtensions(Map<String, Object> innerUserExtensions) {
      this.innerUserExtensions = innerUserExtensions;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorReport.SensorReportBuilder userExtensions(Map<String, Object> userExtensions) {
      this.userExtensions$value = userExtensions;
      userExtensions$set = true;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public SensorReport.SensorReportBuilder anyAttributes(Map<QName, Object> anyAttributes) {
      this.anyAttributes$value = anyAttributes;
      anyAttributes$set = true;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public SensorReport.SensorReportBuilder namespaceContext(ConversionNamespaceContext namespaceContext) {
      this.namespaceContext = namespaceContext;
      return this;
    }

    public SensorReport build() {
      Map<String, Object> userExtensions$value = this.userExtensions$value;
      if (!this.userExtensions$set) userExtensions$value = SensorReport.$default$userExtensions();
      Map<QName, Object> anyAttributes$value = this.anyAttributes$value;
      if (!this.anyAttributes$set) anyAttributes$value = SensorReport.$default$anyAttributes();
      return new SensorReport(this.type, this.exception, this.coordinateReferenceSystem, this.microorganism, this.chemicalSubstance, this.time, this.value, this.component, this.stringValue, this.booleanValue, this.hexBinaryValue, this.uriValue, this.minValue, this.maxValue, this.meanValue, this.sDev, this.percRank, this.percValue, this.deviceID, this.deviceMetadata, this.rawData, this.dataProcessingMethod, this.uom, this.bizRules, this.innerUserExtensions, userExtensions$value, anyAttributes$value, this.namespaceContext);
    }

    @Override
    public String toString() {
      return "SensorReport.SensorReportBuilder(type=" + this.type + ", exception=" + this.exception + ", coordinateReferenceSystem=" + this.coordinateReferenceSystem + ", microorganism=" + this.microorganism + ", chemicalSubstance=" + this.chemicalSubstance + ", time=" + this.time + ", value=" + this.value + ", component=" + this.component + ", stringValue=" + this.stringValue + ", booleanValue=" + this.booleanValue + ", hexBinaryValue=" + this.hexBinaryValue + ", uriValue=" + this.uriValue + ", minValue=" + this.minValue + ", maxValue=" + this.maxValue + ", meanValue=" + this.meanValue + ", sDev=" + this.sDev + ", percRank=" + this.percRank + ", percValue=" + this.percValue + ", deviceID=" + this.deviceID + ", deviceMetadata=" + this.deviceMetadata + ", rawData=" + this.rawData + ", dataProcessingMethod=" + this.dataProcessingMethod + ", uom=" + this.uom + ", bizRules=" + this.bizRules + ", innerUserExtensions=" + this.innerUserExtensions + ", userExtensions$value=" + this.userExtensions$value + ", anyAttributes$value=" + this.anyAttributes$value + ", namespaceContext=" + this.namespaceContext + ")";
    }
  }

  public static SensorReport.SensorReportBuilder builder() {
    return new SensorReport.SensorReportBuilder();
  }

  public URI getType() {
    return this.type;
  }

  public String getException() {
    return this.exception;
  }

  public String getCoordinateReferenceSystem() {
    return this.coordinateReferenceSystem;
  }

  public URI getMicroorganism() {
    return this.microorganism;
  }

  public URI getChemicalSubstance() {
    return this.chemicalSubstance;
  }

  public OffsetDateTime getTime() {
    return this.time;
  }

  public Double getValue() {
    return this.value;
  }

  public String getComponent() {
    return this.component;
  }

  public String getStringValue() {
    return this.stringValue;
  }

  public Boolean getBooleanValue() {
    return this.booleanValue;
  }

  public String getHexBinaryValue() {
    return this.hexBinaryValue;
  }

  public URI getUriValue() {
    return this.uriValue;
  }

  public Double getMinValue() {
    return this.minValue;
  }

  public Double getMaxValue() {
    return this.maxValue;
  }

  public Double getMeanValue() {
    return this.meanValue;
  }

  public Double getPercRank() {
    return this.percRank;
  }

  public Double getPercValue() {
    return this.percValue;
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

  public URI getDataProcessingMethod() {
    return this.dataProcessingMethod;
  }

  public String getUom() {
    return this.uom;
  }

  public String getBizRules() {
    return this.bizRules;
  }

  public Map<String, Object> getInnerUserExtensions() {
    return this.innerUserExtensions;
  }

  public Map<QName, Object> getAnyAttributes() {
    return this.anyAttributes;
  }

  public void setType(URI type) {
    this.type = type;
  }

  public void setException(String exception) {
    this.exception = exception;
  }

  public void setCoordinateReferenceSystem(String coordinateReferenceSystem) {
    this.coordinateReferenceSystem = coordinateReferenceSystem;
  }

  public void setMicroorganism(URI microorganism) {
    this.microorganism = microorganism;
  }

  public void setChemicalSubstance(URI chemicalSubstance) {
    this.chemicalSubstance = chemicalSubstance;
  }

  public void setTime(OffsetDateTime time) {
    this.time = time;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public void setComponent(String component) {
    this.component = component;
  }

  public void setStringValue(String stringValue) {
    this.stringValue = stringValue;
  }

  public void setBooleanValue(Boolean booleanValue) {
    this.booleanValue = booleanValue;
  }

  public void setHexBinaryValue(String hexBinaryValue) {
    this.hexBinaryValue = hexBinaryValue;
  }

  public void setUriValue(URI uriValue) {
    this.uriValue = uriValue;
  }

  public void setMinValue(Double minValue) {
    this.minValue = minValue;
  }

  public void setMaxValue(Double maxValue) {
    this.maxValue = maxValue;
  }

  public void setMeanValue(Double meanValue) {
    this.meanValue = meanValue;
  }

  public void setSDev(Double sDev) {
    this.sDev = sDev;
  }

  public void setPercRank(Double percRank) {
    this.percRank = percRank;
  }

  public void setPercValue(Double percValue) {
    this.percValue = percValue;
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

  public void setDataProcessingMethod(URI dataProcessingMethod) {
    this.dataProcessingMethod = dataProcessingMethod;
  }

  public void setUom(String uom) {
    this.uom = uom;
  }

  public void setBizRules(String bizRules) {
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
    if (!(o instanceof SensorReport)) return false;
    SensorReport other = (SensorReport) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$value = this.getValue();
    Object other$value = other.getValue();
    if (this$value == null ? other$value != null : !this$value.equals(other$value)) return false;
    Object this$booleanValue = this.getBooleanValue();
    Object other$booleanValue = other.getBooleanValue();
    if (this$booleanValue == null ? other$booleanValue != null : !this$booleanValue.equals(other$booleanValue)) return false;
    Object this$minValue = this.getMinValue();
    Object other$minValue = other.getMinValue();
    if (this$minValue == null ? other$minValue != null : !this$minValue.equals(other$minValue)) return false;
    Object this$maxValue = this.getMaxValue();
    Object other$maxValue = other.getMaxValue();
    if (this$maxValue == null ? other$maxValue != null : !this$maxValue.equals(other$maxValue)) return false;
    Object this$meanValue = this.getMeanValue();
    Object other$meanValue = other.getMeanValue();
    if (this$meanValue == null ? other$meanValue != null : !this$meanValue.equals(other$meanValue)) return false;
    Object this$sDev = this.getSDev();
    Object other$sDev = other.getSDev();
    if (this$sDev == null ? other$sDev != null : !this$sDev.equals(other$sDev)) return false;
    Object this$percRank = this.getPercRank();
    Object other$percRank = other.getPercRank();
    if (this$percRank == null ? other$percRank != null : !this$percRank.equals(other$percRank)) return false;
    Object this$percValue = this.getPercValue();
    Object other$percValue = other.getPercValue();
    if (this$percValue == null ? other$percValue != null : !this$percValue.equals(other$percValue)) return false;
    Object this$type = this.getType();
    Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
    Object this$exception = this.getException();
    Object other$exception = other.getException();
    if (this$exception == null ? other$exception != null : !this$exception.equals(other$exception)) return false;
    Object this$coordinateReferenceSystem = this.getCoordinateReferenceSystem();
    Object other$coordinateReferenceSystem = other.getCoordinateReferenceSystem();
    if (this$coordinateReferenceSystem == null ? other$coordinateReferenceSystem != null : !this$coordinateReferenceSystem.equals(other$coordinateReferenceSystem)) return false;
    Object this$microorganism = this.getMicroorganism();
    Object other$microorganism = other.getMicroorganism();
    if (this$microorganism == null ? other$microorganism != null : !this$microorganism.equals(other$microorganism)) return false;
    Object this$chemicalSubstance = this.getChemicalSubstance();
    Object other$chemicalSubstance = other.getChemicalSubstance();
    if (this$chemicalSubstance == null ? other$chemicalSubstance != null : !this$chemicalSubstance.equals(other$chemicalSubstance)) return false;
    Object this$time = this.getTime();
    Object other$time = other.getTime();
    if (this$time == null ? other$time != null : !this$time.equals(other$time)) return false;
    Object this$component = this.getComponent();
    Object other$component = other.getComponent();
    if (this$component == null ? other$component != null : !this$component.equals(other$component)) return false;
    Object this$stringValue = this.getStringValue();
    Object other$stringValue = other.getStringValue();
    if (this$stringValue == null ? other$stringValue != null : !this$stringValue.equals(other$stringValue)) return false;
    Object this$hexBinaryValue = this.getHexBinaryValue();
    Object other$hexBinaryValue = other.getHexBinaryValue();
    if (this$hexBinaryValue == null ? other$hexBinaryValue != null : !this$hexBinaryValue.equals(other$hexBinaryValue)) return false;
    Object this$uriValue = this.getUriValue();
    Object other$uriValue = other.getUriValue();
    if (this$uriValue == null ? other$uriValue != null : !this$uriValue.equals(other$uriValue)) return false;
    Object this$deviceID = this.getDeviceID();
    Object other$deviceID = other.getDeviceID();
    if (this$deviceID == null ? other$deviceID != null : !this$deviceID.equals(other$deviceID)) return false;
    Object this$deviceMetadata = this.getDeviceMetadata();
    Object other$deviceMetadata = other.getDeviceMetadata();
    if (this$deviceMetadata == null ? other$deviceMetadata != null : !this$deviceMetadata.equals(other$deviceMetadata)) return false;
    Object this$rawData = this.getRawData();
    Object other$rawData = other.getRawData();
    if (this$rawData == null ? other$rawData != null : !this$rawData.equals(other$rawData)) return false;
    Object this$dataProcessingMethod = this.getDataProcessingMethod();
    Object other$dataProcessingMethod = other.getDataProcessingMethod();
    if (this$dataProcessingMethod == null ? other$dataProcessingMethod != null : !this$dataProcessingMethod.equals(other$dataProcessingMethod)) return false;
    Object this$uom = this.getUom();
    Object other$uom = other.getUom();
    if (this$uom == null ? other$uom != null : !this$uom.equals(other$uom)) return false;
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
    return other instanceof SensorReport;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $value = this.getValue();
    result = result * PRIME + ($value == null ? 43 : $value.hashCode());
    Object $booleanValue = this.getBooleanValue();
    result = result * PRIME + ($booleanValue == null ? 43 : $booleanValue.hashCode());
    Object $minValue = this.getMinValue();
    result = result * PRIME + ($minValue == null ? 43 : $minValue.hashCode());
    Object $maxValue = this.getMaxValue();
    result = result * PRIME + ($maxValue == null ? 43 : $maxValue.hashCode());
    Object $meanValue = this.getMeanValue();
    result = result * PRIME + ($meanValue == null ? 43 : $meanValue.hashCode());
    Object $sDev = this.getSDev();
    result = result * PRIME + ($sDev == null ? 43 : $sDev.hashCode());
    Object $percRank = this.getPercRank();
    result = result * PRIME + ($percRank == null ? 43 : $percRank.hashCode());
    Object $percValue = this.getPercValue();
    result = result * PRIME + ($percValue == null ? 43 : $percValue.hashCode());
    Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    Object $exception = this.getException();
    result = result * PRIME + ($exception == null ? 43 : $exception.hashCode());
    Object $coordinateReferenceSystem = this.getCoordinateReferenceSystem();
    result = result * PRIME + ($coordinateReferenceSystem == null ? 43 : $coordinateReferenceSystem.hashCode());
    Object $microorganism = this.getMicroorganism();
    result = result * PRIME + ($microorganism == null ? 43 : $microorganism.hashCode());
    Object $chemicalSubstance = this.getChemicalSubstance();
    result = result * PRIME + ($chemicalSubstance == null ? 43 : $chemicalSubstance.hashCode());
    Object $time = this.getTime();
    result = result * PRIME + ($time == null ? 43 : $time.hashCode());
    Object $component = this.getComponent();
    result = result * PRIME + ($component == null ? 43 : $component.hashCode());
    Object $stringValue = this.getStringValue();
    result = result * PRIME + ($stringValue == null ? 43 : $stringValue.hashCode());
    Object $hexBinaryValue = this.getHexBinaryValue();
    result = result * PRIME + ($hexBinaryValue == null ? 43 : $hexBinaryValue.hashCode());
    Object $uriValue = this.getUriValue();
    result = result * PRIME + ($uriValue == null ? 43 : $uriValue.hashCode());
    Object $deviceID = this.getDeviceID();
    result = result * PRIME + ($deviceID == null ? 43 : $deviceID.hashCode());
    Object $deviceMetadata = this.getDeviceMetadata();
    result = result * PRIME + ($deviceMetadata == null ? 43 : $deviceMetadata.hashCode());
    Object $rawData = this.getRawData();
    result = result * PRIME + ($rawData == null ? 43 : $rawData.hashCode());
    Object $dataProcessingMethod = this.getDataProcessingMethod();
    result = result * PRIME + ($dataProcessingMethod == null ? 43 : $dataProcessingMethod.hashCode());
    Object $uom = this.getUom();
    result = result * PRIME + ($uom == null ? 43 : $uom.hashCode());
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
    return "SensorReport(type=" + this.getType() + ", exception=" + this.getException() + ", coordinateReferenceSystem=" + this.getCoordinateReferenceSystem() + ", microorganism=" + this.getMicroorganism() + ", chemicalSubstance=" + this.getChemicalSubstance() + ", time=" + this.getTime() + ", value=" + this.getValue() + ", component=" + this.getComponent() + ", stringValue=" + this.getStringValue() + ", booleanValue=" + this.getBooleanValue() + ", hexBinaryValue=" + this.getHexBinaryValue() + ", uriValue=" + this.getUriValue() + ", minValue=" + this.getMinValue() + ", maxValue=" + this.getMaxValue() + ", meanValue=" + this.getMeanValue() + ", sDev=" + this.getSDev() + ", percRank=" + this.getPercRank() + ", percValue=" + this.getPercValue() + ", deviceID=" + this.getDeviceID() + ", deviceMetadata=" + this.getDeviceMetadata() + ", rawData=" + this.getRawData() + ", dataProcessingMethod=" + this.getDataProcessingMethod() + ", uom=" + this.getUom() + ", bizRules=" + this.getBizRules() + ", innerUserExtensions=" + this.getInnerUserExtensions() + ", userExtensions=" + this.getUserExtensions() + ", anyAttributes=" + this.getAnyAttributes() + ", namespaceContext=" + this.getNamespaceContext() + ")";
  }

  public SensorReport() {
    this.userExtensions = SensorReport.$default$userExtensions();
    this.anyAttributes = SensorReport.$default$anyAttributes();
  }

  public SensorReport(URI type, String exception, String coordinateReferenceSystem, URI microorganism, URI chemicalSubstance, OffsetDateTime time, Double value, String component, String stringValue, Boolean booleanValue, String hexBinaryValue, URI uriValue, Double minValue, Double maxValue, Double meanValue, Double sDev, Double percRank, Double percValue, URI deviceID, URI deviceMetadata, URI rawData, URI dataProcessingMethod, String uom, String bizRules, Map<String, Object> innerUserExtensions, Map<String, Object> userExtensions, Map<QName, Object> anyAttributes, ConversionNamespaceContext namespaceContext) {
    this.type = type;
    this.exception = exception;
    this.coordinateReferenceSystem = coordinateReferenceSystem;
    this.microorganism = microorganism;
    this.chemicalSubstance = chemicalSubstance;
    this.time = time;
    this.value = value;
    this.component = component;
    this.stringValue = stringValue;
    this.booleanValue = booleanValue;
    this.hexBinaryValue = hexBinaryValue;
    this.uriValue = uriValue;
    this.minValue = minValue;
    this.maxValue = maxValue;
    this.meanValue = meanValue;
    this.sDev = sDev;
    this.percRank = percRank;
    this.percValue = percValue;
    this.deviceID = deviceID;
    this.deviceMetadata = deviceMetadata;
    this.rawData = rawData;
    this.dataProcessingMethod = dataProcessingMethod;
    this.uom = uom;
    this.bizRules = bizRules;
    this.innerUserExtensions = innerUserExtensions;
    this.userExtensions = userExtensions;
    this.anyAttributes = anyAttributes;
    this.namespaceContext = namespaceContext;
  }
}
