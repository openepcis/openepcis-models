package io.openepcis.model.epcis.util;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.persistence.oxm.NamespacePrefixMapper;

public class EPCISNamespacePrefixMapper extends NamespacePrefixMapper {

  private Map<String, String> namespaceMap = new HashMap<>();

  /** Create mappings. */
  public EPCISNamespacePrefixMapper() {
    namespaceMap.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
    namespaceMap.put("urn:epcglobal:epcis:xsd:2", "epcis");
    namespaceMap.put("urn:epcglobal:epcis-query:xsd:2", "epcisq");
    namespaceMap.put(
        "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", "sbdh");
    namespaceMap.put("http://www.w3.org/2003/05/soap-envelope/", "soap");
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
