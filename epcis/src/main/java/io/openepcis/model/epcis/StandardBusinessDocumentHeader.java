package io.openepcis.model.epcis;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
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
    name = "StandardBusinessDocumentHeader",
    namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
    propOrder = {
      "headerVersion",
      "sender",
      "receiver",
      "documentIdentification",
      "manifest",
      "businessScope"
    })
public class StandardBusinessDocumentHeader {

  @XmlElement(
      name = "HeaderVersion",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      required = true)
  protected String headerVersion;

  @XmlElement(
      name = "Sender",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      required = true)
  protected List<Partner> sender;

  @XmlElement(
      name = "Receiver",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      required = true)
  protected List<Partner> receiver;

  @XmlElement(
      name = "DocumentIdentification",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      required = true)
  protected DocumentIdentification documentIdentification;

  @XmlElement(
      name = "Manifest",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected Manifest manifest;

  @XmlElement(
      name = "BusinessScope",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected BusinessScope businessScope;
}
