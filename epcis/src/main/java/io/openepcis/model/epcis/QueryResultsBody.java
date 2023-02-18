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
import jakarta.xml.bind.annotation.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class QueryResultsBody {
  @XmlElementWrapper(name = "EventList")
  @XmlElements({
    @XmlElement(name = "ObjectEvent", type = ObjectEvent.class),
    @XmlElement(name = "TransformationEvent", type = TransformationEvent.class),
    @XmlElement(name = "AggregationEvent", type = AggregationEvent.class),
    @XmlElement(name = "AssociationEvent", type = AssociationEvent.class),
    @XmlElement(name = "TransactionEvent", type = TransactionEvent.class)
  })
  private List<? extends EPCISEvent> eventList;
}
