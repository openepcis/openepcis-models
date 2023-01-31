package io.openepcis.model.epcis;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.math.BigInteger;
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
    name = "Manifest",
    namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
    propOrder = {"numberOfItems", "manifestItem"})
public class Manifest {

  @XmlElement(
      name = "NumberOfItems",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      required = true)
  protected BigInteger numberOfItems;

  @XmlElement(
      name = "ManifestItem",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      required = true)
  protected List<ManifestItem> manifestItem;
}
