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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@XmlRootElement(name = "EPCISBody")
@XmlType(name = "EPCISBodyType", namespace = "urn:epcglobal:epcis:xsd:2", propOrder = {"eventList", "extension", "any"})
@XmlAccessorType(XmlAccessType.FIELD)
public class EPCISBody {
  @XmlElement(name = "EventList")
  private List<? extends EPCISEvent> eventList;
  protected EPCISBodyExtension extension;
  @XmlAnyElement(lax = true)
  protected List<Object> any;
  @XmlAnyAttribute
  private Map<QName, String> otherAttributes = new HashMap<>();

  public List<? extends EPCISEvent> getEventList() {
    return this.eventList;
  }

  public EPCISBodyExtension getExtension() {
    return this.extension;
  }

  public List<Object> getAny() {
    return this.any;
  }

  public Map<QName, String> getOtherAttributes() {
    return this.otherAttributes;
  }

  public void setEventList(List<? extends EPCISEvent> eventList) {
    this.eventList = eventList;
  }

  public void setExtension(EPCISBodyExtension extension) {
    this.extension = extension;
  }

  public void setAny(List<Object> any) {
    this.any = any;
  }

  public void setOtherAttributes(Map<QName, String> otherAttributes) {
    this.otherAttributes = otherAttributes;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof EPCISBody)) return false;
    EPCISBody other = (EPCISBody) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$eventList = this.getEventList();
    Object other$eventList = other.getEventList();
    if (this$eventList == null ? other$eventList != null : !this$eventList.equals(other$eventList)) return false;
    Object this$extension = this.getExtension();
    Object other$extension = other.getExtension();
    if (this$extension == null ? other$extension != null : !this$extension.equals(other$extension)) return false;
    Object this$any = this.getAny();
    Object other$any = other.getAny();
    if (this$any == null ? other$any != null : !this$any.equals(other$any)) return false;
    Object this$otherAttributes = this.getOtherAttributes();
    Object other$otherAttributes = other.getOtherAttributes();
    if (this$otherAttributes == null ? other$otherAttributes != null : !this$otherAttributes.equals(other$otherAttributes)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof EPCISBody;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $eventList = this.getEventList();
    result = result * PRIME + ($eventList == null ? 43 : $eventList.hashCode());
    Object $extension = this.getExtension();
    result = result * PRIME + ($extension == null ? 43 : $extension.hashCode());
    Object $any = this.getAny();
    result = result * PRIME + ($any == null ? 43 : $any.hashCode());
    Object $otherAttributes = this.getOtherAttributes();
    result = result * PRIME + ($otherAttributes == null ? 43 : $otherAttributes.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "EPCISBody(eventList=" + this.getEventList() + ", extension=" + this.getExtension() + ", any=" + this.getAny() + ", otherAttributes=" + this.getOtherAttributes() + ")";
  }

  public EPCISBody() {
  }
}
