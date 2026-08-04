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
import jakarta.xml.bind.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManifestItem", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", propOrder = {"mimeTypeQualifierCode", "uniformResourceIdentifier", "description", "languageCode"})
public class ManifestItem {
  @XmlElement(name = "MimeTypeQualifierCode", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
  protected String mimeTypeQualifierCode;
  @XmlElement(name = "UniformResourceIdentifier", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
  @XmlSchemaType(name = "anyURI")
  protected String uniformResourceIdentifier;
  @XmlElement(name = "Description", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected String description;
  @XmlElement(name = "LanguageCode", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected String languageCode;

  public String getMimeTypeQualifierCode() {
    return this.mimeTypeQualifierCode;
  }

  public String getUniformResourceIdentifier() {
    return this.uniformResourceIdentifier;
  }

  public String getDescription() {
    return this.description;
  }

  public String getLanguageCode() {
    return this.languageCode;
  }

  public void setMimeTypeQualifierCode(String mimeTypeQualifierCode) {
    this.mimeTypeQualifierCode = mimeTypeQualifierCode;
  }

  public void setUniformResourceIdentifier(String uniformResourceIdentifier) {
    this.uniformResourceIdentifier = uniformResourceIdentifier;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setLanguageCode(String languageCode) {
    this.languageCode = languageCode;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof ManifestItem)) return false;
    ManifestItem other = (ManifestItem) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$mimeTypeQualifierCode = this.getMimeTypeQualifierCode();
    Object other$mimeTypeQualifierCode = other.getMimeTypeQualifierCode();
    if (this$mimeTypeQualifierCode == null ? other$mimeTypeQualifierCode != null : !this$mimeTypeQualifierCode.equals(other$mimeTypeQualifierCode)) return false;
    Object this$uniformResourceIdentifier = this.getUniformResourceIdentifier();
    Object other$uniformResourceIdentifier = other.getUniformResourceIdentifier();
    if (this$uniformResourceIdentifier == null ? other$uniformResourceIdentifier != null : !this$uniformResourceIdentifier.equals(other$uniformResourceIdentifier)) return false;
    Object this$description = this.getDescription();
    Object other$description = other.getDescription();
    if (this$description == null ? other$description != null : !this$description.equals(other$description)) return false;
    Object this$languageCode = this.getLanguageCode();
    Object other$languageCode = other.getLanguageCode();
    if (this$languageCode == null ? other$languageCode != null : !this$languageCode.equals(other$languageCode)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof ManifestItem;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $mimeTypeQualifierCode = this.getMimeTypeQualifierCode();
    result = result * PRIME + ($mimeTypeQualifierCode == null ? 43 : $mimeTypeQualifierCode.hashCode());
    Object $uniformResourceIdentifier = this.getUniformResourceIdentifier();
    result = result * PRIME + ($uniformResourceIdentifier == null ? 43 : $uniformResourceIdentifier.hashCode());
    Object $description = this.getDescription();
    result = result * PRIME + ($description == null ? 43 : $description.hashCode());
    Object $languageCode = this.getLanguageCode();
    result = result * PRIME + ($languageCode == null ? 43 : $languageCode.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "ManifestItem(mimeTypeQualifierCode=" + this.getMimeTypeQualifierCode() + ", uniformResourceIdentifier=" + this.getUniformResourceIdentifier() + ", description=" + this.getDescription() + ", languageCode=" + this.getLanguageCode() + ")";
  }

  public ManifestItem() {
  }

  public ManifestItem(String mimeTypeQualifierCode, String uniformResourceIdentifier, String description, String languageCode) {
    this.mimeTypeQualifierCode = mimeTypeQualifierCode;
    this.uniformResourceIdentifier = uniformResourceIdentifier;
    this.description = description;
    this.languageCode = languageCode;
  }
}
