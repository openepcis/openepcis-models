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
package io.openepcis.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlTransient
public class PaginationSupport {
  @JsonProperty("nextPageToken")
  @XmlTransient
  protected String nextPageToken;
  @JsonProperty("rel")
  @XmlTransient
  protected String rel;
  @JsonProperty("tokenExpiryTime")
  @XmlTransient
  protected OffsetDateTime tokenExpiryTime;

  public OffsetDateTime getTokenExpiryTime() {
    return tokenExpiryTime == null ? null : tokenExpiryTime.truncatedTo(ChronoUnit.MILLIS);
  }

  public String getNextPageToken() {
    return this.nextPageToken;
  }

  public String getRel() {
    return this.rel;
  }

  public void setNextPageToken(String nextPageToken) {
    this.nextPageToken = nextPageToken;
  }

  public void setRel(String rel) {
    this.rel = rel;
  }

  public void setTokenExpiryTime(OffsetDateTime tokenExpiryTime) {
    this.tokenExpiryTime = tokenExpiryTime;
  }

  @Override
  public String toString() {
    return "PaginationSupport(nextPageToken=" + this.getNextPageToken() + ", rel=" + this.getRel() + ", tokenExpiryTime=" + this.getTokenExpiryTime() + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof PaginationSupport)) return false;
    PaginationSupport other = (PaginationSupport) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$nextPageToken = this.getNextPageToken();
    Object other$nextPageToken = other.getNextPageToken();
    if (this$nextPageToken == null ? other$nextPageToken != null : !this$nextPageToken.equals(other$nextPageToken)) return false;
    Object this$rel = this.getRel();
    Object other$rel = other.getRel();
    if (this$rel == null ? other$rel != null : !this$rel.equals(other$rel)) return false;
    Object this$tokenExpiryTime = this.getTokenExpiryTime();
    Object other$tokenExpiryTime = other.getTokenExpiryTime();
    if (this$tokenExpiryTime == null ? other$tokenExpiryTime != null : !this$tokenExpiryTime.equals(other$tokenExpiryTime)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof PaginationSupport;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $nextPageToken = this.getNextPageToken();
    result = result * PRIME + ($nextPageToken == null ? 43 : $nextPageToken.hashCode());
    Object $rel = this.getRel();
    result = result * PRIME + ($rel == null ? 43 : $rel.hashCode());
    Object $tokenExpiryTime = this.getTokenExpiryTime();
    result = result * PRIME + ($tokenExpiryTime == null ? 43 : $tokenExpiryTime.hashCode());
    return result;
  }

  public PaginationSupport() {
  }

  public PaginationSupport(String nextPageToken, String rel, OffsetDateTime tokenExpiryTime) {
    this.nextPageToken = nextPageToken;
    this.rel = rel;
    this.tokenExpiryTime = tokenExpiryTime;
  }
}
