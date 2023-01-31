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
    name = "ManifestItem",
    namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
    propOrder = {
      "mimeTypeQualifierCode",
      "uniformResourceIdentifier",
      "description",
      "languageCode"
    })
public class ManifestItem {

  @XmlElement(
      name = "MimeTypeQualifierCode",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      required = true)
  protected String mimeTypeQualifierCode;

  @XmlElement(
      name = "UniformResourceIdentifier",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      required = true)
  @XmlSchemaType(name = "anyURI")
  protected String uniformResourceIdentifier;

  @XmlElement(
      name = "Description",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected String description;

  @XmlElement(
      name = "LanguageCode",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected String languageCode;
}
