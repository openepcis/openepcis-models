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
public class VocabularyElements {
  private List<VocabularyElement> vocabularyElementList;


  public static class VocabularyElementsBuilder {
    private List<VocabularyElement> vocabularyElementList;

    VocabularyElementsBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public VocabularyElements.VocabularyElementsBuilder vocabularyElementList(List<VocabularyElement> vocabularyElementList) {
      this.vocabularyElementList = vocabularyElementList;
      return this;
    }

    public VocabularyElements build() {
      return new VocabularyElements(this.vocabularyElementList);
    }

    @Override
    public String toString() {
      return "VocabularyElements.VocabularyElementsBuilder(vocabularyElementList=" + this.vocabularyElementList + ")";
    }
  }

  public static VocabularyElements.VocabularyElementsBuilder builder() {
    return new VocabularyElements.VocabularyElementsBuilder();
  }

  public List<VocabularyElement> getVocabularyElementList() {
    return this.vocabularyElementList;
  }

  public void setVocabularyElementList(List<VocabularyElement> vocabularyElementList) {
    this.vocabularyElementList = vocabularyElementList;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof VocabularyElements)) return false;
    VocabularyElements other = (VocabularyElements) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$vocabularyElementList = this.getVocabularyElementList();
    Object other$vocabularyElementList = other.getVocabularyElementList();
    if (this$vocabularyElementList == null ? other$vocabularyElementList != null : !this$vocabularyElementList.equals(other$vocabularyElementList)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof VocabularyElements;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $vocabularyElementList = this.getVocabularyElementList();
    result = result * PRIME + ($vocabularyElementList == null ? 43 : $vocabularyElementList.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "VocabularyElements(vocabularyElementList=" + this.getVocabularyElementList() + ")";
  }

  public VocabularyElements() {
  }

  public VocabularyElements(List<VocabularyElement> vocabularyElementList) {
    this.vocabularyElementList = vocabularyElementList;
  }
}
