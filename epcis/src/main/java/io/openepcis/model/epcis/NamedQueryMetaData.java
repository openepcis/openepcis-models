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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * NamedQueryMetaData
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
// Older clients still send epcisVersion, which this model carried until the version of the
// documents a subscriber receives moved to the subscription that delivers them. Such a body is
// read without it rather than refused, so a tool that has not been updated keeps working. Nothing
// else unknown is tolerated: a misspelt field is still an error, which is how it should be.
@JsonIgnoreProperties({"epcisVersion"})
public class NamedQueryMetaData {
  @JsonProperty("name")
  private String name;
  @JsonProperty("createdAt")
  private OffsetDateTime createdAt;
  @JsonProperty("query")
  private Map<String, Object> epcisQuery;

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
    return Objects.equals(this.name, namedQueryMetaData.name) && Objects.equals(this.createdAt, namedQueryMetaData.createdAt) && Objects.equals(this.epcisQuery, namedQueryMetaData.epcisQuery);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, createdAt, epcisQuery);
  }

  @Override
  public String toString() {
    return "class NamedQueryMetaData {\n" + "    name: " + toIndentedString(name) + "\n" + "    createdAt: " + toIndentedString(createdAt) + "\n" + "    epcisQuery: " + toIndentedString(epcisQuery) + "\n" + "}";
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

  private static String $default$name() {
    return null;
  }

  private static OffsetDateTime $default$createdAt() {
    return null;
  }

  private static Map<String, Object> $default$epcisQuery() {
    return null;
  }

  public static class NamedQueryMetaDataBuilder {
    private boolean name$set;
    private String name$value;
    private boolean createdAt$set;
    private OffsetDateTime createdAt$value;
    private boolean epcisQuery$set;
    private Map<String, Object> epcisQuery$value;

    NamedQueryMetaDataBuilder() {
    }

    /**
     * @return {@code this}.
     */
    @JsonProperty("name")
    public NamedQueryMetaData.NamedQueryMetaDataBuilder name(String name) {
      this.name$value = name;
      name$set = true;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonProperty("createdAt")
    public NamedQueryMetaData.NamedQueryMetaDataBuilder createdAt(OffsetDateTime createdAt) {
      this.createdAt$value = createdAt;
      createdAt$set = true;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonProperty("query")
    public NamedQueryMetaData.NamedQueryMetaDataBuilder epcisQuery(Map<String, Object> epcisQuery) {
      this.epcisQuery$value = epcisQuery;
      epcisQuery$set = true;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public NamedQueryMetaData build() {
      String name$value = this.name$value;
      if (!this.name$set) name$value = NamedQueryMetaData.$default$name();
      OffsetDateTime createdAt$value = this.createdAt$value;
      if (!this.createdAt$set) createdAt$value = NamedQueryMetaData.$default$createdAt();
      Map<String, Object> epcisQuery$value = this.epcisQuery$value;
      if (!this.epcisQuery$set) epcisQuery$value = NamedQueryMetaData.$default$epcisQuery();
      return new NamedQueryMetaData(name$value, createdAt$value, epcisQuery$value);
    }

    @Override
    public String toString() {
      return "NamedQueryMetaData.NamedQueryMetaDataBuilder(name$value=" + this.name$value + ", createdAt$value=" + this.createdAt$value + ", epcisQuery$value=" + this.epcisQuery$value + ")";
    }
  }

  public static NamedQueryMetaData.NamedQueryMetaDataBuilder builder() {
    return new NamedQueryMetaData.NamedQueryMetaDataBuilder();
  }

  public NamedQueryMetaData() {
    this.name = NamedQueryMetaData.$default$name();
    this.createdAt = NamedQueryMetaData.$default$createdAt();
    this.epcisQuery = NamedQueryMetaData.$default$epcisQuery();
  }

  public NamedQueryMetaData(String name, OffsetDateTime createdAt, Map<String, Object> epcisQuery) {
    this.name = name;
    this.createdAt = createdAt;
    this.epcisQuery = epcisQuery;
  }
}
