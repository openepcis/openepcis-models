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
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Partner", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", propOrder = {"identifier", "contactInformation"})
public class Partner {
  @XmlElement(name = "Identifier", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
  protected PartnerIdentification identifier;
  @XmlElement(name = "ContactInformation", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected List<ContactInformation> contactInformation;

  public PartnerIdentification getIdentifier() {
    return this.identifier;
  }

  public List<ContactInformation> getContactInformation() {
    return this.contactInformation;
  }

  public void setIdentifier(PartnerIdentification identifier) {
    this.identifier = identifier;
  }

  public void setContactInformation(List<ContactInformation> contactInformation) {
    this.contactInformation = contactInformation;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Partner)) return false;
    Partner other = (Partner) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$identifier = this.getIdentifier();
    Object other$identifier = other.getIdentifier();
    if (this$identifier == null ? other$identifier != null : !this$identifier.equals(other$identifier)) return false;
    Object this$contactInformation = this.getContactInformation();
    Object other$contactInformation = other.getContactInformation();
    if (this$contactInformation == null ? other$contactInformation != null : !this$contactInformation.equals(other$contactInformation)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof Partner;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $identifier = this.getIdentifier();
    result = result * PRIME + ($identifier == null ? 43 : $identifier.hashCode());
    Object $contactInformation = this.getContactInformation();
    result = result * PRIME + ($contactInformation == null ? 43 : $contactInformation.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "Partner(identifier=" + this.getIdentifier() + ", contactInformation=" + this.getContactInformation() + ")";
  }

  public Partner() {
  }

  public Partner(PartnerIdentification identifier, List<ContactInformation> contactInformation) {
    this.identifier = identifier;
    this.contactInformation = contactInformation;
  }
}
