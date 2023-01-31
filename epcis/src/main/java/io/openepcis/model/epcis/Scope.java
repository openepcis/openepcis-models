package io.openepcis.model.epcis;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "Scope",
    namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
    propOrder = {"type", "instanceIdentifier", "identifier", "scopeInformation"})
public class Scope {

  @XmlElement(
      name = "Type",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      required = true)
  protected String type;

  @XmlElement(
      name = "InstanceIdentifier",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      required = true)
  protected String instanceIdentifier;

  @XmlElement(
      name = "Identifier",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected String identifier;

  @XmlElement(
      name = "ScopeInformation",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      type = JAXBElement.class)
  protected List<JAXBElement<?>> scopeInformation;
}
