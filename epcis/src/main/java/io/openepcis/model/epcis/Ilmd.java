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

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ilmd implements Serializable {
  private Map<String, Object> userExtensions;
  @JsonIgnore
  private Map<String, Object> innerUserExtensions;

  @JsonAnyGetter
  public Map<String, Object> getUserExtensions() {
    return userExtensions;
  }


  public static class IlmdBuilder {
    private Map<String, Object> userExtensions;
    private Map<String, Object> innerUserExtensions;

    IlmdBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public Ilmd.IlmdBuilder userExtensions(Map<String, Object> userExtensions) {
      this.userExtensions = userExtensions;
      return this;
    }

    /**
     * @return {@code this}.
     */
    @JsonIgnore
    public Ilmd.IlmdBuilder innerUserExtensions(Map<String, Object> innerUserExtensions) {
      this.innerUserExtensions = innerUserExtensions;
      return this;
    }

    public Ilmd build() {
      return new Ilmd(this.userExtensions, this.innerUserExtensions);
    }

    @Override
    public String toString() {
      return "Ilmd.IlmdBuilder(userExtensions=" + this.userExtensions + ", innerUserExtensions=" + this.innerUserExtensions + ")";
    }
  }

  public static Ilmd.IlmdBuilder builder() {
    return new Ilmd.IlmdBuilder();
  }

  public Map<String, Object> getInnerUserExtensions() {
    return this.innerUserExtensions;
  }

  public void setUserExtensions(Map<String, Object> userExtensions) {
    this.userExtensions = userExtensions;
  }

  public void setInnerUserExtensions(Map<String, Object> innerUserExtensions) {
    this.innerUserExtensions = innerUserExtensions;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Ilmd)) return false;
    Ilmd other = (Ilmd) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$userExtensions = this.getUserExtensions();
    Object other$userExtensions = other.getUserExtensions();
    if (this$userExtensions == null ? other$userExtensions != null : !this$userExtensions.equals(other$userExtensions)) return false;
    Object this$innerUserExtensions = this.getInnerUserExtensions();
    Object other$innerUserExtensions = other.getInnerUserExtensions();
    if (this$innerUserExtensions == null ? other$innerUserExtensions != null : !this$innerUserExtensions.equals(other$innerUserExtensions)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof Ilmd;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $userExtensions = this.getUserExtensions();
    result = result * PRIME + ($userExtensions == null ? 43 : $userExtensions.hashCode());
    Object $innerUserExtensions = this.getInnerUserExtensions();
    result = result * PRIME + ($innerUserExtensions == null ? 43 : $innerUserExtensions.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "Ilmd(userExtensions=" + this.getUserExtensions() + ", innerUserExtensions=" + this.getInnerUserExtensions() + ")";
  }

  public Ilmd() {
  }

  public Ilmd(Map<String, Object> userExtensions, Map<String, Object> innerUserExtensions) {
    this.userExtensions = userExtensions;
    this.innerUserExtensions = innerUserExtensions;
  }
}
