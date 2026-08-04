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
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.NONE)
public class BizTransactionList implements Serializable {
  @XmlAttribute
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  private String type;
  @XmlValue
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  private String bizTransaction;


  public static class BizTransactionListBuilder {
    private String type;
    private String bizTransaction;

    BizTransactionListBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public BizTransactionList.BizTransactionListBuilder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public BizTransactionList.BizTransactionListBuilder bizTransaction(String bizTransaction) {
      this.bizTransaction = bizTransaction;
      return this;
    }

    public BizTransactionList build() {
      return new BizTransactionList(this.type, this.bizTransaction);
    }

    @Override
    public String toString() {
      return "BizTransactionList.BizTransactionListBuilder(type=" + this.type + ", bizTransaction=" + this.bizTransaction + ")";
    }
  }

  public static BizTransactionList.BizTransactionListBuilder builder() {
    return new BizTransactionList.BizTransactionListBuilder();
  }

  public String getType() {
    return this.type;
  }

  public String getBizTransaction() {
    return this.bizTransaction;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setBizTransaction(String bizTransaction) {
    this.bizTransaction = bizTransaction;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof BizTransactionList)) return false;
    BizTransactionList other = (BizTransactionList) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$type = this.getType();
    Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
    Object this$bizTransaction = this.getBizTransaction();
    Object other$bizTransaction = other.getBizTransaction();
    if (this$bizTransaction == null ? other$bizTransaction != null : !this$bizTransaction.equals(other$bizTransaction)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof BizTransactionList;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    Object $bizTransaction = this.getBizTransaction();
    result = result * PRIME + ($bizTransaction == null ? 43 : $bizTransaction.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "BizTransactionList(type=" + this.getType() + ", bizTransaction=" + this.getBizTransaction() + ")";
  }

  public BizTransactionList() {
  }

  public BizTransactionList(String type, String bizTransaction) {
    this.type = type;
    this.bizTransaction = bizTransaction;
  }
}
