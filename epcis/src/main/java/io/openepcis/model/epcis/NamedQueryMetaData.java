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
package io.openepcis.model.epcis;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** NamedQueryMetaData */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NamedQueryMetaData {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("deleted")
  private Boolean deleted;

  @JsonProperty("createdAt")
  private OffsetDateTime createdAt = null;

  @JsonProperty("query")
  private Map<String, Object> epcisQuery = null;

  public NamedQueryMetaData name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public NamedQueryMetaData createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   *
   * @return createdAt
   */
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt != null ? createdAt : OffsetDateTime.now();
  }

  public NamedQueryMetaData epcisQuery(Map<String, Object> epcisQuery) {
    this.epcisQuery = epcisQuery;
    return this;
  }

  /**
   * Get epcisQuery
   *
   * @return epcisQuery
   */
  public Map<String, Object> getEpcisQuery() {
    return epcisQuery;
  }

  public void setEpcisQuery(Map<String, Object> epcisQuery) {
    this.epcisQuery = epcisQuery;
  }

  /**
   * Get activeSubscriptions
   *
   * @return activeSubscriptions
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NamedQueryMetaData namedQueryMetaData = (NamedQueryMetaData) o;
    return Objects.equals(this.name, namedQueryMetaData.name)
        && Objects.equals(this.createdAt, namedQueryMetaData.createdAt)
        && Objects.equals(this.epcisQuery, namedQueryMetaData.epcisQuery);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, createdAt, epcisQuery);
  }

  @Override
  public String toString() {
    return "class NamedQueryMetaData {\n"
        + "    name: "
        + toIndentedString(name)
        + "\n"
        + "    createdAt: "
        + toIndentedString(createdAt)
        + "\n"
        + "    epcisQuery: "
        + toIndentedString(epcisQuery)
        + "\n"
        + "}";
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
