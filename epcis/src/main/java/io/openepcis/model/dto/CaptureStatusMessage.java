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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CaptureStatusMessage extends Tracer {

  public enum Type {
    CAPTURED, VALID, INVALID, PROCESSED;
  }

  Type type;
  protected int value;
  protected List<InvalidEPCISEventInfo> errors = new ArrayList<>();
  private Map<String, Object> metadata;

  public static CaptureStatusMessage eventCapturedCount(int count, Map<String, Object> metadata) {
    return new CaptureStatusMessage(Type.CAPTURED, count, Collections.emptyList(), metadata);
  }

  public static CaptureStatusMessage valid(int count, Map<String, Object> metadata) {
    return new CaptureStatusMessage(Type.VALID, count, Collections.emptyList(), metadata);
  }

  public static CaptureStatusMessage invalid(int count, List<InvalidEPCISEventInfo> errors, Map<String, Object> metadata) {
    return new CaptureStatusMessage(Type.INVALID, count, errors, metadata);
  }

  public static CaptureStatusMessage processed(int count, Map<String, Object> metadata) {
    return new CaptureStatusMessage(Type.PROCESSED, count, Collections.emptyList(), metadata);
  }

  public Type getType() {
    return this.type;
  }

  public int getValue() {
    return this.value;
  }

  public List<InvalidEPCISEventInfo> getErrors() {
    return this.errors;
  }

  public Map<String, Object> getMetadata() {
    return this.metadata;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public void setErrors(List<InvalidEPCISEventInfo> errors) {
    this.errors = errors;
  }

  public void setMetadata(Map<String, Object> metadata) {
    this.metadata = metadata;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof CaptureStatusMessage)) return false;
    CaptureStatusMessage other = (CaptureStatusMessage) o;
    if (!other.canEqual((Object) this)) return false;
    if (this.getValue() != other.getValue()) return false;
    Object this$type = this.getType();
    Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
    Object this$errors = this.getErrors();
    Object other$errors = other.getErrors();
    if (this$errors == null ? other$errors != null : !this$errors.equals(other$errors)) return false;
    Object this$metadata = this.getMetadata();
    Object other$metadata = other.getMetadata();
    if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof CaptureStatusMessage;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    result = result * PRIME + this.getValue();
    Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    Object $errors = this.getErrors();
    result = result * PRIME + ($errors == null ? 43 : $errors.hashCode());
    Object $metadata = this.getMetadata();
    result = result * PRIME + ($metadata == null ? 43 : $metadata.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "CaptureStatusMessage(type=" + this.getType() + ", value=" + this.getValue() + ", errors=" + this.getErrors() + ", metadata=" + this.getMetadata() + ")";
  }

  public CaptureStatusMessage() {
  }

  public CaptureStatusMessage(Type type, int value, List<InvalidEPCISEventInfo> errors, Map<String, Object> metadata) {
    this.type = type;
    this.value = value;
    this.errors = errors;
    this.metadata = metadata;
  }
}
