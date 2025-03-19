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
package io.openepcis.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CaptureStatusMessage extends Tracer {

  public enum Type {
    CAPTURED,
    VALID,
    INVALID,
    PROCESSED
  };

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

  public static CaptureStatusMessage invalid(
      int count, List<InvalidEPCISEventInfo> errors, Map<String, Object> metadata) {
    return new CaptureStatusMessage(Type.INVALID, count, errors, metadata);
  }

  public static CaptureStatusMessage processed(int count, Map<String, Object> metadata) {
    return new CaptureStatusMessage(Type.PROCESSED, count, Collections.emptyList(), metadata);
  }
}
