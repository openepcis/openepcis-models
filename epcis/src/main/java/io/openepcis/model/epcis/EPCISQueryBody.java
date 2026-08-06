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
@XmlRootElement(name = "EPCISBody")
@XmlType(name = "EPCISQueryBodyType", propOrder = {"queryResults"})
@XmlAccessorType(XmlAccessType.FIELD)
public class EPCISQueryBody {
  @XmlElement(name = "QueryResults")
  private EpcisQueryResult queryResults;

  public EPCISQueryBody(EpcisQueryResult queryResults) {
    this.queryResults = queryResults;
  }

  public EpcisQueryResult getQueryResults() {
    return this.queryResults;
  }

  public void setQueryResults(EpcisQueryResult queryResults) {
    this.queryResults = queryResults;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof EPCISQueryBody)) return false;
    EPCISQueryBody other = (EPCISQueryBody) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$queryResults = this.getQueryResults();
    Object other$queryResults = other.getQueryResults();
    if (this$queryResults == null ? other$queryResults != null : !this$queryResults.equals(other$queryResults)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof EPCISQueryBody;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $queryResults = this.getQueryResults();
    result = result * PRIME + ($queryResults == null ? 43 : $queryResults.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "EPCISQueryBody(queryResults=" + this.getQueryResults() + ")";
  }

  public EPCISQueryBody() {
  }
}
