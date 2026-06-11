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
package io.openepcis.model.epcis.format.convert;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helpers for interpreting the JSON-LD {@code @context} of an event so that custom-extension
 * identifier values are left untouched during EPC/CBV format translation.
 *
 * <p>Ported (behaviour-preserving) from the EPC/CBV format utilities of the proprietary repository
 * layer so that the translation can run directly on the public {@code EPCISEvent} model without any
 * dependency on the Elasticsearch model types.
 */
final class ExtensionContext {

  private static final ObjectMapper SHARED_MAPPER = new ObjectMapper();

  private ExtensionContext() {}

  /** Flatten a JSON-LD {@code @context} list (maps and/or string-valued objects) into a map. */
  static Map<String, Object> convertContextToMap(final List<Object> context) {
    final HashMap<String, Object> result = new HashMap<>();
    if (context == null || context.isEmpty()) {
      return result;
    }
    for (final Object m : context) {
      if (m instanceof Map<?, ?> map) {
        map.forEach((k, v) -> result.put(String.valueOf(k), v));
      } else if (m != null) {
        result.putAll(SHARED_MAPPER.convertValue(m, HashMap.class));
      }
    }
    return result;
  }

  /**
   * EPC variant: a value is a custom-extension value when its prefix is declared in the context, or
   * (for web URIs) when its namespace (everything up to the last {@code '/'}) is a declared
   * namespace. Such values must pass through translation unchanged.
   */
  static boolean isEpcExtensionValue(final String value, final List<Object> context) {
    if (value == null) {
      return false;
    }
    final Map<String, Object> contextMap = convertContextToMap(context);
    final int colonIdx = value.indexOf(':');
    final String prefix = colonIdx > 0 ? value.substring(0, colonIdx) : value;
    if (contextMap.containsKey(prefix)) {
      return true;
    }
    if (value.startsWith("http://") || value.startsWith("https://")) {
      final int lastSlash = value.lastIndexOf('/');
      if (lastSlash < 0) {
        return false;
      }
      final String namespace = value.substring(0, lastSlash);
      for (final Object v : contextMap.values()) {
        if (v != null && namespace.equals(v.toString())) {
          return true;
        }
      }
    }
    return false;
  }

  /** CBV variant: a value is a custom-extension value when its prefix is declared in the context. */
  static boolean isCbvExtensionValue(final String value, final List<Object> context) {
    if (value == null) {
      return false;
    }
    final Map<String, Object> contextMap = convertContextToMap(context);
    final String prefix = value.split(":")[0];
    return contextMap.containsKey(prefix);
  }
}
