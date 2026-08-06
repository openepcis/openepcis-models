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
package io.openepcis.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.openepcis.core.model.PaginationSupport;
import io.openepcis.model.epcis.NamedQueryMetaData;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NamedQueryMetaDataResult extends PaginationSupport {
  @JsonProperty("namedQueryMetaData")
  private List<NamedQueryMetaData> namedQueryMetaDataList;

  public NamedQueryMetaDataResult() {
  }

  public List<NamedQueryMetaData> getNamedQueryMetaDataList() {
    return this.namedQueryMetaDataList;
  }

  public void setNamedQueryMetaDataList(List<NamedQueryMetaData> namedQueryMetaDataList) {
    this.namedQueryMetaDataList = namedQueryMetaDataList;
  }

  @Override
  public String toString() {
    return "NamedQueryMetaDataResult(namedQueryMetaDataList=" + this.getNamedQueryMetaDataList() + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof NamedQueryMetaDataResult)) return false;
    NamedQueryMetaDataResult other = (NamedQueryMetaDataResult) o;
    if (!other.canEqual((Object) this)) return false;
    if (!super.equals(o)) return false;
    Object this$namedQueryMetaDataList = this.getNamedQueryMetaDataList();
    Object other$namedQueryMetaDataList = other.getNamedQueryMetaDataList();
    if (this$namedQueryMetaDataList == null ? other$namedQueryMetaDataList != null : !this$namedQueryMetaDataList.equals(other$namedQueryMetaDataList)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof NamedQueryMetaDataResult;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = super.hashCode();
    Object $namedQueryMetaDataList = this.getNamedQueryMetaDataList();
    result = result * PRIME + ($namedQueryMetaDataList == null ? 43 : $namedQueryMetaDataList.hashCode());
    return result;
  }
}
