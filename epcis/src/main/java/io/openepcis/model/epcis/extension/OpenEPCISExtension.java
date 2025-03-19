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
package io.openepcis.model.epcis.extension;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.Builder;
import lombok.Data;

@Data
public class OpenEPCISExtension implements CaptureID, EventHashID, EventSequence {
  @XmlTransient @JsonIgnore private String hash;

  @XmlTransient @JsonIgnore private Integer sequenceInEPCISDoc;

  @XmlTransient @JsonIgnore private String captureID;

  public OpenEPCISExtension() {}

  @Builder(builderMethodName = "builder")
  public OpenEPCISExtension(
      final String hash, final Integer sequenceInEPCISDoc, final String captureID) {
    this.hash = hash;
    this.sequenceInEPCISDoc = sequenceInEPCISDoc;
    this.captureID = captureID;
  }
}
