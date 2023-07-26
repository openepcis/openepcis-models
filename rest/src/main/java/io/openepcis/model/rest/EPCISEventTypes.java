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
package io.openepcis.model.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.openepcis.constants.EPCIS;

import java.util.stream.Stream;

/** The five types of EPCIS events. */
public enum EPCISEventTypes {
  OBJECT_EVENT(EPCIS.OBJECT_EVENT),
  AGGREGATION_EVENT(EPCIS.AGGREGATION_EVENT),
  ASSOCIATION_EVENT(EPCIS.ASSOCIATION_EVENT),
  TRANSFORMATION_EVENT(EPCIS.TRANSFORMATION_EVENT),
  TRANSACTION_EVENT(EPCIS.TRANSACTION_EVENT),
  ALL("all");

  private final String value;

  EPCISEventTypes(String value) {
    this.value = value;
  }

  @JsonCreator
  public static EPCISEventTypes fromValue(String text) {
    for (EPCISEventTypes b : EPCISEventTypes.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static boolean isIndependentEvent(String type) {
    return Stream.of(values()).anyMatch(v -> type.equalsIgnoreCase(v.value));
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }
}
