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

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactInformation", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", propOrder = {"contact", "emailAddress", "faxNumber", "telephoneNumber", "contactTypeIdentifier"})
public class ContactInformation {
  @XmlElement(name = "Contact", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
  protected String contact;
  @XmlElement(name = "EmailAddress", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected String emailAddress;
  @XmlElement(name = "FaxNumber", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected String faxNumber;
  @XmlElement(name = "TelephoneNumber", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected String telephoneNumber;
  @XmlElement(name = "ContactTypeIdentifier", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected String contactTypeIdentifier;

  public String getContact() {
    return this.contact;
  }

  public String getEmailAddress() {
    return this.emailAddress;
  }

  public String getFaxNumber() {
    return this.faxNumber;
  }

  public String getTelephoneNumber() {
    return this.telephoneNumber;
  }

  public String getContactTypeIdentifier() {
    return this.contactTypeIdentifier;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public void setFaxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
  }

  public void setTelephoneNumber(String telephoneNumber) {
    this.telephoneNumber = telephoneNumber;
  }

  public void setContactTypeIdentifier(String contactTypeIdentifier) {
    this.contactTypeIdentifier = contactTypeIdentifier;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof ContactInformation)) return false;
    ContactInformation other = (ContactInformation) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$contact = this.getContact();
    Object other$contact = other.getContact();
    if (this$contact == null ? other$contact != null : !this$contact.equals(other$contact)) return false;
    Object this$emailAddress = this.getEmailAddress();
    Object other$emailAddress = other.getEmailAddress();
    if (this$emailAddress == null ? other$emailAddress != null : !this$emailAddress.equals(other$emailAddress)) return false;
    Object this$faxNumber = this.getFaxNumber();
    Object other$faxNumber = other.getFaxNumber();
    if (this$faxNumber == null ? other$faxNumber != null : !this$faxNumber.equals(other$faxNumber)) return false;
    Object this$telephoneNumber = this.getTelephoneNumber();
    Object other$telephoneNumber = other.getTelephoneNumber();
    if (this$telephoneNumber == null ? other$telephoneNumber != null : !this$telephoneNumber.equals(other$telephoneNumber)) return false;
    Object this$contactTypeIdentifier = this.getContactTypeIdentifier();
    Object other$contactTypeIdentifier = other.getContactTypeIdentifier();
    if (this$contactTypeIdentifier == null ? other$contactTypeIdentifier != null : !this$contactTypeIdentifier.equals(other$contactTypeIdentifier)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof ContactInformation;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $contact = this.getContact();
    result = result * PRIME + ($contact == null ? 43 : $contact.hashCode());
    Object $emailAddress = this.getEmailAddress();
    result = result * PRIME + ($emailAddress == null ? 43 : $emailAddress.hashCode());
    Object $faxNumber = this.getFaxNumber();
    result = result * PRIME + ($faxNumber == null ? 43 : $faxNumber.hashCode());
    Object $telephoneNumber = this.getTelephoneNumber();
    result = result * PRIME + ($telephoneNumber == null ? 43 : $telephoneNumber.hashCode());
    Object $contactTypeIdentifier = this.getContactTypeIdentifier();
    result = result * PRIME + ($contactTypeIdentifier == null ? 43 : $contactTypeIdentifier.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "ContactInformation(contact=" + this.getContact() + ", emailAddress=" + this.getEmailAddress() + ", faxNumber=" + this.getFaxNumber() + ", telephoneNumber=" + this.getTelephoneNumber() + ", contactTypeIdentifier=" + this.getContactTypeIdentifier() + ")";
  }

  public ContactInformation() {
  }

  public ContactInformation(String contact, String emailAddress, String faxNumber, String telephoneNumber, String contactTypeIdentifier) {
    this.contact = contact;
    this.emailAddress = emailAddress;
    this.faxNumber = faxNumber;
    this.telephoneNumber = telephoneNumber;
    this.contactTypeIdentifier = contactTypeIdentifier;
  }
}
