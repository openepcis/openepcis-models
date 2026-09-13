/*
 * Copyright 2022-2026 benelog GmbH & Co. KG
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */
package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.GLNTypeCode;
import io.openepcis.model.gs1webvocab.OrganizationRoleType;
import java.util.LinkedHashMap;
import java.util.List;

public interface Organization<
    OI extends OrganizationIDDetails,
    PO extends PostalAddress,
    CP extends ContactPoint,
    C extends CertificationDetails,
    P extends Place,
    O extends Organization,
    OF extends Offer,
    OS extends OrganizationStatusHistory,
    OM extends Manages,
    OO extends Owns> {


  List<OI> getAdditionalOrganizationID();

  void setAdditionalOrganizationID(List<OI> value);

  String getAdditionalOrganizationIdentificationTypeValue();

  void setAdditionalOrganizationIdentificationTypeValue(String value);

  PO getAddress();

  void setAddress(PO value);

  List<CP> getAfterHoursContact();

  void setAfterHoursContact(List<CP> value);

  C getCertification();

  void setCertification(C value);

  List<CP> getContactPoint();

  void setContactPoint(List<CP> value);

  LinkedHashMap<String, String> getDepartment();

  void setDepartment(LinkedHashMap<String, String> value);

  GLNTypeCode getGlnType();

  void setGlnType(GLNTypeCode value);

  String getGlobalLocationNumber();

  void setGlobalLocationNumber(String value);

  List<P> getHasPrimaryLocation();

  void setHasPrimaryLocation(List<P> value);

  P getLesseeOf();

  void setLesseeOf(P value);

  P getLessorFor();

  void setLessorFor(P value);

  List<P> getLocation();

  void setLocation(List<P> value);

  List<OF> getMakesOffer();

  void setMakesOffer(List<OF> value);

  O getManagedBy();

  void setManagedBy(O value);

  OM getManages();

  void setManages(OM value);

  P getOccupies();

  void setOccupies(P value);

  OS getOrganizationHistory();

  void setOrganizationHistory(OS value);

  LinkedHashMap<String, String> getOrganizationName();

  void setOrganizationName(LinkedHashMap<String, String> value);

  OrganizationRoleType getOrganizationRole();

  void setOrganizationRole(OrganizationRoleType value);

  O getOwnedBy();

  void setOwnedBy(O value);

  OO getOwns();

  void setOwns(OO value);

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
