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
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"sensorMetadata", "sensorReport", "extension", "anyElements"})
public class SensorElementList implements Serializable {
  @JsonIgnore
  @XmlTransient
  private Map<String, Object> innerUserExtensions;
  private SensorMetadata sensorMetadata;
  private List<SensorReport> sensorReport;
  @XmlPath("extension")
  @XmlJavaTypeAdapter(CustomExtensionAdapter.class)
  @JsonIgnore
  private Map<String, Object> extension;
  @JsonIgnore
  @XmlTransient
  private Map<String, Object> userExtensions;
  @XmlAnyElement(lax = true)
  @JsonIgnore
  private List<Object> anyElements;

  @JsonAnySetter
  public void setUserExtensions(String key, Object value) {
    userExtensions.put(key, value);
    // Detect default EPCIS namespaces (gs1, cbvmda, etc.) after json deserialization, if present
    // add namespacesURI that are later used for XML marshalling
    DefaultNamespaceDeserializer.getInstance().processExtensions(userExtensions, null);
  }

  @JsonAnyGetter
  @JsonSerialize(using = CustomExtensionsSerializer.class)
  @UserExtensions(extension = "userExtensions")
  public Map<String, Object> getUserExtensions() {
    return userExtensions;
  }

  public void beforeMarshal(Marshaller m) throws ParserConfigurationException {
    // Add all elements from UserExtensions to AnyElements before Marshaling & creating XML
    if (userExtensions != null) {
      final ConversionNamespaceContext nsContext = m.getAdapter(CustomExtensionAdapter.class).getNsContext();
      final ExtensionsModifier extensionsModifier = new ExtensionsModifier(nsContext);
      anyElements = extensionsModifier.createXmlElement(userExtensions);
      userExtensions = new HashMap<>();
    }
  }

  public void afterUnmarshal(Unmarshaller m, Object parent) throws ParserConfigurationException {
    // Add all elements from AnyElements to UserExtensions after Unmarshalling before creating JSON
    if (anyElements != null) {
      final ExtensionsModifier extensionsModifier = new ExtensionsModifier();
      final ConversionNamespaceContext nsContext = ConversionNamespaceContext.fromUnmarshaller(m).orElse(null);
      userExtensions = extensionsModifier.createObject(anyElements, nsContext);
      anyElements = new ArrayList();
    }
    // If there are elements in Extension after Unmarshalling then add it to UserExtensions before
    // creating JSON
    if (extension != null) {
      userExtensions.putAll(extension);
      extension = new HashMap<>();
    }
  }

  private static Map<String, Object> $default$userExtensions() {
    return new HashMap<>();
  }

  private static List<Object> $default$anyElements() {
    return new ArrayList<>();
  }


  public static class SensorElementListBuilder {
    private Map<String, Object> innerUserExtensions;
    private SensorMetadata sensorMetadata;
    private List<SensorReport> sensorReport;
    private Map<String, Object> extension;
    private boolean userExtensions$set;
    private Map<String, Object> userExtensions$value;
    private boolean anyElements$set;
    private List<Object> anyElements$value;

    SensorElementListBuilder() {
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public SensorElementList.SensorElementListBuilder innerUserExtensions(Map<String, Object> innerUserExtensions) {
      this.innerUserExtensions = innerUserExtensions;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorElementList.SensorElementListBuilder sensorMetadata(SensorMetadata sensorMetadata) {
      this.sensorMetadata = sensorMetadata;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SensorElementList.SensorElementListBuilder sensorReport(List<SensorReport> sensorReport) {
      this.sensorReport = sensorReport;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public SensorElementList.SensorElementListBuilder extension(Map<String, Object> extension) {
      this.extension = extension;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public SensorElementList.SensorElementListBuilder userExtensions(Map<String, Object> userExtensions) {
      this.userExtensions$value = userExtensions;
      userExtensions$set = true;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public SensorElementList.SensorElementListBuilder anyElements(List<Object> anyElements) {
      this.anyElements$value = anyElements;
      anyElements$set = true;
      return this;
    }

    public SensorElementList build() {
      Map<String, Object> userExtensions$value = this.userExtensions$value;
      if (!this.userExtensions$set) userExtensions$value = SensorElementList.$default$userExtensions();
      List<Object> anyElements$value = this.anyElements$value;
      if (!this.anyElements$set) anyElements$value = SensorElementList.$default$anyElements();
      return new SensorElementList(this.innerUserExtensions, this.sensorMetadata, this.sensorReport, this.extension, userExtensions$value, anyElements$value);
    }

    @Override
    public String toString() {
      return "SensorElementList.SensorElementListBuilder(innerUserExtensions=" + this.innerUserExtensions + ", sensorMetadata=" + this.sensorMetadata + ", sensorReport=" + this.sensorReport + ", extension=" + this.extension + ", userExtensions$value=" + this.userExtensions$value + ", anyElements$value=" + this.anyElements$value + ")";
    }
  }

  public static SensorElementList.SensorElementListBuilder builder() {
    return new SensorElementList.SensorElementListBuilder();
  }

  public Map<String, Object> getInnerUserExtensions() {
    return this.innerUserExtensions;
  }

  public SensorMetadata getSensorMetadata() {
    return this.sensorMetadata;
  }

  public List<SensorReport> getSensorReport() {
    return this.sensorReport;
  }

  public Map<String, Object> getExtension() {
    return this.extension;
  }

  public List<Object> getAnyElements() {
    return this.anyElements;
  }

  public void setInnerUserExtensions(Map<String, Object> innerUserExtensions) {
    this.innerUserExtensions = innerUserExtensions;
  }

  public void setSensorMetadata(SensorMetadata sensorMetadata) {
    this.sensorMetadata = sensorMetadata;
  }

  public void setSensorReport(List<SensorReport> sensorReport) {
    this.sensorReport = sensorReport;
  }

  public void setExtension(Map<String, Object> extension) {
    this.extension = extension;
  }

  public void setUserExtensions(Map<String, Object> userExtensions) {
    this.userExtensions = userExtensions;
  }

  public void setAnyElements(List<Object> anyElements) {
    this.anyElements = anyElements;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof SensorElementList)) return false;
    SensorElementList other = (SensorElementList) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$innerUserExtensions = this.getInnerUserExtensions();
    Object other$innerUserExtensions = other.getInnerUserExtensions();
    if (this$innerUserExtensions == null ? other$innerUserExtensions != null : !this$innerUserExtensions.equals(other$innerUserExtensions)) return false;
    Object this$sensorMetadata = this.getSensorMetadata();
    Object other$sensorMetadata = other.getSensorMetadata();
    if (this$sensorMetadata == null ? other$sensorMetadata != null : !this$sensorMetadata.equals(other$sensorMetadata)) return false;
    Object this$sensorReport = this.getSensorReport();
    Object other$sensorReport = other.getSensorReport();
    if (this$sensorReport == null ? other$sensorReport != null : !this$sensorReport.equals(other$sensorReport)) return false;
    Object this$extension = this.getExtension();
    Object other$extension = other.getExtension();
    if (this$extension == null ? other$extension != null : !this$extension.equals(other$extension)) return false;
    Object this$userExtensions = this.getUserExtensions();
    Object other$userExtensions = other.getUserExtensions();
    if (this$userExtensions == null ? other$userExtensions != null : !this$userExtensions.equals(other$userExtensions)) return false;
    Object this$anyElements = this.getAnyElements();
    Object other$anyElements = other.getAnyElements();
    if (this$anyElements == null ? other$anyElements != null : !this$anyElements.equals(other$anyElements)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof SensorElementList;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $innerUserExtensions = this.getInnerUserExtensions();
    result = result * PRIME + ($innerUserExtensions == null ? 43 : $innerUserExtensions.hashCode());
    Object $sensorMetadata = this.getSensorMetadata();
    result = result * PRIME + ($sensorMetadata == null ? 43 : $sensorMetadata.hashCode());
    Object $sensorReport = this.getSensorReport();
    result = result * PRIME + ($sensorReport == null ? 43 : $sensorReport.hashCode());
    Object $extension = this.getExtension();
    result = result * PRIME + ($extension == null ? 43 : $extension.hashCode());
    Object $userExtensions = this.getUserExtensions();
    result = result * PRIME + ($userExtensions == null ? 43 : $userExtensions.hashCode());
    Object $anyElements = this.getAnyElements();
    result = result * PRIME + ($anyElements == null ? 43 : $anyElements.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "SensorElementList(innerUserExtensions=" + this.getInnerUserExtensions() + ", sensorMetadata=" + this.getSensorMetadata() + ", sensorReport=" + this.getSensorReport() + ", extension=" + this.getExtension() + ", userExtensions=" + this.getUserExtensions() + ", anyElements=" + this.getAnyElements() + ")";
  }

  public SensorElementList() {
    this.userExtensions = SensorElementList.$default$userExtensions();
    this.anyElements = SensorElementList.$default$anyElements();
  }

  public SensorElementList(Map<String, Object> innerUserExtensions, SensorMetadata sensorMetadata, List<SensorReport> sensorReport, Map<String, Object> extension, Map<String, Object> userExtensions, List<Object> anyElements) {
    this.innerUserExtensions = innerUserExtensions;
    this.sensorMetadata = sensorMetadata;
    this.sensorReport = sensorReport;
    this.extension = extension;
    this.userExtensions = userExtensions;
    this.anyElements = anyElements;
  }
}
