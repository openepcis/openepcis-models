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
import jakarta.xml.bind.annotation.*;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class QueryResultsBody {
  @XmlElementWrapper(name = "EventList")
  @XmlElements({@XmlElement(name = "ObjectEvent", type = ObjectEvent.class), @XmlElement(name = "TransformationEvent", type = TransformationEvent.class), @XmlElement(name = "AggregationEvent", type = AggregationEvent.class), @XmlElement(name = "AssociationEvent", type = AssociationEvent.class), @XmlElement(name = "TransactionEvent", type = TransactionEvent.class)})
  private List<? extends EPCISEvent> eventList;

  public List<? extends EPCISEvent> getEventList() {
    return this.eventList;
  }

  public void setEventList(List<? extends EPCISEvent> eventList) {
    this.eventList = eventList;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof QueryResultsBody)) return false;
    QueryResultsBody other = (QueryResultsBody) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$eventList = this.getEventList();
    Object other$eventList = other.getEventList();
    if (this$eventList == null ? other$eventList != null : !this$eventList.equals(other$eventList)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof QueryResultsBody;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $eventList = this.getEventList();
    result = result * PRIME + ($eventList == null ? 43 : $eventList.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "QueryResultsBody(eventList=" + this.getEventList() + ")";
  }

  public QueryResultsBody() {
  }

  public QueryResultsBody(List<? extends EPCISEvent> eventList) {
    this.eventList = eventList;
  }
}
