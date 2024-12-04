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
 * A class providing nutritional value and intake percent.
 *
 * <p>Java class for NutritionMeasurementType complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="NutritionMeasurementType">
 *   <complexContent>
 *     <extension base="{}QuantitativeValue">
 *       <sequence>
 *         <element name="dailyValueIntakePercent" type="{http://www.w3.org/2001/XMLSchema}float"/>
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

    protected float dailyValueIntakePercent;


    /**
     * Gets the value of the dailyValueIntakePercent property.
     */
    @Override
    public float getDailyValueIntakePercent() {
        return dailyValueIntakePercent;
    }

    /**
     * Sets the value of the dailyValueIntakePercent property.
     */
    @Override
    public void setDailyValueIntakePercent(float value) {
        this.dailyValueIntakePercent = value;
    }

}
