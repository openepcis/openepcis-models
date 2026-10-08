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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.openepcis.model.rest.ProblemResponseBodyForCapture;
import jakarta.xml.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@XmlType(
    name = "InvalidEPCISEventInfo",
    factoryClass = ObjectFactory.class,
    factoryMethod = "createInvalidEPCISEventInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class InvalidEPCISEventInfo {
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

  @JsonProperty("sequenceInEPCISDoc")
  @XmlElement
  private List<Integer> sequenceInEPCISDoc = null;

  /**
   * HARD_ERROR keeps the event out of the repository; SOFT_ERROR is reported while the event is
   * stored. Absent means HARD_ERROR, as every entry was before severities.
   */
  @JsonProperty("severity")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @XmlElement
  private Severity severity = null;

  /** Where the entry points; supersedes {@code sequenceInEPCISDoc}, which stays for older clients. */
  @JsonProperty("eventLocationsInEPCISDocument")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @XmlElement
  private List<EventLocationInEPCISDocument> eventLocationsInEPCISDocument = null;

  /** Severity of a validation entry, as in the SmartHub Connect API. */
  public enum Severity {
    SOFT_ERROR,
    HARD_ERROR
  }

  public InvalidEPCISEventInfo() {}

  public InvalidEPCISEventInfo(
      String type, String title, Integer status, String detail, List<Integer> sequenceInEPCISDoc) {
    this(type, title, status, detail);
    this.setSequenceInEPCISDoc(sequenceInEPCISDoc);
  }

  public InvalidEPCISEventInfo(String type, String title, Integer status, String detail) {
    this.setType(type);
    this.setTitle(title);
    this.setStatus(status);
    this.setDetail(detail);
  }

  public InvalidEPCISEventInfo type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   *
   * @return type
   */
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public InvalidEPCISEventInfo title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   *
   * @return title
   */
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public InvalidEPCISEventInfo status(Integer status) {
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

  public InvalidEPCISEventInfo detail(String detail) {
    this.detail = detail;
    return this;
  }

  /**
   * Get detail
   *
   * @return detail
   */
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public InvalidEPCISEventInfo instance(String instance) {
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

  public InvalidEPCISEventInfo sequenceInEPCISDoc(List<Integer> sequenceInEPCISDoc) {
    this.sequenceInEPCISDoc = sequenceInEPCISDoc;
    return this;
  }

  /**
   * Get sequenceInEPCISDoc
   *
   * @return sequenceInEPCISDoc
   */
  public List<Integer> getSequenceInEPCISDoc() {
    return sequenceInEPCISDoc;
  }

  public void setSequenceInEPCISDoc(List<Integer> sequenceInEPCISDoc) {
    this.sequenceInEPCISDoc = sequenceInEPCISDoc;
  }

  public InvalidEPCISEventInfo severity(Severity severity) {
    this.severity = severity;
    return this;
  }

  public Severity getSeverity() {
    return severity;
  }

  public void setSeverity(Severity severity) {
    this.severity = severity;
  }

  public InvalidEPCISEventInfo eventLocationsInEPCISDocument(
      List<EventLocationInEPCISDocument> eventLocationsInEPCISDocument) {
    this.eventLocationsInEPCISDocument = eventLocationsInEPCISDocument;
    return this;
  }

  public List<EventLocationInEPCISDocument> getEventLocationsInEPCISDocument() {
    return eventLocationsInEPCISDocument;
  }

  public void setEventLocationsInEPCISDocument(
      List<EventLocationInEPCISDocument> eventLocationsInEPCISDocument) {
    this.eventLocationsInEPCISDocument = eventLocationsInEPCISDocument;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvalidEPCISEventInfo invalidEPCISEventInfo = (InvalidEPCISEventInfo) o;
    return Objects.equals(this.type, invalidEPCISEventInfo.type)
        && Objects.equals(this.title, invalidEPCISEventInfo.title)
        && Objects.equals(this.status, invalidEPCISEventInfo.status)
        && Objects.equals(this.detail, invalidEPCISEventInfo.detail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, title, status, detail);
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
    if (severity != null) {
      sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
    }
    if (eventLocationsInEPCISDocument != null) {
      sb.append("    eventLocationsInEPCISDocument: ")
          .append(toIndentedString(eventLocationsInEPCISDocument))
          .append("\n");
    }
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

  public ProblemResponseBodyForCapture toProblemResponseBodyForCapture() {
    return new ProblemResponseBodyForCapture(
        getType(), getTitle(), getStatus(), getDetail(), getSequenceInEPCISDoc());
  }
}
