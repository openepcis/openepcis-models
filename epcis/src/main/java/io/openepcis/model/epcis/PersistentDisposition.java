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
import jakarta.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlType(propOrder = {"unset", "set"})
public class PersistentDisposition implements Serializable {
  private List<String> set;
  private List<String> unset;


  public static class PersistentDispositionBuilder {
    private List<String> set;
    private List<String> unset;

    PersistentDispositionBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public PersistentDisposition.PersistentDispositionBuilder set(List<String> set) {
      this.set = set;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public PersistentDisposition.PersistentDispositionBuilder unset(List<String> unset) {
      this.unset = unset;
      return this;
    }

    public PersistentDisposition build() {
      return new PersistentDisposition(this.set, this.unset);
    }

    @Override
    public String toString() {
      return "PersistentDisposition.PersistentDispositionBuilder(set=" + this.set + ", unset=" + this.unset + ")";
    }
  }

  public static PersistentDisposition.PersistentDispositionBuilder builder() {
    return new PersistentDisposition.PersistentDispositionBuilder();
  }

  public List<String> getSet() {
    return this.set;
  }

  public List<String> getUnset() {
    return this.unset;
  }

  public void setSet(List<String> set) {
    this.set = set;
  }

  public void setUnset(List<String> unset) {
    this.unset = unset;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof PersistentDisposition)) return false;
    PersistentDisposition other = (PersistentDisposition) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$set = this.getSet();
    Object other$set = other.getSet();
    if (this$set == null ? other$set != null : !this$set.equals(other$set)) return false;
    Object this$unset = this.getUnset();
    Object other$unset = other.getUnset();
    if (this$unset == null ? other$unset != null : !this$unset.equals(other$unset)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof PersistentDisposition;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $set = this.getSet();
    result = result * PRIME + ($set == null ? 43 : $set.hashCode());
    Object $unset = this.getUnset();
    result = result * PRIME + ($unset == null ? 43 : $unset.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "PersistentDisposition(set=" + this.getSet() + ", unset=" + this.getUnset() + ")";
  }

  public PersistentDisposition() {
  }

  public PersistentDisposition(List<String> set, List<String> unset) {
    this.set = set;
    this.unset = unset;
  }
}
