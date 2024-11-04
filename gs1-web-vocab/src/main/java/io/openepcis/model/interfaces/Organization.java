package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.*;

public interface Organization {
    OrganizationIDDetails getAdditionalOrganizationID();

    void setAdditionalOrganizationID(OrganizationIDDetails value);

    String getAdditionalOrganizationIdentificationTypeValue();

    void setAdditionalOrganizationIdentificationTypeValue(String value);

    PostalAddressXMLImpl getAddress();

    void setAddress(PostalAddressXMLImpl value);

    ContactPoint getAfterHoursContact();

    void setAfterHoursContact(ContactPoint value);

    CertificationDetailsXMLImpl getCertification();

    void setCertification(CertificationDetailsXMLImpl value);

    ContactPoint getContactPoint();

    void setContactPoint(ContactPoint value);

    String getDepartment();

    void setDepartment(String value);

    GLNTypeCode getGlnType();

    void setGlnType(GLNTypeCode value);

    String getGlobalLocationNumber();

    void setGlobalLocationNumber(String value);

    PlaceXMLImpl getHasPrimaryLocation();

    void setHasPrimaryLocation(PlaceXMLImpl value);

    PlaceXMLImpl getLesseeOf();

    void setLesseeOf(PlaceXMLImpl value);

    PlaceXMLImpl getLessorFor();

    void setLessorFor(PlaceXMLImpl value);

    PlaceXMLImpl getLocation();

    void setLocation(PlaceXMLImpl value);

    OfferXMLImpl getMakesOffer();

    void setMakesOffer(OfferXMLImpl value);

    OrganizationXMLImpl getManagedBy();

    void setManagedBy(OrganizationXMLImpl value);

    OrganizationXMLImpl getManages();

    void setManages(OrganizationXMLImpl value);

    PlaceXMLImpl getOccupies();

    void setOccupies(PlaceXMLImpl value);

    OrganizationStatusHistory getOrganizationHistory();

    void setOrganizationHistory(OrganizationStatusHistory value);

    String getOrganizationName();

    void setOrganizationName(String value);

    OrganizationRoleType getOrganizationRole();

    void setOrganizationRole(OrganizationRoleType value);

    OrganizationXMLImpl getOwnedBy();

    void setOwnedBy(OrganizationXMLImpl value);

    OrganizationXMLImpl getOwns();

    void setOwns(OrganizationXMLImpl value);

    OrganizationXMLImpl getParentOrganization();

    void setParentOrganization(OrganizationXMLImpl value);

    String getPartyGLN();

    void setPartyGLN(String value);

    OrganizationXMLImpl getReplacedByOrganization();

    void setReplacedByOrganization(OrganizationXMLImpl value);

    OrganizationXMLImpl getReplacedOrganization();

    void setReplacedOrganization(OrganizationXMLImpl value);

    PlaceXMLImpl getResponsibleForLocation();

    void setResponsibleForLocation(PlaceXMLImpl value);

    OrganizationXMLImpl getSubOrganization();

    void setSubOrganization(OrganizationXMLImpl value);

    PlaceXMLImpl getUsesManagedLocation();

    void setUsesManagedLocation(PlaceXMLImpl value);
}
