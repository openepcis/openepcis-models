//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package io.openepcis.model.gs1webvocab;

import io.openepcis.model.interfaces.QuantitativeValue;
import io.openepcis.model.interfaces.ReferencedFileDetails;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReferencedFileDetails complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="ReferencedFileDetails">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="fileLanguageCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="filePixelHeight" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="filePixelWidth" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="referencedFileEffectiveEndDateTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="referencedFileEffectiveStartDateTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="referencedFileSize" type="{}QuantitativeValue"/>
 *         <element name="referencedFileType" type="{}ReferencedFileTypeCode"/>
 *         <element name="referencedFileURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferencedFileDetails", propOrder = {
    "fileLanguageCode",
    "filePixelHeight",
    "filePixelWidth",
    "referencedFileEffectiveEndDateTime",
    "referencedFileEffectiveStartDateTime",
    "referencedFileSize",
    "referencedFileType",
    "referencedFileURL"
})
public class ReferencedFileDetailsXMLImpl implements ReferencedFileDetails<QuantitativeValueXMLImpl> {

    @XmlElement(required = true)
    protected String fileLanguageCode;
    @XmlElement(required = true)
    protected String filePixelHeight;
    @XmlElement(required = true)
    protected String filePixelWidth;
    @XmlElement(required = true)
    protected String referencedFileEffectiveEndDateTime;
    @XmlElement(required = true)
    protected String referencedFileEffectiveStartDateTime;
    @XmlElement(required = true)
    protected QuantitativeValueXMLImpl referencedFileSize;
    @XmlElement(required = true)
    protected String referencedFileType;
    @XmlElement(required = true)
    protected String referencedFileURL;

    /**
     * Gets the value of the fileLanguageCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getFileLanguageCode() {
        return fileLanguageCode;
    }

    /**
     * Sets the value of the fileLanguageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setFileLanguageCode(String value) {
        this.fileLanguageCode = value;
    }

    /**
     * Gets the value of the filePixelHeight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getFilePixelHeight() {
        return filePixelHeight;
    }

    /**
     * Sets the value of the filePixelHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setFilePixelHeight(String value) {
        this.filePixelHeight = value;
    }

    /**
     * Gets the value of the filePixelWidth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getFilePixelWidth() {
        return filePixelWidth;
    }

    /**
     * Sets the value of the filePixelWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setFilePixelWidth(String value) {
        this.filePixelWidth = value;
    }

    /**
     * Gets the value of the referencedFileEffectiveEndDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getReferencedFileEffectiveEndDateTime() {
        return referencedFileEffectiveEndDateTime;
    }

    /**
     * Sets the value of the referencedFileEffectiveEndDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setReferencedFileEffectiveEndDateTime(String value) {
        this.referencedFileEffectiveEndDateTime = value;
    }

    /**
     * Gets the value of the referencedFileEffectiveStartDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getReferencedFileEffectiveStartDateTime() {
        return referencedFileEffectiveStartDateTime;
    }

    /**
     * Sets the value of the referencedFileEffectiveStartDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setReferencedFileEffectiveStartDateTime(String value) {
        this.referencedFileEffectiveStartDateTime = value;
    }

    /**
     * Gets the value of the referencedFileSize property.
     * 
     * @return
     *     possible object is
     *     {@link QuantitativeValueXMLImpl }
     *     
     */
    @Override
    public QuantitativeValueXMLImpl getReferencedFileSize() {
        return referencedFileSize;
    }

    /**
     * Sets the value of the referencedFileSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantitativeValueXMLImpl }
     *     
     */
    @Override
    public void setReferencedFileSize(QuantitativeValueXMLImpl value) {
        this.referencedFileSize = value;
    }

    /**
     * Gets the value of the referencedFileType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getReferencedFileType() {
        return referencedFileType;
    }

    /**
     * Sets the value of the referencedFileType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setReferencedFileType(String value) {
        this.referencedFileType = value;
    }

    /**
     * Gets the value of the referencedFileURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getReferencedFileURL() {
        return referencedFileURL;
    }

    /**
     * Sets the value of the referencedFileURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setReferencedFileURL(String value) {
        this.referencedFileURL = value;
    }

}
