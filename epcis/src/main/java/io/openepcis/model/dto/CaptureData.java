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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.openepcis.model.epcis.modifier.CustomInstantAdapter;
import io.openepcis.model.epcis.modifier.OffsetDateTimeSerializer;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.beans.Transient;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(InvalidEPCISEventInfo.class)
public class CaptureData {

  @XmlAttribute(name = "captureID")
  protected String captureID;

  @XmlElement(name = "createdAt", required = true)
  @XmlJavaTypeAdapter(CustomInstantAdapter.class)
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  protected OffsetDateTime createdAt;

  @XmlElement(name = "finishedAt", required = true)
  @XmlJavaTypeAdapter(CustomInstantAdapter.class)
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  protected OffsetDateTime finishedAt;

  @XmlAttribute(name = "running")
  protected boolean running;

  @XmlAttribute(name = "success")
  protected boolean success;

  @XmlElement(name = "captureErrorBehaviour")
  protected String captureErrorBehaviour;

  @XmlElementWrapper(name = "errors")
  @XmlElement(name = "error")
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
