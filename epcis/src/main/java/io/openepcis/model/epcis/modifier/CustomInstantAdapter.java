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
package io.openepcis.model.epcis.modifier;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class CustomInstantAdapter extends XmlAdapter<String, OffsetDateTime> {
  private final List<String> formatStrings =
      Arrays.asList(
          "yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
          "yyyy-MM-dd'T'HH:mm:ss Z",
          "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

  @Override
  public String marshal(OffsetDateTime v) {
    // Commenting the code as it is producing null value during JSON -> XML conversion.
    /*for (String format : formatStrings) {
      try {
        return new SimpleDateFormat(format).format(v);
      } catch (Exception e) {
      }
    }
    return null;*/
    return v.toString();
  }

  @Override
  public OffsetDateTime unmarshal(String v) {
    for (String format : formatStrings) {
      try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return ZonedDateTime.parse(v, formatter).toOffsetDateTime();

      } catch (Exception e) {
      }
    }
    return null;
  }
}
