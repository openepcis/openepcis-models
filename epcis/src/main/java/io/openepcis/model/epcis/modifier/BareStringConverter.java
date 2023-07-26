/*
 * Copyright 2022-2023 benelog GmbH & Co. KG
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
package io.openepcis.model.epcis.modifier;

import io.openepcis.model.epcis.BizTransactionList;
import io.openepcis.model.epcis.PersistentDisposition;
import java.util.ArrayList;
import java.util.List;

public class BareStringConverter {

  private BareStringConverter() {}

  public static Object bareStringConversion(String type, Object input) {
    // Check if input is instance of String
    if (type.equalsIgnoreCase("disposition")
        || type.equalsIgnoreCase("bizStep")
        || type.equalsIgnoreCase("errorDeclarationReason")) {
      return stringConverter(input);
    } else if (type.equalsIgnoreCase("persistentDisposition")) {
      final PersistentDisposition persistentDisposition = (PersistentDisposition) input;

      // If Set elements are present then add it to List
      if (persistentDisposition.getSet() != null && !persistentDisposition.getSet().isEmpty()) {
        final List<String> setList = new ArrayList<>();
        persistentDisposition
            .getSet()
            .forEach(
                set -> {
                  setList.add(stringConverter(set));
                });
        persistentDisposition.setSet(setList);
      }

      // If Unset elements are present then add it to List
      if (persistentDisposition.getUnset() != null && !persistentDisposition.getUnset().isEmpty()) {
        final List<String> unsetList = new ArrayList<>();
        persistentDisposition
            .getUnset()
            .forEach(
                unset -> {
                  unsetList.add(stringConverter(unset));
                });
        persistentDisposition.setUnset(unsetList);
      }
      return persistentDisposition;
    } else if (type.equalsIgnoreCase("bizTransaction")) {
      final List<BizTransactionList> bizTransactionList = (List<BizTransactionList>) input;

      if (bizTransactionList != null && !bizTransactionList.isEmpty()) {
        bizTransactionList.forEach(
            bizTransaction -> {
              if (bizTransaction.getType() != null && bizTransaction.getType() != "") {
                bizTransaction.setType(stringConverter(bizTransaction.getType()));
              }
            });
      }

      return bizTransactionList;
    } else {
      return input;
    }
  }

  private static String stringConverter(Object StringInput) {
    final String inputValue = (String) StringInput;
    // Check if input is URN or Web URI
    if (inputValue.contains(":cbv:")) {
      // If URN then obtain the value after last index of :
      return inputValue.substring(inputValue.lastIndexOf(":") + 1);
    } else if (inputValue.contains("http://") || inputValue.contains("https://")) {
      // If WebURI then obtain the value after last index of /
      return inputValue.substring(inputValue.lastIndexOf("-") + 1);
    } else {
      return inputValue;
    }
  }
}
