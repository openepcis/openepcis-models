package io.openepcis.model.interfaces;

public interface PostalAddress {
    Country getAddressCountry();

    void setAddressCountry(Country value);

    String getAddressLocality();

    void setAddressLocality(String value);

    String getAddressRegion();

    void setAddressRegion(String value);

    String getAddressSuburb();

    void setAddressSuburb(String value);

    String getCountyCode();

    void setCountyCode(String value);

    String getCrossStreet();

    void setCrossStreet(String value);

    String getOrganizationName();

    void setOrganizationName(String value);

    String getPostOfficeBoxNumber();

    void setPostOfficeBoxNumber(String value);

    String getPostalCode();

    void setPostalCode(String value);

    String getPostalName();

    void setPostalName(String value);

    String getStreetAddress();

    void setStreetAddress(String value);

    String getStreetAddressLine2();

    void setStreetAddressLine2(String value);

    String getStreetAddressLine3();

    void setStreetAddressLine3(String value);

    String getStreetAddressLine4();

    void setStreetAddressLine4(String value);
}
