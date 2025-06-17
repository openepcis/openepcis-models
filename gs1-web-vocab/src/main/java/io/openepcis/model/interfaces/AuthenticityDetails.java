package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.SecurityMarking;

import java.util.LinkedHashMap;

public interface AuthenticityDetails {
  LinkedHashMap<String, String> getAuthenticitySecurityFeatureInstructions();

  void setAuthenticitySecurityFeatureInstructions(LinkedHashMap<String, String> value);

  String getAuthenticitySecurityFeatureInstructionsURL();

  void setAuthenticitySecurityFeatureInstructionsURL(String value);

  String getAuthenticitySecurityFeatureRegularExpression();

  void setAuthenticitySecurityFeatureRegularExpression(String value);

  SecurityMarking getAuthenticitySecurityFeatureType();

  void setAuthenticitySecurityFeatureType(SecurityMarking value);

  String getAuthenticitySecurityFeatureValue();

  void setAuthenticitySecurityFeatureValue(String value);
}
