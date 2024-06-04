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
  /** A unique identifier associated with each schema document. */
  private String id;
  /**
   * The namespace URI may be an HTTP URL whose authority portion is a domain name owned by the
   * vendor/user, a URN having a URN namespace identifier issued to the vendor/user by IANA, an OID
   * URN whose initial path is a Private Enterprise Number assigned to the vendor/user, etc. This
   * will be used to identify the user-extension fields and schemas defined by the user/vendor in
   * the Schema file.
   */
  private String namespace;
  /**
   * S3 Keys are unique identifiers for objects/files saved in S3. In this case it’s same as the
   * path of the JSON Schema document saved in the openepcis S3 bucket.
   */
  private String jsonSchemaS3Key;
  /**
   * This field is populated when a URL-based schema is defined using POST
   * /userExtension/jsonSchema/url . During this operation, the schema is not saved in S3.
   */
  private String jsonSchemaUrl;
  /** This field holds the value of the default prefix associated with the schema namespace. */
  private String defaultPrefix;
  /** Stores the time a schema was registered in OffsetDateTime format */
  private OffsetDateTime createdAt;
  /** Stores the time a schema was updated in OffsetDateTime format */
  private OffsetDateTime updatedAt;
  /** Stores the userID of user registering the schema in UUID format */
  private String createdBy;
  /** Stores the userID of user updating the schema in UUID format */
  private String updatedBy;
}
