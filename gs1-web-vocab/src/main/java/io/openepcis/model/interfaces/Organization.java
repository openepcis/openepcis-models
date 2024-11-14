package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.*;

public interface Organization<OI extends OrganizationIDDetails,PO extends PostalAddress,CP extends ContactPoint,C extends CertificationDetails
        ,P extends Place, O extends Organization,OF extends Offer,OS extends OrganizationStatusHistory> {

    OI getAdditionalOrganizationID();

    void setAdditionalOrganizationID(OI value);

    String getAdditionalOrganizationIdentificationTypeValue();

    void setAdditionalOrganizationIdentificationTypeValue(String value);

    PO getAddress();

    void setAddress(PO value);

    CP getAfterHoursContact();

    void setAfterHoursContact(CP value);

    C getCertification();

    void setCertification(C value);

    CP getContactPoint();

    void setContactPoint(CP value);

    String getDepartment();

    void setDepartment(String value);

    GLNTypeCode getGlnType();

    void setGlnType(GLNTypeCode value);

    String getGlobalLocationNumber();

    void setGlobalLocationNumber(String value);

    P getHasPrimaryLocation();

    void setHasPrimaryLocation(P value);

    P getLesseeOf();

    void setLesseeOf(P value);

    P getLessorFor();

    void setLessorFor(P value);

    P getLocation();

    void setLocation(P value);

    OF getMakesOffer();

    void setMakesOffer(OF value);

    O getManagedBy();

    void setManagedBy(O value);

    O getManages();

    void setManages(O value);

    P getOccupies();

    void setOccupies(P value);

    OS getOrganizationHistory();

    void setOrganizationHistory(OS value);

    String getOrganizationName();

    void setOrganizationName(String value);

    OrganizationRoleType getOrganizationRole();

    void setOrganizationRole(OrganizationRoleType value);

    O getOwnedBy();

    void setOwnedBy(O value);

    O getOwns();

    void setOwns(O value);

    O getParentOrganization();

    void setParentOrganization(O value);

    String getPartyGLN();

    void setPartyGLN(String value);

    O getReplacedByOrganization();

    void setReplacedByOrganization(O value);

    O getReplacedOrganization();

    void setReplacedOrganization(O value);

    P getResponsibleForLocation();

    void setResponsibleForLocation(P value);

    O getSubOrganization();

    void setSubOrganization(O value);

    P getUsesManagedLocation();

    void setUsesManagedLocation(P value);
}
