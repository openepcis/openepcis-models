/*
 * Copyright 2022 benelog GmbH & Co. KG
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

/**
 * Constant values used during the execution of both XML-JSON and JSON-XML for comparison of event
 * and validations.
 */
public class Constants {

  public static final String[] EVENT_TYPES =
      new String[] {
        "ObjectEvent",
        "AggregationEvent",
        "TransactionEvent",
        "TransformationEvent",
        "AssociationEvent"
      };
  public static final String[] PROTECTED_TERMS_OF_CONTEXT =
      new String[] {
        "epcis", "cbv", "vtype", "cbvmda", "xsd", "dcterms", "gs1", "xsi", "schemaLocation"
      };
}
