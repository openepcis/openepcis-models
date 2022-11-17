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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

/** A response as specified in [RFC 7807](https://tools.ietf.org/html/rfc7807) */
@XmlRootElement
@NoArgsConstructor
@XmlType(
    name = "ProblemResponseBody",
    factoryClass = ObjectFactory.class,
    factoryMethod = "createProblemResponseBody")
public class ProblemResponseBody {
  @JsonProperty("type")
  @XmlElement
  private String type = null;

  @JsonProperty("title")
  @XmlElement
  private String title = null;

  @JsonProperty("status")
  @XmlElement
  private Integer status = null;

  @JsonProperty("detail")
  @XmlElement
  private String detail = null;

  @JsonProperty("instance")
  @XmlElement
  private String instance = null;

  public ProblemResponseBody type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   *
   * @return type
   */
  @NotNull
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ProblemResponseBody title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   *
   * @return title
   */
  @NotNull
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ProblemResponseBody status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public ProblemResponseBody detail(String detail) {
    this.detail = detail;
    return this;
  }

  /**
   * Get detail
   *
   * @return detail
   */
  @NotNull
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public ProblemResponseBody instance(String instance) {
    this.instance = instance;
    return this;
  }

  /**
   * Get instance
   *
   * @return instance
   */
  public String getInstance() {
    return instance;
  }

  public void setInstance(String instance) {
    this.instance = instance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProblemResponseBody rfC7807ProblemResponseBody = (ProblemResponseBody) o;
    return Objects.equals(this.type, rfC7807ProblemResponseBody.type)
        && Objects.equals(this.title, rfC7807ProblemResponseBody.title)
        && Objects.equals(this.status, rfC7807ProblemResponseBody.status)
        && Objects.equals(this.detail, rfC7807ProblemResponseBody.detail)
        && Objects.equals(this.instance, rfC7807ProblemResponseBody.instance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, title, status, detail, instance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RFC7807ProblemResponseBody {\n");

    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
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
