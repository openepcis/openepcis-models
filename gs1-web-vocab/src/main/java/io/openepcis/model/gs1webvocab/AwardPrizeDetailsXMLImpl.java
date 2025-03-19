package io.openepcis.model.gs1webvocab;

import io.openepcis.model.interfaces.AwardPrizeDetails;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.Year;

/**
 * Describes a prize or award won by a product or organization.
 *
 * <p>Java class for AwardPrizeDetails complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="AwardPrizeDetails">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="awardPrizeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="awardPrizeCountryCode" type="{}Country"/>
 *         <element name="awardPrizeDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="awardPrizeJury" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="awardPrizeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="awardPrizeYear" type="{http://www.w3.org/2001/XMLSchema}gYear"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "AwardPrizeDetails",
    propOrder = {
      "awardPrizeCode",
      "awardPrizeCountryCode",
      "awardPrizeDescription",
      "awardPrizeJury",
      "awardPrizeName",
      "awardPrizeYear"
    })
public class AwardPrizeDetailsXMLImpl implements AwardPrizeDetails<CountryXMLImpl> {

  @XmlElement(required = true)
  protected String awardPrizeCode;

  @XmlElement(required = true)
  protected CountryXMLImpl awardPrizeCountryCode;

  @XmlElement(required = true)
  protected String awardPrizeDescription;

  @XmlElement(required = true)
  protected String awardPrizeJury;

  @XmlElement(required = true)
  protected String awardPrizeName;

  @XmlElement(required = true, type = String.class)
  @XmlJavaTypeAdapter(Adapter3.class)
  @XmlSchemaType(name = "gYear")
  protected Year awardPrizeYear;

  /**
   * Gets the value of the awardPrizeCode property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getAwardPrizeCode() {
    return awardPrizeCode;
  }

  /**
   * Sets the value of the awardPrizeCode property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setAwardPrizeCode(String value) {
    this.awardPrizeCode = value;
  }

  /**
   * Gets the value of the awardPrizeCountryCode property.
   *
   * @return possible object is {@link CountryXMLImpl }
   */
  @Override
  public CountryXMLImpl getAwardPrizeCountryCode() {
    return awardPrizeCountryCode;
  }

  /**
   * Sets the value of the awardPrizeCountryCode property.
   *
   * @param value allowed object is {@link CountryXMLImpl }
   */
  @Override
  public void setAwardPrizeCountryCode(CountryXMLImpl value) {
    this.awardPrizeCountryCode = value;
  }

  /**
   * Gets the value of the awardPrizeDescription property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getAwardPrizeDescription() {
    return awardPrizeDescription;
  }

  /**
   * Sets the value of the awardPrizeDescription property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setAwardPrizeDescription(String value) {
    this.awardPrizeDescription = value;
  }

  /**
   * Gets the value of the awardPrizeJury property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getAwardPrizeJury() {
    return awardPrizeJury;
  }

  /**
   * Sets the value of the awardPrizeJury property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setAwardPrizeJury(String value) {
    this.awardPrizeJury = value;
  }

  /**
   * Gets the value of the awardPrizeName property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getAwardPrizeName() {
    return awardPrizeName;
  }

  /**
   * Sets the value of the awardPrizeName property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setAwardPrizeName(String value) {
    this.awardPrizeName = value;
  }

  /**
   * Gets the value of the awardPrizeYear property.
   *
   * @return possible object is {@link Year }
   */
  @Override
  public Year getAwardPrizeYear() {
    return awardPrizeYear;
  }

  /**
   * Sets the value of the awardPrizeYear property.
   *
   * @param value allowed object is {@link Year }
   */
  @Override
  public void setAwardPrizeYear(Year value) {
    this.awardPrizeYear = value;
  }
}
