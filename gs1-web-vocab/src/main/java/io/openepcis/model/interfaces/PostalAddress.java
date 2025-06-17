package io.openepcis.model.interfaces;

import java.util.LinkedHashMap;

public interface PostalAddress<C extends Country> {
    C getAddressCountry();

    void setAddressCountry(C country);

    LinkedHashMap<String, String> getAddressLocality();

    void setAddressLocality(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getAddressRegion();

    void setAddressRegion(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getAddressSuburb();

    void setAddressSuburb(LinkedHashMap<String, String> value);

    String getCountyCode();

    void setCountyCode(String value);

    LinkedHashMap<String, String> getCrossStreet();

    void setCrossStreet(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getOrganizationName();

    void setOrganizationName(LinkedHashMap<String, String> value);

    String getPostOfficeBoxNumber();

    void setPostOfficeBoxNumber(String value);

    String getPostalCode();

    void setPostalCode(String value);

    LinkedHashMap<String, String> getPostalName();

    void setPostalName(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getStreetAddress();

    void setStreetAddress(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getStreetAddressLine2();

    void setStreetAddressLine2(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getStreetAddressLine3();

    void setStreetAddressLine3(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getStreetAddressLine4();

    void setStreetAddressLine4(LinkedHashMap<String, String> value);
}
