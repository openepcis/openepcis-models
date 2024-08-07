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
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

public class ProblemResponseBodyForCapture {
  @JsonProperty("type")
  private String type = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("detail")
  private String detail = null;

  @JsonProperty("instance")
  private String instance = null;

  @JsonProperty("sequenceInEPCISDoc")
  private List<Integer> sequenceInEPCISDoc = null;

  public ProblemResponseBodyForCapture() {}

  public ProblemResponseBodyForCapture(
      String type, String title, Integer status, String detail, List<Integer> sequenceInEPCISDoc) {
    this.setType(type);
    this.setTitle(title);
    this.setStatus(status);
    this.setDetail(detail);
    this.setSequenceInEPCISDoc(sequenceInEPCISDoc);
  }

  public ProblemResponseBodyForCapture type(String type) {
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

  public ProblemResponseBodyForCapture title(String title) {
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

  public ProblemResponseBodyForCapture status(Integer status) {
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

  public ProblemResponseBodyForCapture detail(String detail) {
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

  public ProblemResponseBodyForCapture instance(String instance) {
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

  public ProblemResponseBodyForCapture sequenceInEPCISDoc(List<Integer> sequenceInEPCISDoc) {
    this.sequenceInEPCISDoc = sequenceInEPCISDoc;
    return this;
  }

  /**
   * Get sequenceInEPCISDoc
   *
   * @return sequenceInEPCISDoc
   */
  @NotNull
  public List<Integer> getSequenceInEPCISDoc() {
    return sequenceInEPCISDoc;
  }

  public void setSequenceInEPCISDoc(List<Integer> sequenceInEPCISDoc) {
    this.sequenceInEPCISDoc = sequenceInEPCISDoc;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProblemResponseBodyForCapture rfC7807ProblemResponseBodyForCapture =
        (ProblemResponseBodyForCapture) o;
    return Objects.equals(this.type, rfC7807ProblemResponseBodyForCapture.type)
        && Objects.equals(this.title, rfC7807ProblemResponseBodyForCapture.title)
        && Objects.equals(this.status, rfC7807ProblemResponseBodyForCapture.status)
        && Objects.equals(this.detail, rfC7807ProblemResponseBodyForCapture.detail)
        && Objects.equals(this.instance, rfC7807ProblemResponseBodyForCapture.instance)
        && Objects.equals(
            this.sequenceInEPCISDoc, rfC7807ProblemResponseBodyForCapture.sequenceInEPCISDoc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, title, status, detail, instance, sequenceInEPCISDoc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RFC7807ProblemResponseBodyForCapture {\n");

    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
    sb.append("    sequenceInEPCISDoc: ").append(toIndentedString(sequenceInEPCISDoc)).append("\n");
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
