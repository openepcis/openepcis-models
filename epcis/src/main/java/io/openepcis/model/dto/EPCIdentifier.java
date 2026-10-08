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
package io.openepcis.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.Objects;

/** One EPC in both spellings, as the SmartHub Connect API reports it. */
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EPCIdentifier {

  /** URN form, e.g. urn:epc:id:sgtin:0614141.107346.2017. */
  @JsonProperty("urn")
  @XmlElement
  private String urn;

  /** GS1 Digital Link form, e.g. https://id.gs1.org/01/00614141107346/21/2017. */
  @JsonProperty("digitalLink")
  @XmlElement
  private String digitalLink;

  public EPCIdentifier() {}

  public EPCIdentifier(final String urn, final String digitalLink) {
    this.urn = urn;
    this.digitalLink = digitalLink;
  }

  public String getUrn() {
    return urn;
  }

  public void setUrn(final String urn) {
    this.urn = urn;
  }

  public String getDigitalLink() {
    return digitalLink;
  }

  public void setDigitalLink(final String digitalLink) {
    this.digitalLink = digitalLink;
  }

  @Override
  public boolean equals(final Object o) {
    return o instanceof EPCIdentifier other
        && Objects.equals(urn, other.urn)
        && Objects.equals(digitalLink, other.digitalLink);
  }

  @Override
  public int hashCode() {
    return Objects.hash(urn, digitalLink);
  }

  @Override
  public String toString() {
    return "EPCIdentifier{urn=" + urn + ", digitalLink=" + digitalLink + "}";
  }
}
