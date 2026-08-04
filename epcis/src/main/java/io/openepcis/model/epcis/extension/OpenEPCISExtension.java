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
package io.openepcis.model.epcis.extension;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.openepcis.model.epcis.util.ConversionNamespaceContext;
import jakarta.xml.bind.annotation.XmlTransient;

public class OpenEPCISExtension implements CaptureID, EventHashID, EventSequence {
  @XmlTransient
  @JsonIgnore
  private String hash;
  @XmlTransient
  @JsonIgnore
  private Integer sequenceInEPCISDoc;
  @XmlTransient
  @JsonIgnore
  private String captureID;
  /**
   * Namespace context for JSON-to-XML conversion.
   * Holds custom namespace prefix-to-URI mappings (e.g., ext1 -> https://ns.ext.de/epcis/)
   * so that beforeMarshal() can create properly namespaced XML elements.
   */
  @XmlTransient
  @JsonIgnore
  private ConversionNamespaceContext conversionNamespaceContext;

  public OpenEPCISExtension() {
  }

  public OpenEPCISExtension(final String hash, final Integer sequenceInEPCISDoc, final String captureID) {
    this.hash = hash;
    this.sequenceInEPCISDoc = sequenceInEPCISDoc;
    this.captureID = captureID;
  }


  public static class OpenEPCISExtensionBuilder {
    private String hash;
    private Integer sequenceInEPCISDoc;
    private String captureID;

    OpenEPCISExtensionBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public OpenEPCISExtension.OpenEPCISExtensionBuilder hash(String hash) {
      this.hash = hash;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public OpenEPCISExtension.OpenEPCISExtensionBuilder sequenceInEPCISDoc(Integer sequenceInEPCISDoc) {
      this.sequenceInEPCISDoc = sequenceInEPCISDoc;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public OpenEPCISExtension.OpenEPCISExtensionBuilder captureID(String captureID) {
      this.captureID = captureID;
      return this;
    }

    public OpenEPCISExtension build() {
      return new OpenEPCISExtension(this.hash, this.sequenceInEPCISDoc, this.captureID);
    }

    @Override
    public String toString() {
      return "OpenEPCISExtension.OpenEPCISExtensionBuilder(hash=" + this.hash + ", sequenceInEPCISDoc=" + this.sequenceInEPCISDoc + ", captureID=" + this.captureID + ")";
    }
  }

  public static OpenEPCISExtension.OpenEPCISExtensionBuilder builder() {
    return new OpenEPCISExtension.OpenEPCISExtensionBuilder();
  }

  public String getHash() {
    return this.hash;
  }

  public Integer getSequenceInEPCISDoc() {
    return this.sequenceInEPCISDoc;
  }

  public String getCaptureID() {
    return this.captureID;
  }

  /**
   * Namespace context for JSON-to-XML conversion.
   * Holds custom namespace prefix-to-URI mappings (e.g., ext1 -> https://ns.ext.de/epcis/)
   * so that beforeMarshal() can create properly namespaced XML elements.
   */
  public ConversionNamespaceContext getConversionNamespaceContext() {
    return this.conversionNamespaceContext;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public void setSequenceInEPCISDoc(Integer sequenceInEPCISDoc) {
    this.sequenceInEPCISDoc = sequenceInEPCISDoc;
  }

  public void setCaptureID(String captureID) {
    this.captureID = captureID;
  }

  /**
   * Namespace context for JSON-to-XML conversion.
   * Holds custom namespace prefix-to-URI mappings (e.g., ext1 -> https://ns.ext.de/epcis/)
   * so that beforeMarshal() can create properly namespaced XML elements.
   */
  public void setConversionNamespaceContext(ConversionNamespaceContext conversionNamespaceContext) {
    this.conversionNamespaceContext = conversionNamespaceContext;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof OpenEPCISExtension)) return false;
    OpenEPCISExtension other = (OpenEPCISExtension) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$sequenceInEPCISDoc = this.getSequenceInEPCISDoc();
    Object other$sequenceInEPCISDoc = other.getSequenceInEPCISDoc();
    if (this$sequenceInEPCISDoc == null ? other$sequenceInEPCISDoc != null : !this$sequenceInEPCISDoc.equals(other$sequenceInEPCISDoc)) return false;
    Object this$hash = this.getHash();
    Object other$hash = other.getHash();
    if (this$hash == null ? other$hash != null : !this$hash.equals(other$hash)) return false;
    Object this$captureID = this.getCaptureID();
    Object other$captureID = other.getCaptureID();
    if (this$captureID == null ? other$captureID != null : !this$captureID.equals(other$captureID)) return false;
    Object this$conversionNamespaceContext = this.getConversionNamespaceContext();
    Object other$conversionNamespaceContext = other.getConversionNamespaceContext();
    if (this$conversionNamespaceContext == null ? other$conversionNamespaceContext != null : !this$conversionNamespaceContext.equals(other$conversionNamespaceContext)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof OpenEPCISExtension;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $sequenceInEPCISDoc = this.getSequenceInEPCISDoc();
    result = result * PRIME + ($sequenceInEPCISDoc == null ? 43 : $sequenceInEPCISDoc.hashCode());
    Object $hash = this.getHash();
    result = result * PRIME + ($hash == null ? 43 : $hash.hashCode());
    Object $captureID = this.getCaptureID();
    result = result * PRIME + ($captureID == null ? 43 : $captureID.hashCode());
    Object $conversionNamespaceContext = this.getConversionNamespaceContext();
    result = result * PRIME + ($conversionNamespaceContext == null ? 43 : $conversionNamespaceContext.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "OpenEPCISExtension(hash=" + this.getHash() + ", sequenceInEPCISDoc=" + this.getSequenceInEPCISDoc() + ", captureID=" + this.getCaptureID() + ", conversionNamespaceContext=" + this.getConversionNamespaceContext() + ")";
  }
}
