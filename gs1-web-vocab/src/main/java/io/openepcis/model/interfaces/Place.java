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
import io.openepcis.model.gs1webvocab.LocationRoleType;

import java.util.LinkedHashMap;
import java.util.List;

public interface Place<
        L extends LocationIDDetails,
        PO extends PostalAddress,
        C extends ContactPoint,
        P extends Place,
        CD extends CertificationDetails,
        O extends Organization,
        LO extends LocationStatusHistory,
        GO extends Geo> {
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

    LinkedHashMap<String, String> getDigitalLocationName();

    void setDigitalLocationName(LinkedHashMap<String, String> value);

    GO getGeo();

    void setGeo(GO value);

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

    LinkedHashMap<String, String> getPhysicalLocationName();

    void setPhysicalLocationName(LinkedHashMap<String, String> value);

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
