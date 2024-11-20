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
 * <p>Java class for WarrantyPromise complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="WarrantyPromise">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="durationOfWarranty" type="{}QuantitativeValue"/>
 *         <element name="warrantyScopeDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WarrantyPromise", propOrder = {
    "durationOfWarranty",
    "warrantyScopeDescription"
})
public class WarrantyPromise {

    @XmlElement(required = true)
    protected QuantitativeValue durationOfWarranty;
    @XmlElement(required = true)
    protected String warrantyScopeDescription;

    /**
     * Gets the value of the durationOfWarranty property.
     * 
     * @return
     *     possible object is
     *     {@link QuantitativeValue }
     *     
     */
    public QuantitativeValue getDurationOfWarranty() {
        return durationOfWarranty;
    }

    /**
     * Sets the value of the durationOfWarranty property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantitativeValue }
     *     
     */
    public void setDurationOfWarranty(QuantitativeValue value) {
        this.durationOfWarranty = value;
    }

    /**
     * Gets the value of the warrantyScopeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWarrantyScopeDescription() {
        return warrantyScopeDescription;
    }

    /**
     * Sets the value of the warrantyScopeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWarrantyScopeDescription(String value) {
        this.warrantyScopeDescription = value;
    }

}