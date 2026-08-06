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
import io.openepcis.model.epcis.EpcisQueryResult;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueryResult extends PaginationSupport {
  @JsonProperty("queryResults")
  private EpcisQueryResult queryResults;

  public QueryResult() {
  }

  public EpcisQueryResult getQueryResults() {
    return this.queryResults;
  }

  public void setQueryResults(EpcisQueryResult queryResults) {
    this.queryResults = queryResults;
  }

  @Override
  public String toString() {
    return "QueryResult(queryResults=" + this.getQueryResults() + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof QueryResult)) return false;
    QueryResult other = (QueryResult) o;
    if (!other.canEqual((Object) this)) return false;
    if (!super.equals(o)) return false;
    Object this$queryResults = this.getQueryResults();
    Object other$queryResults = other.getQueryResults();
    if (this$queryResults == null ? other$queryResults != null : !this$queryResults.equals(other$queryResults)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof QueryResult;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = super.hashCode();
    Object $queryResults = this.getQueryResults();
    result = result * PRIME + ($queryResults == null ? 43 : $queryResults.hashCode());
    return result;
  }
}
