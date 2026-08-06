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
import java.math.BigInteger;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Manifest", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", propOrder = {"numberOfItems", "manifestItem"})
public class Manifest {
  @XmlElement(name = "NumberOfItems", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
  protected BigInteger numberOfItems;
  @XmlElement(name = "ManifestItem", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
  protected List<ManifestItem> manifestItem;

  public BigInteger getNumberOfItems() {
    return this.numberOfItems;
  }

  public List<ManifestItem> getManifestItem() {
    return this.manifestItem;
  }

  public void setNumberOfItems(BigInteger numberOfItems) {
    this.numberOfItems = numberOfItems;
  }

  public void setManifestItem(List<ManifestItem> manifestItem) {
    this.manifestItem = manifestItem;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Manifest)) return false;
    Manifest other = (Manifest) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$numberOfItems = this.getNumberOfItems();
    Object other$numberOfItems = other.getNumberOfItems();
    if (this$numberOfItems == null ? other$numberOfItems != null : !this$numberOfItems.equals(other$numberOfItems)) return false;
    Object this$manifestItem = this.getManifestItem();
    Object other$manifestItem = other.getManifestItem();
    if (this$manifestItem == null ? other$manifestItem != null : !this$manifestItem.equals(other$manifestItem)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof Manifest;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $numberOfItems = this.getNumberOfItems();
    result = result * PRIME + ($numberOfItems == null ? 43 : $numberOfItems.hashCode());
    Object $manifestItem = this.getManifestItem();
    result = result * PRIME + ($manifestItem == null ? 43 : $manifestItem.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "Manifest(numberOfItems=" + this.getNumberOfItems() + ", manifestItem=" + this.getManifestItem() + ")";
  }

  public Manifest() {
  }

  public Manifest(BigInteger numberOfItems, List<ManifestItem> manifestItem) {
    this.numberOfItems = numberOfItems;
    this.manifestItem = manifestItem;
  }
}
