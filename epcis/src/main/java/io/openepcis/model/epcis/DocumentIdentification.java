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

import static com.fasterxml.jackson.annotation.JsonFormat.Feature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE;
import static com.fasterxml.jackson.annotation.JsonFormat.Feature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.openepcis.model.epcis.modifier.CustomInstantAdapter;
import io.openepcis.model.epcis.modifier.OffsetDateTimeSerializer;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.OffsetDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentIdentification", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", propOrder = {"standard", "typeVersion", "instanceIdentifier", "type", "multipleType", "creationDateAndTime"})
public class DocumentIdentification {
  @XmlElement(name = "Standard", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
  protected String standard;
  @XmlElement(name = "TypeVersion", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
  protected String typeVersion;
  @XmlElement(name = "InstanceIdentifier", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
  protected String instanceIdentifier;
  @XmlElement(name = "Type", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
  protected String type;
  @XmlElement(name = "MultipleType", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected Boolean multipleType;
  @XmlElement(name = "CreationDateAndTime", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
  @XmlSchemaType(name = "dateTime")
  @XmlJavaTypeAdapter(CustomInstantAdapter.class)
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  @JsonFormat(without = {ADJUST_DATES_TO_CONTEXT_TIME_ZONE, WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS})
  protected OffsetDateTime creationDateAndTime;

  public String getStandard() {
    return this.standard;
  }

  public String getTypeVersion() {
    return this.typeVersion;
  }

  public String getInstanceIdentifier() {
    return this.instanceIdentifier;
  }

  public String getType() {
    return this.type;
  }

  public Boolean getMultipleType() {
    return this.multipleType;
  }

  public OffsetDateTime getCreationDateAndTime() {
    return this.creationDateAndTime;
  }

  public void setStandard(String standard) {
    this.standard = standard;
  }

  public void setTypeVersion(String typeVersion) {
    this.typeVersion = typeVersion;
  }

  public void setInstanceIdentifier(String instanceIdentifier) {
    this.instanceIdentifier = instanceIdentifier;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setMultipleType(Boolean multipleType) {
    this.multipleType = multipleType;
  }

  public void setCreationDateAndTime(OffsetDateTime creationDateAndTime) {
    this.creationDateAndTime = creationDateAndTime;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof DocumentIdentification)) return false;
    DocumentIdentification other = (DocumentIdentification) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$multipleType = this.getMultipleType();
    Object other$multipleType = other.getMultipleType();
    if (this$multipleType == null ? other$multipleType != null : !this$multipleType.equals(other$multipleType)) return false;
    Object this$standard = this.getStandard();
    Object other$standard = other.getStandard();
    if (this$standard == null ? other$standard != null : !this$standard.equals(other$standard)) return false;
    Object this$typeVersion = this.getTypeVersion();
    Object other$typeVersion = other.getTypeVersion();
    if (this$typeVersion == null ? other$typeVersion != null : !this$typeVersion.equals(other$typeVersion)) return false;
    Object this$instanceIdentifier = this.getInstanceIdentifier();
    Object other$instanceIdentifier = other.getInstanceIdentifier();
    if (this$instanceIdentifier == null ? other$instanceIdentifier != null : !this$instanceIdentifier.equals(other$instanceIdentifier)) return false;
    Object this$type = this.getType();
    Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
    Object this$creationDateAndTime = this.getCreationDateAndTime();
    Object other$creationDateAndTime = other.getCreationDateAndTime();
    if (this$creationDateAndTime == null ? other$creationDateAndTime != null : !this$creationDateAndTime.equals(other$creationDateAndTime)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof DocumentIdentification;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $multipleType = this.getMultipleType();
    result = result * PRIME + ($multipleType == null ? 43 : $multipleType.hashCode());
    Object $standard = this.getStandard();
    result = result * PRIME + ($standard == null ? 43 : $standard.hashCode());
    Object $typeVersion = this.getTypeVersion();
    result = result * PRIME + ($typeVersion == null ? 43 : $typeVersion.hashCode());
    Object $instanceIdentifier = this.getInstanceIdentifier();
    result = result * PRIME + ($instanceIdentifier == null ? 43 : $instanceIdentifier.hashCode());
    Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    Object $creationDateAndTime = this.getCreationDateAndTime();
    result = result * PRIME + ($creationDateAndTime == null ? 43 : $creationDateAndTime.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "DocumentIdentification(standard=" + this.getStandard() + ", typeVersion=" + this.getTypeVersion() + ", instanceIdentifier=" + this.getInstanceIdentifier() + ", type=" + this.getType() + ", multipleType=" + this.getMultipleType() + ", creationDateAndTime=" + this.getCreationDateAndTime() + ")";
  }

  public DocumentIdentification() {
  }

  public DocumentIdentification(String standard, String typeVersion, String instanceIdentifier, String type, Boolean multipleType, OffsetDateTime creationDateAndTime) {
    this.standard = standard;
    this.typeVersion = typeVersion;
    this.instanceIdentifier = instanceIdentifier;
    this.type = type;
    this.multipleType = multipleType;
    this.creationDateAndTime = creationDateAndTime;
  }
}
