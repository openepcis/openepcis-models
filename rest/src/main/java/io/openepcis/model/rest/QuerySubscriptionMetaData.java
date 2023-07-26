/*
 * Copyright 2022-2023 benelog GmbH & Co. KG
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
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

/** QuerySubscriptionMetaData */
public class QuerySubscriptionMetaData {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("callbacks")
  private EventCallbackUrls callbacks = null;

  @JsonProperty("createdAt")
  private OffsetDateTime createdAt = null;

  @JsonProperty("reportIfEmpty")
  private Boolean reportIfEmpty = null;

  @JsonProperty("initialRecordTime")
  private OffsetDateTime initialRecordTime = null;

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

  public QuerySubscriptionMetaData createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   *
   * @return createdAt
   */
  @Valid
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt != null ? createdAt : OffsetDateTime.now();
  }

  public Boolean getReportIfEmpty() {
    return reportIfEmpty;
  }

  public void setReportIfEmpty(Boolean reportIfEmpty) {
    this.reportIfEmpty = reportIfEmpty;
  }

  public OffsetDateTime getInitialRecordTime() {
    return initialRecordTime;
  }

  public void setInitialRecordTime(OffsetDateTime initialRecordTime) {
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
