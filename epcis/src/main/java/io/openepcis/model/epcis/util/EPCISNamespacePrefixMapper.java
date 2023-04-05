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
