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
