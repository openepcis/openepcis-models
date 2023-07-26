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
package io.openepcis.model.epcis.util;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.persistence.oxm.NamespacePrefixMapper;

public class EPCISNamespacePrefixMapper extends NamespacePrefixMapper {

  public static final Map<String, String> EPCIS_NAMESPACE_MAP =
      Map.of(
          "http://www.w3.org/2001/XMLSchema-instance", "xsi",
          "urn:epcglobal:epcis:xsd:2", "epcis",
          "urn:epcglobal:epcis-query:xsd:2", "epcisq",
          "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", "sbdh");

  private Map<String, String> namespaceMap;

  public EPCISNamespacePrefixMapper(final Map<String, String> namespaceMap) {
    this.namespaceMap = namespaceMap;
  }

  public EPCISNamespacePrefixMapper() {
    this(new HashMap<>(EPCIS_NAMESPACE_MAP));
  }

  /* (non-Javadoc)
   * Returning null when not found based on spec.
   * @see com.sun.xml.bind.marshaller.NamespacePrefixMapper#getPreferredPrefix(java.lang.String, java.lang.String, boolean)
   */
  @Override
  public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
    return namespaceMap.getOrDefault(namespaceUri, suggestion);
  }
}
