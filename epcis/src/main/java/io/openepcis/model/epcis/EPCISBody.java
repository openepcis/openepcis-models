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
import jakarta.xml.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@NoArgsConstructor
@XmlRootElement(name = "EPCISBody")
@XmlType(
    name = "EPCISBodyType",
    namespace = "urn:epcglobal:epcis:xsd:2",
    propOrder = {"eventList", "extension", "any"})
@XmlAccessorType(XmlAccessType.FIELD)
public class EPCISBody {

  @XmlElement(name = "EventList")
  private List<? extends EPCISEvent> eventList;

  protected EPCISBodyExtension extension;

  @XmlAnyElement(lax = true)
  protected List<Object> any;

  @XmlAnyAttribute private Map<QName, String> otherAttributes = new HashMap<>();
}
