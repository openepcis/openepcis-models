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
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "Scope",
    namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
    propOrder = {"type", "instanceIdentifier", "identifier", "scopeInformation"})
public class Scope {

  @XmlElement(
      name = "Type",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      required = true)
  protected String type;

  @XmlElement(
      name = "InstanceIdentifier",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      required = true)
  protected String instanceIdentifier;

  @XmlElement(
      name = "Identifier",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected String identifier;

  @XmlElement(
      name = "ScopeInformation",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      type = JAXBElement.class)
  protected List<JAXBElement<?>> scopeInformation;
}
