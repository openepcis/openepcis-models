/*
 * Copyright 2022-2023 benelog GmbH & Co. KG
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
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@XmlRootElement(name="EPCISCaptureJobList")
@XmlType(
    propOrder = {"captureJobs"},
    name = "EPCISCaptureJobList",
    factoryClass = ObjectFactory.class,
    factoryMethod = "createCaptureJobPageResult")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(CaptureJob.class)
public class CaptureJobPageResult extends PaginationSupport {

  @XmlAnyElement private List<CaptureJob> captureJobs;

  public CaptureJobPageResult(
      final String rel,
      final String nextPageToken,
      final OffsetDateTime tokenExpiryTime,
      final List<CaptureJob> captureJobs) {
    super(nextPageToken, rel, tokenExpiryTime);
    this.captureJobs = captureJobs;
  }
}
