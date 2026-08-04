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
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuantityList implements Serializable {
  private String epcClass;
  private Float quantity;
  private String uom;


  public static class QuantityListBuilder {
    private String epcClass;
    private Float quantity;
    private String uom;

    QuantityListBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public QuantityList.QuantityListBuilder epcClass(String epcClass) {
      this.epcClass = epcClass;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public QuantityList.QuantityListBuilder quantity(Float quantity) {
      this.quantity = quantity;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public QuantityList.QuantityListBuilder uom(String uom) {
      this.uom = uom;
      return this;
    }

    public QuantityList build() {
      return new QuantityList(this.epcClass, this.quantity, this.uom);
    }

    @Override
    public String toString() {
      return "QuantityList.QuantityListBuilder(epcClass=" + this.epcClass + ", quantity=" + this.quantity + ", uom=" + this.uom + ")";
    }
  }

  public static QuantityList.QuantityListBuilder builder() {
    return new QuantityList.QuantityListBuilder();
  }

  public String getEpcClass() {
    return this.epcClass;
  }

  public Float getQuantity() {
    return this.quantity;
  }

  public String getUom() {
    return this.uom;
  }

  public void setEpcClass(String epcClass) {
    this.epcClass = epcClass;
  }

  public void setQuantity(Float quantity) {
    this.quantity = quantity;
  }

  public void setUom(String uom) {
    this.uom = uom;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof QuantityList)) return false;
    QuantityList other = (QuantityList) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$quantity = this.getQuantity();
    Object other$quantity = other.getQuantity();
    if (this$quantity == null ? other$quantity != null : !this$quantity.equals(other$quantity)) return false;
    Object this$epcClass = this.getEpcClass();
    Object other$epcClass = other.getEpcClass();
    if (this$epcClass == null ? other$epcClass != null : !this$epcClass.equals(other$epcClass)) return false;
    Object this$uom = this.getUom();
    Object other$uom = other.getUom();
    if (this$uom == null ? other$uom != null : !this$uom.equals(other$uom)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof QuantityList;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $quantity = this.getQuantity();
    result = result * PRIME + ($quantity == null ? 43 : $quantity.hashCode());
    Object $epcClass = this.getEpcClass();
    result = result * PRIME + ($epcClass == null ? 43 : $epcClass.hashCode());
    Object $uom = this.getUom();
    result = result * PRIME + ($uom == null ? 43 : $uom.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "QuantityList(epcClass=" + this.getEpcClass() + ", quantity=" + this.getQuantity() + ", uom=" + this.getUom() + ")";
  }

  public QuantityList() {
  }

  public QuantityList(String epcClass, Float quantity, String uom) {
    this.epcClass = epcClass;
    this.quantity = quantity;
    this.uom = uom;
  }
}
