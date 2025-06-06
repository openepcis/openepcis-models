//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import io.openepcis.model.interfaces.Organization;
import jakarta.xml.bind.annotation.*;
import java.util.List;

/**
 * An Organization is any legal or physical entity involved at any point in any supply chain and
 * upon which there is a need to retrieve predefined information. An Organization is uniquely
 * identified by a Global Location Number (GLN).
 *
 * <p>Java class for Organization complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="Organization">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="additionalOrganizationID" type="{}OrganizationID_Details"/>
 *         <element name="additionalOrganizationIdentificationTypeValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="address" type="{}PostalAddress"/>
 *         <element name="afterHoursContact" type="{}ContactPoint"/>
 *         <element name="certification" type="{}CertificationDetails"/>
 *         <element name="contactPoint" type="{}ContactPoint"/>
 *         <element name="department" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="glnType" type="{}GLN_TypeCode"/>
 *         <element name="globalLocationNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="hasPrimaryLocation" type="{}Place"/>
 *         <element name="lesseeOf" type="{}Place"/>
 *         <element name="lessorFor" type="{}Place"/>
 *         <element name="location" type="{}Place"/>
 *         <element name="makesOffer" type="{}Offer"/>
 *         <element name="managedBy" type="{}Organization"/>
 *         <element name="manages" type="{}Organization"/>
 *         <element name="occupies" type="{}Place"/>
 *         <element name="organizationHistory" type="{}OrganizationStatusHistory"/>
 *         <element name="organizationName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="organizationRole" type="{}OrganizationRoleType"/>
 *         <element name="ownedBy" type="{}Organization"/>
 *         <element name="owns" type="{}Organization"/>
 *         <element name="parentOrganization" type="{}Organization"/>
 *         <element name="partyGLN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="replacedByOrganization" type="{}Organization"/>
 *         <element name="replacedOrganization" type="{}Organization"/>
 *         <element name="responsibleForLocation" type="{}Place"/>
 *         <element name="subOrganization" type="{}Organization"/>
 *         <element name="usesManagedLocation" type="{}Place"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "Organization",
    propOrder = {
      "additionalOrganizationID",
      "additionalOrganizationIdentificationTypeValue",
      "address",
      "afterHoursContact",
      "certification",
      "contactPoint",
      "department",
      "glnType",
      "globalLocationNumber",
      "hasPrimaryLocation",
      "lesseeOf",
      "lessorFor",
      "location",
      "makesOffer",
      "managedBy",
      "manages",
      "occupies",
      "organizationHistory",
      "organizationName",
      "organizationRole",
      "ownedBy",
      "owns",
      "parentOrganization",
      "partyGLN",
      "replacedByOrganization",
      "replacedOrganization",
      "responsibleForLocation",
      "subOrganization",
      "usesManagedLocation"
    })
public class OrganizationXMLImpl
    implements Organization<
        OrganizationIDDetailsXMLImpl,
        PostalAddressXMLImpl,
        ContactPointXMLImpl,
        CertificationDetailsXMLImpl,
        PlaceXMLImpl,
        OrganizationXMLImpl,
        OfferXMLImpl,
        OrganizationStatusHistoryXMLImpl> {

  @XmlElement(required = true)
  protected List<OrganizationIDDetailsXMLImpl> additionalOrganizationID;

  @XmlElement(required = true)
  protected String additionalOrganizationIdentificationTypeValue;

  @XmlElement(required = true)
  protected List<PostalAddressXMLImpl> address;

  @XmlElement(required = true)
  protected List<ContactPointXMLImpl> afterHoursContact;

  @XmlElement(required = true)
  protected CertificationDetailsXMLImpl certification;

  @XmlElement(required = true)
  protected List<ContactPointXMLImpl> contactPoint;

  @XmlElement(required = true)
  protected String department;

  @XmlElement(required = true)
  @XmlSchemaType(name = "string")
  protected GLNTypeCode glnType;

  @XmlElement(required = true)
  protected String globalLocationNumber;

  @XmlElement(required = true)
  protected List<PlaceXMLImpl> hasPrimaryLocation;

  @XmlElement(required = true)
  protected PlaceXMLImpl lesseeOf;

  @XmlElement(required = true)
  protected PlaceXMLImpl lessorFor;

  @XmlElement(required = true)
  protected List<PlaceXMLImpl> location;

  @XmlElement(required = true)
  protected List<OfferXMLImpl> makesOffer;

  @XmlElement(required = true)
  protected OrganizationXMLImpl managedBy;

  @XmlElement(required = true)
  protected List<OrganizationXMLImpl> manages;

  @XmlElement(required = true)
  protected PlaceXMLImpl occupies;

  @XmlElement(required = true)
  protected OrganizationStatusHistoryXMLImpl organizationHistory;

  @XmlElement(required = true)
  protected String organizationName;

  @XmlElement(required = true)
  @XmlSchemaType(name = "string")
  protected OrganizationRoleType organizationRole;

  @XmlElement(required = true)
  protected OrganizationXMLImpl ownedBy;

  @XmlElement(required = true)
  protected List<OrganizationXMLImpl> owns;

  @XmlElement(required = true)
  protected OrganizationXMLImpl parentOrganizationXMLImpl;

  @XmlElement(required = true)
  protected String partyGLN;

  @XmlElement(required = true)
  protected OrganizationXMLImpl replacedByOrganizationXMLImpl;

  @XmlElement(required = true)
  protected OrganizationXMLImpl replacedOrganizationXMLImpl;

  @XmlElement(required = true)
  protected PlaceXMLImpl responsibleForLocation;

  @XmlElement(required = true)
  protected OrganizationXMLImpl subOrganizationXMLImpl;

  @XmlElement(required = true)
  protected PlaceXMLImpl usesManagedLocation;

  /**
   * Gets the value of the additionalOrganizationID property.
   *
   * @return possible object is {@link OrganizationIDDetailsXMLImpl }
   */
  @Override
  public List<OrganizationIDDetailsXMLImpl> getAdditionalOrganizationID() {
    return additionalOrganizationID;
  }

  /**
   * Sets the value of the additionalOrganizationID property.
   *
   * @param value allowed object is {@link OrganizationIDDetailsXMLImpl }
   */
  @Override
  public void setAdditionalOrganizationID(List<OrganizationIDDetailsXMLImpl> value) {
    this.additionalOrganizationID = value;
  }

  /**
   * Gets the value of the additionalOrganizationIdentificationTypeValue property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getAdditionalOrganizationIdentificationTypeValue() {
    return additionalOrganizationIdentificationTypeValue;
  }

  /**
   * Sets the value of the additionalOrganizationIdentificationTypeValue property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setAdditionalOrganizationIdentificationTypeValue(String value) {
    this.additionalOrganizationIdentificationTypeValue = value;
  }

  /**
   * Gets the value of the address property.
   *
   * @return possible object is {@link PostalAddressXMLImpl }
   */
  @Override
  public List<PostalAddressXMLImpl> getAddress() {
    return address;
  }

  /**
   * Sets the value of the address property.
   *
   * @param value allowed object is {@link PostalAddressXMLImpl }
   */
  @Override
  public void setAddress(List<PostalAddressXMLImpl> value) {
    this.address = value;
  }

  /**
   * Gets the value of the afterHoursContact property.
   *
   * @return possible object is {@link ContactPointXMLImpl }
   */
  @Override
  public List<ContactPointXMLImpl> getAfterHoursContact() {
    return afterHoursContact;
  }

  /**
   * Sets the value of the afterHoursContact property.
   *
   * @param value allowed object is {@link ContactPointXMLImpl }
   */
  @Override
  public void setAfterHoursContact(List<ContactPointXMLImpl> value) {
    this.afterHoursContact = value;
  }

  /**
   * Gets the value of the certification property.
   *
   * @return possible object is {@link CertificationDetailsXMLImpl }
   */
  @Override
  public CertificationDetailsXMLImpl getCertification() {
    return certification;
  }

  /**
   * Sets the value of the certification property.
   *
   * @param value allowed object is {@link CertificationDetailsXMLImpl }
   */
  @Override
  public void setCertification(CertificationDetailsXMLImpl value) {
    this.certification = value;
  }

  /**
   * Gets the value of the contactPoint property.
   *
   * @return possible object is {@link ContactPointXMLImpl }
   */
  @Override
  public List<ContactPointXMLImpl> getContactPoint() {
    return contactPoint;
  }

  /**
   * Sets the value of the contactPoint property.
   *
   * @param value allowed object is {@link ContactPointXMLImpl }
   */
  @Override
  public void setContactPoint(List<ContactPointXMLImpl> value) {
    this.contactPoint = value;
  }

  /**
   * Gets the value of the department property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getDepartment() {
    return department;
  }

  /**
   * Sets the value of the department property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setDepartment(String value) {
    this.department = value;
  }

  /**
   * Gets the value of the glnType property.
   *
   * @return possible object is {@link GLNTypeCode }
   */
  @Override
  public GLNTypeCode getGlnType() {
    return glnType;
  }

  /**
   * Sets the value of the glnType property.
   *
   * @param value allowed object is {@link GLNTypeCode }
   */
  @Override
  public void setGlnType(GLNTypeCode value) {
    this.glnType = value;
  }

  /**
   * Gets the value of the globalLocationNumber property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getGlobalLocationNumber() {
    return globalLocationNumber;
  }

  /**
   * Sets the value of the globalLocationNumber property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setGlobalLocationNumber(String value) {
    this.globalLocationNumber = value;
  }

  /**
   * Gets the value of the hasPrimaryLocation property.
   *
   * @return possible object is {@link PlaceXMLImpl }
   */
  @Override
  public List<PlaceXMLImpl> getHasPrimaryLocation() {
    return hasPrimaryLocation;
  }

  /**
   * Sets the value of the hasPrimaryLocation property.
   *
   * @param value allowed object is {@link PlaceXMLImpl }
   */
  @Override
  public void setHasPrimaryLocation(List<PlaceXMLImpl> value) {
    this.hasPrimaryLocation = value;
  }

  /**
   * Gets the value of the lesseeOf property.
   *
   * @return possible object is {@link PlaceXMLImpl }
   */
  @Override
  public PlaceXMLImpl getLesseeOf() {
    return lesseeOf;
  }

  /**
   * Sets the value of the lesseeOf property.
   *
   * @param value allowed object is {@link PlaceXMLImpl }
   */
  @Override
  public void setLesseeOf(PlaceXMLImpl value) {
    this.lesseeOf = value;
  }

  /**
   * Gets the value of the lessorFor property.
   *
   * @return possible object is {@link PlaceXMLImpl }
   */
  @Override
  public PlaceXMLImpl getLessorFor() {
    return lessorFor;
  }

  /**
   * Sets the value of the lessorFor property.
   *
   * @param value allowed object is {@link PlaceXMLImpl }
   */
  @Override
  public void setLessorFor(PlaceXMLImpl value) {
    this.lessorFor = value;
  }

  /**
   * Gets the value of the location property.
   *
   * @return possible object is {@link PlaceXMLImpl }
   */
  @Override
  public List<PlaceXMLImpl> getLocation() {
    return location;
  }

  /**
   * Sets the value of the location property.
   *
   * @param value allowed object is {@link PlaceXMLImpl }
   */
  @Override
  public void setLocation(List<PlaceXMLImpl> value) {
    this.location = value;
  }

  /**
   * Gets the value of the makesOffer property.
   *
   * @return possible object is {@link OfferXMLImpl }
   */
  @Override
  public List<OfferXMLImpl> getMakesOffer() {
    return makesOffer;
  }

  /**
   * Sets the value of the makesOffer property.
   *
   * @param value allowed object is {@link OfferXMLImpl }
   */
  @Override
  public void setMakesOffer(List<OfferXMLImpl> value) {
    this.makesOffer = value;
  }

  /**
   * Gets the value of the managedBy property.
   *
   * @return possible object is {@link OrganizationXMLImpl }
   */
  @Override
  public OrganizationXMLImpl getManagedBy() {
    return managedBy;
  }

  /**
   * Sets the value of the managedBy property.
   *
   * @param value allowed object is {@link OrganizationXMLImpl }
   */
  @Override
  public void setManagedBy(OrganizationXMLImpl value) {
    this.managedBy = value;
  }

  /**
   * Gets the value of the manages property.
   *
   * @return possible object is {@link OrganizationXMLImpl }
   */
  @Override
  public List<OrganizationXMLImpl> getManages() {
    return manages;
  }

  /**
   * Sets the value of the manages property.
   *
   * @param value allowed object is {@link OrganizationXMLImpl }
   */
  @Override
  public void setManages(List<OrganizationXMLImpl> value) {
    this.manages = value;
  }

  /**
   * Gets the value of the occupies property.
   *
   * @return possible object is {@link PlaceXMLImpl }
   */
  @Override
  public PlaceXMLImpl getOccupies() {
    return occupies;
  }

  /**
   * Sets the value of the occupies property.
   *
   * @param value allowed object is {@link PlaceXMLImpl }
   */
  @Override
  public void setOccupies(PlaceXMLImpl value) {
    this.occupies = value;
  }

  /**
   * Gets the value of the organizationHistory property.
   *
   * @return possible object is {@link OrganizationStatusHistoryXMLImpl }
   */
  @Override
  public OrganizationStatusHistoryXMLImpl getOrganizationHistory() {
    return organizationHistory;
  }

  /**
   * Sets the value of the organizationHistory property.
   *
   * @param value allowed object is {@link OrganizationStatusHistoryXMLImpl }
   */
  @Override
  public void setOrganizationHistory(OrganizationStatusHistoryXMLImpl value) {
    this.organizationHistory = value;
  }

  /**
   * Gets the value of the organizationName property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getOrganizationName() {
    return organizationName;
  }

  /**
   * Sets the value of the organizationName property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setOrganizationName(String value) {
    this.organizationName = value;
  }

  /**
   * Gets the value of the organizationRole property.
   *
   * @return possible object is {@link OrganizationRoleType }
   */
  @Override
  public OrganizationRoleType getOrganizationRole() {
    return organizationRole;
  }

  /**
   * Sets the value of the organizationRole property.
   *
   * @param value allowed object is {@link OrganizationRoleType }
   */
  @Override
  public void setOrganizationRole(OrganizationRoleType value) {
    this.organizationRole = value;
  }

  /**
   * Gets the value of the ownedBy property.
   *
   * @return possible object is {@link OrganizationXMLImpl }
   */
  @Override
  public OrganizationXMLImpl getOwnedBy() {
    return ownedBy;
  }

  /**
   * Sets the value of the ownedBy property.
   *
   * @param value allowed object is {@link OrganizationXMLImpl }
   */
  @Override
  public void setOwnedBy(OrganizationXMLImpl value) {
    this.ownedBy = value;
  }

  /**
   * Gets the value of the owns property.
   *
   * @return possible object is {@link OrganizationXMLImpl }
   */
  @Override
  public List<OrganizationXMLImpl> getOwns() {
    return owns;
  }

  /**
   * Sets the value of the owns property.
   *
   * @param value allowed object is {@link OrganizationXMLImpl }
   */
  @Override
  public void setOwns(List<OrganizationXMLImpl> value) {
    this.owns = value;
  }

  /**
   * Gets the value of the parentOrganization property.
   *
   * @return possible object is {@link OrganizationXMLImpl }
   */
  @Override
  public OrganizationXMLImpl getParentOrganization() {
    return parentOrganizationXMLImpl;
  }

  /**
   * Sets the value of the parentOrganization property.
   *
   * @param value allowed object is {@link OrganizationXMLImpl }
   */
  @Override
  public void setParentOrganization(OrganizationXMLImpl value) {
    this.parentOrganizationXMLImpl = value;
  }

  /**
   * Gets the value of the partyGLN property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getPartyGLN() {
    return partyGLN;
  }

  /**
   * Sets the value of the partyGLN property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setPartyGLN(String value) {
    this.partyGLN = value;
  }

  /**
   * Gets the value of the replacedByOrganization property.
   *
   * @return possible object is {@link OrganizationXMLImpl }
   */
  @Override
  public OrganizationXMLImpl getReplacedByOrganization() {
    return replacedByOrganizationXMLImpl;
  }

  /**
   * Sets the value of the replacedByOrganization property.
   *
   * @param value allowed object is {@link OrganizationXMLImpl }
   */
  @Override
  public void setReplacedByOrganization(OrganizationXMLImpl value) {
    this.replacedByOrganizationXMLImpl = value;
  }

  /**
   * Gets the value of the replacedOrganization property.
   *
   * @return possible object is {@link OrganizationXMLImpl }
   */
  @Override
  public OrganizationXMLImpl getReplacedOrganization() {
    return replacedOrganizationXMLImpl;
  }

  /**
   * Sets the value of the replacedOrganization property.
   *
   * @param value allowed object is {@link OrganizationXMLImpl }
   */
  @Override
  public void setReplacedOrganization(OrganizationXMLImpl value) {
    this.replacedOrganizationXMLImpl = value;
  }

  /**
   * Gets the value of the responsibleForLocation property.
   *
   * @return possible object is {@link PlaceXMLImpl }
   */
  @Override
  public PlaceXMLImpl getResponsibleForLocation() {
    return responsibleForLocation;
  }

  /**
   * Sets the value of the responsibleForLocation property.
   *
   * @param value allowed object is {@link PlaceXMLImpl }
   */
  @Override
  public void setResponsibleForLocation(PlaceXMLImpl value) {
    this.responsibleForLocation = value;
  }

  /**
   * Gets the value of the subOrganization property.
   *
   * @return possible object is {@link OrganizationXMLImpl }
   */
  @Override
  public OrganizationXMLImpl getSubOrganization() {
    return subOrganizationXMLImpl;
  }

  /**
   * Sets the value of the subOrganization property.
   *
   * @param value allowed object is {@link OrganizationXMLImpl }
   */
  @Override
  public void setSubOrganization(OrganizationXMLImpl value) {
    this.subOrganizationXMLImpl = value;
  }

  /**
   * Gets the value of the usesManagedLocation property.
   *
   * @return possible object is {@link PlaceXMLImpl }
   */
  @Override
  public PlaceXMLImpl getUsesManagedLocation() {
    return usesManagedLocation;
  }

  /**
   * Sets the value of the usesManagedLocation property.
   *
   * @param value allowed object is {@link PlaceXMLImpl }
   */
  @Override
  public void setUsesManagedLocation(PlaceXMLImpl value) {
    this.usesManagedLocation = value;
  }
}
