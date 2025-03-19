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

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.openepcis.model.epcis.modifier.*;
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
public class SensorMetadata implements Serializable {

  @XmlAttribute
  @XmlJavaTypeAdapter(CustomInstantAdapter.class)
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  private OffsetDateTime time;

  @XmlAttribute private URI deviceID;

  @XmlAttribute private URI deviceMetadata;

  @XmlAttribute private URI rawData;

  @XmlAttribute
  @XmlJavaTypeAdapter(CustomInstantAdapter.class)
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  private OffsetDateTime startTime;

  @XmlAttribute
  @XmlJavaTypeAdapter(CustomInstantAdapter.class)
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  private OffsetDateTime endTime;

  @XmlAttribute private URI dataProcessingMethod;

  @XmlAttribute private URI bizRules;

  @JsonIgnore @XmlTransient private Map<String, Object> innerUserExtensions;

  @JsonIgnore @XmlTransient @Builder.Default
  private Map<String, Object> userExtensions = new HashMap<>();

  @XmlAnyAttribute @JsonIgnore @Builder.Default
  private Map<QName, Object> anyAttributes = new HashMap<>();

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
      anyAttributes.forEach(
          (key, value) ->
              userExtensions.put(CommonExtensionModifier.getNamespacePrefix(key), value));
      anyAttributes = new HashMap<>();
    }
  }
}
