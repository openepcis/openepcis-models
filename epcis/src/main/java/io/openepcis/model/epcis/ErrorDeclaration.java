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
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"declarationTime", "reason", "correctiveEventIDs", "extension", "anyElements"})
public class ErrorDeclaration implements Serializable {
  @XmlElement(name = "declarationTime", required = true)
  private OffsetDateTime declarationTime;
  private String reason;
  @XmlElementWrapper(name = "correctiveEventIDs")
  @XmlElement(name = "correctiveEventID")
  private List<String> correctiveEventIDs;
  @JsonIgnore
  @XmlTransient
  private Map<String, Object> innerUserExtensions;
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
    // Detect default EPCIS namespaces (gs1, cbvmda, etc.), if present add namespacesURI that are
    // later used for XML marshalling
    DefaultNamespaceDeserializer.getInstance().processExtensions(userExtensions, null);
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
      anyElements = new ArrayList<>();
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


  public static class ErrorDeclarationBuilder {
    private OffsetDateTime declarationTime;
    private String reason;
    private List<String> correctiveEventIDs;
    private Map<String, Object> innerUserExtensions;
    private Map<String, Object> extension;
    private boolean userExtensions$set;
    private Map<String, Object> userExtensions$value;
    private boolean anyElements$set;
    private List<Object> anyElements$value;

    ErrorDeclarationBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public ErrorDeclaration.ErrorDeclarationBuilder declarationTime(OffsetDateTime declarationTime) {
      this.declarationTime = declarationTime;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ErrorDeclaration.ErrorDeclarationBuilder reason(String reason) {
      this.reason = reason;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public ErrorDeclaration.ErrorDeclarationBuilder correctiveEventIDs(List<String> correctiveEventIDs) {
      this.correctiveEventIDs = correctiveEventIDs;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public ErrorDeclaration.ErrorDeclarationBuilder innerUserExtensions(Map<String, Object> innerUserExtensions) {
      this.innerUserExtensions = innerUserExtensions;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public ErrorDeclaration.ErrorDeclarationBuilder extension(Map<String, Object> extension) {
      this.extension = extension;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public ErrorDeclaration.ErrorDeclarationBuilder userExtensions(Map<String, Object> userExtensions) {
      this.userExtensions$value = userExtensions;
      userExtensions$set = true;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public ErrorDeclaration.ErrorDeclarationBuilder anyElements(List<Object> anyElements) {
      this.anyElements$value = anyElements;
      anyElements$set = true;
      return this;
    }

    public ErrorDeclaration build() {
      Map<String, Object> userExtensions$value = this.userExtensions$value;
      if (!this.userExtensions$set) userExtensions$value = ErrorDeclaration.$default$userExtensions();
      List<Object> anyElements$value = this.anyElements$value;
      if (!this.anyElements$set) anyElements$value = ErrorDeclaration.$default$anyElements();
      return new ErrorDeclaration(this.declarationTime, this.reason, this.correctiveEventIDs, this.innerUserExtensions, this.extension, userExtensions$value, anyElements$value);
    }

    @Override
    public String toString() {
      return "ErrorDeclaration.ErrorDeclarationBuilder(declarationTime=" + this.declarationTime + ", reason=" + this.reason + ", correctiveEventIDs=" + this.correctiveEventIDs + ", innerUserExtensions=" + this.innerUserExtensions + ", extension=" + this.extension + ", userExtensions$value=" + this.userExtensions$value + ", anyElements$value=" + this.anyElements$value + ")";
    }
  }

  public static ErrorDeclaration.ErrorDeclarationBuilder builder() {
    return new ErrorDeclaration.ErrorDeclarationBuilder();
  }

  public OffsetDateTime getDeclarationTime() {
    return this.declarationTime;
  }

  public String getReason() {
    return this.reason;
  }

  public List<String> getCorrectiveEventIDs() {
    return this.correctiveEventIDs;
  }

  public Map<String, Object> getInnerUserExtensions() {
    return this.innerUserExtensions;
  }

  public Map<String, Object> getExtension() {
    return this.extension;
  }

  public List<Object> getAnyElements() {
    return this.anyElements;
  }

  public void setDeclarationTime(OffsetDateTime declarationTime) {
    this.declarationTime = declarationTime;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public void setCorrectiveEventIDs(List<String> correctiveEventIDs) {
    this.correctiveEventIDs = correctiveEventIDs;
  }

  public void setInnerUserExtensions(Map<String, Object> innerUserExtensions) {
    this.innerUserExtensions = innerUserExtensions;
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
    if (!(o instanceof ErrorDeclaration)) return false;
    ErrorDeclaration other = (ErrorDeclaration) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$declarationTime = this.getDeclarationTime();
    Object other$declarationTime = other.getDeclarationTime();
    if (this$declarationTime == null ? other$declarationTime != null : !this$declarationTime.equals(other$declarationTime)) return false;
    Object this$reason = this.getReason();
    Object other$reason = other.getReason();
    if (this$reason == null ? other$reason != null : !this$reason.equals(other$reason)) return false;
    Object this$correctiveEventIDs = this.getCorrectiveEventIDs();
    Object other$correctiveEventIDs = other.getCorrectiveEventIDs();
    if (this$correctiveEventIDs == null ? other$correctiveEventIDs != null : !this$correctiveEventIDs.equals(other$correctiveEventIDs)) return false;
    Object this$innerUserExtensions = this.getInnerUserExtensions();
    Object other$innerUserExtensions = other.getInnerUserExtensions();
    if (this$innerUserExtensions == null ? other$innerUserExtensions != null : !this$innerUserExtensions.equals(other$innerUserExtensions)) return false;
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
    return other instanceof ErrorDeclaration;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $declarationTime = this.getDeclarationTime();
    result = result * PRIME + ($declarationTime == null ? 43 : $declarationTime.hashCode());
    Object $reason = this.getReason();
    result = result * PRIME + ($reason == null ? 43 : $reason.hashCode());
    Object $correctiveEventIDs = this.getCorrectiveEventIDs();
    result = result * PRIME + ($correctiveEventIDs == null ? 43 : $correctiveEventIDs.hashCode());
    Object $innerUserExtensions = this.getInnerUserExtensions();
    result = result * PRIME + ($innerUserExtensions == null ? 43 : $innerUserExtensions.hashCode());
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
    return "ErrorDeclaration(declarationTime=" + this.getDeclarationTime() + ", reason=" + this.getReason() + ", correctiveEventIDs=" + this.getCorrectiveEventIDs() + ", innerUserExtensions=" + this.getInnerUserExtensions() + ", extension=" + this.getExtension() + ", userExtensions=" + this.getUserExtensions() + ", anyElements=" + this.getAnyElements() + ")";
  }

  public ErrorDeclaration() {
    this.userExtensions = ErrorDeclaration.$default$userExtensions();
    this.anyElements = ErrorDeclaration.$default$anyElements();
  }

  public ErrorDeclaration(OffsetDateTime declarationTime, String reason, List<String> correctiveEventIDs, Map<String, Object> innerUserExtensions, Map<String, Object> extension, Map<String, Object> userExtensions, List<Object> anyElements) {
    this.declarationTime = declarationTime;
    this.reason = reason;
    this.correctiveEventIDs = correctiveEventIDs;
    this.innerUserExtensions = innerUserExtensions;
    this.extension = extension;
    this.userExtensions = userExtensions;
    this.anyElements = anyElements;
  }
}
