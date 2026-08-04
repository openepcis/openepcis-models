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

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.*;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Scope", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", propOrder = {"type", "instanceIdentifier", "identifier", "scopeInformation"})
public class Scope {
  @XmlElement(name = "Type", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
  protected String type;
  @XmlElement(name = "InstanceIdentifier", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
  protected String instanceIdentifier;
  @XmlElement(name = "Identifier", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected String identifier;
  @XmlElement(name = "ScopeInformation", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", type = JAXBElement.class)
  protected List<JAXBElement<?>> scopeInformation;

  public String getType() {
    return this.type;
  }

  public String getInstanceIdentifier() {
    return this.instanceIdentifier;
  }

  public String getIdentifier() {
    return this.identifier;
  }

  public List<JAXBElement<?>> getScopeInformation() {
    return this.scopeInformation;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setInstanceIdentifier(String instanceIdentifier) {
    this.instanceIdentifier = instanceIdentifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public void setScopeInformation(List<JAXBElement<?>> scopeInformation) {
    this.scopeInformation = scopeInformation;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Scope)) return false;
    Scope other = (Scope) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$type = this.getType();
    Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
    Object this$instanceIdentifier = this.getInstanceIdentifier();
    Object other$instanceIdentifier = other.getInstanceIdentifier();
    if (this$instanceIdentifier == null ? other$instanceIdentifier != null : !this$instanceIdentifier.equals(other$instanceIdentifier)) return false;
    Object this$identifier = this.getIdentifier();
    Object other$identifier = other.getIdentifier();
    if (this$identifier == null ? other$identifier != null : !this$identifier.equals(other$identifier)) return false;
    Object this$scopeInformation = this.getScopeInformation();
    Object other$scopeInformation = other.getScopeInformation();
    if (this$scopeInformation == null ? other$scopeInformation != null : !this$scopeInformation.equals(other$scopeInformation)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof Scope;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    Object $instanceIdentifier = this.getInstanceIdentifier();
    result = result * PRIME + ($instanceIdentifier == null ? 43 : $instanceIdentifier.hashCode());
    Object $identifier = this.getIdentifier();
    result = result * PRIME + ($identifier == null ? 43 : $identifier.hashCode());
    Object $scopeInformation = this.getScopeInformation();
    result = result * PRIME + ($scopeInformation == null ? 43 : $scopeInformation.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "Scope(type=" + this.getType() + ", instanceIdentifier=" + this.getInstanceIdentifier() + ", identifier=" + this.getIdentifier() + ", scopeInformation=" + this.getScopeInformation() + ")";
  }

  public Scope() {
  }

  public Scope(String type, String instanceIdentifier, String identifier, List<JAXBElement<?>> scopeInformation) {
    this.type = type;
    this.instanceIdentifier = instanceIdentifier;
    this.identifier = identifier;
    this.scopeInformation = scopeInformation;
  }
}
