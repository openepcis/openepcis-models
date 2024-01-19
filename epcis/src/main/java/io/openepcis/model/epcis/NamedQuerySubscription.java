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
package io.openepcis.model.epcis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NamedQuerySubscription {
  private UUID subscriptionID;
  private String wsSessionID;
  private String queryName;
  private URI dest;
  private String signatureToken;
  private OffsetDateTime minRecordTime;
  private OffsetDateTime initialRecordTime;
  private Boolean reportIfEmpty;
  private Boolean stream;
  private Schedule schedule;
  @Builder.Default private Boolean deleted = false;
  private OffsetDateTime createdAt;
  private String epcFormat;
  private String cbvFormat;
  private String subscribedBy;
  private List<String> rolesAllowed;
}
