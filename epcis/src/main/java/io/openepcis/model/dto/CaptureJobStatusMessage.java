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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.OffsetDateTime;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CaptureJobStatusMessage extends CaptureJob {
  private int validEventCount = 0;
  private int invalidEventCount = 0;
  private int processedEventCount = 0;
  private int capturedEventCount = 0;
  protected String storageBucket;
  protected String storageKey;
  private Map<String, Object> metadata;

  public CaptureJobStatusMessage(String captureID, boolean running, boolean success, OffsetDateTime createdAt, String captureErrorBehaviour, OffsetDateTime finishedAt, String storageBucket, String storageKey) {
    super(captureID, running, success, createdAt, captureErrorBehaviour, finishedAt);
    this.storageBucket = storageBucket;
    this.storageKey = storageKey;
  }

  @Deprecated(since = "0.9", forRemoval = true)
  @JsonIgnore
  public String getS3Bucket() {
    return storageBucket;
  }

  @Deprecated(since = "0.9", forRemoval = true)
  @JsonIgnore
  public String getS3Key() {
    return storageKey;
  }

  @Deprecated(since = "0.9", forRemoval = true)
  @JsonIgnore
  public void setS3Bucket(String s3Bucket) {
    storageBucket = s3Bucket;
  }

  @Deprecated(since = "0.9", forRemoval = true)
  @JsonIgnore
  public void setS3Key(String s3Key) {
    storageKey = s3Key;
  }

  public int getValidEventCount() {
    return this.validEventCount;
  }

  public int getInvalidEventCount() {
    return this.invalidEventCount;
  }

  public int getProcessedEventCount() {
    return this.processedEventCount;
  }

  public int getCapturedEventCount() {
    return this.capturedEventCount;
  }

  public String getStorageBucket() {
    return this.storageBucket;
  }

  public String getStorageKey() {
    return this.storageKey;
  }

  public Map<String, Object> getMetadata() {
    return this.metadata;
  }

  public void setValidEventCount(int validEventCount) {
    this.validEventCount = validEventCount;
  }

  public void setInvalidEventCount(int invalidEventCount) {
    this.invalidEventCount = invalidEventCount;
  }

  public void setProcessedEventCount(int processedEventCount) {
    this.processedEventCount = processedEventCount;
  }

  public void setCapturedEventCount(int capturedEventCount) {
    this.capturedEventCount = capturedEventCount;
  }

  public void setStorageBucket(String storageBucket) {
    this.storageBucket = storageBucket;
  }

  public void setStorageKey(String storageKey) {
    this.storageKey = storageKey;
  }

  public void setMetadata(Map<String, Object> metadata) {
    this.metadata = metadata;
  }

  @Override
  public String toString() {
    return "CaptureJobStatusMessage(validEventCount=" + this.getValidEventCount() + ", invalidEventCount=" + this.getInvalidEventCount() + ", processedEventCount=" + this.getProcessedEventCount() + ", capturedEventCount=" + this.getCapturedEventCount() + ", storageBucket=" + this.getStorageBucket() + ", storageKey=" + this.getStorageKey() + ", metadata=" + this.getMetadata() + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof CaptureJobStatusMessage)) return false;
    CaptureJobStatusMessage other = (CaptureJobStatusMessage) o;
    if (!other.canEqual((Object) this)) return false;
    if (!super.equals(o)) return false;
    if (this.getValidEventCount() != other.getValidEventCount()) return false;
    if (this.getInvalidEventCount() != other.getInvalidEventCount()) return false;
    if (this.getProcessedEventCount() != other.getProcessedEventCount()) return false;
    if (this.getCapturedEventCount() != other.getCapturedEventCount()) return false;
    Object this$storageBucket = this.getStorageBucket();
    Object other$storageBucket = other.getStorageBucket();
    if (this$storageBucket == null ? other$storageBucket != null : !this$storageBucket.equals(other$storageBucket)) return false;
    Object this$storageKey = this.getStorageKey();
    Object other$storageKey = other.getStorageKey();
    if (this$storageKey == null ? other$storageKey != null : !this$storageKey.equals(other$storageKey)) return false;
    Object this$metadata = this.getMetadata();
    Object other$metadata = other.getMetadata();
    if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof CaptureJobStatusMessage;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = super.hashCode();
    result = result * PRIME + this.getValidEventCount();
    result = result * PRIME + this.getInvalidEventCount();
    result = result * PRIME + this.getProcessedEventCount();
    result = result * PRIME + this.getCapturedEventCount();
    Object $storageBucket = this.getStorageBucket();
    result = result * PRIME + ($storageBucket == null ? 43 : $storageBucket.hashCode());
    Object $storageKey = this.getStorageKey();
    result = result * PRIME + ($storageKey == null ? 43 : $storageKey.hashCode());
    Object $metadata = this.getMetadata();
    result = result * PRIME + ($metadata == null ? 43 : $metadata.hashCode());
    return result;
  }

  public CaptureJobStatusMessage() {
  }
}
