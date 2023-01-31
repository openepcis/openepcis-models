package io.openepcis.model.epcis;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "PartnerIdentification",
    namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
    propOrder = {"value"})
public class PartnerIdentification {

  @XmlValue protected String value;

  @XmlAttribute(name = "Authority")
  protected String authority;
}
