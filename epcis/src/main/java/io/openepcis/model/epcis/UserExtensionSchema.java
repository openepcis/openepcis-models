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
package io.openepcis.model.epcis;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.OffsetDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserExtensionSchema {
  /**
   * A unique identifier associated with each schema document.
   */
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
  /**
   * This field holds the value of the default prefix associated with the schema namespace.
   */
  private String defaultPrefix;
  /**
   * Stores the time a schema was registered in OffsetDateTime format
   */
  private OffsetDateTime createdAt;
  /**
   * Stores the time a schema was updated in OffsetDateTime format
   */
  private OffsetDateTime updatedAt;
  /**
   * Stores the userID of user registering the schema in UUID format
   */
  private String createdBy;
  /**
   * Stores the userID of user updating the schema in UUID format
   */
  private String updatedBy;
  /**
   * This field holds the Custom URL of the JSON-LD context document associated with the schema.
   */
  private String jsonldContextUrl;

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof UserExtensionSchema)) return false;
    UserExtensionSchema other = (UserExtensionSchema) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$id = this.getId();
    Object other$id = other.getId();
    if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
    Object this$namespace = this.getNamespace();
    Object other$namespace = other.getNamespace();
    if (this$namespace == null ? other$namespace != null : !this$namespace.equals(other$namespace)) return false;
    Object this$jsonSchemaS3Key = this.getJsonSchemaS3Key();
    Object other$jsonSchemaS3Key = other.getJsonSchemaS3Key();
    if (this$jsonSchemaS3Key == null ? other$jsonSchemaS3Key != null : !this$jsonSchemaS3Key.equals(other$jsonSchemaS3Key)) return false;
    Object this$jsonSchemaUrl = this.getJsonSchemaUrl();
    Object other$jsonSchemaUrl = other.getJsonSchemaUrl();
    if (this$jsonSchemaUrl == null ? other$jsonSchemaUrl != null : !this$jsonSchemaUrl.equals(other$jsonSchemaUrl)) return false;
    Object this$defaultPrefix = this.getDefaultPrefix();
    Object other$defaultPrefix = other.getDefaultPrefix();
    if (this$defaultPrefix == null ? other$defaultPrefix != null : !this$defaultPrefix.equals(other$defaultPrefix)) return false;
    Object this$createdAt = this.getCreatedAt();
    Object other$createdAt = other.getCreatedAt();
    if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
    Object this$updatedAt = this.getUpdatedAt();
    Object other$updatedAt = other.getUpdatedAt();
    if (this$updatedAt == null ? other$updatedAt != null : !this$updatedAt.equals(other$updatedAt)) return false;
    Object this$createdBy = this.getCreatedBy();
    Object other$createdBy = other.getCreatedBy();
    if (this$createdBy == null ? other$createdBy != null : !this$createdBy.equals(other$createdBy)) return false;
    Object this$updatedBy = this.getUpdatedBy();
    Object other$updatedBy = other.getUpdatedBy();
    if (this$updatedBy == null ? other$updatedBy != null : !this$updatedBy.equals(other$updatedBy)) return false;
    Object this$jsonldContextUrl = this.getJsonldContextUrl();
    Object other$jsonldContextUrl = other.getJsonldContextUrl();
    if (this$jsonldContextUrl == null ? other$jsonldContextUrl != null : !this$jsonldContextUrl.equals(other$jsonldContextUrl)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof UserExtensionSchema;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $id = this.getId();
    result = result * PRIME + ($id == null ? 43 : $id.hashCode());
    Object $namespace = this.getNamespace();
    result = result * PRIME + ($namespace == null ? 43 : $namespace.hashCode());
    Object $jsonSchemaS3Key = this.getJsonSchemaS3Key();
    result = result * PRIME + ($jsonSchemaS3Key == null ? 43 : $jsonSchemaS3Key.hashCode());
    Object $jsonSchemaUrl = this.getJsonSchemaUrl();
    result = result * PRIME + ($jsonSchemaUrl == null ? 43 : $jsonSchemaUrl.hashCode());
    Object $defaultPrefix = this.getDefaultPrefix();
    result = result * PRIME + ($defaultPrefix == null ? 43 : $defaultPrefix.hashCode());
    Object $createdAt = this.getCreatedAt();
    result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
    Object $updatedAt = this.getUpdatedAt();
    result = result * PRIME + ($updatedAt == null ? 43 : $updatedAt.hashCode());
    Object $createdBy = this.getCreatedBy();
    result = result * PRIME + ($createdBy == null ? 43 : $createdBy.hashCode());
    Object $updatedBy = this.getUpdatedBy();
    result = result * PRIME + ($updatedBy == null ? 43 : $updatedBy.hashCode());
    Object $jsonldContextUrl = this.getJsonldContextUrl();
    result = result * PRIME + ($jsonldContextUrl == null ? 43 : $jsonldContextUrl.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "UserExtensionSchema(super=" + super.toString() + ", id=" + this.getId() + ", namespace=" + this.getNamespace() + ", jsonSchemaS3Key=" + this.getJsonSchemaS3Key() + ", jsonSchemaUrl=" + this.getJsonSchemaUrl() + ", defaultPrefix=" + this.getDefaultPrefix() + ", createdAt=" + this.getCreatedAt() + ", updatedAt=" + this.getUpdatedAt() + ", createdBy=" + this.getCreatedBy() + ", updatedBy=" + this.getUpdatedBy() + ", jsonldContextUrl=" + this.getJsonldContextUrl() + ")";
  }

  /**
   * A unique identifier associated with each schema document.
   */
  public String getId() {
    return this.id;
  }

  /**
   * The namespace URI may be an HTTP URL whose authority portion is a domain name owned by the
   * vendor/user, a URN having a URN namespace identifier issued to the vendor/user by IANA, an OID
   * URN whose initial path is a Private Enterprise Number assigned to the vendor/user, etc. This
   * will be used to identify the user-extension fields and schemas defined by the user/vendor in
   * the Schema file.
   */
  public String getNamespace() {
    return this.namespace;
  }

  /**
   * S3 Keys are unique identifiers for objects/files saved in S3. In this case it’s same as the
   * path of the JSON Schema document saved in the openepcis S3 bucket.
   */
  public String getJsonSchemaS3Key() {
    return this.jsonSchemaS3Key;
  }

  /**
   * This field is populated when a URL-based schema is defined using POST
   * /userExtension/jsonSchema/url . During this operation, the schema is not saved in S3.
   */
  public String getJsonSchemaUrl() {
    return this.jsonSchemaUrl;
  }

  /**
   * This field holds the value of the default prefix associated with the schema namespace.
   */
  public String getDefaultPrefix() {
    return this.defaultPrefix;
  }

  /**
   * Stores the time a schema was registered in OffsetDateTime format
   */
  public OffsetDateTime getCreatedAt() {
    return this.createdAt;
  }

  /**
   * Stores the time a schema was updated in OffsetDateTime format
   */
  public OffsetDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  /**
   * Stores the userID of user registering the schema in UUID format
   */
  public String getCreatedBy() {
    return this.createdBy;
  }

  /**
   * Stores the userID of user updating the schema in UUID format
   */
  public String getUpdatedBy() {
    return this.updatedBy;
  }

  /**
   * This field holds the Custom URL of the JSON-LD context document associated with the schema.
   */
  public String getJsonldContextUrl() {
    return this.jsonldContextUrl;
  }

  /**
   * A unique identifier associated with each schema document.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The namespace URI may be an HTTP URL whose authority portion is a domain name owned by the
   * vendor/user, a URN having a URN namespace identifier issued to the vendor/user by IANA, an OID
   * URN whose initial path is a Private Enterprise Number assigned to the vendor/user, etc. This
   * will be used to identify the user-extension fields and schemas defined by the user/vendor in
   * the Schema file.
   */
  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  /**
   * S3 Keys are unique identifiers for objects/files saved in S3. In this case it’s same as the
   * path of the JSON Schema document saved in the openepcis S3 bucket.
   */
  public void setJsonSchemaS3Key(String jsonSchemaS3Key) {
    this.jsonSchemaS3Key = jsonSchemaS3Key;
  }

  /**
   * This field is populated when a URL-based schema is defined using POST
   * /userExtension/jsonSchema/url . During this operation, the schema is not saved in S3.
   */
  public void setJsonSchemaUrl(String jsonSchemaUrl) {
    this.jsonSchemaUrl = jsonSchemaUrl;
  }

  /**
   * This field holds the value of the default prefix associated with the schema namespace.
   */
  public void setDefaultPrefix(String defaultPrefix) {
    this.defaultPrefix = defaultPrefix;
  }

  /**
   * Stores the time a schema was registered in OffsetDateTime format
   */
  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Stores the time a schema was updated in OffsetDateTime format
   */
  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  /**
   * Stores the userID of user registering the schema in UUID format
   */
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * Stores the userID of user updating the schema in UUID format
   */
  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  /**
   * This field holds the Custom URL of the JSON-LD context document associated with the schema.
   */
  public void setJsonldContextUrl(String jsonldContextUrl) {
    this.jsonldContextUrl = jsonldContextUrl;
  }

  /**
   * Creates a new {@code UserExtensionSchema} instance.
   *
   * @param id A unique identifier associated with each schema document.
   * @param namespace The namespace URI may be an HTTP URL whose authority portion is a domain name owned by the
   * vendor/user, a URN having a URN namespace identifier issued to the vendor/user by IANA, an OID
   * URN whose initial path is a Private Enterprise Number assigned to the vendor/user, etc. This
   * will be used to identify the user-extension fields and schemas defined by the user/vendor in
   * the Schema file.
   * @param jsonSchemaS3Key S3 Keys are unique identifiers for objects/files saved in S3. In this case it’s same as the
   * path of the JSON Schema document saved in the openepcis S3 bucket.
   * @param jsonSchemaUrl This field is populated when a URL-based schema is defined using POST
   * /userExtension/jsonSchema/url . During this operation, the schema is not saved in S3.
   * @param defaultPrefix This field holds the value of the default prefix associated with the schema namespace.
   * @param createdAt Stores the time a schema was registered in OffsetDateTime format
   * @param updatedAt Stores the time a schema was updated in OffsetDateTime format
   * @param createdBy Stores the userID of user registering the schema in UUID format
   * @param updatedBy Stores the userID of user updating the schema in UUID format
   * @param jsonldContextUrl This field holds the Custom URL of the JSON-LD context document associated with the schema.
   */
  public UserExtensionSchema(String id, String namespace, String jsonSchemaS3Key, String jsonSchemaUrl, String defaultPrefix, OffsetDateTime createdAt, OffsetDateTime updatedAt, String createdBy, String updatedBy, String jsonldContextUrl) {
    this.id = id;
    this.namespace = namespace;
    this.jsonSchemaS3Key = jsonSchemaS3Key;
    this.jsonSchemaUrl = jsonSchemaUrl;
    this.defaultPrefix = defaultPrefix;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
    this.jsonldContextUrl = jsonldContextUrl;
  }

  public UserExtensionSchema() {
  }
}
