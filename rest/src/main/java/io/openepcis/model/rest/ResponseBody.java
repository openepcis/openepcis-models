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
package io.openepcis.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "ResponseBody", factoryClass = ObjectFactory.class, factoryMethod = "createResponseBody")
public class ResponseBody {
  @JsonProperty("response")
  @XmlElement
  private String response;

  public ResponseBody() {
  }

  public ResponseBody(String response) {
    this.response = response;
  }

  public String getResponse() {
    return this.response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof ResponseBody)) return false;
    ResponseBody other = (ResponseBody) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$response = this.getResponse();
    Object other$response = other.getResponse();
    if (this$response == null ? other$response != null : !this$response.equals(other$response)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof ResponseBody;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $response = this.getResponse();
    result = result * PRIME + ($response == null ? 43 : $response.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "ResponseBody(response=" + this.getResponse() + ")";
  }
}
