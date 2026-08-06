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
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.NONE)
public class DestinationList implements Serializable {
  @XmlAttribute
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  private String type;
  @XmlValue
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  private String destination;


  public static class DestinationListBuilder {
    private String type;
    private String destination;

    DestinationListBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public DestinationList.DestinationListBuilder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public DestinationList.DestinationListBuilder destination(String destination) {
      this.destination = destination;
      return this;
    }

    public DestinationList build() {
      return new DestinationList(this.type, this.destination);
    }

    @Override
    public String toString() {
      return "DestinationList.DestinationListBuilder(type=" + this.type + ", destination=" + this.destination + ")";
    }
  }

  public static DestinationList.DestinationListBuilder builder() {
    return new DestinationList.DestinationListBuilder();
  }

  public String getType() {
    return this.type;
  }

  public String getDestination() {
    return this.destination;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof DestinationList)) return false;
    DestinationList other = (DestinationList) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$type = this.getType();
    Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
    Object this$destination = this.getDestination();
    Object other$destination = other.getDestination();
    if (this$destination == null ? other$destination != null : !this$destination.equals(other$destination)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof DestinationList;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    Object $destination = this.getDestination();
    result = result * PRIME + ($destination == null ? 43 : $destination.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "DestinationList(type=" + this.getType() + ", destination=" + this.getDestination() + ")";
  }

  public DestinationList() {
  }

  public DestinationList(String type, String destination) {
    this.type = type;
    this.destination = destination;
  }
}
