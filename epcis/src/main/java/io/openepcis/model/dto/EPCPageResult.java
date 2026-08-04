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
package io.openepcis.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.openepcis.core.model.PaginationSupport;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EPCPageResult extends PaginationSupport {
  @JsonProperty("@context")
  private List<Object> contextInfo;
  @JsonProperty("type")
  private String type;
  @JsonProperty("member")
  private List<String> member = new ArrayList<>();

  public List<Object> getContextInfo() {
    return this.contextInfo;
  }

  public String getType() {
    return this.type;
  }

  public List<String> getMember() {
    return this.member;
  }

  public void setContextInfo(List<Object> contextInfo) {
    this.contextInfo = contextInfo;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setMember(List<String> member) {
    this.member = member;
  }

  @Override
  public String toString() {
    return "EPCPageResult(contextInfo=" + this.getContextInfo() + ", type=" + this.getType() + ", member=" + this.getMember() + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof EPCPageResult)) return false;
    EPCPageResult other = (EPCPageResult) o;
    if (!other.canEqual((Object) this)) return false;
    if (!super.equals(o)) return false;
    Object this$contextInfo = this.getContextInfo();
    Object other$contextInfo = other.getContextInfo();
    if (this$contextInfo == null ? other$contextInfo != null : !this$contextInfo.equals(other$contextInfo)) return false;
    Object this$type = this.getType();
    Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
    Object this$member = this.getMember();
    Object other$member = other.getMember();
    if (this$member == null ? other$member != null : !this$member.equals(other$member)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof EPCPageResult;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = super.hashCode();
    Object $contextInfo = this.getContextInfo();
    result = result * PRIME + ($contextInfo == null ? 43 : $contextInfo.hashCode());
    Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    Object $member = this.getMember();
    result = result * PRIME + ($member == null ? 43 : $member.hashCode());
    return result;
  }

  public EPCPageResult() {
  }
}
