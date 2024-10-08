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
 * <p>Java class for ReturnablePackageDepositDetails complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="ReturnablePackageDepositDetails">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="returnablePackageDepositAmount" type="{}PriceSpecification"/>
 *         <element name="returnablePackageDepositRegion" type="{}Country"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnablePackageDepositDetails", propOrder = {
    "returnablePackageDepositAmount",
    "returnablePackageDepositRegion"
})
public class ReturnablePackageDepositDetails {

    @XmlElement(required = true)
    protected PriceSpecification returnablePackageDepositAmount;
    @XmlElement(required = true)
    protected Country returnablePackageDepositRegion;

    /**
     * Gets the value of the returnablePackageDepositAmount property.
     * 
     * @return
     *     possible object is
     *     {@link PriceSpecification }
     *     
     */
    public PriceSpecification getReturnablePackageDepositAmount() {
        return returnablePackageDepositAmount;
    }

    /**
     * Sets the value of the returnablePackageDepositAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceSpecification }
     *     
     */
    public void setReturnablePackageDepositAmount(PriceSpecification value) {
        this.returnablePackageDepositAmount = value;
    }

    /**
     * Gets the value of the returnablePackageDepositRegion property.
     * 
     * @return
     *     possible object is
     *     {@link Country }
     *     
     */
    public Country getReturnablePackageDepositRegion() {
        return returnablePackageDepositRegion;
    }

    /**
     * Sets the value of the returnablePackageDepositRegion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Country }
     *     
     */
    public void setReturnablePackageDepositRegion(Country value) {
        this.returnablePackageDepositRegion = value;
    }

}
