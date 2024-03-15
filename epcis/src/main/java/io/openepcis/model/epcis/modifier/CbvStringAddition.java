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

public class CbvStringAddition {

  private CbvStringAddition() {}

  private static final String CBV_STRING = "urn:epcglobal:cbv:disp:";
  private static final String CBV_DISP_STRING = ":cbv:disp:";

  public static Object cbvStringConverter(String type, Object input) {

    if (type.equalsIgnoreCase("errorDeclarationReason")) {
      // For error reason add corresponding CBV URN
      final String errorReason = (String) input;
      return errorReason.contains(":cbv:er:") || errorReason.contains("http")
          ? errorReason
          : "urn:epcglobal:cbv:er:" + errorReason;
    } else if (type.equalsIgnoreCase("bizStep")) {
      // For Business Step add corresponding CBV URN
      final String bizStep = (String) input;
      return bizStep.contains(":cbv:bizstep:") || bizStep.contains("http")
          ? bizStep
          : "urn:epcglobal:cbv:bizstep:" + bizStep;
    } else if (type.equalsIgnoreCase("disposition")) {
      // For Disposition add corresponding CBV URN
      final String disposition = (String) input;
      return disposition.contains(CBV_DISP_STRING) || disposition.contains("http")
          ? disposition
          : CBV_STRING + disposition;
    } else if (type.equalsIgnoreCase("persistentDisposition")) {
      final PersistentDisposition persistentDisposition = (PersistentDisposition) input;

      // If Set elements are present then add it to List
      if (persistentDisposition.getSet() != null && !persistentDisposition.getSet().isEmpty()) {
        final List<String> setList = new ArrayList<>();
        persistentDisposition
            .getSet()
            .forEach(
                set -> {
                  final String modifiedSetString =
                      set.contains(CBV_DISP_STRING) || set.contains("http")
                          ? set
                          : CBV_STRING + set;
                  setList.add(modifiedSetString);
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
                  final String modifiedUnsetString =
                      unset.contains(CBV_DISP_STRING) || unset.contains("http")
                          ? unset
                          : CBV_STRING + unset;
                  unsetList.add(modifiedUnsetString);
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
                final String modifiedType =
                    bizTransaction.getType().contains(":cbv:btt:")
                            || bizTransaction.getType().contains("http")
                        ? bizTransaction.getType()
                        : "urn:epcglobal:cbv:btt:" + bizTransaction.getType();
                bizTransaction.setType(modifiedType);
              }
            });
      }

      return bizTransactionList;
    } else {
      return input;
    }
  }
}
