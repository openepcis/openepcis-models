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
@XmlType(name = "PartnerIdentification", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", propOrder = {"value"})
public class PartnerIdentification {
  @XmlValue
  protected String value;
  @XmlAttribute(name = "Authority")
  protected String authority;

  public String getValue() {
    return this.value;
  }

  public String getAuthority() {
    return this.authority;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof PartnerIdentification)) return false;
    PartnerIdentification other = (PartnerIdentification) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$value = this.getValue();
    Object other$value = other.getValue();
    if (this$value == null ? other$value != null : !this$value.equals(other$value)) return false;
    Object this$authority = this.getAuthority();
    Object other$authority = other.getAuthority();
    if (this$authority == null ? other$authority != null : !this$authority.equals(other$authority)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof PartnerIdentification;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $value = this.getValue();
    result = result * PRIME + ($value == null ? 43 : $value.hashCode());
    Object $authority = this.getAuthority();
    result = result * PRIME + ($authority == null ? 43 : $authority.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "PartnerIdentification(value=" + this.getValue() + ", authority=" + this.getAuthority() + ")";
  }

  public PartnerIdentification() {
  }

  public PartnerIdentification(String value, String authority) {
    this.value = value;
    this.authority = authority;
  }
}
