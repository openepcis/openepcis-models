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
