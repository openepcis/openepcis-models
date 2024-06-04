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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CaptureStatusMessage {
  public enum Type {
    CAPTURED,
    VALID,
    INVALID,
    PROCESSED
  };

  Type type;
  protected int value;
  protected List<InvalidEPCISEventInfo> errors = new ArrayList<>();

  public static CaptureStatusMessage eventCapturedCount(int count) {
    return new CaptureStatusMessage(Type.CAPTURED, count, Collections.emptyList());
  }

  public static CaptureStatusMessage valid(int count) {
    return new CaptureStatusMessage(Type.VALID, count, Collections.emptyList());
  }

  public static CaptureStatusMessage invalid(int count, List<InvalidEPCISEventInfo> errors) {
    return new CaptureStatusMessage(Type.INVALID, count, errors);
  }

  public static CaptureStatusMessage processed(int count) {
    return new CaptureStatusMessage(Type.PROCESSED, count, Collections.emptyList());
  }
}
