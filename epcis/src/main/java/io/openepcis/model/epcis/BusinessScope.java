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
@XmlType(name = "BusinessScope", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", propOrder = {"scope"})
public class BusinessScope {
  @XmlElement(name = "Scope", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected List<Scope> scope;

  public List<Scope> getScope() {
    return this.scope;
  }

  public void setScope(List<Scope> scope) {
    this.scope = scope;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof BusinessScope)) return false;
    BusinessScope other = (BusinessScope) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$scope = this.getScope();
    Object other$scope = other.getScope();
    if (this$scope == null ? other$scope != null : !this$scope.equals(other$scope)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof BusinessScope;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $scope = this.getScope();
    result = result * PRIME + ($scope == null ? 43 : $scope.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "BusinessScope(scope=" + this.getScope() + ")";
  }

  public BusinessScope() {
  }

  public BusinessScope(List<Scope> scope) {
    this.scope = scope;
  }
}
