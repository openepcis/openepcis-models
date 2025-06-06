//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import io.openepcis.model.interfaces.WearableProduct;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.Year;
import java.util.List;

/**
 * Products that are worn on the body.
 *
 * <p>Java class for WearableProduct complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="WearableProduct">
 *   <complexContent>
 *     <extension base="{}Product">
 *       <sequence>
 *         <element name="consumerLifestage" type="{}ConsumerLifestageCode"/>
 *         <element name="isPatterned" type="{}NonbinaryLogicCode"/>
 *         <element name="isThermal" type="{}NonbinaryLogicCode"/>
 *         <element name="isWaterproof" type="{}NonbinaryLogicCode"/>
 *         <element name="isWearableItemDisposable" type="{}NonbinaryLogicCode"/>
 *         <element name="seasonCalendarYear" type="{http://www.w3.org/2001/XMLSchema}gYear"/>
 *         <element name="seasonName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="seasonParameter" type="{}SeasonParameterCode"/>
 *         <element name="size" type="{}SizeDetails"/>
 *         <element name="sportingActivityType" type="{}SportingActivityTypeCode"/>
 *         <element name="styleDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="targetConsumerAge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="targetConsumerGender" type="{}TargetConsumerGenderCode"/>
 *         <element name="textileMaterialContent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "WearableProduct",
    propOrder = {
      "consumerLifestage",
      "isPatterned",
      "isThermal",
      "isWaterproof",
      "isWearableItemDisposable",
      "seasonCalendarYear",
      "seasonName",
      "seasonParameter",
      "size",
      "sportingActivityType",
      "styleDescription",
      "targetConsumerAge",
      "targetConsumerGender",
      "textileMaterialContent"
    })
@XmlSeeAlso({ClothingXMLImpl.class, FootwearXMLImpl.class})
public class WearableProductXMLImpl extends ProductXMLImpl
    implements WearableProduct<SizeDetailsXMLImpl> {

  @XmlElement(required = true)
  @XmlSchemaType(name = "string")
  protected ConsumerLifestageCode consumerLifestage;

  @XmlElement(required = true)
  @XmlSchemaType(name = "string")
  protected NonbinaryLogicCode isPatterned;

  @XmlElement(required = true)
  @XmlSchemaType(name = "string")
  protected NonbinaryLogicCode isThermal;

  @XmlElement(required = true)
  @XmlSchemaType(name = "string")
  protected NonbinaryLogicCode isWaterproof;

  @XmlElement(required = true)
  @XmlSchemaType(name = "string")
  protected NonbinaryLogicCode isWearableItemDisposable;

  @XmlElement(required = true, type = String.class)
  @XmlJavaTypeAdapter(Adapter3.class)
  @XmlSchemaType(name = "gYear")
  protected Year seasonCalendarYear;

  @XmlElement(required = true)
  protected String seasonName;

  @XmlElement(required = true)
  @XmlSchemaType(name = "string")
  protected SeasonParameterCode seasonParameter;

  @XmlElement(required = true)
  protected List<SizeDetailsXMLImpl> size;

  @XmlElement(required = true)
  @XmlSchemaType(name = "string")
  protected SportingActivityTypeCode sportingActivityType;

  @XmlElement(required = true)
  protected String styleDescription;

  @XmlElement(required = true)
  protected String targetConsumerAge;

  @XmlElement(required = true)
  @XmlSchemaType(name = "string")
  protected TargetConsumerGenderCode targetConsumerGender;

  @XmlElement(required = true)
  protected String textileMaterialContent;

  /**
   * Gets the value of the consumerLifestage property.
   *
   * @return possible object is {@link ConsumerLifestageCode }
   */
  @Override
  public ConsumerLifestageCode getConsumerLifestage() {
    return consumerLifestage;
  }

  /**
   * Sets the value of the consumerLifestage property.
   *
   * @param value allowed object is {@link ConsumerLifestageCode }
   */
  @Override
  public void setConsumerLifestage(ConsumerLifestageCode value) {
    this.consumerLifestage = value;
  }

  /**
   * Gets the value of the isPatterned property.
   *
   * @return possible object is {@link NonbinaryLogicCode }
   */
  @Override
  public NonbinaryLogicCode getIsPatterned() {
    return isPatterned;
  }

  /**
   * Sets the value of the isPatterned property.
   *
   * @param value allowed object is {@link NonbinaryLogicCode }
   */
  @Override
  public void setIsPatterned(NonbinaryLogicCode value) {
    this.isPatterned = value;
  }

  /**
   * Gets the value of the isThermal property.
   *
   * @return possible object is {@link NonbinaryLogicCode }
   */
  @Override
  public NonbinaryLogicCode getIsThermal() {
    return isThermal;
  }

  /**
   * Sets the value of the isThermal property.
   *
   * @param value allowed object is {@link NonbinaryLogicCode }
   */
  @Override
  public void setIsThermal(NonbinaryLogicCode value) {
    this.isThermal = value;
  }

  /**
   * Gets the value of the isWaterproof property.
   *
   * @return possible object is {@link NonbinaryLogicCode }
   */
  @Override
  public NonbinaryLogicCode getIsWaterproof() {
    return isWaterproof;
  }

  /**
   * Sets the value of the isWaterproof property.
   *
   * @param value allowed object is {@link NonbinaryLogicCode }
   */
  @Override
  public void setIsWaterproof(NonbinaryLogicCode value) {
    this.isWaterproof = value;
  }

  /**
   * Gets the value of the isWearableItemDisposable property.
   *
   * @return possible object is {@link NonbinaryLogicCode }
   */
  @Override
  public NonbinaryLogicCode getIsWearableItemDisposable() {
    return isWearableItemDisposable;
  }

  /**
   * Sets the value of the isWearableItemDisposable property.
   *
   * @param value allowed object is {@link NonbinaryLogicCode }
   */
  @Override
  public void setIsWearableItemDisposable(NonbinaryLogicCode value) {
    this.isWearableItemDisposable = value;
  }

  /**
   * Gets the value of the seasonCalendarYear property.
   *
   * @return possible object is {@link Year }
   */
  @Override
  public Year getSeasonCalendarYear() {
    return seasonCalendarYear;
  }

  /**
   * Sets the value of the seasonCalendarYear property.
   *
   * @param value allowed object is {@link Year }
   */
  @Override
  public void setSeasonCalendarYear(Year value) {
    this.seasonCalendarYear = value;
  }

  /**
   * Gets the value of the seasonName property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getSeasonName() {
    return seasonName;
  }

  /**
   * Sets the value of the seasonName property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setSeasonName(String value) {
    this.seasonName = value;
  }

  /**
   * Gets the value of the seasonParameter property.
   *
   * @return possible object is {@link SeasonParameterCode }
   */
  @Override
  public SeasonParameterCode getSeasonParameter() {
    return seasonParameter;
  }

  /**
   * Sets the value of the seasonParameter property.
   *
   * @param value allowed object is {@link SeasonParameterCode }
   */
  @Override
  public void setSeasonParameter(SeasonParameterCode value) {
    this.seasonParameter = value;
  }

  /**
   * Gets the value of the size property.
   *
   * @return possible object is {@link SizeDetailsXMLImpl }
   */
  @Override
  public List<SizeDetailsXMLImpl> getSize() {
    return size;
  }

  /**
   * Sets the value of the size property.
   *
   * @param value allowed object is {@link SizeDetailsXMLImpl }
   */
  @Override
  public void setSize(List<SizeDetailsXMLImpl> value) {
    this.size = value;
  }

  /**
   * Gets the value of the sportingActivityType property.
   *
   * @return possible object is {@link SportingActivityTypeCode }
   */
  @Override
  public SportingActivityTypeCode getSportingActivityType() {
    return sportingActivityType;
  }

  /**
   * Sets the value of the sportingActivityType property.
   *
   * @param value allowed object is {@link SportingActivityTypeCode }
   */
  @Override
  public void setSportingActivityType(SportingActivityTypeCode value) {
    this.sportingActivityType = value;
  }

  /**
   * Gets the value of the styleDescription property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getStyleDescription() {
    return styleDescription;
  }

  /**
   * Sets the value of the styleDescription property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setStyleDescription(String value) {
    this.styleDescription = value;
  }

  /**
   * Gets the value of the targetConsumerAge property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getTargetConsumerAge() {
    return targetConsumerAge;
  }

  /**
   * Sets the value of the targetConsumerAge property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setTargetConsumerAge(String value) {
    this.targetConsumerAge = value;
  }

  /**
   * Gets the value of the targetConsumerGender property.
   *
   * @return possible object is {@link TargetConsumerGenderCode }
   */
  @Override
  public TargetConsumerGenderCode getTargetConsumerGender() {
    return targetConsumerGender;
  }

  /**
   * Sets the value of the targetConsumerGender property.
   *
   * @param value allowed object is {@link TargetConsumerGenderCode }
   */
  @Override
  public void setTargetConsumerGender(TargetConsumerGenderCode value) {
    this.targetConsumerGender = value;
  }

  /**
   * Gets the value of the textileMaterialContent property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getTextileMaterialContent() {
    return textileMaterialContent;
  }

  /**
   * Sets the value of the textileMaterialContent property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setTextileMaterialContent(String value) {
    this.textileMaterialContent = value;
  }
}
