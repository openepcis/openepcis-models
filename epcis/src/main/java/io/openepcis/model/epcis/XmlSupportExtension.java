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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.xml.bind.annotation.XmlSeeAlso;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    visible = true,
    property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = ObjectEvent.class, name = "ObjectEvent"),
  @JsonSubTypes.Type(value = AggregationEvent.class, name = "AggregationEvent"),
  @JsonSubTypes.Type(value = TransactionEvent.class, name = "TransactionEvent"),
  @JsonSubTypes.Type(value = TransformationEvent.class, name = "TransformationEvent"),
  @JsonSubTypes.Type(value = AssociationEvent.class, name = "AssociationEvent")
})
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlSeeAlso({
  ObjectEvent.class,
  AggregationEvent.class,
  TransactionEvent.class,
  TransformationEvent.class,
  AssociationEvent.class
})
public interface XmlSupportExtension {
  Object xmlSupport();
}
