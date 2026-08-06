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

import static com.fasterxml.jackson.annotation.JsonFormat.Feature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE;
import static com.fasterxml.jackson.annotation.JsonFormat.Feature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.openepcis.model.epcis.modifier.CustomInstantAdapter;
import io.openepcis.model.epcis.modifier.OffsetDateTimeSerializer;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.beans.Transient;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(InvalidEPCISEventInfo.class)
public class CaptureData extends Tracer {
  @XmlAttribute(name = "captureID")
  protected String captureID;
  @XmlElement(name = "createdAt", required = true)
  @XmlJavaTypeAdapter(CustomInstantAdapter.class)
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  @JsonFormat(without = {ADJUST_DATES_TO_CONTEXT_TIME_ZONE, WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS})
  protected OffsetDateTime createdAt;
  @XmlElement(name = "finishedAt", required = true)
  @XmlJavaTypeAdapter(CustomInstantAdapter.class)
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  @JsonFormat(without = {ADJUST_DATES_TO_CONTEXT_TIME_ZONE, WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS})
  protected OffsetDateTime finishedAt;
  @XmlAttribute(name = "running")
  protected boolean running;
  @XmlAttribute(name = "success")
  protected boolean success;
  @XmlElement(name = "captureErrorBehaviour")
  protected String captureErrorBehaviour;
  @XmlElementWrapper(name = "errors")
  @XmlElement(name = "error")
  protected List<InvalidEPCISEventInfo> errors = new ArrayList<>();

  @Transient
  public boolean isProceed() {
    return "PROCEED".equalsIgnoreCase(getCaptureErrorBehaviour());
  }

  @Transient
  public boolean isRollback() {
    return "ROLLBACK".equalsIgnoreCase(getCaptureErrorBehaviour());
  }

  public String getCaptureID() {
    return this.captureID;
  }

  public OffsetDateTime getCreatedAt() {
    return this.createdAt;
  }

  public OffsetDateTime getFinishedAt() {
    return this.finishedAt;
  }

  public boolean isRunning() {
    return this.running;
  }

  public boolean isSuccess() {
    return this.success;
  }

  public String getCaptureErrorBehaviour() {
    return this.captureErrorBehaviour;
  }

  public List<InvalidEPCISEventInfo> getErrors() {
    return this.errors;
  }

  public void setCaptureID(String captureID) {
    this.captureID = captureID;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public void setFinishedAt(OffsetDateTime finishedAt) {
    this.finishedAt = finishedAt;
  }

  public void setRunning(boolean running) {
    this.running = running;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public void setCaptureErrorBehaviour(String captureErrorBehaviour) {
    this.captureErrorBehaviour = captureErrorBehaviour;
  }

  public void setErrors(List<InvalidEPCISEventInfo> errors) {
    this.errors = errors;
  }

  @Override
  public String toString() {
    return "CaptureData(captureID=" + this.getCaptureID() + ", createdAt=" + this.getCreatedAt() + ", finishedAt=" + this.getFinishedAt() + ", running=" + this.isRunning() + ", success=" + this.isSuccess() + ", captureErrorBehaviour=" + this.getCaptureErrorBehaviour() + ", errors=" + this.getErrors() + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof CaptureData)) return false;
    CaptureData other = (CaptureData) o;
    if (!other.canEqual((Object) this)) return false;
    if (this.isRunning() != other.isRunning()) return false;
    if (this.isSuccess() != other.isSuccess()) return false;
    Object this$captureID = this.getCaptureID();
    Object other$captureID = other.getCaptureID();
    if (this$captureID == null ? other$captureID != null : !this$captureID.equals(other$captureID)) return false;
    Object this$createdAt = this.getCreatedAt();
    Object other$createdAt = other.getCreatedAt();
    if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
    Object this$finishedAt = this.getFinishedAt();
    Object other$finishedAt = other.getFinishedAt();
    if (this$finishedAt == null ? other$finishedAt != null : !this$finishedAt.equals(other$finishedAt)) return false;
    Object this$captureErrorBehaviour = this.getCaptureErrorBehaviour();
    Object other$captureErrorBehaviour = other.getCaptureErrorBehaviour();
    if (this$captureErrorBehaviour == null ? other$captureErrorBehaviour != null : !this$captureErrorBehaviour.equals(other$captureErrorBehaviour)) return false;
    Object this$errors = this.getErrors();
    Object other$errors = other.getErrors();
    if (this$errors == null ? other$errors != null : !this$errors.equals(other$errors)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof CaptureData;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    result = result * PRIME + (this.isRunning() ? 79 : 97);
    result = result * PRIME + (this.isSuccess() ? 79 : 97);
    Object $captureID = this.getCaptureID();
    result = result * PRIME + ($captureID == null ? 43 : $captureID.hashCode());
    Object $createdAt = this.getCreatedAt();
    result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
    Object $finishedAt = this.getFinishedAt();
    result = result * PRIME + ($finishedAt == null ? 43 : $finishedAt.hashCode());
    Object $captureErrorBehaviour = this.getCaptureErrorBehaviour();
    result = result * PRIME + ($captureErrorBehaviour == null ? 43 : $captureErrorBehaviour.hashCode());
    Object $errors = this.getErrors();
    result = result * PRIME + ($errors == null ? 43 : $errors.hashCode());
    return result;
  }

  public CaptureData() {
  }

  public CaptureData(String captureID, OffsetDateTime createdAt, OffsetDateTime finishedAt, boolean running, boolean success, String captureErrorBehaviour, List<InvalidEPCISEventInfo> errors) {
    this.captureID = captureID;
    this.createdAt = createdAt;
    this.finishedAt = finishedAt;
    this.running = running;
    this.success = success;
    this.captureErrorBehaviour = captureErrorBehaviour;
    this.errors = errors;
  }
}
