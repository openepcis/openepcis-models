//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package io.openepcis.model.gs1webvocab;

import io.openepcis.model.interfaces.Footwear;
import io.openepcis.model.interfaces.TextileMaterialDetails;
import jakarta.xml.bind.annotation.*;


/**
 * <p>Java class for Footwear complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Footwear">
 *   <complexContent>
 *     <extension base="{}WearableProduct">
 *       <sequence>
 *         <element name="footwearFasteningType" type="{}FootwearFasteningTypeCode"/>
 *         <element name="footwearUpperType" type="{}UpperTypeCode"/>
 *         <element name="upperMaterialType" type="{}TextileMaterialDetails"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Footwear", propOrder = {
    "footwearFasteningType",
    "footwearUpperType",
    "upperMaterialType"
})
public class FootwearXMLImpl
    extends WearableProductXMLImpl implements Footwear {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected FootwearFasteningTypeCode footwearFasteningType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected UpperTypeCode footwearUpperType;
    @XmlElement(required = true)
    protected TextileMaterialDetails upperMaterialType;

    /**
     * Gets the value of the footwearFasteningType property.
     * 
     * @return
     *     possible object is
     *     {@link FootwearFasteningTypeCode }
     *     
     */
    @Override
    public FootwearFasteningTypeCode getFootwearFasteningType() {
        return footwearFasteningType;
    }

    /**
     * Sets the value of the footwearFasteningType property.
     * 
     * @param value
     *     allowed object is
     *     {@link FootwearFasteningTypeCode }
     *     
     */
    @Override
    public void setFootwearFasteningType(FootwearFasteningTypeCode value) {
        this.footwearFasteningType = value;
    }

    /**
     * Gets the value of the footwearUpperType property.
     * 
     * @return
     *     possible object is
     *     {@link UpperTypeCode }
     *     
     */
    @Override
    public UpperTypeCode getFootwearUpperType() {
        return footwearUpperType;
    }

    /**
     * Sets the value of the footwearUpperType property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpperTypeCode }
     *     
     */
    @Override
    public void setFootwearUpperType(UpperTypeCode value) {
        this.footwearUpperType = value;
    }

    /**
     * Gets the value of the upperMaterialType property.
     * 
     * @return
     *     possible object is
     *     {@link TextileMaterialDetailsXMLImpl }
     *     
     */
    @Override
    public TextileMaterialDetails getUpperMaterialType() {
        return upperMaterialType;
    }

    /**
     * Sets the value of the upperMaterialType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextileMaterialDetailsXMLImpl }
     *     
     */
    @Override
    public void setUpperMaterialType(TextileMaterialDetails value) {
        this.upperMaterialType = value;
    }

}