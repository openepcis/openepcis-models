package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.*;
import java.util.List;

public interface Place<
    L extends LocationIDDetails,
    PO extends PostalAddress,
    C extends ContactPoint,
    P extends Place,
    CD extends CertificationDetails,
    O extends Organization,
    LO extends LocationStatusHistory> {
  List<L> getAdditionalLocationID();

  void setAdditionalLocationID(List<L> value);

  PO getAddress();

  void setAddress(PO value);

  C getAfterHoursContact();

  void setAfterHoursContact(C value);

  P getBaseLocation();

  void setBaseLocation(P value);

  CD getCertification();

  void setCertification(CD value);

  C getContactPoint();

  void setContactPoint(C value);

  P getContainedInPlace();

  void setContainedInPlace(P value);

  P getContainsPlace();

  void setContainsPlace(P value);

  String getDigitalAddress();

  void setDigitalAddress(String value);

  String getDigitalLocationName();

  void setDigitalLocationName(String value);

  P getGeo();

  void setGeo(P value);

  GLNTypeCode getGlnType();

  void setGlnType(GLNTypeCode value);

  String getGlobalLocationNumber();

  void setGlobalLocationNumber(String value);

  O getLeasedFrom();

  void setLeasedFrom(O value);

  O getLeasedTo();

  void setLeasedTo(O value);

  String getLocationGLN();

  void setLocationGLN(String value);

  LO getLocationHistory();

  void setLocationHistory(LO value);

  LocationRoleType getLocationRole();

  void setLocationRole(LocationRoleType value);

  O getManagedBy();

  void setManagedBy(O value);

  O getManagedFor();

  void setManagedFor(O value);

  O getOccupiedBy();

  void setOccupiedBy(O value);

  O getOwnedBy();

  void setOwnedBy(O value);

  String getPhysicalLocationName();

  void setPhysicalLocationName(String value);

  O getPrimaryLocationOf();

  void setPrimaryLocationOf(O value);

  O getRelatedOrganization();

  void setRelatedOrganization(O value);

  P getReplacedByPlace();

  void setReplacedByPlace(P value);

  P getReplacedPlace();

  void setReplacedPlace(P value);

  O getResponsibleOrganization();

  void setResponsibleOrganization(O value);
}
