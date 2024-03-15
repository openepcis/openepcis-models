/*
 * Copyright 2022-2023 benelog GmbH & Co. KG
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
package io.openepcis.model.epcis.format;

import java.util.Optional;

public enum EPCFormat {
  Always_GS1_Digital_Link("always_gs1_digital_link"),
  Always_EPC_URN("always_epc_urn"),
  Never_Translates("never_translates"),
  No_Preference("no_preference");

  private String epcFormat;

  EPCFormat(String epcFormat) {
    this.epcFormat = epcFormat;
  }

  public String getEPCFormat() {
    return this.epcFormat;
  }

  public static Optional<EPCFormat> fromString(String epcFormat) {
    for (EPCFormat epf : EPCFormat.values()) {
      if (epf.epcFormat.equalsIgnoreCase(epcFormat)) {
        return Optional.of(epf);
      }
    }
    return Optional.empty();
  }
}
