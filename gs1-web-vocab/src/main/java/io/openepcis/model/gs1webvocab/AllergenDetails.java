//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Java class for AllergenDetails complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="AllergenDetails">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="allergenLevelOfContainmentCode" type="{}LevelOfContainmentCode"/>
 *         <element name="allergenType" type="{}AllergenTypeCode"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AllergenDetails", propOrder = {
    "allergenLevelOfContainmentCode",
    "allergenType"
})
public class AllergenDetails {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected LevelOfContainmentCode allergenLevelOfContainmentCode;
    @XmlElement(required = true)
    protected String allergenType;

    /**
     * Gets the value of the allergenLevelOfContainmentCode property.
     * 
     * @return
     *     possible object is
     *     {@link LevelOfContainmentCode }
     *     
     */
    public LevelOfContainmentCode getAllergenLevelOfContainmentCode() {
        return allergenLevelOfContainmentCode;
    }

    /**
     * Sets the value of the allergenLevelOfContainmentCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link LevelOfContainmentCode }
     *     
     */
    public void setAllergenLevelOfContainmentCode(LevelOfContainmentCode value) {
        this.allergenLevelOfContainmentCode = value;
    }

    /**
     * Gets the value of the allergenType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllergenType() {
        return allergenType;
    }

    /**
     * Sets the value of the allergenType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllergenType(String value) {
        this.allergenType = value;
    }

}
