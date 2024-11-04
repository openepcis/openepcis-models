package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.SecurityMarking;

public interface AuthenticityDetails {
    String getAuthenticitySecurityFeatureInstructions();

    void setAuthenticitySecurityFeatureInstructions(String value);

    String getAuthenticitySecurityFeatureInstructionsURL();

    void setAuthenticitySecurityFeatureInstructionsURL(String value);

    String getAuthenticitySecurityFeatureRegularExpression();

    void setAuthenticitySecurityFeatureRegularExpression(String value);

    SecurityMarking getAuthenticitySecurityFeatureType();

    void setAuthenticitySecurityFeatureType(SecurityMarking value);

    String getAuthenticitySecurityFeatureValue();

    void setAuthenticitySecurityFeatureValue(String value);
}
