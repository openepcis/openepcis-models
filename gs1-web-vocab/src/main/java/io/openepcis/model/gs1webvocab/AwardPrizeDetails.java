//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AwardPrizeDetails complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
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
 *         <element name="awardPrizeYear" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AwardPrizeDetails", propOrder = {
    "awardPrizeCode",
    "awardPrizeCountryCode",
    "awardPrizeDescription",
    "awardPrizeJury",
    "awardPrizeName",
    "awardPrizeYear"
})
public class AwardPrizeDetails {

    @XmlElement(required = true)
    protected String awardPrizeCode;
    @XmlElement(required = true)
    protected Country awardPrizeCountryCode;
    @XmlElement(required = true)
    protected String awardPrizeDescription;
    @XmlElement(required = true)
    protected String awardPrizeJury;
    @XmlElement(required = true)
    protected String awardPrizeName;
    @XmlElement(required = true)
    protected String awardPrizeYear;

    /**
     * Gets the value of the awardPrizeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAwardPrizeCode() {
        return awardPrizeCode;
    }

    /**
     * Sets the value of the awardPrizeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAwardPrizeCode(String value) {
        this.awardPrizeCode = value;
    }

    /**
     * Gets the value of the awardPrizeCountryCode property.
     * 
     * @return
     *     possible object is
     *     {@link Country }
     *     
     */
    public Country getAwardPrizeCountryCode() {
        return awardPrizeCountryCode;
    }

    /**
     * Sets the value of the awardPrizeCountryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Country }
     *     
     */
    public void setAwardPrizeCountryCode(Country value) {
        this.awardPrizeCountryCode = value;
    }

    /**
     * Gets the value of the awardPrizeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAwardPrizeDescription() {
        return awardPrizeDescription;
    }

    /**
     * Sets the value of the awardPrizeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAwardPrizeDescription(String value) {
        this.awardPrizeDescription = value;
    }

    /**
     * Gets the value of the awardPrizeJury property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAwardPrizeJury() {
        return awardPrizeJury;
    }

    /**
     * Sets the value of the awardPrizeJury property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAwardPrizeJury(String value) {
        this.awardPrizeJury = value;
    }

    /**
     * Gets the value of the awardPrizeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAwardPrizeName() {
        return awardPrizeName;
    }

    /**
     * Sets the value of the awardPrizeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAwardPrizeName(String value) {
        this.awardPrizeName = value;
    }

    /**
     * Gets the value of the awardPrizeYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAwardPrizeYear() {
        return awardPrizeYear;
    }

    /**
     * Sets the value of the awardPrizeYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAwardPrizeYear(String value) {
        this.awardPrizeYear = value;
    }

}
