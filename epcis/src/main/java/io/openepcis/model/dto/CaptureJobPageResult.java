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
import io.openepcis.core.model.PaginationSupport;
import jakarta.xml.bind.annotation.*;
import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "EPCISCaptureJobList", namespace = "urn:epcglobal:epcis:xsd:2")
@XmlType(propOrder = {"captureJobs"}, name = "EPCISCaptureJobList", namespace = "urn:epcglobal:epcis:xsd:2", factoryClass = ObjectFactory.class, factoryMethod = "createCaptureJobPageResult")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(CaptureJob.class)
public class CaptureJobPageResult extends PaginationSupport {
  @XmlElement(namespace = "", name = "EPCISCaptureJob")
  private List<CaptureJob> captureJobs;

  public CaptureJobPageResult(final String rel, final String nextPageToken, final OffsetDateTime tokenExpiryTime, final List<CaptureJob> captureJobs) {
    super(nextPageToken, rel, tokenExpiryTime);
    this.captureJobs = captureJobs;
  }

  public List<CaptureJob> getCaptureJobs() {
    return this.captureJobs;
  }

  public void setCaptureJobs(List<CaptureJob> captureJobs) {
    this.captureJobs = captureJobs;
  }

  @Override
  public String toString() {
    return "CaptureJobPageResult(captureJobs=" + this.getCaptureJobs() + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof CaptureJobPageResult)) return false;
    CaptureJobPageResult other = (CaptureJobPageResult) o;
    if (!other.canEqual((Object) this)) return false;
    if (!super.equals(o)) return false;
    Object this$captureJobs = this.getCaptureJobs();
    Object other$captureJobs = other.getCaptureJobs();
    if (this$captureJobs == null ? other$captureJobs != null : !this$captureJobs.equals(other$captureJobs)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof CaptureJobPageResult;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = super.hashCode();
    Object $captureJobs = this.getCaptureJobs();
    result = result * PRIME + ($captureJobs == null ? 43 : $captureJobs.hashCode());
    return result;
  }

  public CaptureJobPageResult() {
  }
}
