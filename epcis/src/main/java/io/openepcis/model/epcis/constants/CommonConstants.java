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
package io.openepcis.model.epcis.constants;

public class CommonConstants {

  private CommonConstants() {}

  public static final String DOUBLE = "double";
  public static final String BOOLEAN = "boolean";
  public static final String DATE = "date";
  public static final String OBJECT = "object";
  public static final String KEYWORD = "keyword";
  public static final String CAPTURE_ID = "captureID";
  public static final String SEQUENCE_IN_EPCIS_DOC = "sequenceInEPCISDoc";
  public static final String KEY = "key";
  public static final String VALUE = "Value";
  public static final String EXPANDED_KEY = "expandedKey";
  public static final String JSON_LD_USER_EXTENSION_FIELD_SEPARATOR = ":";
  public static final String CONTEXT = "@context";
  public static final String HTTPS_NS_GS_1_ORG_EPCIS_EPCIS_BODY =
      "https://ns.gs1.org/epcis/epcisBody";
  public static final String HTTPS_NS_GS_1_ORG_EPCIS_EVENT_LIST =
      "https://ns.gs1.org/epcis/eventList";
  public static final String JSON_LD_VALUE = "@value";
  public static final String CAPTURE_RESOURCE = "capture/";
  public static final String EVENTS_RESOURCE = "events/";
  public static final String EPCIS_BODY = "epcisBody";
  public static final String EVENT_LIST = "eventList";
  public static final String EPCIS_HEADER = "epcisHeader";
  public static final String EPCIS_DEFAULT_NAMESPACE =
      "https://ref.gs1.org/standards/epcis/2.0.0/epcis-context.jsonld";
  public static final String _SOURCE = "_source";
  public static final String EPCIS_QUERY_DOC = "EPCISQueryDocument";
  public static final String SCHEMA_VERSION = "2.0";
  public static final String GS1_EPCIS_Capture_Limit = "GS1-EPCIS-Capture-Limit";
  public static final String GS1_EPCIS_Capture_File_Size_Limit =
      "GS1-EPCIS-Capture-File-Size-Limit";
  public static final String GS1_Capture_Error_Behaviour = "GS1-Capture-Error-Behaviour";
  public static final String LOCATION = "Location";
  public static final String PROCEED = "proceed";
  public static final String ROLLBACK = "rollback";
  public static final String VALIDATION_FAILED = "Validation failed";
  public static final String CAPTURE_VALIDATION_EXCEPTION = "CaptureValidationException";
  public static final String GS1_EPCIS_VERSION = "GS1-EPCIS-Version";
  public static final String GS1_EPCIS_MIN = "GS1-EPCIS-Min";
  public static final String GS1_EPCIS_MAX = "GS1-EPCIS-Max";
  public static final String GS1_CBV_MIN = "GS1-CBV-Min";
  public static final String GS1_CBV_MAX = "GS1-CBV-Max";
  public static final String GS1_CBV_VERSION = "GS1-CBV-Version";
  public static final String GS1_Vendor_VERSION = "GS1-Vendor-Version";
  public static final String GS1_EPC_FORMAT = "GS1-EPC-Format";
  public static final String GS1_SIGNATURE = "GS1-Signature";
  public static final String ISO8601_TIMESTAMP_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
  public static final String DOCUMENT_TYPE = "DocumentType";
}
