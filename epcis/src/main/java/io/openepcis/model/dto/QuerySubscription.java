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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.openepcis.model.epcis.Schedule;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuerySubscription {
  private UUID subscriptionID;
  private String queryName;
  private URI dest;
  private String signatureToken;
  private OffsetDateTime initialRecordTime;
  private Boolean reportIfEmpty;
  private Boolean stream;
  private Schedule schedule;
  private OffsetDateTime createdAt;

  public UUID getSubscriptionID() {
    return this.subscriptionID;
  }

  public String getQueryName() {
    return this.queryName;
  }

  public URI getDest() {
    return this.dest;
  }

  public String getSignatureToken() {
    return this.signatureToken;
  }

  public OffsetDateTime getInitialRecordTime() {
    return this.initialRecordTime;
  }

  public Boolean getReportIfEmpty() {
    return this.reportIfEmpty;
  }

  public Boolean getStream() {
    return this.stream;
  }

  public Schedule getSchedule() {
    return this.schedule;
  }

  public OffsetDateTime getCreatedAt() {
    return this.createdAt;
  }

  public void setSubscriptionID(UUID subscriptionID) {
    this.subscriptionID = subscriptionID;
  }

  public void setQueryName(String queryName) {
    this.queryName = queryName;
  }

  public void setDest(URI dest) {
    this.dest = dest;
  }

  public void setSignatureToken(String signatureToken) {
    this.signatureToken = signatureToken;
  }

  public void setInitialRecordTime(OffsetDateTime initialRecordTime) {
    this.initialRecordTime = initialRecordTime;
  }

  public void setReportIfEmpty(Boolean reportIfEmpty) {
    this.reportIfEmpty = reportIfEmpty;
  }

  public void setStream(Boolean stream) {
    this.stream = stream;
  }

  public void setSchedule(Schedule schedule) {
    this.schedule = schedule;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof QuerySubscription)) return false;
    QuerySubscription other = (QuerySubscription) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$reportIfEmpty = this.getReportIfEmpty();
    Object other$reportIfEmpty = other.getReportIfEmpty();
    if (this$reportIfEmpty == null ? other$reportIfEmpty != null : !this$reportIfEmpty.equals(other$reportIfEmpty)) return false;
    Object this$stream = this.getStream();
    Object other$stream = other.getStream();
    if (this$stream == null ? other$stream != null : !this$stream.equals(other$stream)) return false;
    Object this$subscriptionID = this.getSubscriptionID();
    Object other$subscriptionID = other.getSubscriptionID();
    if (this$subscriptionID == null ? other$subscriptionID != null : !this$subscriptionID.equals(other$subscriptionID)) return false;
    Object this$queryName = this.getQueryName();
    Object other$queryName = other.getQueryName();
    if (this$queryName == null ? other$queryName != null : !this$queryName.equals(other$queryName)) return false;
    Object this$dest = this.getDest();
    Object other$dest = other.getDest();
    if (this$dest == null ? other$dest != null : !this$dest.equals(other$dest)) return false;
    Object this$signatureToken = this.getSignatureToken();
    Object other$signatureToken = other.getSignatureToken();
    if (this$signatureToken == null ? other$signatureToken != null : !this$signatureToken.equals(other$signatureToken)) return false;
    Object this$initialRecordTime = this.getInitialRecordTime();
    Object other$initialRecordTime = other.getInitialRecordTime();
    if (this$initialRecordTime == null ? other$initialRecordTime != null : !this$initialRecordTime.equals(other$initialRecordTime)) return false;
    Object this$schedule = this.getSchedule();
    Object other$schedule = other.getSchedule();
    if (this$schedule == null ? other$schedule != null : !this$schedule.equals(other$schedule)) return false;
    Object this$createdAt = this.getCreatedAt();
    Object other$createdAt = other.getCreatedAt();
    if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof QuerySubscription;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $reportIfEmpty = this.getReportIfEmpty();
    result = result * PRIME + ($reportIfEmpty == null ? 43 : $reportIfEmpty.hashCode());
    Object $stream = this.getStream();
    result = result * PRIME + ($stream == null ? 43 : $stream.hashCode());
    Object $subscriptionID = this.getSubscriptionID();
    result = result * PRIME + ($subscriptionID == null ? 43 : $subscriptionID.hashCode());
    Object $queryName = this.getQueryName();
    result = result * PRIME + ($queryName == null ? 43 : $queryName.hashCode());
    Object $dest = this.getDest();
    result = result * PRIME + ($dest == null ? 43 : $dest.hashCode());
    Object $signatureToken = this.getSignatureToken();
    result = result * PRIME + ($signatureToken == null ? 43 : $signatureToken.hashCode());
    Object $initialRecordTime = this.getInitialRecordTime();
    result = result * PRIME + ($initialRecordTime == null ? 43 : $initialRecordTime.hashCode());
    Object $schedule = this.getSchedule();
    result = result * PRIME + ($schedule == null ? 43 : $schedule.hashCode());
    Object $createdAt = this.getCreatedAt();
    result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "QuerySubscription(subscriptionID=" + this.getSubscriptionID() + ", queryName=" + this.getQueryName() + ", dest=" + this.getDest() + ", signatureToken=" + this.getSignatureToken() + ", initialRecordTime=" + this.getInitialRecordTime() + ", reportIfEmpty=" + this.getReportIfEmpty() + ", stream=" + this.getStream() + ", schedule=" + this.getSchedule() + ", createdAt=" + this.getCreatedAt() + ")";
  }

  public QuerySubscription() {
  }

  public QuerySubscription(UUID subscriptionID, String queryName, URI dest, String signatureToken, OffsetDateTime initialRecordTime, Boolean reportIfEmpty, Boolean stream, Schedule schedule, OffsetDateTime createdAt) {
    this.subscriptionID = subscriptionID;
    this.queryName = queryName;
    this.dest = dest;
    this.signatureToken = signatureToken;
    this.initialRecordTime = initialRecordTime;
    this.reportIfEmpty = reportIfEmpty;
    this.stream = stream;
    this.schedule = schedule;
    this.createdAt = createdAt;
  }
}
