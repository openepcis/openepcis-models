//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package io.openepcis.model.gs1webvocab;

import io.openepcis.model.interfaces.NutritionMeasurementType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NutritionMeasurementType complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="NutritionMeasurementType">
 *   <complexContent>
 *     <extension base="{}QuantitativeValue">
 *       <sequence>
 *         <element name="dailyValueIntakePercent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NutritionMeasurementType", propOrder = {
    "dailyValueIntakePercent"
})
public class NutritionMeasurementTypeXMLImpl
    extends QuantitativeValueXMLImpl implements NutritionMeasurementType {

    @XmlElement(required = true)
    protected String dailyValueIntakePercent;

    /**
     * Gets the value of the dailyValueIntakePercent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getDailyValueIntakePercent() {
        return dailyValueIntakePercent;
    }

    /**
     * Sets the value of the dailyValueIntakePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setDailyValueIntakePercent(String value) {
        this.dailyValueIntakePercent = value;
    }

}