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

import io.openepcis.constants.EPCIS;
import io.openepcis.core.exception.ValidationException;
import io.openepcis.identifiers.converter.util.ConverterUtil;
import io.openepcis.model.epcis.format.EPCFormat;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * EPC identifier (instance-level and class-level) translation between URN and GS1 Digital Link / Web
 * URI, driven by an {@link EPCFormat} preference.
 *
 * <p>Behaviour-preserving port of {@code EPCFormatUtil} from the proprietary repository layer,
 * operating directly on plain strings (no Elasticsearch holder types). The conversion itself uses
 * the public {@link ConverterUtil} from the digital-link translator. The build phase ({@code
 * buildEpc}/{@code buildClassLevelEpc}) and the render phase ({@code getEpcInExpectedFormat}/{@code
 * getEpcAsExpected}) of the original are fused into a single pure function per identifier.
 *
 * <p>The {@code applyDigitalLinkHostOverride} behaviour of the original is intentionally omitted: it
 * only rewrites the Digital Link authority when a {@code GS1-Digital-Link-Host} request header is
 * present, which never happens in the document-converter context, so it is a no-op pass-through
 * here.
 */
final class IdentifierFormatUtil {

  private IdentifierFormatUtil() {}

  /**
   * Translate a single EPC identifier into the requested format.
   *
   * @param captured the value as captured in the event
   * @param format the requested EPC format (null is treated as default / no-preference)
   * @param context the event's JSON-LD {@code @context} (extension values pass through unchanged)
   * @param classLevel {@code true} for class-level identifiers (e.g. {@code quantityList.epcClass})
   * @param uriField {@code true} for fields rendered as a URI in the model (read/biz-location point,
   *     sensor identifiers); only affects the default/no-preference fallback, matching the original
   *     {@code getEpcAsExpected} (URI) vs {@code getEpcInExpectedFormat} (string) divergence
   */
  static String translateEpc(
      final String captured,
      final EPCFormat format,
      final List<Object> context,
      final boolean classLevel,
      final boolean uriField) {
    if (StringUtils.isEmpty(captured)) {
      return captured;
    }
    if (ExtensionContext.isEpcExtensionValue(captured, context)) {
      return captured;
    }

    String asURN = null;
    String canonicalDL = null;
    if (captured.startsWith("urn:")) {
      asURN = captured;
      canonicalDL =
          classLevel
              ? ConverterUtil.toURIForClassLevelIdentifier(captured)
              : ConverterUtil.toURI(captured);
    } else if (classLevel) {
      // buildClassLevelEpc does not swallow ValidationException
      final Map<String, String> map = ConverterUtil.toURNForClassLevelIdentifier(captured);
      asURN = map.get("asURN");
      canonicalDL = map.get("canonicalDL");
    } else {
      try {
        final Map<String, String> map = ConverterUtil.toURN(captured);
        asURN = map.get("asURN");
        canonicalDL = map.get("canonicalDL");
      } catch (final ValidationException e) {
        // unsupported GS1 extension — keep captured; treat web URIs as their own canonical DL
        if (captured.startsWith("http://") || captured.startsWith("https://")) {
          canonicalDL = captured;
        }
      }
    }
    return select(format, captured, asURN, canonicalDL, uriField);
  }

  private static String select(
      final EPCFormat format,
      final String captured,
      final String asURN,
      final String canonicalDL,
      final boolean uriField) {
    final EPCFormat f = format != null ? format : EPCFormat.No_Preference;
    return switch (f) {
      case Always_GS1_Digital_Link -> canonicalDL;
      case Always_EPC_URN -> asURN;
      case Never_Translates -> captured;
      // getEpcAsExpected (URI fields) falls back to captured; getEpcInExpectedFormat (string) does not
      default -> uriField ? (canonicalDL != null ? canonicalDL : captured) : canonicalDL;
    };
  }

  /**
   * Translate a GS1-identifier value found inside user extensions. Mirrors {@code
   * buildUserExtensionEpc} + {@code getEpcInExpectedFormat} (non context-aware): {@code @id} keys and
   * non-GS1 values pass through; conversion failures pass through.
   */
  static String translateUserExtensionEpc(
      final String key, final String captured, final EPCFormat format) {
    if (EPCIS.AT_ID.equalsIgnoreCase(key)
        || StringUtils.isEmpty(captured)
        || !isGS1Identifier(captured)) {
      return captured;
    }
    String asURN = captured;
    String canonicalDL = captured;
    try {
      if (captured.startsWith(EPCIS.URN)) {
        asURN = captured;
        canonicalDL = ConverterUtil.toURI(captured);
      } else {
        final Map<String, String> map = ConverterUtil.toURN(captured);
        asURN = map.getOrDefault("asURN", captured);
        canonicalDL = map.getOrDefault("canonicalDL", captured);
      }
    } catch (final Exception e) {
      return captured;
    }
    final EPCFormat f = format != null ? format : EPCFormat.No_Preference;
    return switch (f) {
      case Always_EPC_URN -> asURN;
      case Never_Translates -> captured;
      // Always_GS1_Digital_Link and No_Preference both render the canonical Digital Link
      default -> canonicalDL;
    };
  }

  static boolean isGS1Identifier(final String value) {
    return value.startsWith(EPCIS.URN)
        || value.startsWith("https://")
        || value.startsWith("http://");
  }
}
