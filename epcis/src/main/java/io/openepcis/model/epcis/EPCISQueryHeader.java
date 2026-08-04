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

public class EPCISQueryHeader {
  private EPCISMasterData epcisMasterData;

  public EPCISMasterData getEpcisMasterData() {
    return this.epcisMasterData;
  }

  public void setEpcisMasterData(EPCISMasterData epcisMasterData) {
    this.epcisMasterData = epcisMasterData;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof EPCISQueryHeader)) return false;
    EPCISQueryHeader other = (EPCISQueryHeader) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$epcisMasterData = this.getEpcisMasterData();
    Object other$epcisMasterData = other.getEpcisMasterData();
    if (this$epcisMasterData == null ? other$epcisMasterData != null : !this$epcisMasterData.equals(other$epcisMasterData)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof EPCISQueryHeader;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $epcisMasterData = this.getEpcisMasterData();
    result = result * PRIME + ($epcisMasterData == null ? 43 : $epcisMasterData.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "EPCISQueryHeader(epcisMasterData=" + this.getEpcisMasterData() + ")";
  }

  public EPCISQueryHeader() {
  }
}
