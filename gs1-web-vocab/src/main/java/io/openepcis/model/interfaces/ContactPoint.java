package io.openepcis.model.interfaces;

public interface ContactPoint {
  String getAvailableLanguage();

  void setAvailableLanguage(String value);

  String getContactTitle();

  void setContactTitle(String value);

  String getContactType();

  void setContactType(String value);

  String getEmail();

  void setEmail(String value);

  String getFaxNumber();

  void setFaxNumber(String value);

  String getResponsibility();

  void setResponsibility(String value);

  String getTelephone();

  void setTelephone(String value);
}
