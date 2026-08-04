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

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlType(name = "EpcisQueryResult", propOrder = {"subscriptionID", "queryName", "queryType", "resultsBody"})
@XmlAccessorType(XmlAccessType.FIELD)
public class EpcisQueryResult {
  @XmlElement
  private String subscriptionID;
  @XmlElement
  private String queryName;
  @XmlElement
  private String queryType;
  @XmlElement
  private QueryResultsBody resultsBody;


  public static class EpcisQueryResultBuilder {
    private String subscriptionID;
    private String queryName;
    private String queryType;
    private QueryResultsBody resultsBody;

    EpcisQueryResultBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public EpcisQueryResult.EpcisQueryResultBuilder subscriptionID(String subscriptionID) {
      this.subscriptionID = subscriptionID;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public EpcisQueryResult.EpcisQueryResultBuilder queryName(String queryName) {
      this.queryName = queryName;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public EpcisQueryResult.EpcisQueryResultBuilder queryType(String queryType) {
      this.queryType = queryType;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public EpcisQueryResult.EpcisQueryResultBuilder resultsBody(QueryResultsBody resultsBody) {
      this.resultsBody = resultsBody;
      return this;
    }

    public EpcisQueryResult build() {
      return new EpcisQueryResult(this.subscriptionID, this.queryName, this.queryType, this.resultsBody);
    }

    @Override
    public String toString() {
      return "EpcisQueryResult.EpcisQueryResultBuilder(subscriptionID=" + this.subscriptionID + ", queryName=" + this.queryName + ", queryType=" + this.queryType + ", resultsBody=" + this.resultsBody + ")";
    }
  }

  public static EpcisQueryResult.EpcisQueryResultBuilder builder() {
    return new EpcisQueryResult.EpcisQueryResultBuilder();
  }

  public String getSubscriptionID() {
    return this.subscriptionID;
  }

  public String getQueryName() {
    return this.queryName;
  }

  public String getQueryType() {
    return this.queryType;
  }

  public QueryResultsBody getResultsBody() {
    return this.resultsBody;
  }

  public void setSubscriptionID(String subscriptionID) {
    this.subscriptionID = subscriptionID;
  }

  public void setQueryName(String queryName) {
    this.queryName = queryName;
  }

  public void setQueryType(String queryType) {
    this.queryType = queryType;
  }

  public void setResultsBody(QueryResultsBody resultsBody) {
    this.resultsBody = resultsBody;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof EpcisQueryResult)) return false;
    EpcisQueryResult other = (EpcisQueryResult) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$subscriptionID = this.getSubscriptionID();
    Object other$subscriptionID = other.getSubscriptionID();
    if (this$subscriptionID == null ? other$subscriptionID != null : !this$subscriptionID.equals(other$subscriptionID)) return false;
    Object this$queryName = this.getQueryName();
    Object other$queryName = other.getQueryName();
    if (this$queryName == null ? other$queryName != null : !this$queryName.equals(other$queryName)) return false;
    Object this$queryType = this.getQueryType();
    Object other$queryType = other.getQueryType();
    if (this$queryType == null ? other$queryType != null : !this$queryType.equals(other$queryType)) return false;
    Object this$resultsBody = this.getResultsBody();
    Object other$resultsBody = other.getResultsBody();
    if (this$resultsBody == null ? other$resultsBody != null : !this$resultsBody.equals(other$resultsBody)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof EpcisQueryResult;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $subscriptionID = this.getSubscriptionID();
    result = result * PRIME + ($subscriptionID == null ? 43 : $subscriptionID.hashCode());
    Object $queryName = this.getQueryName();
    result = result * PRIME + ($queryName == null ? 43 : $queryName.hashCode());
    Object $queryType = this.getQueryType();
    result = result * PRIME + ($queryType == null ? 43 : $queryType.hashCode());
    Object $resultsBody = this.getResultsBody();
    result = result * PRIME + ($resultsBody == null ? 43 : $resultsBody.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "EpcisQueryResult(subscriptionID=" + this.getSubscriptionID() + ", queryName=" + this.getQueryName() + ", queryType=" + this.getQueryType() + ", resultsBody=" + this.getResultsBody() + ")";
  }

  public EpcisQueryResult() {
  }

  public EpcisQueryResult(String subscriptionID, String queryName, String queryType, QueryResultsBody resultsBody) {
    this.subscriptionID = subscriptionID;
    this.queryName = queryName;
    this.queryType = queryType;
    this.resultsBody = resultsBody;
  }
}
