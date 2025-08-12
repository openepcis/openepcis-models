package io.openepcis.model.interfaces;

import java.util.LinkedHashMap;

public interface ContactPoint {
    String getAvailableLanguage();

    void setAvailableLanguage(String value);

    LinkedHashMap<String, String> getContactTitle();

    void setContactTitle(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getContactType();

    void setContactType(LinkedHashMap<String, String> value);

    String getEmail();

    void setEmail(String value);

    String getFaxNumber();

    void setFaxNumber(String value);

    LinkedHashMap<String, String> getResponsibility();

    void setResponsibility(LinkedHashMap<String, String> value);

    String getTelephone();

    void setTelephone(String value);
}
