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
package io.openepcis.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlTransient
public class PaginationSupport {
  @JsonProperty("nextPageToken")
  @XmlTransient
  protected String nextPageToken;

  @JsonProperty("rel")
  @XmlTransient
  protected String rel;

  @JsonProperty("tokenExpiryTime")
  @XmlTransient
  protected OffsetDateTime tokenExpiryTime;

  public OffsetDateTime getTokenExpiryTime() {
    return tokenExpiryTime == null ? null : tokenExpiryTime.truncatedTo(ChronoUnit.MILLIS);
  }
}
