package io.openepcis.model.epcis;

import jakarta.xml.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "EPCISBodyExtensionType",
    namespace = "urn:epcglobal:epcis:xsd:2",
    propOrder = {"any"})
public class EPCISBodyExtension {

  @XmlAnyElement(lax = true)
  protected List<Object> any;

  @XmlAnyAttribute private Map<QName, String> otherAttributes = new HashMap<>();
}
