/*
 * Copyright 2022 benelog GmbH & Co. KG
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

public enum CBVFormat {
  Always_URN("always_urn"),
  Always_Web_URI("always_web_uri"),
  Never_Translate("never_translate"),
  No_Preference("no_preference");

  private String cbvFormat;

  CBVFormat(String cbvFormat) {
    this.cbvFormat = cbvFormat;
  }

  public String getCbvFormat() {
    return this.cbvFormat;
  }

  public static CBVFormat fromString(Optional<String> cbvFormat) {
    for (CBVFormat cbf : CBVFormat.values()) {
      if (cbf.cbvFormat.equalsIgnoreCase(String.valueOf(cbvFormat))) {
        return cbf;
      }
    }
    return No_Preference;
  }
}
