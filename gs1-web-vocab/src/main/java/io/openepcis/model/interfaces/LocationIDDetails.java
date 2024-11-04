package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.LocationIDType;

public interface LocationIDDetails {
    String getLocationID();

    void setLocationID(String value);

    String getLocationIDQualifier();

    void setLocationIDQualifier(String value);

    LocationIDType getLocationIDType();

    void setLocationIDType(LocationIDType value);

    String getLocationIDURI();

    void setLocationIDURI(String value);
}
