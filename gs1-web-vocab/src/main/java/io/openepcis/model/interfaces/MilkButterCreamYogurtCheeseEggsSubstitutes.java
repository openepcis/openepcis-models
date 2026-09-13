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

import io.openepcis.model.gs1webvocab.CheeseFirmnessCode;
import io.openepcis.model.gs1webvocab.NonbinaryLogicCode;
import io.openepcis.model.gs1webvocab.SharpnessOfCheeseCode;

import java.util.LinkedHashMap;

public interface MilkButterCreamYogurtCheeseEggsSubstitutes {
  CheeseFirmnessCode getCheeseFirmness();

  void setCheeseFirmness(CheeseFirmnessCode value);

  LinkedHashMap<String, String> getCheeseMaturationPeriodDescription();

  void setCheeseMaturationPeriodDescription(LinkedHashMap<String, String> value);

  float getFatInMilkContent();

  void setFatInMilkContent(float value);

  float getFatpercentageInDryMatter();

  void setFatpercentageInDryMatter(float value);

  NonbinaryLogicCode getIsHomogenised();

  void setIsHomogenised(NonbinaryLogicCode value);

  NonbinaryLogicCode getIsRindEdible();

  void setIsRindEdible(NonbinaryLogicCode value);

  SharpnessOfCheeseCode getSharpnessOfCheese();

  void setSharpnessOfCheese(SharpnessOfCheeseCode value);
}
