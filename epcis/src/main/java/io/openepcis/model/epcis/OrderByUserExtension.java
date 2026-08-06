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

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderByUserExtension {
  private String path;
  private String extendedKey;
  private String nestedPath;
  private String dataType;

  public void setDataType(String dataType) {
    this.dataType = dataType + "Value";
  }

  @Override
  public String toString() {
    return "OrderByUserExtension(super=" + super.toString() + ", path=" + this.getPath() + ", extendedKey=" + this.getExtendedKey() + ", nestedPath=" + this.getNestedPath() + ", dataType=" + this.getDataType() + ")";
  }

  public String getPath() {
    return this.path;
  }

  public String getExtendedKey() {
    return this.extendedKey;
  }

  public String getNestedPath() {
    return this.nestedPath;
  }

  public String getDataType() {
    return this.dataType;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public void setExtendedKey(String extendedKey) {
    this.extendedKey = extendedKey;
  }

  public void setNestedPath(String nestedPath) {
    this.nestedPath = nestedPath;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof OrderByUserExtension)) return false;
    OrderByUserExtension other = (OrderByUserExtension) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$path = this.getPath();
    Object other$path = other.getPath();
    if (this$path == null ? other$path != null : !this$path.equals(other$path)) return false;
    Object this$extendedKey = this.getExtendedKey();
    Object other$extendedKey = other.getExtendedKey();
    if (this$extendedKey == null ? other$extendedKey != null : !this$extendedKey.equals(other$extendedKey)) return false;
    Object this$nestedPath = this.getNestedPath();
    Object other$nestedPath = other.getNestedPath();
    if (this$nestedPath == null ? other$nestedPath != null : !this$nestedPath.equals(other$nestedPath)) return false;
    Object this$dataType = this.getDataType();
    Object other$dataType = other.getDataType();
    if (this$dataType == null ? other$dataType != null : !this$dataType.equals(other$dataType)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof OrderByUserExtension;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $path = this.getPath();
    result = result * PRIME + ($path == null ? 43 : $path.hashCode());
    Object $extendedKey = this.getExtendedKey();
    result = result * PRIME + ($extendedKey == null ? 43 : $extendedKey.hashCode());
    Object $nestedPath = this.getNestedPath();
    result = result * PRIME + ($nestedPath == null ? 43 : $nestedPath.hashCode());
    Object $dataType = this.getDataType();
    result = result * PRIME + ($dataType == null ? 43 : $dataType.hashCode());
    return result;
  }

  public OrderByUserExtension() {
  }
}
