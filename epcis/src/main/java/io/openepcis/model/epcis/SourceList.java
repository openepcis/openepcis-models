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
public class SourceList implements Serializable {
  @XmlAttribute
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  private String type;
  @XmlValue
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  private String source;


  public static class SourceListBuilder {
    private String type;
    private String source;

    SourceListBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public SourceList.SourceListBuilder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public SourceList.SourceListBuilder source(String source) {
      this.source = source;
      return this;
    }

    public SourceList build() {
      return new SourceList(this.type, this.source);
    }

    @Override
    public String toString() {
      return "SourceList.SourceListBuilder(type=" + this.type + ", source=" + this.source + ")";
    }
  }

  public static SourceList.SourceListBuilder builder() {
    return new SourceList.SourceListBuilder();
  }

  public String getType() {
    return this.type;
  }

  public String getSource() {
    return this.source;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setSource(String source) {
    this.source = source;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof SourceList)) return false;
    SourceList other = (SourceList) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$type = this.getType();
    Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
    Object this$source = this.getSource();
    Object other$source = other.getSource();
    if (this$source == null ? other$source != null : !this$source.equals(other$source)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof SourceList;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    Object $source = this.getSource();
    result = result * PRIME + ($source == null ? 43 : $source.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "SourceList(type=" + this.getType() + ", source=" + this.getSource() + ")";
  }

  public SourceList() {
  }

  public SourceList(String type, String source) {
    this.type = type;
    this.source = source;
  }
}
