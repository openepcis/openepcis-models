//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Java class for SizeDetails complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="SizeDetails">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="sizeDimension" type="{}QuantitativeValue"/>
 *         <element name="sizeGroup" type="{}SizeGroupCode"/>
 *         <element name="sizeSystem" type="{}SizeSystemCode"/>
 *         <element name="sizeType" type="{}SizeTypeCode"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SizeDetails", propOrder = {
    "sizeDimension",
    "sizeGroup",
    "sizeSystem",
    "sizeType"
})
public class SizeDetails {

    @XmlElement(required = true)
    protected QuantitativeValue sizeDimension;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected SizeGroupCode sizeGroup;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected SizeSystemCode sizeSystem;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected SizeTypeCode sizeType;

    /**
     * Gets the value of the sizeDimension property.
     * 
     * @return
     *     possible object is
     *     {@link QuantitativeValue }
     *     
     */
    public QuantitativeValue getSizeDimension() {
        return sizeDimension;
    }

    /**
     * Sets the value of the sizeDimension property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantitativeValue }
     *     
     */
    public void setSizeDimension(QuantitativeValue value) {
        this.sizeDimension = value;
    }

    /**
     * Gets the value of the sizeGroup property.
     * 
     * @return
     *     possible object is
     *     {@link SizeGroupCode }
     *     
     */
    public SizeGroupCode getSizeGroup() {
        return sizeGroup;
    }

    /**
     * Sets the value of the sizeGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeGroupCode }
     *     
     */
    public void setSizeGroup(SizeGroupCode value) {
        this.sizeGroup = value;
    }

    /**
     * Gets the value of the sizeSystem property.
     * 
     * @return
     *     possible object is
     *     {@link SizeSystemCode }
     *     
     */
    public SizeSystemCode getSizeSystem() {
        return sizeSystem;
    }

    /**
     * Sets the value of the sizeSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeSystemCode }
     *     
     */
    public void setSizeSystem(SizeSystemCode value) {
        this.sizeSystem = value;
    }

    /**
     * Gets the value of the sizeType property.
     * 
     * @return
     *     possible object is
     *     {@link SizeTypeCode }
     *     
     */
    public SizeTypeCode getSizeType() {
        return sizeType;
    }

    /**
     * Sets the value of the sizeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeTypeCode }
     *     
     */
    public void setSizeType(SizeTypeCode value) {
        this.sizeType = value;
    }

}