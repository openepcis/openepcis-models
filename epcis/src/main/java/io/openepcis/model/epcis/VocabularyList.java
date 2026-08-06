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
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VocabularyList {
  private List<VocabularyElements> vocabularyElements;


  public static class VocabularyListBuilder {
    private List<VocabularyElements> vocabularyElements;

    VocabularyListBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public VocabularyList.VocabularyListBuilder vocabularyElements(List<VocabularyElements> vocabularyElements) {
      this.vocabularyElements = vocabularyElements;
      return this;
    }

    public VocabularyList build() {
      return new VocabularyList(this.vocabularyElements);
    }

    @Override
    public String toString() {
      return "VocabularyList.VocabularyListBuilder(vocabularyElements=" + this.vocabularyElements + ")";
    }
  }

  public static VocabularyList.VocabularyListBuilder builder() {
    return new VocabularyList.VocabularyListBuilder();
  }

  public List<VocabularyElements> getVocabularyElements() {
    return this.vocabularyElements;
  }

  public void setVocabularyElements(List<VocabularyElements> vocabularyElements) {
    this.vocabularyElements = vocabularyElements;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof VocabularyList)) return false;
    VocabularyList other = (VocabularyList) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$vocabularyElements = this.getVocabularyElements();
    Object other$vocabularyElements = other.getVocabularyElements();
    if (this$vocabularyElements == null ? other$vocabularyElements != null : !this$vocabularyElements.equals(other$vocabularyElements)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof VocabularyList;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $vocabularyElements = this.getVocabularyElements();
    result = result * PRIME + ($vocabularyElements == null ? 43 : $vocabularyElements.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "VocabularyList(vocabularyElements=" + this.getVocabularyElements() + ")";
  }

  public VocabularyList() {
  }

  public VocabularyList(List<VocabularyElements> vocabularyElements) {
    this.vocabularyElements = vocabularyElements;
  }
}
