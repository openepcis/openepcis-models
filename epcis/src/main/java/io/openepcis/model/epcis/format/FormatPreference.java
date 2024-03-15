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

public class FormatPreference {

  private EPCFormat epcFormat;
  private CBVFormat cbvFormat;

  public FormatPreference(String epcFormat, String cbvFormat) {
    this.epcFormat = EPCFormat.fromString(epcFormat).orElse(EPCFormat.No_Preference);
    this.cbvFormat = CBVFormat.fromString(cbvFormat).orElse(CBVFormat.No_Preference);
  }

  public static FormatPreference getInstance(EPCFormat epcFormat, CBVFormat cbvFormat) {
    return new FormatPreference(epcFormat.getEPCFormat(), cbvFormat.getCbvFormat());
  }

  public static FormatPreference getInstance(
      Optional<String> epcFormat, Optional<String> cbvFormat) {
    return getInstance(
        epcFormat.isPresent()
            ? EPCFormat.fromString(epcFormat.get()).orElse(EPCFormat.No_Preference)
            : EPCFormat.No_Preference,
        cbvFormat.isPresent()
            ? CBVFormat.fromString(cbvFormat.get()).orElse(CBVFormat.No_Preference)
            : CBVFormat.No_Preference);
  }

  public EPCFormat getEpcFormat() {
    return epcFormat;
  }

  public void setEpcFormat(EPCFormat epcFormat) {
    this.epcFormat = epcFormat;
  }

  public CBVFormat getCbvFormat() {
    return cbvFormat;
  }

  public void setCbvFormat(CBVFormat cbvFormat) {
    this.cbvFormat = cbvFormat;
  }
}
