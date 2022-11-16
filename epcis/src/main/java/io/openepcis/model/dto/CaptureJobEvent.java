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

import com.fasterxml.jackson.annotation.JsonInclude;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.xml.bind.annotation.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
// @JsonIgnoreProperties(ignoreUnknown = true)
@RegisterForReflection
@XmlRootElement
@XmlType(
    name = "CaptureJob",
    factoryClass = ObjectFactory.class,
    factoryMethod = "createCaptureJobEvent")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(InvalidEPCISEventInfo.class)
public class CaptureJobEvent extends CaptureDataEvent {

  public CaptureJobEvent(
      final String captureID,
      final boolean running,
      final boolean success,
      final OffsetDateTime createdAt,
      final String captureErrorBehaviour,
      final OffsetDateTime finishedAt) {
    super(
        captureID,
        createdAt,
        finishedAt,
        running,
        success,
        captureErrorBehaviour,
        new ArrayList<>());
  }
}
