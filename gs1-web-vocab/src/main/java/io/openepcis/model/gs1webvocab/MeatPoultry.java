//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MeatPoultry complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="MeatPoultry">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="anatomicalForm" type="{}AnatomicalFormCode"/>
 *         <element name="bonelessClaim" type="{}NonbinaryLogicCode"/>
 *         <element name="meatPoultryType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="minimumMeatPoultryContent" type="{}QuantitativeValue"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeatPoultry", propOrder = {
    "anatomicalForm",
    "bonelessClaim",
    "meatPoultryType",
    "minimumMeatPoultryContent"
})
public class MeatPoultry {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected AnatomicalFormCode anatomicalForm;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected NonbinaryLogicCode bonelessClaim;
    @XmlElement(required = true)
    protected String meatPoultryType;
    @XmlElement(required = true)
    protected QuantitativeValue minimumMeatPoultryContent;

    /**
     * Gets the value of the anatomicalForm property.
     * 
     * @return
     *     possible object is
     *     {@link AnatomicalFormCode }
     *     
     */
    public AnatomicalFormCode getAnatomicalForm() {
        return anatomicalForm;
    }

    /**
     * Sets the value of the anatomicalForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnatomicalFormCode }
     *     
     */
    public void setAnatomicalForm(AnatomicalFormCode value) {
        this.anatomicalForm = value;
    }

    /**
     * Gets the value of the bonelessClaim property.
     * 
     * @return
     *     possible object is
     *     {@link NonbinaryLogicCode }
     *     
     */
    public NonbinaryLogicCode getBonelessClaim() {
        return bonelessClaim;
    }

    /**
     * Sets the value of the bonelessClaim property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonbinaryLogicCode }
     *     
     */
    public void setBonelessClaim(NonbinaryLogicCode value) {
        this.bonelessClaim = value;
    }

    /**
     * Gets the value of the meatPoultryType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeatPoultryType() {
        return meatPoultryType;
    }

    /**
     * Sets the value of the meatPoultryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeatPoultryType(String value) {
        this.meatPoultryType = value;
    }

    /**
     * Gets the value of the minimumMeatPoultryContent property.
     * 
     * @return
     *     possible object is
     *     {@link QuantitativeValue }
     *     
     */
    public QuantitativeValue getMinimumMeatPoultryContent() {
        return minimumMeatPoultryContent;
    }

    /**
     * Sets the value of the minimumMeatPoultryContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantitativeValue }
     *     
     */
    public void setMinimumMeatPoultryContent(QuantitativeValue value) {
        this.minimumMeatPoultryContent = value;
    }

}
