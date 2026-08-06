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

import java.util.HashMap;
import java.util.Set;

public class Tracer {
  private String traceId;
  private String spanId;
  private String defaultGroup;
  @Deprecated
  private HashMap<String, Set<String>> subscribedUserGroups;
  @Deprecated
  private Set<String> userId;

  public String getTraceId() {
    return this.traceId;
  }

  public String getSpanId() {
    return this.spanId;
  }

  public String getDefaultGroup() {
    return this.defaultGroup;
  }

  @Deprecated
  public HashMap<String, Set<String>> getSubscribedUserGroups() {
    return this.subscribedUserGroups;
  }

  @Deprecated
  public Set<String> getUserId() {
    return this.userId;
  }

  public void setTraceId(String traceId) {
    this.traceId = traceId;
  }

  public void setSpanId(String spanId) {
    this.spanId = spanId;
  }

  public void setDefaultGroup(String defaultGroup) {
    this.defaultGroup = defaultGroup;
  }

  @Deprecated
  public void setSubscribedUserGroups(HashMap<String, Set<String>> subscribedUserGroups) {
    this.subscribedUserGroups = subscribedUserGroups;
  }

  @Deprecated
  public void setUserId(Set<String> userId) {
    this.userId = userId;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Tracer)) return false;
    Tracer other = (Tracer) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$traceId = this.getTraceId();
    Object other$traceId = other.getTraceId();
    if (this$traceId == null ? other$traceId != null : !this$traceId.equals(other$traceId)) return false;
    Object this$spanId = this.getSpanId();
    Object other$spanId = other.getSpanId();
    if (this$spanId == null ? other$spanId != null : !this$spanId.equals(other$spanId)) return false;
    Object this$defaultGroup = this.getDefaultGroup();
    Object other$defaultGroup = other.getDefaultGroup();
    if (this$defaultGroup == null ? other$defaultGroup != null : !this$defaultGroup.equals(other$defaultGroup)) return false;
    Object this$subscribedUserGroups = this.getSubscribedUserGroups();
    Object other$subscribedUserGroups = other.getSubscribedUserGroups();
    if (this$subscribedUserGroups == null ? other$subscribedUserGroups != null : !this$subscribedUserGroups.equals(other$subscribedUserGroups)) return false;
    Object this$userId = this.getUserId();
    Object other$userId = other.getUserId();
    if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof Tracer;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $traceId = this.getTraceId();
    result = result * PRIME + ($traceId == null ? 43 : $traceId.hashCode());
    Object $spanId = this.getSpanId();
    result = result * PRIME + ($spanId == null ? 43 : $spanId.hashCode());
    Object $defaultGroup = this.getDefaultGroup();
    result = result * PRIME + ($defaultGroup == null ? 43 : $defaultGroup.hashCode());
    Object $subscribedUserGroups = this.getSubscribedUserGroups();
    result = result * PRIME + ($subscribedUserGroups == null ? 43 : $subscribedUserGroups.hashCode());
    Object $userId = this.getUserId();
    result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "Tracer(traceId=" + this.getTraceId() + ", spanId=" + this.getSpanId() + ", defaultGroup=" + this.getDefaultGroup() + ", subscribedUserGroups=" + this.getSubscribedUserGroups() + ", userId=" + this.getUserId() + ")";
  }

  public Tracer() {
  }

  public Tracer(String traceId, String spanId, String defaultGroup, HashMap<String, Set<String>> subscribedUserGroups, Set<String> userId) {
    this.traceId = traceId;
    this.spanId = spanId;
    this.defaultGroup = defaultGroup;
    this.subscribedUserGroups = subscribedUserGroups;
    this.userId = userId;
  }
}
