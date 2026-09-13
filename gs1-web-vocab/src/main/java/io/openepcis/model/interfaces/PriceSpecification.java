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

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public interface PriceSpecification<Q extends QuantitativeValue> {
  float getDutyFeeTaxAmount();

  void setDutyFeeTaxAmount(float value);

  LinkedHashMap<String, String> getDutyFeeTaxDescription();

  void setDutyFeeTaxDescription(LinkedHashMap<String, String> value);

  float getDutyFeeTaxRate();

  void setDutyFeeTaxRate(float value);

  Q getEligibleQuantity();

  void setEligibleQuantity(Q value);

  Q getEligibleQuantityMaximum();

  void setEligibleQuantityMaximum(Q value);

  Q getEligibleQuantityMinimum();

  void setEligibleQuantityMinimum(Q value);

  float getMaxPrice();

  void setMaxPrice(float value);

  float getMinPrice();

  void setMinPrice(float value);

  float getPrice();

  void setPrice(float value);

  String getPriceCurrency();

  void setPriceCurrency(String value);

  LocalDateTime getValidFrom();

  void setValidFrom(LocalDateTime value);

  LocalDateTime getValidThrough();

  void setValidThrough(LocalDateTime value);
}
