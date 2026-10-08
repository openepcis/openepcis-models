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
import java.util.List;
import java.util.Objects;

/**
 * Where in the capture document a validation entry points: the event (position, eventID, canonical
 * hash, stored representation) and, within it, the field and the identifiers concerned. The shape
 * is the {@code eventLocationsInEPCISDocument} item of the SmartHub Connect API v4.1.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventLocationInEPCISDocument {

  /** Position of the event in the event list. */
  @JsonProperty("index")
  @XmlElement
  private Integer index;

  /** The event's eventID, when it has one. */
  @JsonProperty("eventId")
  @XmlElement
  private String eventId;

  /** Where the event's own representation can be fetched, when it is stored separately. */
  @JsonProperty("uri")
  @XmlElement
  private String uri;

  /** The event's canonical hash. */
  @JsonProperty("eventHashId")
  @XmlElement
  private String eventHashId;

  /** JSONPath relative to the event, e.g. {@code $.bizLocation}. */
  @JsonProperty("jsonPath")
  @XmlElement
  private String jsonPath;

  /** XPath of the same field in EPCIS XML, e.g. {@code /ObjectEvent/bizLocation}. */
  @JsonProperty("xmlPath")
  @XmlElement
  private String xmlPath;

  /** The identifiers within the event that the entry is about. */
  @JsonProperty("identifiers")
  @XmlElement
  private List<EPCIdentifier> identifiers;

  public EventLocationInEPCISDocument() {}

  public EventLocationInEPCISDocument index(final Integer index) {
    this.index = index;
    return this;
  }

  public EventLocationInEPCISDocument eventId(final String eventId) {
    this.eventId = eventId;
    return this;
  }

  public EventLocationInEPCISDocument uri(final String uri) {
    this.uri = uri;
    return this;
  }

  public EventLocationInEPCISDocument eventHashId(final String eventHashId) {
    this.eventHashId = eventHashId;
    return this;
  }

  public EventLocationInEPCISDocument jsonPath(final String jsonPath) {
    this.jsonPath = jsonPath;
    return this;
  }

  public EventLocationInEPCISDocument xmlPath(final String xmlPath) {
    this.xmlPath = xmlPath;
    return this;
  }

  public EventLocationInEPCISDocument identifiers(final List<EPCIdentifier> identifiers) {
    this.identifiers = identifiers;
    return this;
  }

  public Integer getIndex() {
    return index;
  }

  public void setIndex(final Integer index) {
    this.index = index;
  }

  public String getEventId() {
    return eventId;
  }

  public void setEventId(final String eventId) {
    this.eventId = eventId;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(final String uri) {
    this.uri = uri;
  }

  public String getEventHashId() {
    return eventHashId;
  }

  public void setEventHashId(final String eventHashId) {
    this.eventHashId = eventHashId;
  }

  public String getJsonPath() {
    return jsonPath;
  }

  public void setJsonPath(final String jsonPath) {
    this.jsonPath = jsonPath;
  }

  public String getXmlPath() {
    return xmlPath;
  }

  public void setXmlPath(final String xmlPath) {
    this.xmlPath = xmlPath;
  }

  public List<EPCIdentifier> getIdentifiers() {
    return identifiers;
  }

  public void setIdentifiers(final List<EPCIdentifier> identifiers) {
    this.identifiers = identifiers;
  }

  @Override
  public boolean equals(final Object o) {
    return o instanceof EventLocationInEPCISDocument other
        && Objects.equals(index, other.index)
        && Objects.equals(eventId, other.eventId)
        && Objects.equals(uri, other.uri)
        && Objects.equals(eventHashId, other.eventHashId)
        && Objects.equals(jsonPath, other.jsonPath)
        && Objects.equals(xmlPath, other.xmlPath)
        && Objects.equals(identifiers, other.identifiers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, eventId, uri, eventHashId, jsonPath, xmlPath, identifiers);
  }

  @Override
  public String toString() {
    return "EventLocationInEPCISDocument{index=" + index + ", eventId=" + eventId + ", eventHashId="
        + eventHashId + ", jsonPath=" + jsonPath + ", xmlPath=" + xmlPath + ", identifiers=" + identifiers + "}";
  }
}
