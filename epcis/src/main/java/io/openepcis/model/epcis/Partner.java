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
    name = "Partner",
    namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
    propOrder = {"identifier", "contactInformation"})
public class Partner {

  @XmlElement(
      name = "Identifier",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      required = true)
  protected PartnerIdentification identifier;

  @XmlElement(
      name = "ContactInformation",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected List<ContactInformation> contactInformation;
}
