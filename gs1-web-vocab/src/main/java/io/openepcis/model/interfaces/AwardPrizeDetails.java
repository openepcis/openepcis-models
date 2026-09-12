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

import java.time.Year;
import java.util.LinkedHashMap;

public interface AwardPrizeDetails<C extends Country> {
    String getAwardPrizeCode();

    void setAwardPrizeCode(String value);

    C getAwardPrizeCountryCode();

    void setAwardPrizeCountryCode(C value);

    LinkedHashMap<String, String> getAwardPrizeDescription();

    void setAwardPrizeDescription(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getAwardPrizeJury();

    void setAwardPrizeJury(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getAwardPrizeName();

    void setAwardPrizeName(LinkedHashMap<String, String> value);

    Year getAwardPrizeYear();

    void setAwardPrizeYear(Year value);
}
