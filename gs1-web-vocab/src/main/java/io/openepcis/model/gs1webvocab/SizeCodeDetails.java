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
 * <p>Java class for SizeCodeDetails complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="SizeCodeDetails">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="sizeCodeListCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="sizeCodeValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SizeCodeDetails", propOrder = {
    "sizeCodeListCode",
    "sizeCodeValue"
})
public class SizeCodeDetails {

    @XmlElement(required = true)
    protected String sizeCodeListCode;
    @XmlElement(required = true)
    protected String sizeCodeValue;

    /**
     * Gets the value of the sizeCodeListCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSizeCodeListCode() {
        return sizeCodeListCode;
    }

    /**
     * Sets the value of the sizeCodeListCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSizeCodeListCode(String value) {
        this.sizeCodeListCode = value;
    }

    /**
     * Gets the value of the sizeCodeValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSizeCodeValue() {
        return sizeCodeValue;
    }

    /**
     * Sets the value of the sizeCodeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSizeCodeValue(String value) {
        this.sizeCodeValue = value;
    }

}
