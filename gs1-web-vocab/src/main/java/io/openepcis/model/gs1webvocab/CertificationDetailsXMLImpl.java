package io.openepcis.model.gs1webvocab;

import io.openepcis.model.interfaces.CertificationDetails;
import io.openepcis.model.interfaces.Thing;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;


/**
 * Certification issued by a certifying body to a certification subject (Organization, Place, Product).
 *
 * <p>Java class for CertificationDetails complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="CertificationDetails">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="certificationAgency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="certificationAgencyURL" type="{}Organization"/>
 *         <element name="certificationAuditDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         <element name="certificationEndDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         <element name="certificationIdentification" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="certificationStandard" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="certificationStartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         <element name="certificationStatement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="certificationStatus" type="{}CertificationStatus"/>
 *         <element name="certificationSubject" type="{}Thing">
 *         <element name="certificationType" type="{}Thing"/>
 *         <element name="certificationURI" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         <element name="certificationValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="initialCertificationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CertificationDetails", propOrder = {
    "certificationAgency",
    "certificationAgencyURL",
    "certificationAuditDate",
    "certificationEndDate",
    "certificationIdentification",
    "certificationStandard",
    "certificationStartDate",
    "certificationStatement",
    "certificationStatus",
    "certificationSubject",
    "certificationType",
    "certificationURI",
    "certificationValue",
    "initialCertificationDate"
})
public class CertificationDetailsXMLImpl implements CertificationDetails<OrganizationXMLImpl> {

    @XmlElement(required = true)
    protected String certificationAgency;
    @XmlElement(required = true)
    protected OrganizationXMLImpl certificationAgencyURL;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected LocalDate certificationAuditDate;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected LocalDate certificationEndDate;
    @XmlElement(required = true)
    protected String certificationIdentification;
    @XmlElement(required = true)
    protected String certificationStandard;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected LocalDate certificationStartDate;
    @XmlElement(required = true)
    protected String certificationStatement;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CertificationStatus certificationStatus;
    @XmlElement(required = true)
    protected Object certificationSubject;
    @XmlElement(required = true)
    protected Object certificationType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String certificationURI;
    @XmlElement(required = true)
    protected String certificationValue;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected LocalDate initialCertificationDate;

    /**
     * Gets the value of the certificationAgency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getCertificationAgency() {
        return certificationAgency;
    }

    /**
     * Sets the value of the certificationAgency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setCertificationAgency(String value) {
        this.certificationAgency = value;
    }

    /**
     * Gets the value of the certificationAgencyURL property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationXMLImpl }
     *     
     */
    @Override
    public OrganizationXMLImpl getCertificationAgencyURL() {
        return certificationAgencyURL;
    }

    /**
     * Sets the value of the certificationAgencyURL property.
     *
     * @param value
     *     allowed object is
     *     {@link OrganizationXMLImpl }
     *
     */
    @Override
    public void setCertificationAgencyURL(OrganizationXMLImpl value) {
        this.certificationAgencyURL = value;
    }

    /**
     * Gets the value of the certificationAuditDate property.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    @Override
    public LocalDate getCertificationAuditDate() {
        return certificationAuditDate;
    }

    /**
     * Sets the value of the certificationAuditDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    @Override
    public void setCertificationAuditDate(LocalDate value) {
        this.certificationAuditDate = value;
    }

    /**
     * Gets the value of the certificationEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    @Override
    public LocalDate getCertificationEndDate() {
        return certificationEndDate;
    }

    /**
     * Sets the value of the certificationEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    @Override
    public void setCertificationEndDate(LocalDate value) {
        this.certificationEndDate = value;
    }

    /**
     * Gets the value of the certificationIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getCertificationIdentification() {
        return certificationIdentification;
    }

    /**
     * Sets the value of the certificationIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setCertificationIdentification(String value) {
        this.certificationIdentification = value;
    }

    /**
     * Gets the value of the certificationStandard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getCertificationStandard() {
        return certificationStandard;
    }

    /**
     * Sets the value of the certificationStandard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setCertificationStandard(String value) {
        this.certificationStandard = value;
    }

    /**
     * Gets the value of the certificationStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    @Override
    public LocalDate getCertificationStartDate() {
        return certificationStartDate;
    }

    /**
     * Sets the value of the certificationStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    @Override
    public void setCertificationStartDate(LocalDate value) {
        this.certificationStartDate = value;
    }

    /**
     * Gets the value of the certificationStatement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getCertificationStatement() {
        return certificationStatement;
    }

    /**
     * Sets the value of the certificationStatement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setCertificationStatement(String value) {
        this.certificationStatement = value;
    }

    /**
     * Gets the value of the certificationStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CertificationStatus }
     *     
     */
    @Override
    public CertificationStatus getCertificationStatus() {
        return certificationStatus;
    }

    /**
     * Sets the value of the certificationStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CertificationStatus }
     *     
     */
    @Override
    public void setCertificationStatus(CertificationStatus value) {
        this.certificationStatus = value;
    }

    /**
     * Gets the value of the certificationSubject property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    @Override
    public Object getCertificationSubject() {
        return certificationSubject;
    }

    /**
     * Sets the value of the certificationSubject property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    @Override
    public void setCertificationSubject(Object value) {
        this.certificationSubject = value;
    }

    /**
     * Gets the value of the certificationType property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    @Override
    public Object getCertificationType() {
        return certificationType;
    }

    /**
     * Sets the value of the certificationType property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    @Override
    public void setCertificationType(Object value) {
        this.certificationType = value;
    }

    /**
     * Gets the value of the certificationURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getCertificationURI() {
        return certificationURI;
    }

    /**
     * Sets the value of the certificationURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setCertificationURI(String value) {
        this.certificationURI = value;
    }

    /**
     * Gets the value of the certificationValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getCertificationValue() {
        return certificationValue;
    }

    /**
     * Sets the value of the certificationValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setCertificationValue(String value) {
        this.certificationValue = value;
    }

    /**
     * Gets the value of the initialCertificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    @Override
    public LocalDate getInitialCertificationDate() {
        return initialCertificationDate;
    }

    /**
     * Sets the value of the initialCertificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    @Override
    public void setInitialCertificationDate(LocalDate value) {
        this.initialCertificationDate = value;
    }

}
