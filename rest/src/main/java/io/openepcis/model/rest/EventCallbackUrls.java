/*
 * Copyright 2022-2024 benelog GmbH & Co. KG
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

/** A subscription that listens for events that match a query rule */
public class EventCallbackUrls {
  @JsonProperty("eventUrl")
  private String eventUrl = null;

  public EventCallbackUrls eventUrl(String eventUrl) {
    this.eventUrl = eventUrl;
    return this;
  }

  /**
   * Get eventUrl
   *
   * @return eventUrl
   */
  public String getEventUrl() {
    return eventUrl;
  }

  public void setEventUrl(String eventUrl) {
    this.eventUrl = eventUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventCallbackUrls eventCallbackUrls = (EventCallbackUrls) o;
    return Objects.equals(this.eventUrl, eventCallbackUrls.eventUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventCallbackUrls {\n");

    sb.append("    eventUrl: ").append(toIndentedString(eventUrl)).append("\n");
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
