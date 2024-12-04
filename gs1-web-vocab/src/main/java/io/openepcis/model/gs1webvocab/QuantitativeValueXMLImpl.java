//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package io.openepcis.model.gs1webvocab;

import io.openepcis.model.interfaces.QuantitativeValue;
import jakarta.xml.bind.annotation.*;


/**
 * A point value or interval for product characteristics and other purposes. A unit of measurement is also specified.
 *
 * <p>Java class for QuantitativeValue complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="QuantitativeValue">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="unitCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="value" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuantitativeValue", propOrder = {
    "unitCode",
    "value"
})
@XmlSeeAlso({
    NutritionMeasurementTypeXMLImpl.class
})
public class QuantitativeValueXMLImpl implements QuantitativeValue {

    @XmlElement(required = true)
    protected String unitCode;
    protected float value;


    /**
     * Gets the value of the unitCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getUnitCode() {
        return unitCode;
    }

    /**
     * Sets the value of the unitCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setUnitCode(String value) {
        this.unitCode = value;
    }

    /**
     * Gets the value of the value property.
     */
    @Override
    public float getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     */
    @Override
    public void setValue(float value) {
        this.value = value;
    }

}
