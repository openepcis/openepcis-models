package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.OrganizationIDType;

public interface OrganizationIDDetails {
    String getOrganizationID();

    void setOrganizationID(String value);

    String getOrganizationIDQualifier();

    void setOrganizationIDQualifier(String value);

    OrganizationIDType getOrganizationIDType();

    void setOrganizationIDType(OrganizationIDType value);

    String getOrganizationIDURI();

    void setOrganizationIDURI(String value);
}
