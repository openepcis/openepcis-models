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
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    propOrder = {"declarationTime", "reason", "correctiveEventIDs", "extension", "anyElements"})
public class ErrorDeclaration implements Serializable {

  @XmlElement(name = "declarationTime", required = true)
  private OffsetDateTime declarationTime;

  private String reason;

  @XmlElementWrapper(name = "correctiveEventIDs")
  @XmlElement(name = "correctiveEventID")
  private List<String> correctiveEventIDs;

  @JsonIgnore @XmlTransient private Map<String, Object> innerUserExtensions;

  @XmlPath("extension")
  @XmlJavaTypeAdapter(CustomExtensionAdapter.class)
  @JsonIgnore
  private Map<String, Object> extension;

  @JsonIgnore @XmlTransient @Builder.Default
  private Map<String, Object> userExtensions = new HashMap<>();

  @XmlAnyElement(lax = true)
  @JsonIgnore
  @Builder.Default
  private List<Object> anyElements = new ArrayList<>();

  @JsonAnySetter
  public void setUserExtensions(String key, Object value) {
    userExtensions.put(key, value);

    // Detect default EPCIS namespaces (gs1, cbvmda, etc.), if present add namespacesURI that are
    // later used for XML marshalling
    DefaultNamespaceDeserializer.getInstance().processExtensions(userExtensions);
  }

  @JsonAnyGetter
  @JsonSerialize(using = CustomExtensionsSerializer.class)
  @UserExtensions(extension = "userExtensions")
  public Map<String, Object> getUserExtensions() {
    return userExtensions;
  }

  public void beforeMarshal(Marshaller m) throws ParserConfigurationException {
    // Add all elements from UserExtensions to AnyElements before Marshaling before creating XML
    if (userExtensions != null) {
      final ExtensionsModifier extensionsModifier = new ExtensionsModifier();
      anyElements = extensionsModifier.createXmlElement(userExtensions);
      userExtensions = new HashMap<>();
    }
  }

  public void afterUnmarshal(Unmarshaller m, Object parent) throws ParserConfigurationException {
    // Add all elements from AnyElements to UserExtensions after Unmarshalling before creating JSON
    if (anyElements != null) {
      final ExtensionsModifier extensionsModifier = new ExtensionsModifier();
      userExtensions = extensionsModifier.createObject(anyElements);
      anyElements = new ArrayList<>();
    }

    // If there are elements in Extension after Unmarshalling then add it to UserExtensions before
    // creating JSON
    if (extension != null) {
      userExtensions.putAll(extension);
      extension = new HashMap<>();
    }
  }
}
