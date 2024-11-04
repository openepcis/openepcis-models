package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.*;

public interface Place {
    LocationIDDetails getAdditionalLocationID();

    void setAdditionalLocationID(LocationIDDetails value);

    PostalAddressXMLImpl getAddress();

    void setAddress(PostalAddressXMLImpl value);

    ContactPoint getAfterHoursContact();

    void setAfterHoursContact(ContactPoint value);

    PlaceXMLImpl getBaseLocation();

    void setBaseLocation(PlaceXMLImpl value);

    CertificationDetailsXMLImpl getCertification();

    void setCertification(CertificationDetailsXMLImpl value);

    ContactPoint getContactPoint();

    void setContactPoint(ContactPoint value);

    PlaceXMLImpl getContainedInPlace();

    void setContainedInPlace(PlaceXMLImpl value);

    PlaceXMLImpl getContainsPlace();

    void setContainsPlace(PlaceXMLImpl value);

    String getDigitalAddress();

    void setDigitalAddress(String value);

    String getDigitalLocationName();

    void setDigitalLocationName(String value);

    PlaceXMLImpl getGeo();

    void setGeo(PlaceXMLImpl value);

    GLNTypeCode getGlnType();

    void setGlnType(GLNTypeCode value);

    String getGlobalLocationNumber();

    void setGlobalLocationNumber(String value);

    OrganizationXMLImpl getLeasedFrom();

    void setLeasedFrom(OrganizationXMLImpl value);

    OrganizationXMLImpl getLeasedTo();

    void setLeasedTo(OrganizationXMLImpl value);

    String getLocationGLN();

    void setLocationGLN(String value);

    LocationStatusHistory getLocationHistory();

    void setLocationHistory(LocationStatusHistory value);

    String getLocationRole();

    void setLocationRole(String value);

    OrganizationXMLImpl getManagedBy();

    void setManagedBy(OrganizationXMLImpl value);

    OrganizationXMLImpl getManagedFor();

    void setManagedFor(OrganizationXMLImpl value);

    OrganizationXMLImpl getOccupiedBy();

    void setOccupiedBy(OrganizationXMLImpl value);

    OrganizationXMLImpl getOwnedBy();

    void setOwnedBy(OrganizationXMLImpl value);

    String getPhysicalLocationName();

    void setPhysicalLocationName(String value);

    OrganizationXMLImpl getPrimaryLocationOf();

    void setPrimaryLocationOf(OrganizationXMLImpl value);

    OrganizationXMLImpl getRelatedOrganization();

    void setRelatedOrganization(OrganizationXMLImpl value);

    PlaceXMLImpl getReplacedByPlace();

    void setReplacedByPlace(PlaceXMLImpl value);

    PlaceXMLImpl getReplacedPlace();

    void setReplacedPlace(PlaceXMLImpl value);

    OrganizationXMLImpl getResponsibleOrganization();

    void setResponsibleOrganization(OrganizationXMLImpl value);
}
