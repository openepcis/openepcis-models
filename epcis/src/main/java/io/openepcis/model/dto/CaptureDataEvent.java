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
package io.openepcis.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.quarkus.runtime.annotations.RegisterForReflection;
import java.beans.Transient;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@RegisterForReflection
public class CaptureDataEvent {
  protected String captureID;
  protected OffsetDateTime createdAt;
  protected OffsetDateTime finishedAt;
  protected boolean running;
  protected boolean success;
  protected String captureErrorBehaviour;
  protected List<InvalidEPCISEventInfo> errors = new ArrayList<>();

  @Transient
  public boolean isProceed() {
    return "PROCEED".equalsIgnoreCase(getCaptureErrorBehaviour());
  }

  @Transient
  public boolean isRollback() {
    return "ROLLBACK".equalsIgnoreCase(getCaptureErrorBehaviour());
  }
}
