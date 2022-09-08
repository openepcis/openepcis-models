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
package io.openepcis.model.epcis;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.OffsetDateTime;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@ToString(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserExtensionSchema {
  private String id;
  private String clientID;
  private String namespace;
  private String xsdS3Key;
  private String jsonSchemaS3Key;
  private String xsdUrl;
  private String jsonSchemaUrl;
  private String javaBeanSource;
  private String rootFileName;
  private String defaultPrefix;
  private OffsetDateTime createdAt;
  private OffsetDateTime updatedAt;
  private String createdBy;
  private String updatedBy;
}
