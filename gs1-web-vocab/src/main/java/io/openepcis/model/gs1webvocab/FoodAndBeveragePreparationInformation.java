//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Java class for FoodAndBeveragePreparationInformation complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="FoodAndBeveragePreparationInformation">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="convenienceLevelPercent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="manufacturerPreparationCode" type="{}PreparationTypeCode"/>
 *         <element name="maximumOptimumConsumptionTemperature" type="{}QuantitativeValue"/>
 *         <element name="minimumOptimumConsumptionTemperature" type="{}QuantitativeValue"/>
 *         <element name="preparationCode" type="{}PreparationTypeCode"/>
 *         <element name="preparationConsumptionPrecautions" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="preparationInstructions" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="yield" type="{}ProductYieldDetails"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FoodAndBeveragePreparationInformation", propOrder = {
    "convenienceLevelPercent",
    "manufacturerPreparationCode",
    "maximumOptimumConsumptionTemperature",
    "minimumOptimumConsumptionTemperature",
    "preparationCode",
    "preparationConsumptionPrecautions",
    "preparationInstructions",
    "yield"
})
public class FoodAndBeveragePreparationInformation {

    @XmlElement(required = true)
    protected String convenienceLevelPercent;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected PreparationTypeCode manufacturerPreparationCode;
    @XmlElement(required = true)
    protected QuantitativeValue maximumOptimumConsumptionTemperature;
    @XmlElement(required = true)
    protected QuantitativeValue minimumOptimumConsumptionTemperature;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected PreparationTypeCode preparationCode;
    @XmlElement(required = true)
    protected String preparationConsumptionPrecautions;
    @XmlElement(required = true)
    protected String preparationInstructions;
    @XmlElement(required = true)
    protected ProductYieldDetails yield;

    /**
     * Gets the value of the convenienceLevelPercent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConvenienceLevelPercent() {
        return convenienceLevelPercent;
    }

    /**
     * Sets the value of the convenienceLevelPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConvenienceLevelPercent(String value) {
        this.convenienceLevelPercent = value;
    }

    /**
     * Gets the value of the manufacturerPreparationCode property.
     * 
     * @return
     *     possible object is
     *     {@link PreparationTypeCode }
     *     
     */
    public PreparationTypeCode getManufacturerPreparationCode() {
        return manufacturerPreparationCode;
    }

    /**
     * Sets the value of the manufacturerPreparationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreparationTypeCode }
     *     
     */
    public void setManufacturerPreparationCode(PreparationTypeCode value) {
        this.manufacturerPreparationCode = value;
    }

    /**
     * Gets the value of the maximumOptimumConsumptionTemperature property.
     * 
     * @return
     *     possible object is
     *     {@link QuantitativeValue }
     *     
     */
    public QuantitativeValue getMaximumOptimumConsumptionTemperature() {
        return maximumOptimumConsumptionTemperature;
    }

    /**
     * Sets the value of the maximumOptimumConsumptionTemperature property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantitativeValue }
     *     
     */
    public void setMaximumOptimumConsumptionTemperature(QuantitativeValue value) {
        this.maximumOptimumConsumptionTemperature = value;
    }

    /**
     * Gets the value of the minimumOptimumConsumptionTemperature property.
     * 
     * @return
     *     possible object is
     *     {@link QuantitativeValue }
     *     
     */
    public QuantitativeValue getMinimumOptimumConsumptionTemperature() {
        return minimumOptimumConsumptionTemperature;
    }

    /**
     * Sets the value of the minimumOptimumConsumptionTemperature property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantitativeValue }
     *     
     */
    public void setMinimumOptimumConsumptionTemperature(QuantitativeValue value) {
        this.minimumOptimumConsumptionTemperature = value;
    }

    /**
     * Gets the value of the preparationCode property.
     * 
     * @return
     *     possible object is
     *     {@link PreparationTypeCode }
     *     
     */
    public PreparationTypeCode getPreparationCode() {
        return preparationCode;
    }

    /**
     * Sets the value of the preparationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreparationTypeCode }
     *     
     */
    public void setPreparationCode(PreparationTypeCode value) {
        this.preparationCode = value;
    }

    /**
     * Gets the value of the preparationConsumptionPrecautions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreparationConsumptionPrecautions() {
        return preparationConsumptionPrecautions;
    }

    /**
     * Sets the value of the preparationConsumptionPrecautions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreparationConsumptionPrecautions(String value) {
        this.preparationConsumptionPrecautions = value;
    }

    /**
     * Gets the value of the preparationInstructions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreparationInstructions() {
        return preparationInstructions;
    }

    /**
     * Sets the value of the preparationInstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreparationInstructions(String value) {
        this.preparationInstructions = value;
    }

    /**
     * Gets the value of the yield property.
     * 
     * @return
     *     possible object is
     *     {@link ProductYieldDetails }
     *     
     */
    public ProductYieldDetails getYield() {
        return yield;
    }

    /**
     * Sets the value of the yield property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductYieldDetails }
     *     
     */
    public void setYield(ProductYieldDetails value) {
        this.yield = value;
    }

}
