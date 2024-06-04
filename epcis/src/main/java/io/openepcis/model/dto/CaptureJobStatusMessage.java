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
import java.time.OffsetDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CaptureJobStatusMessage extends CaptureJob {

  private int validEventCount = 0;
  private int invalidEventCount = 0;
  private int processedEventCount = 0;
  private int capturedEventCount = 0;
  protected String s3Bucket;
  protected String s3Key;

  public CaptureJobStatusMessage(
      String captureID,
      boolean running,
      boolean success,
      OffsetDateTime createdAt,
      String captureErrorBehaviour,
      OffsetDateTime finishedAt,
      String s3Bucket,
      String s3Key) {
    super(captureID, running, success, createdAt, captureErrorBehaviour, finishedAt);
    this.s3Bucket = s3Bucket;
    this.s3Key = s3Key;
  }
}
