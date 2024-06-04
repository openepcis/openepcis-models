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

import jakarta.xml.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.xml.namespace.QName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "EPCISDocumentType",
    namespace = "urn:epcglobal:epcis:xsd:2",
    propOrder = {"epcisHeader", "epcisBody", "extension", "any"})
public class EPCISDocument {

  @XmlElement(name = "EPCISBody")
  private EPCISBody epcisBody;

  @XmlTransient private String errorUrl;

  @XmlElement(name = "EPCISHeader")
  private EPCISHeader epcisHeader;

  @XmlElement private EPCISDocumentExtension extension;

  @XmlAnyElement(lax = true)
  protected List<Object> any;

  @XmlAnyAttribute private Map<QName, String> otherAttributes = new HashMap<>();

  public boolean hasEvents() {
    return Objects.nonNull(epcisBody)
        && Objects.nonNull(epcisBody.getEventList())
        && !epcisBody.getEventList().isEmpty();
  }

  public boolean hasErrorDeclarationEvent() {
    if (Objects.nonNull(epcisBody)
        && Objects.nonNull(epcisBody.getEventList())
        && !epcisBody.getEventList().isEmpty()) {

      return epcisBody.getEventList().stream()
          .anyMatch(e -> Objects.nonNull(e.getErrorDeclaration()));
    }
    return false;
  }
}
