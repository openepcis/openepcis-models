/*
 * Copyright 2022 benelog GmbH & Co. KG
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
package io.openepcis.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import java.util.UUID;
import javax.validation.Valid;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/** QuerySubscriptionMetaData */
public class QuerySubscriptionMetaData {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("callbacks")
  private EventCallbackUrls callbacks = null;

  @JsonProperty("createdAt")
  private DateTime createdAt = null;

  @JsonProperty("reportIfEmpty")
  private Boolean reportIfEmpty = null;

  @JsonProperty("initialRecordTime")
  private DateTime initialRecordTime = null;

  @JsonProperty("schedule")
  private String schedule = null;

  public QuerySubscriptionMetaData id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @Valid
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = UUID.randomUUID();
  }

  public QuerySubscriptionMetaData callbacks(EventCallbackUrls callbacks) {
    this.callbacks = callbacks;
    return this;
  }

  /**
   * Get callbacks
   *
   * @return callbacks
   */
  @Valid
  public EventCallbackUrls getCallbacks() {
    return callbacks;
  }

  public void setCallbacks(EventCallbackUrls callbacks) {
    this.callbacks = callbacks;
  }

  public QuerySubscriptionMetaData createdAt(DateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   *
   * @return createdAt
   */
  @Valid
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateTime createdAt) {
    DateTime now = new DateTime();
    DateTime dateTime = now.toDateTime(DateTimeZone.UTC);
    this.createdAt = createdAt != null ? createdAt : dateTime;
  }

  public Boolean getReportIfEmpty() {
    return reportIfEmpty;
  }

  public void setReportIfEmpty(Boolean reportIfEmpty) {
    this.reportIfEmpty = reportIfEmpty;
  }

  public DateTime getInitialRecordTime() {
    return initialRecordTime;
  }

  public void setInitialRecordTime(DateTime initialRecordTime) {
    this.initialRecordTime = initialRecordTime;
  }

  public String getSchedule() {
    return schedule;
  }

  public void setSchedule(String schedule) {
    this.schedule = schedule;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuerySubscriptionMetaData querySubscriptionMetaData = (QuerySubscriptionMetaData) o;
    return Objects.equals(this.id, querySubscriptionMetaData.id)
        && Objects.equals(this.callbacks, querySubscriptionMetaData.callbacks)
        && Objects.equals(this.createdAt, querySubscriptionMetaData.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, callbacks, createdAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuerySubscriptionMetaData {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    callbacks: ").append(toIndentedString(callbacks)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
