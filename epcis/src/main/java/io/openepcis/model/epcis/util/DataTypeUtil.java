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
package io.openepcis.model.epcis.util;

import io.openepcis.model.epcis.constants.CommonConstants;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DataTypeUtil {

  private DataTypeUtil() {
    throw new UnsupportedOperationException("Invalid invocation of constructor");
  }

  public static String getValueKeyFromType(Object value) {
    if (value instanceof List) {
      final List l = ((List) value);
      if (l != null && !l.isEmpty()) {
        value = l.get(0);
      } else {
        return "[]";
      }
    }

    if (value instanceof Long || value instanceof Integer) return CommonConstants.DOUBLE;
    else if (value instanceof Double || value instanceof Float) return CommonConstants.DOUBLE;
    else if (value instanceof Boolean) return CommonConstants.BOOLEAN;
    else if (value instanceof Instant
        || value instanceof ZonedDateTime
        || value instanceof LocalDateTime) return CommonConstants.DATE;
    else if (value instanceof String) {
      try {
        ZonedDateTime.parse(value.toString());
        return CommonConstants.DATE;
      } catch (Exception e) {
        try {
          LocalDateTime.parse(value.toString());
          return CommonConstants.DATE;
        } catch (Exception ex) {
          try {
            LocalDate.parse(value.toString());
            return CommonConstants.DATE;
          } catch (Exception exp) {
            try {
              Double.parseDouble(value.toString());
              return CommonConstants.DOUBLE;
            } catch (Exception dexp) {
              return CommonConstants.KEYWORD;
            }
          }
        }
      }
    } else return CommonConstants.OBJECT;
  }

  public static String getPathSuffixFromType(Object value) {
    if (value instanceof List) return getValueKeyFromType(((List) value).get(0));
    else return getValueKeyFromType(value);
  }

  public static boolean isLong(String value) {
    try {
      Long.valueOf(value);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean isDouble(String value) {
    try {
      Double.parseDouble(value);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean isDate(String value) {
    try {
      ZonedDateTime.parse(value, DateTimeFormatter.ISO_ZONED_DATE_TIME);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
