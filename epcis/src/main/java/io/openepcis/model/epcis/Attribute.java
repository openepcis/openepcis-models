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
import java.net.URI;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attribute {
  private URI id;
  private Object attribute;


  public static class AttributeBuilder {
    private URI id;
    private Object attribute;

    AttributeBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public Attribute.AttributeBuilder id(URI id) {
      this.id = id;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public Attribute.AttributeBuilder attribute(Object attribute) {
      this.attribute = attribute;
      return this;
    }

    public Attribute build() {
      return new Attribute(this.id, this.attribute);
    }

    @Override
    public String toString() {
      return "Attribute.AttributeBuilder(id=" + this.id + ", attribute=" + this.attribute + ")";
    }
  }

  public static Attribute.AttributeBuilder builder() {
    return new Attribute.AttributeBuilder();
  }

  public URI getId() {
    return this.id;
  }

  public Object getAttribute() {
    return this.attribute;
  }

  public void setId(URI id) {
    this.id = id;
  }

  public void setAttribute(Object attribute) {
    this.attribute = attribute;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Attribute)) return false;
    Attribute other = (Attribute) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$id = this.getId();
    Object other$id = other.getId();
    if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
    Object this$attribute = this.getAttribute();
    Object other$attribute = other.getAttribute();
    if (this$attribute == null ? other$attribute != null : !this$attribute.equals(other$attribute)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof Attribute;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $id = this.getId();
    result = result * PRIME + ($id == null ? 43 : $id.hashCode());
    Object $attribute = this.getAttribute();
    result = result * PRIME + ($attribute == null ? 43 : $attribute.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "Attribute(id=" + this.getId() + ", attribute=" + this.getAttribute() + ")";
  }

  public Attribute() {
  }

  public Attribute(URI id, Object attribute) {
    this.id = id;
    this.attribute = attribute;
  }
}
