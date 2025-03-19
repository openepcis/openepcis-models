/*
 * Copyright 2022-2024 benelog GmbH & Co. KG
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
package io.openepcis.model.epcis.modifier;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CustomInstantAdapter extends XmlAdapter<String, OffsetDateTime> {

  @Override
  public String marshal(OffsetDateTime v) {
    return v.truncatedTo(ChronoUnit.MILLIS).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
  }

  @Override
  public OffsetDateTime unmarshal(String v) {
    return ZonedDateTime.parse(v, DateTimeFormatter.ISO_ZONED_DATE_TIME).toOffsetDateTime();
  }
}
