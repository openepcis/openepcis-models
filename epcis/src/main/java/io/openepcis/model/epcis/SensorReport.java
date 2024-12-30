/*
 * Copyright 2022-2024 benelog GmbH & Co. KG
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlAccessorType(XmlAccessType.NONE)
public class SensorReport implements Serializable {

  @XmlAttribute private URI type;

  @XmlAttribute private String exception;

  @XmlAttribute private String coordinateReferenceSystem;

  @XmlAttribute private URI microorganism;

  @XmlAttribute private URI chemicalSubstance;

  @XmlAttribute
  @XmlJavaTypeAdapter(CustomInstantAdapter.class)
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  private OffsetDateTime time;

  @XmlAttribute private Double value;

  @XmlAttribute private String component;

  @XmlAttribute private String stringValue;

  @XmlAttribute private Boolean booleanValue;

  @XmlAttribute private String hexBinaryValue;

  @XmlAttribute private URI uriValue;

  @XmlAttribute private Double minValue;

  @XmlAttribute private Double maxValue;

  @XmlAttribute private Double meanValue;

  @XmlAttribute
  @JsonProperty("sDev")
  private Double sDev;

  @XmlAttribute private Double percRank;

  @XmlAttribute private Double percValue;

  @XmlAttribute private URI deviceID;

  @XmlAttribute private URI deviceMetadata;

  @XmlAttribute private URI rawData;

  @XmlAttribute private URI dataProcessingMethod;

  @XmlAttribute private String uom;

  @XmlAttribute private String bizRules;

  @JsonIgnore private Map<String, Object> innerUserExtensions;

  @XmlTransient @Builder.Default private Map<String, Object> userExtensions = new HashMap<>();

  @XmlAnyAttribute @JsonIgnore @Builder.Default private Map<QName, Object> anyAttributes = new HashMap<>();

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

  private static final String EXAMPLE = "example:";

  public void afterUnmarshal(Unmarshaller m, Object parent) {
    // If there are any user-defined attributes in Sensor Metadata then read them and write to
    // User-Extensions MAP
    if (anyAttributes != null) {
      userExtensions = new HashMap<>();
      anyAttributes.forEach(
          (key, value1) ->
              this.userExtensions.put(CommonExtensionModifier.getNamespacePrefix(key), value1));
      anyAttributes = new HashMap<>();
    }

    // If type value contains the GS1:MT- then remove it during XML->JSON conversion
    if (type != null
        && (type.toString().contains("gs1:MT-") || type.toString().contains("gs1:AT-"))) {
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
}
