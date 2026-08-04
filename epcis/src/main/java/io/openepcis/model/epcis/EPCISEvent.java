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

import static com.fasterxml.jackson.annotation.JsonFormat.Feature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE;
import static com.fasterxml.jackson.annotation.JsonFormat.Feature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS;
import static io.openepcis.constants.EPCIS.EPCIS_DEFAULT_NAMESPACES;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.openepcis.identifiers.converter.util.ConverterUtil;
import io.openepcis.model.epcis.extension.OpenEPCISExtension;
import io.openepcis.model.epcis.extension.OpenEPCISSupport;
import io.openepcis.model.epcis.modifier.*;
import io.openepcis.model.epcis.util.ConversionNamespaceContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.*;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.collections4.CollectionUtils;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = false, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = ObjectEvent.class, name = "ObjectEvent"), @JsonSubTypes.Type(value = TransformationEvent.class, name = "TransformationEvent"), @JsonSubTypes.Type(value = AggregationEvent.class, name = "AggregationEvent"), @JsonSubTypes.Type(value = AssociationEvent.class, name = "AssociationEvent"), @JsonSubTypes.Type(value = TransactionEvent.class, name = "TransactionEvent")})
@JsonInclude(Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlTransient
public class EPCISEvent implements Serializable, OpenEPCISSupport {
  @XmlTransient
  @JsonIgnore
  private String type;
  private String eventID;
  @JsonProperty(required = true)
  @XmlElement(name = "eventTimeZoneOffset", required = true)
  private String eventTimeZoneOffset;
  @JsonProperty(required = true)
  @XmlElement(name = "eventTime", required = true)
  @XmlJavaTypeAdapter(CustomInstantAdapter.class)
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  @JsonFormat(without = {ADJUST_DATES_TO_CONTEXT_TIME_ZONE, WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS})
  private OffsetDateTime eventTime;
  @XmlJavaTypeAdapter(CustomInstantAdapter.class)
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  @JsonFormat(without = {ADJUST_DATES_TO_CONTEXT_TIME_ZONE, WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS})
  private OffsetDateTime recordTime;
  private String bizStep;
  private String disposition;
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
  @XmlTransient
  private Map<String, Object> userExtensions;
  @JsonIgnore
  @XmlTransient
  private Map<String, Object> innerUserExtensions;
  @JsonProperty("@context")
  @JsonDeserialize(using = CustomContextDeserializer.class)
  @JsonSerialize(using = CustomContextSerializer.class)
  @XmlTransient
  private List<Object> contextInfo;
  @XmlJavaTypeAdapter(CertificationInfoXmlAdapter.class)
  private Object certificationInfo;
  @JsonIgnore
  @XmlTransient
  private String expandedJSONLDString;
  @JsonIgnore
  @XmlTransient
  private OpenEPCISExtension openEPCISExtension;

  public EPCISEvent(String type, String eventID, String eventTimeZoneOffset, OffsetDateTime eventTime, OffsetDateTime recordTime, String bizStep, String disposition, ReadPoint readPoint, BizLocation bizLocation, ErrorDeclaration errorDeclaration, List<SourceList> sourceList, List<DestinationList> destinationList, List<SensorElementList> sensorElementList, Map<String, Object> extension, Map<String, Object> userExtensions, Map<String, Object> innerUserExtensions, List<Object> contextInfo, Object certificationInfo, String expandedJSONLDString, OpenEPCISExtension openEPCISExtension) {
    this.type = type;
    this.eventID = eventID;
    this.eventTimeZoneOffset = eventTimeZoneOffset;
    this.eventTime = eventTime;
    this.recordTime = recordTime;
    this.bizStep = bizStep;
    this.disposition = disposition;
    this.readPoint = readPoint;
    this.bizLocation = bizLocation;
    this.errorDeclaration = errorDeclaration;
    this.sourceList = sourceList;
    this.destinationList = destinationList;
    this.sensorElementList = sensorElementList;
    this.extension = extension;
    this.userExtensions = userExtensions;
    this.innerUserExtensions = innerUserExtensions;
    this.contextInfo = isEmptyContext(contextInfo) ? null : contextInfo;
    this.certificationInfo = certificationInfo;
    this.expandedJSONLDString = expandedJSONLDString;
    this.openEPCISExtension = openEPCISExtension;
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
  @JsonSerialize(using = CustomExtensionsSerializer.class)
  @UserExtensions(extension = "extension")
  @JsonProperty("extension")
  private Map<String, Object> extension;
  @XmlAnyElement(lax = true)
  @JsonIgnore
  private List<Object> anyElements;

  @JsonAnySetter
  @JsonDeserialize(using = DefaultNamespaceDeserializer.class)
  public void setUserExtensions(String key, Object value) {
    userExtensions.put(key, value);
    // Note: Namespace detection is handled by DefaultNamespaceDeserializer during deserialization
    // when ConversionNamespaceContext is available via Jackson's DeserializationContext attributes.
  }

  // Getter method for the @context field.
  // Note: The CustomContextSerializer handles namespace logic during JSON serialization
  // using ConversionNamespaceContext from Jackson's SerializerProvider attributes.
  public List<Object> getContextInfo() {
    return contextInfo;
  }

  public void beforeMarshal(Marshaller m) throws ParserConfigurationException {
    // Add all elements from UserExtensions to AnyElements before Marshaling & creating XML
    if (userExtensions != null) {
      // Retrieve namespace context from openEPCISExtension (set during JSON->XML conversion)
      // for creating properly namespaced XML elements
      final ConversionNamespaceContext nsContext = openEPCISExtension != null ? openEPCISExtension.getConversionNamespaceContext() : null;
      final ExtensionsModifier extensionsModifier = new ExtensionsModifier(nsContext);
      anyElements = extensionsModifier.createXmlElement(userExtensions);
      userExtensions = new HashMap<>();
    }
    // Call the method to convert the BearStrings during JSON->XML conversion
    if (errorDeclaration != null && errorDeclaration.getReason() != null && !errorDeclaration.getReason().equals("")) {
      errorDeclaration.setReason(errorDeclaration.getReason().contains("http") || errorDeclaration.getReason().contains(":") ? errorDeclaration.getReason() : ConverterUtil.toCbvVocabulary(errorDeclaration.getReason(), "reason", "URN"));
    }
    // Check if bizStep has value if so convert to CBV formatted value.
    if (bizStep != null && !bizStep.equals("")) {
      bizStep = bizStep.contains("http") || bizStep.contains(":") ? bizStep : ConverterUtil.toCbvVocabulary(bizStep, "bizStep", "URN");
    }
    // Check if Disposition has value if so convert to CBV formatted value.
    if (disposition != null && !disposition.equals("")) {
      disposition = disposition.contains("http") || disposition.contains(":") ? disposition : ConverterUtil.toCbvVocabulary(disposition, "disposition", "URN");
    }
    // Check if Source has value if so convert it to CBV formatted value
    if (sourceList != null && !sourceList.isEmpty()) {
      sourceList.forEach(source -> {
        if (source.getType() != null && !source.getType().equals("")) {
          source.setType(source.getType().contains("http") || source.getType().contains(":") ? source.getType() : ConverterUtil.toCbvVocabulary(source.getType(), "sourceList", "URN"));
        }
      });
    }
    // Check if Destination has value if so convert it to CBV formatted value
    if (destinationList != null && !destinationList.isEmpty()) {
      destinationList.forEach(destination -> {
        if (destination.getType() != null && !destination.getType().equals("")) {
          destination.setType(destination.getType().contains("http") || destination.getType().contains(":") ? destination.getType() : ConverterUtil.toCbvVocabulary(destination.getType(), "destinationList", "URN"));
        }
      });
    }
  }

  public void afterUnmarshal(Unmarshaller m, Object parent) throws ParserConfigurationException {
    // Add all elements from AnyElements to UserExtensions after Unmarshalling before creating JSON
    if (anyElements != null) {
      final ExtensionsModifier extensionsModifier = new ExtensionsModifier();
      // Retrieve namespace context from unmarshaller if available (for XML->JSON conversion)
      // This allows namespaces discovered in event extensions to be propagated to the JSON @context
      final ConversionNamespaceContext nsContext = ConversionNamespaceContext.fromUnmarshaller(m).orElse(null);
      userExtensions = extensionsModifier.createObject(anyElements, nsContext);
      anyElements = new ArrayList<>();
    }
    // If there are elements in Extension after Unmarshalling then add it to UserExtensions before
    // creating JSON
    /*if (openepcis != null) {
      userExtensions.putAll(openepcis);
      openepcis = new HashMap<>();
    }*/
    // If there are elements in BaseExtension after Unmarshalling then add it to UserExtensions
    // before creating JSON
    if (baseExtension != null) {
      userExtensions.putAll(baseExtension);
      baseExtension = new HashMap<>();
    }
    // Call the method to convert the values to BareStrings during XML->JSON conversion
    // Check if Error reason is present if so convert to BareString
    if (errorDeclaration != null && errorDeclaration.getReason() != null && !errorDeclaration.getReason().equals("")) {
      errorDeclaration.setReason(ConverterUtil.toBareStringVocabulary(errorDeclaration.getReason()));
    }
    // Check if bizStep has value if so convert to BareString
    if (bizStep != null && !bizStep.equals("")) {
      bizStep = ConverterUtil.toBareStringVocabulary(bizStep);
    }
    // Check if Disposition has value if so convert to BareString
    if (disposition != null && !disposition.equals("")) {
      disposition = ConverterUtil.toBareStringVocabulary(disposition);
    }
    // Check if Source has value if so convert it to BareString value
    if (sourceList != null && !sourceList.isEmpty()) {
      sourceList.forEach(source -> {
        if (source.getType() != null && !source.getType().equals("")) {
          source.setType(ConverterUtil.toBareStringVocabulary(source.getType()));
        }
      });
    }
    // Check if Destination has value if so convert it to BareString value
    if (destinationList != null && !destinationList.isEmpty()) {
      destinationList.forEach(destination -> {
        if (destination.getType() != null && !destination.getType().equals("")) {
          destination.setType(ConverterUtil.toBareStringVocabulary(destination.getType()));
        }
      });
    }
    // Note: contextInfo population from namespace context is handled by the caller
    // via the CustomExtensionAdapter which receives ConversionNamespaceContext through
    // Marshaller.setAdapter().
  }

  // Method to check if provided context contains the empty HashMap if so skip them
  private boolean isEmptyContext(final List<Object> context) {
    if (Objects.nonNull(context)) {
      return context.stream().filter(obj -> obj instanceof HashMap<?, ?>).map(obj -> (HashMap<?, ?>) obj).anyMatch(HashMap::isEmpty);
    }
    return true;
  }

  private static Map<String, Object> $default$userExtensions() {
    return new HashMap<>();
  }

  private static OpenEPCISExtension $default$openEPCISExtension() {
    return new OpenEPCISExtension();
  }


  public static class EPCISEventBuilder {
    private String type;
    private String eventID;
    private String eventTimeZoneOffset;
    private OffsetDateTime eventTime;
    private OffsetDateTime recordTime;
    private String bizStep;
    private String disposition;
    private ReadPoint readPoint;
    private BizLocation bizLocation;
    private ErrorDeclaration errorDeclaration;
    private List<SourceList> sourceList;
    private List<DestinationList> destinationList;
    private List<SensorElementList> sensorElementList;
    private boolean userExtensions$set;
    private Map<String, Object> userExtensions$value;
    private Map<String, Object> innerUserExtensions;
    private List<Object> contextInfo;
    private Object certificationInfo;
    private String expandedJSONLDString;
    private boolean openEPCISExtension$set;
    private OpenEPCISExtension openEPCISExtension$value;
    private Map<String, Serializable> baseExtension;
    private Map<String, Object> extension;
    private List<Object> anyElements;

    EPCISEventBuilder() {
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public EPCISEvent.EPCISEventBuilder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public EPCISEvent.EPCISEventBuilder eventID(String eventID) {
      this.eventID = eventID;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonProperty(required = true)
    public EPCISEvent.EPCISEventBuilder eventTimeZoneOffset(String eventTimeZoneOffset) {
      this.eventTimeZoneOffset = eventTimeZoneOffset;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonProperty(required = true)
    @JsonFormat(without = {ADJUST_DATES_TO_CONTEXT_TIME_ZONE, WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS})
    public EPCISEvent.EPCISEventBuilder eventTime(OffsetDateTime eventTime) {
      this.eventTime = eventTime;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonFormat(without = {ADJUST_DATES_TO_CONTEXT_TIME_ZONE, WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS})
    public EPCISEvent.EPCISEventBuilder recordTime(OffsetDateTime recordTime) {
      this.recordTime = recordTime;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public EPCISEvent.EPCISEventBuilder bizStep(String bizStep) {
      this.bizStep = bizStep;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public EPCISEvent.EPCISEventBuilder disposition(String disposition) {
      this.disposition = disposition;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public EPCISEvent.EPCISEventBuilder readPoint(ReadPoint readPoint) {
      this.readPoint = readPoint;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public EPCISEvent.EPCISEventBuilder bizLocation(BizLocation bizLocation) {
      this.bizLocation = bizLocation;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public EPCISEvent.EPCISEventBuilder errorDeclaration(ErrorDeclaration errorDeclaration) {
      this.errorDeclaration = errorDeclaration;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public EPCISEvent.EPCISEventBuilder sourceList(List<SourceList> sourceList) {
      this.sourceList = sourceList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public EPCISEvent.EPCISEventBuilder destinationList(List<DestinationList> destinationList) {
      this.destinationList = destinationList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public EPCISEvent.EPCISEventBuilder sensorElementList(List<SensorElementList> sensorElementList) {
      this.sensorElementList = sensorElementList;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public EPCISEvent.EPCISEventBuilder userExtensions(Map<String, Object> userExtensions) {
      this.userExtensions$value = userExtensions;
      userExtensions$set = true;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public EPCISEvent.EPCISEventBuilder innerUserExtensions(Map<String, Object> innerUserExtensions) {
      this.innerUserExtensions = innerUserExtensions;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonProperty("@context")
    @JsonDeserialize(using = CustomContextDeserializer.class)
    public EPCISEvent.EPCISEventBuilder contextInfo(List<Object> contextInfo) {
      this.contextInfo = contextInfo;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public EPCISEvent.EPCISEventBuilder certificationInfo(Object certificationInfo) {
      this.certificationInfo = certificationInfo;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public EPCISEvent.EPCISEventBuilder expandedJSONLDString(String expandedJSONLDString) {
      this.expandedJSONLDString = expandedJSONLDString;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public EPCISEvent.EPCISEventBuilder openEPCISExtension(OpenEPCISExtension openEPCISExtension) {
      this.openEPCISExtension$value = openEPCISExtension;
      openEPCISExtension$set = true;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public EPCISEvent.EPCISEventBuilder baseExtension(Map<String, Serializable> baseExtension) {
      this.baseExtension = baseExtension;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonProperty("extension")
    public EPCISEvent.EPCISEventBuilder extension(Map<String, Object> extension) {
      this.extension = extension;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public EPCISEvent.EPCISEventBuilder anyElements(List<Object> anyElements) {
      this.anyElements = anyElements;
      return this;
    }

    public EPCISEvent build() {
      Map<String, Object> userExtensions$value = this.userExtensions$value;
      if (!this.userExtensions$set) userExtensions$value = EPCISEvent.$default$userExtensions();
      OpenEPCISExtension openEPCISExtension$value = this.openEPCISExtension$value;
      if (!this.openEPCISExtension$set) openEPCISExtension$value = EPCISEvent.$default$openEPCISExtension();
      return new EPCISEvent(this.type, this.eventID, this.eventTimeZoneOffset, this.eventTime, this.recordTime, this.bizStep, this.disposition, this.readPoint, this.bizLocation, this.errorDeclaration, this.sourceList, this.destinationList, this.sensorElementList, userExtensions$value, this.innerUserExtensions, this.contextInfo, this.certificationInfo, this.expandedJSONLDString, openEPCISExtension$value, this.baseExtension, this.extension, this.anyElements);
    }

    @Override
    public String toString() {
      return "EPCISEvent.EPCISEventBuilder(type=" + this.type + ", eventID=" + this.eventID + ", eventTimeZoneOffset=" + this.eventTimeZoneOffset + ", eventTime=" + this.eventTime + ", recordTime=" + this.recordTime + ", bizStep=" + this.bizStep + ", disposition=" + this.disposition + ", readPoint=" + this.readPoint + ", bizLocation=" + this.bizLocation + ", errorDeclaration=" + this.errorDeclaration + ", sourceList=" + this.sourceList + ", destinationList=" + this.destinationList + ", sensorElementList=" + this.sensorElementList + ", userExtensions$value=" + this.userExtensions$value + ", innerUserExtensions=" + this.innerUserExtensions + ", contextInfo=" + this.contextInfo + ", certificationInfo=" + this.certificationInfo + ", expandedJSONLDString=" + this.expandedJSONLDString + ", openEPCISExtension$value=" + this.openEPCISExtension$value + ", baseExtension=" + this.baseExtension + ", extension=" + this.extension + ", anyElements=" + this.anyElements + ")";
    }
  }

  public static EPCISEvent.EPCISEventBuilder builder() {
    return new EPCISEvent.EPCISEventBuilder();
  }

  public String getType() {
    return this.type;
  }

  public String getEventID() {
    return this.eventID;
  }

  public String getEventTimeZoneOffset() {
    return this.eventTimeZoneOffset;
  }

  public OffsetDateTime getEventTime() {
    return this.eventTime;
  }

  public OffsetDateTime getRecordTime() {
    return this.recordTime;
  }

  public String getBizStep() {
    return this.bizStep;
  }

  public String getDisposition() {
    return this.disposition;
  }

  public ReadPoint getReadPoint() {
    return this.readPoint;
  }

  public BizLocation getBizLocation() {
    return this.bizLocation;
  }

  public ErrorDeclaration getErrorDeclaration() {
    return this.errorDeclaration;
  }

  public List<SourceList> getSourceList() {
    return this.sourceList;
  }

  public List<DestinationList> getDestinationList() {
    return this.destinationList;
  }

  public List<SensorElementList> getSensorElementList() {
    return this.sensorElementList;
  }

  public Map<String, Object> getInnerUserExtensions() {
    return this.innerUserExtensions;
  }

  public Object getCertificationInfo() {
    return this.certificationInfo;
  }

  public String getExpandedJSONLDString() {
    return this.expandedJSONLDString;
  }

  public OpenEPCISExtension getOpenEPCISExtension() {
    return this.openEPCISExtension;
  }

  public Map<String, Serializable> getBaseExtension() {
    return this.baseExtension;
  }

  public Map<String, Object> getExtension() {
    return this.extension;
  }

  public List<Object> getAnyElements() {
    return this.anyElements;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setEventID(String eventID) {
    this.eventID = eventID;
  }

  public void setEventTimeZoneOffset(String eventTimeZoneOffset) {
    this.eventTimeZoneOffset = eventTimeZoneOffset;
  }

  public void setEventTime(OffsetDateTime eventTime) {
    this.eventTime = eventTime;
  }

  public void setRecordTime(OffsetDateTime recordTime) {
    this.recordTime = recordTime;
  }

  public void setBizStep(String bizStep) {
    this.bizStep = bizStep;
  }

  public void setDisposition(String disposition) {
    this.disposition = disposition;
  }

  public void setReadPoint(ReadPoint readPoint) {
    this.readPoint = readPoint;
  }

  public void setBizLocation(BizLocation bizLocation) {
    this.bizLocation = bizLocation;
  }

  public void setErrorDeclaration(ErrorDeclaration errorDeclaration) {
    this.errorDeclaration = errorDeclaration;
  }

  public void setSourceList(List<SourceList> sourceList) {
    this.sourceList = sourceList;
  }

  public void setDestinationList(List<DestinationList> destinationList) {
    this.destinationList = destinationList;
  }

  public void setSensorElementList(List<SensorElementList> sensorElementList) {
    this.sensorElementList = sensorElementList;
  }

  public void setUserExtensions(Map<String, Object> userExtensions) {
    this.userExtensions = userExtensions;
  }

  public void setInnerUserExtensions(Map<String, Object> innerUserExtensions) {
    this.innerUserExtensions = innerUserExtensions;
  }

  public void setContextInfo(List<Object> contextInfo) {
    this.contextInfo = contextInfo;
  }

  public void setCertificationInfo(Object certificationInfo) {
    this.certificationInfo = certificationInfo;
  }

  public void setExpandedJSONLDString(String expandedJSONLDString) {
    this.expandedJSONLDString = expandedJSONLDString;
  }

  public void setOpenEPCISExtension(OpenEPCISExtension openEPCISExtension) {
    this.openEPCISExtension = openEPCISExtension;
  }

  public void setBaseExtension(Map<String, Serializable> baseExtension) {
    this.baseExtension = baseExtension;
  }

  public void setExtension(Map<String, Object> extension) {
    this.extension = extension;
  }

  public void setAnyElements(List<Object> anyElements) {
    this.anyElements = anyElements;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof EPCISEvent)) return false;
    EPCISEvent other = (EPCISEvent) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$type = this.getType();
    Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
    Object this$eventID = this.getEventID();
    Object other$eventID = other.getEventID();
    if (this$eventID == null ? other$eventID != null : !this$eventID.equals(other$eventID)) return false;
    Object this$eventTimeZoneOffset = this.getEventTimeZoneOffset();
    Object other$eventTimeZoneOffset = other.getEventTimeZoneOffset();
    if (this$eventTimeZoneOffset == null ? other$eventTimeZoneOffset != null : !this$eventTimeZoneOffset.equals(other$eventTimeZoneOffset)) return false;
    Object this$eventTime = this.getEventTime();
    Object other$eventTime = other.getEventTime();
    if (this$eventTime == null ? other$eventTime != null : !this$eventTime.equals(other$eventTime)) return false;
    Object this$recordTime = this.getRecordTime();
    Object other$recordTime = other.getRecordTime();
    if (this$recordTime == null ? other$recordTime != null : !this$recordTime.equals(other$recordTime)) return false;
    Object this$bizStep = this.getBizStep();
    Object other$bizStep = other.getBizStep();
    if (this$bizStep == null ? other$bizStep != null : !this$bizStep.equals(other$bizStep)) return false;
    Object this$disposition = this.getDisposition();
    Object other$disposition = other.getDisposition();
    if (this$disposition == null ? other$disposition != null : !this$disposition.equals(other$disposition)) return false;
    Object this$readPoint = this.getReadPoint();
    Object other$readPoint = other.getReadPoint();
    if (this$readPoint == null ? other$readPoint != null : !this$readPoint.equals(other$readPoint)) return false;
    Object this$bizLocation = this.getBizLocation();
    Object other$bizLocation = other.getBizLocation();
    if (this$bizLocation == null ? other$bizLocation != null : !this$bizLocation.equals(other$bizLocation)) return false;
    Object this$errorDeclaration = this.getErrorDeclaration();
    Object other$errorDeclaration = other.getErrorDeclaration();
    if (this$errorDeclaration == null ? other$errorDeclaration != null : !this$errorDeclaration.equals(other$errorDeclaration)) return false;
    Object this$sourceList = this.getSourceList();
    Object other$sourceList = other.getSourceList();
    if (this$sourceList == null ? other$sourceList != null : !this$sourceList.equals(other$sourceList)) return false;
    Object this$destinationList = this.getDestinationList();
    Object other$destinationList = other.getDestinationList();
    if (this$destinationList == null ? other$destinationList != null : !this$destinationList.equals(other$destinationList)) return false;
    Object this$sensorElementList = this.getSensorElementList();
    Object other$sensorElementList = other.getSensorElementList();
    if (this$sensorElementList == null ? other$sensorElementList != null : !this$sensorElementList.equals(other$sensorElementList)) return false;
    Object this$userExtensions = this.getUserExtensions();
    Object other$userExtensions = other.getUserExtensions();
    if (this$userExtensions == null ? other$userExtensions != null : !this$userExtensions.equals(other$userExtensions)) return false;
    Object this$innerUserExtensions = this.getInnerUserExtensions();
    Object other$innerUserExtensions = other.getInnerUserExtensions();
    if (this$innerUserExtensions == null ? other$innerUserExtensions != null : !this$innerUserExtensions.equals(other$innerUserExtensions)) return false;
    Object this$contextInfo = this.getContextInfo();
    Object other$contextInfo = other.getContextInfo();
    if (this$contextInfo == null ? other$contextInfo != null : !this$contextInfo.equals(other$contextInfo)) return false;
    Object this$certificationInfo = this.getCertificationInfo();
    Object other$certificationInfo = other.getCertificationInfo();
    if (this$certificationInfo == null ? other$certificationInfo != null : !this$certificationInfo.equals(other$certificationInfo)) return false;
    Object this$expandedJSONLDString = this.getExpandedJSONLDString();
    Object other$expandedJSONLDString = other.getExpandedJSONLDString();
    if (this$expandedJSONLDString == null ? other$expandedJSONLDString != null : !this$expandedJSONLDString.equals(other$expandedJSONLDString)) return false;
    Object this$openEPCISExtension = this.getOpenEPCISExtension();
    Object other$openEPCISExtension = other.getOpenEPCISExtension();
    if (this$openEPCISExtension == null ? other$openEPCISExtension != null : !this$openEPCISExtension.equals(other$openEPCISExtension)) return false;
    Object this$baseExtension = this.getBaseExtension();
    Object other$baseExtension = other.getBaseExtension();
    if (this$baseExtension == null ? other$baseExtension != null : !this$baseExtension.equals(other$baseExtension)) return false;
    Object this$extension = this.getExtension();
    Object other$extension = other.getExtension();
    if (this$extension == null ? other$extension != null : !this$extension.equals(other$extension)) return false;
    Object this$anyElements = this.getAnyElements();
    Object other$anyElements = other.getAnyElements();
    if (this$anyElements == null ? other$anyElements != null : !this$anyElements.equals(other$anyElements)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof EPCISEvent;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    Object $eventID = this.getEventID();
    result = result * PRIME + ($eventID == null ? 43 : $eventID.hashCode());
    Object $eventTimeZoneOffset = this.getEventTimeZoneOffset();
    result = result * PRIME + ($eventTimeZoneOffset == null ? 43 : $eventTimeZoneOffset.hashCode());
    Object $eventTime = this.getEventTime();
    result = result * PRIME + ($eventTime == null ? 43 : $eventTime.hashCode());
    Object $recordTime = this.getRecordTime();
    result = result * PRIME + ($recordTime == null ? 43 : $recordTime.hashCode());
    Object $bizStep = this.getBizStep();
    result = result * PRIME + ($bizStep == null ? 43 : $bizStep.hashCode());
    Object $disposition = this.getDisposition();
    result = result * PRIME + ($disposition == null ? 43 : $disposition.hashCode());
    Object $readPoint = this.getReadPoint();
    result = result * PRIME + ($readPoint == null ? 43 : $readPoint.hashCode());
    Object $bizLocation = this.getBizLocation();
    result = result * PRIME + ($bizLocation == null ? 43 : $bizLocation.hashCode());
    Object $errorDeclaration = this.getErrorDeclaration();
    result = result * PRIME + ($errorDeclaration == null ? 43 : $errorDeclaration.hashCode());
    Object $sourceList = this.getSourceList();
    result = result * PRIME + ($sourceList == null ? 43 : $sourceList.hashCode());
    Object $destinationList = this.getDestinationList();
    result = result * PRIME + ($destinationList == null ? 43 : $destinationList.hashCode());
    Object $sensorElementList = this.getSensorElementList();
    result = result * PRIME + ($sensorElementList == null ? 43 : $sensorElementList.hashCode());
    Object $userExtensions = this.getUserExtensions();
    result = result * PRIME + ($userExtensions == null ? 43 : $userExtensions.hashCode());
    Object $innerUserExtensions = this.getInnerUserExtensions();
    result = result * PRIME + ($innerUserExtensions == null ? 43 : $innerUserExtensions.hashCode());
    Object $contextInfo = this.getContextInfo();
    result = result * PRIME + ($contextInfo == null ? 43 : $contextInfo.hashCode());
    Object $certificationInfo = this.getCertificationInfo();
    result = result * PRIME + ($certificationInfo == null ? 43 : $certificationInfo.hashCode());
    Object $expandedJSONLDString = this.getExpandedJSONLDString();
    result = result * PRIME + ($expandedJSONLDString == null ? 43 : $expandedJSONLDString.hashCode());
    Object $openEPCISExtension = this.getOpenEPCISExtension();
    result = result * PRIME + ($openEPCISExtension == null ? 43 : $openEPCISExtension.hashCode());
    Object $baseExtension = this.getBaseExtension();
    result = result * PRIME + ($baseExtension == null ? 43 : $baseExtension.hashCode());
    Object $extension = this.getExtension();
    result = result * PRIME + ($extension == null ? 43 : $extension.hashCode());
    Object $anyElements = this.getAnyElements();
    result = result * PRIME + ($anyElements == null ? 43 : $anyElements.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "EPCISEvent(type=" + this.getType() + ", eventID=" + this.getEventID() + ", eventTimeZoneOffset=" + this.getEventTimeZoneOffset() + ", eventTime=" + this.getEventTime() + ", recordTime=" + this.getRecordTime() + ", bizStep=" + this.getBizStep() + ", disposition=" + this.getDisposition() + ", readPoint=" + this.getReadPoint() + ", bizLocation=" + this.getBizLocation() + ", errorDeclaration=" + this.getErrorDeclaration() + ", sourceList=" + this.getSourceList() + ", destinationList=" + this.getDestinationList() + ", sensorElementList=" + this.getSensorElementList() + ", userExtensions=" + this.getUserExtensions() + ", innerUserExtensions=" + this.getInnerUserExtensions() + ", contextInfo=" + this.getContextInfo() + ", certificationInfo=" + this.getCertificationInfo() + ", expandedJSONLDString=" + this.getExpandedJSONLDString() + ", openEPCISExtension=" + this.getOpenEPCISExtension() + ", baseExtension=" + this.getBaseExtension() + ", extension=" + this.getExtension() + ", anyElements=" + this.getAnyElements() + ")";
  }

  public EPCISEvent() {
    this.userExtensions = EPCISEvent.$default$userExtensions();
    this.openEPCISExtension = EPCISEvent.$default$openEPCISExtension();
  }

  public EPCISEvent(String type, String eventID, String eventTimeZoneOffset, OffsetDateTime eventTime, OffsetDateTime recordTime, String bizStep, String disposition, ReadPoint readPoint, BizLocation bizLocation, ErrorDeclaration errorDeclaration, List<SourceList> sourceList, List<DestinationList> destinationList, List<SensorElementList> sensorElementList, Map<String, Object> userExtensions, Map<String, Object> innerUserExtensions, List<Object> contextInfo, Object certificationInfo, String expandedJSONLDString, OpenEPCISExtension openEPCISExtension, Map<String, Serializable> baseExtension, Map<String, Object> extension, List<Object> anyElements) {
    this.type = type;
    this.eventID = eventID;
    this.eventTimeZoneOffset = eventTimeZoneOffset;
    this.eventTime = eventTime;
    this.recordTime = recordTime;
    this.bizStep = bizStep;
    this.disposition = disposition;
    this.readPoint = readPoint;
    this.bizLocation = bizLocation;
    this.errorDeclaration = errorDeclaration;
    this.sourceList = sourceList;
    this.destinationList = destinationList;
    this.sensorElementList = sensorElementList;
    this.userExtensions = userExtensions;
    this.innerUserExtensions = innerUserExtensions;
    this.contextInfo = contextInfo;
    this.certificationInfo = certificationInfo;
    this.expandedJSONLDString = expandedJSONLDString;
    this.openEPCISExtension = openEPCISExtension;
    this.baseExtension = baseExtension;
    this.extension = extension;
    this.anyElements = anyElements;
  }
}
