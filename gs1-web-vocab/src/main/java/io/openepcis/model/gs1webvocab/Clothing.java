//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Java class for Clothing complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Clothing">
 *   <complexContent>
 *     <extension base="{}WearableProduct">
 *       <sequence>
 *         <element name="clothingCut" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="collarType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="isMaternity" type="{}NonbinaryLogicCode"/>
 *         <element name="textileMaterial" type="{}TextileMaterialDetails"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Clothing", propOrder = {
    "clothingCut",
    "collarType",
    "isMaternity",
    "textileMaterial"
})
public class Clothing
    extends WearableProduct
{

    @XmlElement(required = true)
    protected String clothingCut;
    @XmlElement(required = true)
    protected String collarType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected NonbinaryLogicCode isMaternity;
    @XmlElement(required = true)
    protected TextileMaterialDetails textileMaterial;

    /**
     * Gets the value of the clothingCut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClothingCut() {
        return clothingCut;
    }

    /**
     * Sets the value of the clothingCut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClothingCut(String value) {
        this.clothingCut = value;
    }

    /**
     * Gets the value of the collarType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollarType() {
        return collarType;
    }

    /**
     * Sets the value of the collarType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollarType(String value) {
        this.collarType = value;
    }

    /**
     * Gets the value of the isMaternity property.
     * 
     * @return
     *     possible object is
     *     {@link NonbinaryLogicCode }
     *     
     */
    public NonbinaryLogicCode getIsMaternity() {
        return isMaternity;
    }

    /**
     * Sets the value of the isMaternity property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonbinaryLogicCode }
     *     
     */
    public void setIsMaternity(NonbinaryLogicCode value) {
        this.isMaternity = value;
    }

    /**
     * Gets the value of the textileMaterial property.
     * 
     * @return
     *     possible object is
     *     {@link TextileMaterialDetails }
     *     
     */
    public TextileMaterialDetails getTextileMaterial() {
        return textileMaterial;
    }

    /**
     * Sets the value of the textileMaterial property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextileMaterialDetails }
     *     
     */
    public void setTextileMaterial(TextileMaterialDetails value) {
        this.textileMaterial = value;
    }

}
