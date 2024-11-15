//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package io.openepcis.model.gs1webvocab;

import io.openepcis.model.interfaces.Country;
import io.openepcis.model.interfaces.TargetMarketDetails;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetMarketDetails complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="TargetMarketDetails">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="consumerFirstAvailabilityDateTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="targetMarketCountries" type="{}Country"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetMarketDetails", propOrder = {
    "consumerFirstAvailabilityDateTime",
    "targetMarketCountries"
})
public class TargetMarketDetailsXMLImpl implements TargetMarketDetails<CountryXMLImpl> {

    @XmlElement(required = true)
    protected String consumerFirstAvailabilityDateTime;
    @XmlElement(required = true)
    protected CountryXMLImpl targetMarketCountries;

    /**
     * Gets the value of the consumerFirstAvailabilityDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getConsumerFirstAvailabilityDateTime() {
        return consumerFirstAvailabilityDateTime;
    }

    /**
     * Sets the value of the consumerFirstAvailabilityDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setConsumerFirstAvailabilityDateTime(String value) {
        this.consumerFirstAvailabilityDateTime = value;
    }

    /**
     * Gets the value of the targetMarketCountries property.
     * 
     * @return
     *     possible object is
     *     {@link CountryXMLImpl }
     *     
     */
    @Override
    public CountryXMLImpl getTargetMarketCountries() {
        return targetMarketCountries;
    }

    /**
     * Sets the value of the targetMarketCountries property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryXMLImpl }
     *     
     */
    @Override
    public void setTargetMarketCountries(CountryXMLImpl value) {
        this.targetMarketCountries = value;
    }

}
