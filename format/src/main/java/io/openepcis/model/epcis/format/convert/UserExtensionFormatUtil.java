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

import io.openepcis.model.epcis.format.EPCFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Applies an {@link EPCFormat} preference to the GS1-identifier values found inside user-extension
 * maps of the public {@code EPCISEvent} model.
 *
 * <p>Behaviour-preserving fusion of the proprietary build + render round-trip ({@code
 * EventConvertor.getUserExtensionsFromCoreModel} via {@code userExtensionsBuild} +
 * {@code EPCFormatUtil.buildUserExtensionEpc}, then {@code getCoreModelUserExtensionsWithFormat} via
 * {@code getUserExtensionsInExpectedFormat}). The net effect on a public extension map is: for every
 * {@code String} leaf, translate the value with {@link IdentifierFormatUtil#translateUserExtensionEpc}
 * using the leaf's map key (for elements of a list, the list's own key); recurse into nested maps and
 * lists; pass non-string leaves through unchanged.
 */
final class UserExtensionFormatUtil {

  private UserExtensionFormatUtil() {}

  /**
   * Recursively translate the GS1-identifier string leaves of a user-extension map.
   *
   * @param ext the public extension/userExtensions/innerUserExtensions map (may be {@code null})
   * @param epcFormat the requested EPC format
   * @param context unused for value translation (the original round-trip does not consult the
   *     context for extension EPC values); retained for signature parity / future use
   * @return a new translated map, or {@code null} when the input is {@code null} or empty
   */
  static Map<String, Object> translate(
      final Map<String, Object> ext, final EPCFormat epcFormat, final List<Object> context) {
    if (ext == null || ext.isEmpty()) {
      return ext;
    }
    final Map<String, Object> result = new LinkedHashMap<>();
    for (final Map.Entry<String, Object> entry : ext.entrySet()) {
      result.put(entry.getKey(), translateValue(entry.getKey(), entry.getValue(), epcFormat));
    }
    return result;
  }

  @SuppressWarnings("unchecked")
  private static Object translateValue(
      final String key, final Object value, final EPCFormat epcFormat) {
    if (value instanceof Map<?, ?> map) {
      final Map<String, Object> out = new LinkedHashMap<>();
      for (final Map.Entry<?, ?> e : map.entrySet()) {
        final String childKey = String.valueOf(e.getKey());
        out.put(childKey, translateValue(childKey, e.getValue(), epcFormat));
      }
      return out;
    } else if (value instanceof List<?> list) {
      final List<Object> out = new ArrayList<>(list.size());
      for (final Object item : list) {
        // list elements inherit the list's own key, mirroring userExtensionsBuild recursion
        out.add(translateValue(key, item, epcFormat));
      }
      return out;
    } else if (value instanceof String stringValue) {
      return IdentifierFormatUtil.translateUserExtensionEpc(key, stringValue, epcFormat);
    }
    return value;
  }
}
