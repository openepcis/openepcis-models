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
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuerySubscriptionResults extends PaginationSupport {
  @JsonProperty("querySubscriptions")
  private List<QuerySubscription> querySubscriptions;

  public QuerySubscriptionResults() {
  }

  public List<QuerySubscription> getQuerySubscriptions() {
    return this.querySubscriptions;
  }

  public void setQuerySubscriptions(List<QuerySubscription> querySubscriptions) {
    this.querySubscriptions = querySubscriptions;
  }

  @Override
  public String toString() {
    return "QuerySubscriptionResults(querySubscriptions=" + this.getQuerySubscriptions() + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof QuerySubscriptionResults)) return false;
    QuerySubscriptionResults other = (QuerySubscriptionResults) o;
    if (!other.canEqual((Object) this)) return false;
    if (!super.equals(o)) return false;
    Object this$querySubscriptions = this.getQuerySubscriptions();
    Object other$querySubscriptions = other.getQuerySubscriptions();
    if (this$querySubscriptions == null ? other$querySubscriptions != null : !this$querySubscriptions.equals(other$querySubscriptions)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof QuerySubscriptionResults;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = super.hashCode();
    Object $querySubscriptions = this.getQuerySubscriptions();
    result = result * PRIME + ($querySubscriptions == null ? 43 : $querySubscriptions.hashCode());
    return result;
  }
}
