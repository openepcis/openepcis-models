//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrganizationID_Details complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="OrganizationID_Details">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="organizationID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="organizationID_Qualifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="organizationID_Type" type="{}OrganizationID_Type"/>
 *         <element name="organizationID_URI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationID_Details", propOrder = {
    "organizationID",
    "organizationIDQualifier",
    "organizationIDType",
    "organizationIDURI"
})
public class OrganizationIDDetails {

    @XmlElement(required = true)
    protected String organizationID;
    @XmlElement(name = "organizationID_Qualifier", required = true)
    protected String organizationIDQualifier;
    @XmlElement(name = "organizationID_Type", required = true)
    @XmlSchemaType(name = "string")
    protected OrganizationIDType organizationIDType;
    @XmlElement(name = "organizationID_URI", required = true)
    protected String organizationIDURI;

    /**
     * Gets the value of the organizationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationID() {
        return organizationID;
    }

    /**
     * Sets the value of the organizationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationID(String value) {
        this.organizationID = value;
    }

    /**
     * Gets the value of the organizationIDQualifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationIDQualifier() {
        return organizationIDQualifier;
    }

    /**
     * Sets the value of the organizationIDQualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationIDQualifier(String value) {
        this.organizationIDQualifier = value;
    }

    /**
     * Gets the value of the organizationIDType property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationIDType }
     *     
     */
    public OrganizationIDType getOrganizationIDType() {
        return organizationIDType;
    }

    /**
     * Sets the value of the organizationIDType property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationIDType }
     *     
     */
    public void setOrganizationIDType(OrganizationIDType value) {
        this.organizationIDType = value;
    }

    /**
     * Gets the value of the organizationIDURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationIDURI() {
        return organizationIDURI;
    }

    /**
     * Sets the value of the organizationIDURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationIDURI(String value) {
        this.organizationIDURI = value;
    }

}
