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

import jakarta.xml.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.xml.namespace.QName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EPCISDocumentType", namespace = "urn:epcglobal:epcis:xsd:2", propOrder = {"epcisHeader", "epcisBody", "extension", "any"})
public class EPCISDocument {
  @XmlElement(name = "EPCISBody")
  private EPCISBody epcisBody;
  @XmlTransient
  private String errorUrl;
  @XmlElement(name = "EPCISHeader")
  private EPCISHeader epcisHeader;
  @XmlElement
  private EPCISDocumentExtension extension;
  @XmlAnyElement(lax = true)
  protected List<Object> any;
  @XmlAnyAttribute
  private Map<QName, String> otherAttributes = new HashMap<>();

  public boolean hasEvents() {
    return Objects.nonNull(epcisBody) && Objects.nonNull(epcisBody.getEventList()) && !epcisBody.getEventList().isEmpty();
  }

  public boolean hasErrorDeclarationEvent() {
    if (Objects.nonNull(epcisBody) && Objects.nonNull(epcisBody.getEventList()) && !epcisBody.getEventList().isEmpty()) {
      return epcisBody.getEventList().stream().anyMatch(e -> Objects.nonNull(e.getErrorDeclaration()));
    }
    return false;
  }

  public EPCISBody getEpcisBody() {
    return this.epcisBody;
  }

  public String getErrorUrl() {
    return this.errorUrl;
  }

  public EPCISHeader getEpcisHeader() {
    return this.epcisHeader;
  }

  public EPCISDocumentExtension getExtension() {
    return this.extension;
  }

  public List<Object> getAny() {
    return this.any;
  }

  public Map<QName, String> getOtherAttributes() {
    return this.otherAttributes;
  }

  public void setEpcisBody(EPCISBody epcisBody) {
    this.epcisBody = epcisBody;
  }

  public void setErrorUrl(String errorUrl) {
    this.errorUrl = errorUrl;
  }

  public void setEpcisHeader(EPCISHeader epcisHeader) {
    this.epcisHeader = epcisHeader;
  }

  public void setExtension(EPCISDocumentExtension extension) {
    this.extension = extension;
  }

  public void setAny(List<Object> any) {
    this.any = any;
  }

  public void setOtherAttributes(Map<QName, String> otherAttributes) {
    this.otherAttributes = otherAttributes;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof EPCISDocument)) return false;
    EPCISDocument other = (EPCISDocument) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$epcisBody = this.getEpcisBody();
    Object other$epcisBody = other.getEpcisBody();
    if (this$epcisBody == null ? other$epcisBody != null : !this$epcisBody.equals(other$epcisBody)) return false;
    Object this$errorUrl = this.getErrorUrl();
    Object other$errorUrl = other.getErrorUrl();
    if (this$errorUrl == null ? other$errorUrl != null : !this$errorUrl.equals(other$errorUrl)) return false;
    Object this$epcisHeader = this.getEpcisHeader();
    Object other$epcisHeader = other.getEpcisHeader();
    if (this$epcisHeader == null ? other$epcisHeader != null : !this$epcisHeader.equals(other$epcisHeader)) return false;
    Object this$extension = this.getExtension();
    Object other$extension = other.getExtension();
    if (this$extension == null ? other$extension != null : !this$extension.equals(other$extension)) return false;
    Object this$any = this.getAny();
    Object other$any = other.getAny();
    if (this$any == null ? other$any != null : !this$any.equals(other$any)) return false;
    Object this$otherAttributes = this.getOtherAttributes();
    Object other$otherAttributes = other.getOtherAttributes();
    if (this$otherAttributes == null ? other$otherAttributes != null : !this$otherAttributes.equals(other$otherAttributes)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof EPCISDocument;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $epcisBody = this.getEpcisBody();
    result = result * PRIME + ($epcisBody == null ? 43 : $epcisBody.hashCode());
    Object $errorUrl = this.getErrorUrl();
    result = result * PRIME + ($errorUrl == null ? 43 : $errorUrl.hashCode());
    Object $epcisHeader = this.getEpcisHeader();
    result = result * PRIME + ($epcisHeader == null ? 43 : $epcisHeader.hashCode());
    Object $extension = this.getExtension();
    result = result * PRIME + ($extension == null ? 43 : $extension.hashCode());
    Object $any = this.getAny();
    result = result * PRIME + ($any == null ? 43 : $any.hashCode());
    Object $otherAttributes = this.getOtherAttributes();
    result = result * PRIME + ($otherAttributes == null ? 43 : $otherAttributes.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "EPCISDocument(epcisBody=" + this.getEpcisBody() + ", errorUrl=" + this.getErrorUrl() + ", epcisHeader=" + this.getEpcisHeader() + ", extension=" + this.getExtension() + ", any=" + this.getAny() + ", otherAttributes=" + this.getOtherAttributes() + ")";
  }

  public EPCISDocument() {
  }
}
