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

import java.net.URI;
import java.util.Optional;

public class DeliveryInfo {
  private String subscriptionId;
  private Optional<String> signatureToken;
  private URI uri;
  private String result;

  public String getSubscriptionId() {
    return this.subscriptionId;
  }

  public Optional<String> getSignatureToken() {
    return this.signatureToken;
  }

  public URI getUri() {
    return this.uri;
  }

  public String getResult() {
    return this.result;
  }

  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public void setSignatureToken(Optional<String> signatureToken) {
    this.signatureToken = signatureToken;
  }

  public void setUri(URI uri) {
    this.uri = uri;
  }

  public void setResult(String result) {
    this.result = result;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof DeliveryInfo)) return false;
    DeliveryInfo other = (DeliveryInfo) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$subscriptionId = this.getSubscriptionId();
    Object other$subscriptionId = other.getSubscriptionId();
    if (this$subscriptionId == null ? other$subscriptionId != null : !this$subscriptionId.equals(other$subscriptionId)) return false;
    Object this$signatureToken = this.getSignatureToken();
    Object other$signatureToken = other.getSignatureToken();
    if (this$signatureToken == null ? other$signatureToken != null : !this$signatureToken.equals(other$signatureToken)) return false;
    Object this$uri = this.getUri();
    Object other$uri = other.getUri();
    if (this$uri == null ? other$uri != null : !this$uri.equals(other$uri)) return false;
    Object this$result = this.getResult();
    Object other$result = other.getResult();
    if (this$result == null ? other$result != null : !this$result.equals(other$result)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof DeliveryInfo;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $subscriptionId = this.getSubscriptionId();
    result = result * PRIME + ($subscriptionId == null ? 43 : $subscriptionId.hashCode());
    Object $signatureToken = this.getSignatureToken();
    result = result * PRIME + ($signatureToken == null ? 43 : $signatureToken.hashCode());
    Object $uri = this.getUri();
    result = result * PRIME + ($uri == null ? 43 : $uri.hashCode());
    Object $result = this.getResult();
    result = result * PRIME + ($result == null ? 43 : $result.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "DeliveryInfo(subscriptionId=" + this.getSubscriptionId() + ", signatureToken=" + this.getSignatureToken() + ", uri=" + this.getUri() + ", result=" + this.getResult() + ")";
  }

  public DeliveryInfo(String subscriptionId, Optional<String> signatureToken, URI uri, String result) {
    this.subscriptionId = subscriptionId;
    this.signatureToken = signatureToken;
    this.uri = uri;
    this.result = result;
  }

  public DeliveryInfo() {
  }
}
