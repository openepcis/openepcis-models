@jakarta.xml.bind.annotation.XmlSchema(
    namespace = "urn:epcglobal:epcis:xsd:2",
    elementFormDefault = XmlNsForm.QUALIFIED,
    xmlns = {
      @XmlNs(prefix = "epcis", namespaceURI = "urn:epcglobal:epcis:xsd:2"),
      @XmlNs(prefix = "epcisq", namespaceURI = "urn:epcglobal:epcis-query:xsd:2"),
      @XmlNs(prefix = "epcglobal", namespaceURI = "urn:epcglobal:xsd:1")
    })
package io.openepcis.model.epcis;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
