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
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VocabularyElement {
  private URI id;
  private List<Attribute> attributes;
  private List<URI> children;


  public static class VocabularyElementBuilder {
    private URI id;
    private List<Attribute> attributes;
    private List<URI> children;

    VocabularyElementBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public VocabularyElement.VocabularyElementBuilder id(URI id) {
      this.id = id;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public VocabularyElement.VocabularyElementBuilder attributes(List<Attribute> attributes) {
      this.attributes = attributes;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public VocabularyElement.VocabularyElementBuilder children(List<URI> children) {
      this.children = children;
      return this;
    }

    public VocabularyElement build() {
      return new VocabularyElement(this.id, this.attributes, this.children);
    }

    @Override
    public String toString() {
      return "VocabularyElement.VocabularyElementBuilder(id=" + this.id + ", attributes=" + this.attributes + ", children=" + this.children + ")";
    }
  }

  public static VocabularyElement.VocabularyElementBuilder builder() {
    return new VocabularyElement.VocabularyElementBuilder();
  }

  public URI getId() {
    return this.id;
  }

  public List<Attribute> getAttributes() {
    return this.attributes;
  }

  public List<URI> getChildren() {
    return this.children;
  }

  public void setId(URI id) {
    this.id = id;
  }

  public void setAttributes(List<Attribute> attributes) {
    this.attributes = attributes;
  }

  public void setChildren(List<URI> children) {
    this.children = children;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof VocabularyElement)) return false;
    VocabularyElement other = (VocabularyElement) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$id = this.getId();
    Object other$id = other.getId();
    if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
    Object this$attributes = this.getAttributes();
    Object other$attributes = other.getAttributes();
    if (this$attributes == null ? other$attributes != null : !this$attributes.equals(other$attributes)) return false;
    Object this$children = this.getChildren();
    Object other$children = other.getChildren();
    if (this$children == null ? other$children != null : !this$children.equals(other$children)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof VocabularyElement;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $id = this.getId();
    result = result * PRIME + ($id == null ? 43 : $id.hashCode());
    Object $attributes = this.getAttributes();
    result = result * PRIME + ($attributes == null ? 43 : $attributes.hashCode());
    Object $children = this.getChildren();
    result = result * PRIME + ($children == null ? 43 : $children.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "VocabularyElement(id=" + this.getId() + ", attributes=" + this.getAttributes() + ", children=" + this.getChildren() + ")";
  }

  public VocabularyElement() {
  }

  public VocabularyElement(URI id, List<Attribute> attributes, List<URI> children) {
    this.id = id;
    this.attributes = attributes;
    this.children = children;
  }
}
