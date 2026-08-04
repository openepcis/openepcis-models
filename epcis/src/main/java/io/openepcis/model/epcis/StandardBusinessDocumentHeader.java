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
@XmlType(name = "StandardBusinessDocumentHeader", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", propOrder = {"headerVersion", "sender", "receiver", "documentIdentification", "manifest", "businessScope"})
public class StandardBusinessDocumentHeader {
  @XmlElement(name = "HeaderVersion", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
  protected String headerVersion;
  @XmlElement(name = "Sender", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
  protected List<Partner> sender;
  @XmlElement(name = "Receiver", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
  protected List<Partner> receiver;
  @XmlElement(name = "DocumentIdentification", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
  protected DocumentIdentification documentIdentification;
  @XmlElement(name = "Manifest", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected Manifest manifest;
  @XmlElement(name = "BusinessScope", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected BusinessScope businessScope;

  public String getHeaderVersion() {
    return this.headerVersion;
  }

  public List<Partner> getSender() {
    return this.sender;
  }

  public List<Partner> getReceiver() {
    return this.receiver;
  }

  public DocumentIdentification getDocumentIdentification() {
    return this.documentIdentification;
  }

  public Manifest getManifest() {
    return this.manifest;
  }

  public BusinessScope getBusinessScope() {
    return this.businessScope;
  }

  public void setHeaderVersion(String headerVersion) {
    this.headerVersion = headerVersion;
  }

  public void setSender(List<Partner> sender) {
    this.sender = sender;
  }

  public void setReceiver(List<Partner> receiver) {
    this.receiver = receiver;
  }

  public void setDocumentIdentification(DocumentIdentification documentIdentification) {
    this.documentIdentification = documentIdentification;
  }

  public void setManifest(Manifest manifest) {
    this.manifest = manifest;
  }

  public void setBusinessScope(BusinessScope businessScope) {
    this.businessScope = businessScope;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof StandardBusinessDocumentHeader)) return false;
    StandardBusinessDocumentHeader other = (StandardBusinessDocumentHeader) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$headerVersion = this.getHeaderVersion();
    Object other$headerVersion = other.getHeaderVersion();
    if (this$headerVersion == null ? other$headerVersion != null : !this$headerVersion.equals(other$headerVersion)) return false;
    Object this$sender = this.getSender();
    Object other$sender = other.getSender();
    if (this$sender == null ? other$sender != null : !this$sender.equals(other$sender)) return false;
    Object this$receiver = this.getReceiver();
    Object other$receiver = other.getReceiver();
    if (this$receiver == null ? other$receiver != null : !this$receiver.equals(other$receiver)) return false;
    Object this$documentIdentification = this.getDocumentIdentification();
    Object other$documentIdentification = other.getDocumentIdentification();
    if (this$documentIdentification == null ? other$documentIdentification != null : !this$documentIdentification.equals(other$documentIdentification)) return false;
    Object this$manifest = this.getManifest();
    Object other$manifest = other.getManifest();
    if (this$manifest == null ? other$manifest != null : !this$manifest.equals(other$manifest)) return false;
    Object this$businessScope = this.getBusinessScope();
    Object other$businessScope = other.getBusinessScope();
    if (this$businessScope == null ? other$businessScope != null : !this$businessScope.equals(other$businessScope)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof StandardBusinessDocumentHeader;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $headerVersion = this.getHeaderVersion();
    result = result * PRIME + ($headerVersion == null ? 43 : $headerVersion.hashCode());
    Object $sender = this.getSender();
    result = result * PRIME + ($sender == null ? 43 : $sender.hashCode());
    Object $receiver = this.getReceiver();
    result = result * PRIME + ($receiver == null ? 43 : $receiver.hashCode());
    Object $documentIdentification = this.getDocumentIdentification();
    result = result * PRIME + ($documentIdentification == null ? 43 : $documentIdentification.hashCode());
    Object $manifest = this.getManifest();
    result = result * PRIME + ($manifest == null ? 43 : $manifest.hashCode());
    Object $businessScope = this.getBusinessScope();
    result = result * PRIME + ($businessScope == null ? 43 : $businessScope.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "StandardBusinessDocumentHeader(headerVersion=" + this.getHeaderVersion() + ", sender=" + this.getSender() + ", receiver=" + this.getReceiver() + ", documentIdentification=" + this.getDocumentIdentification() + ", manifest=" + this.getManifest() + ", businessScope=" + this.getBusinessScope() + ")";
  }

  public StandardBusinessDocumentHeader() {
  }

  public StandardBusinessDocumentHeader(String headerVersion, List<Partner> sender, List<Partner> receiver, DocumentIdentification documentIdentification, Manifest manifest, BusinessScope businessScope) {
    this.headerVersion = headerVersion;
    this.sender = sender;
    this.receiver = receiver;
    this.documentIdentification = documentIdentification;
    this.manifest = manifest;
    this.businessScope = businessScope;
  }
}
