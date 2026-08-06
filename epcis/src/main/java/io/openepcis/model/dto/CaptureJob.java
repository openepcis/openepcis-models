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
import jakarta.xml.bind.annotation.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "EPCISCaptureJob", namespace = "urn:epcglobal:epcis:xsd:2")
@XmlType(name = "EPCISCaptureJob", namespace = "urn:epcglobal:epcis:xsd:2")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(InvalidEPCISEventInfo.class)
public class CaptureJob extends CaptureData {
  public CaptureJob(final String captureID, final boolean running, final boolean success, final OffsetDateTime createdAt, final String captureErrorBehaviour, final OffsetDateTime finishedAt) {
    super(captureID, createdAt, finishedAt, running, success, captureErrorBehaviour, new ArrayList<>());
  }

  public static CaptureJob of(CaptureJob captureJob) {
    final CaptureJob c = new CaptureJob();
    c.captureID = captureJob.getCaptureID();
    c.createdAt = captureJob.getCreatedAt();
    c.finishedAt = captureJob.getFinishedAt();
    c.running = captureJob.isRunning();
    c.captureErrorBehaviour = captureJob.getCaptureErrorBehaviour();
    c.success = captureJob.isSuccess();
    c.errors = captureJob.getErrors();
    return c;
  }

  @Override
  public String toString() {
    return "CaptureJob()";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof CaptureJob)) return false;
    CaptureJob other = (CaptureJob) o;
    if (!other.canEqual((Object) this)) return false;
    if (!super.equals(o)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof CaptureJob;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    return result;
  }

  public CaptureJob() {
  }
}
