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
