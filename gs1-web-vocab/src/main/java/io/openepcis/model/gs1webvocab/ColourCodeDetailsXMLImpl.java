//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import io.openepcis.model.interfaces.ColourCodeDetails;
import jakarta.xml.bind.annotation.*;

/**
 * A set of colour code details (colour code, party controlling the code list) for the product.
 *
 * <p>Java class for ColourCodeDetails complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="ColourCodeDetails">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="colourCodeList" type="{}ColourCodeListCode"/>
 *         <element name="colourCodeValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "ColourCodeDetails",
    propOrder = {"colourCodeList", "colourCodeValue"})
public class ColourCodeDetailsXMLImpl implements ColourCodeDetails {

  @XmlElement(required = true)
  @XmlSchemaType(name = "string")
  protected ColourCodeListCode colourCodeList;

  @XmlElement(required = true)
  protected String colourCodeValue;

  /**
   * Gets the value of the colourCodeList property.
   *
   * @return possible object is {@link ColourCodeListCode }
   */
  @Override
  public ColourCodeListCode getColourCodeList() {
    return colourCodeList;
  }

  /**
   * Sets the value of the colourCodeList property.
   *
   * @param value allowed object is {@link ColourCodeListCode }
   */
  @Override
  public void setColourCodeList(ColourCodeListCode value) {
    this.colourCodeList = value;
  }

  /**
   * Gets the value of the colourCodeValue property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getColourCodeValue() {
    return colourCodeValue;
  }

  /**
   * Sets the value of the colourCodeValue property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setColourCodeValue(String value) {
    this.colourCodeValue = value;
  }
}
