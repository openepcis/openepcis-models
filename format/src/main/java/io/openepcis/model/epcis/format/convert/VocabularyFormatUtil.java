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
import io.openepcis.identifiers.converter.StandardVocabConvertorUtil;
import io.openepcis.identifiers.converter.util.ConverterUtil;
import io.openepcis.model.epcis.format.CBVFormat;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * CBV (Core Business Vocabulary) value translation between URN, GS1 Web URI and bare-string forms,
 * driven by a {@link CBVFormat} preference.
 *
 * <p>Behaviour-preserving port of {@code CBVFormatUtil} from the proprietary repository layer,
 * operating directly on plain strings (no Elasticsearch holder types). The build and render phases
 * of the original are fused into a single pure function per vocabulary value.
 */
final class VocabularyFormatUtil {

  private VocabularyFormatUtil() {}

  /**
   * Translate a single standard-vocabulary value into the requested format.
   *
   * @param captured the value as captured in the event
   * @param format the requested CBV format (null treated as default / no-preference)
   * @param urnPrefix the CBV URN prefix for this field (see {@code CBVUrnPrefix})
   * @param context the event's JSON-LD {@code @context} (extension values pass through unchanged)
   */
  static String translateCbv(
      final String captured,
      final CBVFormat format,
      final String urnPrefix,
      final List<Object> context) {
    if (StringUtils.isEmpty(captured)) {
      return null;
    }
    if (ExtensionContext.isCbvExtensionValue(captured, context)) {
      return captured;
    }

    String asURN = null;
    String asURI = null;
    String asBareString = null;

    if (captured.startsWith("urn:") || captured.startsWith("gs1:")) {
      asURN = captured;
      try {
        asURI = StandardVocabConvertorUtil.toURI(captured);
        asBareString = captured.substring(urnPrefix.length());
      } catch (final ValidationException e) {
        // Custom/non-standard URN — keep as-is, no URI or bare-string conversion
      }
    } else if (captured.startsWith(EPCIS.GS1_CBV_DOMAIN) || captured.startsWith(EPCIS.GS1_VOC_DOMAIN)) {
      asURN = StandardVocabConvertorUtil.toURN(captured);
      asURI = captured;
      asBareString = ConverterUtil.toBareStringVocabulary(captured);
    } else if (captured.toLowerCase().startsWith("urn:")) {
      asURN = captured;
    } else if (captured.toLowerCase().startsWith("https://")
        || captured.toLowerCase().startsWith("http://")) {
      asURI = captured;
    } else {
      asURN = urnPrefix.concat(captured);
      asURI = StandardVocabConvertorUtil.toURI(asURN);
      asBareString = captured;
    }

    return select(format, captured, asURN, asURI, asBareString);
  }

  private static String select(
      final CBVFormat format,
      final String captured,
      final String asURN,
      final String asURI,
      final String asBareString) {
    if (StringUtils.isBlank(asURN)) {
      return captured;
    }
    final CBVFormat f = format != null ? format : CBVFormat.No_Preference;
    return switch (f) {
      case Always_Web_URI -> asURI != null ? asURI : captured;
      case Always_URN -> asURN;
      case Never_Translates -> captured;
      default -> asBareString != null ? asBareString : captured;
    };
  }
}
