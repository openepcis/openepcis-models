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
package io.openepcis.model.epcis.exception;

public class ExceptionMessages {

  public static final String EPCIS_DOCUMENT_IS_EMPTY = "EPCIS document is empty";
  public static final String ERROR_WHILE_READING_CAPTURE_DOCUMENT =
      "Error while reading capture document";
  public static final String NO_EVENT_FOUND_WITH_EVENT_ID = "No Event Found with EventId: %s";
  public static final String ORIGINAL_ALIAS_NOT_FOUND_FOR_EXPANDED_FIELD =
      "Original Alias not found for expanded " + "field";
  public static final String EXPANDED_JSONLD_DOCUMENT_DOESN_T_CONTAIN_VALID_NAMESPACE =
      "Expanded JSONLD document " + "doesn't contain valid namespace";
  public static final String CONTEXT_INFORMATION_IS_MISSING_FOR_NAME_SPACE_ALIAS =
      "Context Information is missing " + "for namespace alias(es) : ";
  public static final String ERROR_WHILE_PERSISTING_EVENT = "Error while persisting event";
  public static final String ERROR_WHILE_PERSISTING_USER_EXTENSION_FIELDS =
      "Error while persisting user extension " + "fields.";
  public static final String EMPTY_EVENT_CANNOT_BE_SAVED = "Empty event cannot be saved";
  public static final String EMPTY_CAPTURE_BODY_CANNOT_BE_SAVED =
      "Empty capture Body cannot be saved";
  public static final String ERROR_WHILE_PERSISTING_EPCIS_DOCUMENT =
      "Error while persisting EPCIS Document";
  public static final String ERROR_WHILE_VALIDATING_JSONLD_USER_EXTENSION_FIELDS =
      "Error while validating JSONLD " + "User extension fields";
  public static final String INTERRUPTED_WHILE_VALIDATING_JSONLD_USER_EXTENSION_FIELDS =
      "Thread interrupted while validating JSONLD " + "User extension fields";
  public static final String INVALID_VALUE = "Invalid value | %s=%s";
  public static final String INVALID_VALUE_TYPE = "Invalid value type | %s";
  public static final String VALID_ACTION_VALUES =
      "action must be one of 'ADD', 'OBSERVE' or 'DELETE'";
  public static final String INVALID_QUERY_PARAMETER_NAME = "Invalid query param name.";
  public static final String NO_MATCHING_OPERATOR_FOUND = "No matching operator found for : ";
  public static final String INVALID_QUERY_TYPE = "Invalid query type.";
  public static final String VALUE_REQUIRED = "Value required | %s";
  public static final String DUPLICATE_VALUE = "Duplicate value | %s=%s";
  public static final String EPCIS_EXCEPTIONS = "epcisExceptions:";
  public static final String VALIDATION_FAILED = "Validation failed";
  public static final String CAPTURE_VALIDATION_FAILED = "Capture Validation failed";
  public static final String QUERY_PARAMS_NOT_AS_EXPECTED = "Query params not as expected";
  public static final String MAX_EVENT_COUNT_AND_EVENT_COUNT_LIMIT_ARE_MUTUALLY_EXCLUSIVE =
      "maxEventCount and " + "eventCountLimit are mutually exclusive";
  public static final String EVENT_COUNT_LIMIT_MUST_BE_USED_ALONG_WITH_ORDER_BY =
      "eventCountLimit must be used " + "along with orderBy";
  public static final String SEARCH_RESULT_SIZE_TOO_LARGE_NARROW_DOWN_THE_SEARCH_CRITERIA =
      "Search result size too" + " large. Narrow down the search criteria.";
  public static final String ORDERBY_ORDERDIRECTION_MUST_ALWAYS_BE_PAIRED =
      "Parameter orderDirection must always " + "be paired with Parameter orderBy.";
  public static final String QUERY_NAME_MUST = "Query name is required";
  public static final String QUERY_TYPE_MUST = "Query type is required";
  public static final String ERROR_WHILE_PROCESSING_QUERY =
      "Error while processing ElasticSearch query.";
  public static final String ERROR_WHILE_SAVING_QUERY = "Error while persisting epcis-query";
  public static final String NO_QUERY_EXIST_WITH_NAME = "No EPCIS Query exists with the name: ";
  public static final String QUERY_NAME_ALREADY_EXIST = "The specified query name already exists.";
  public static final String ERROR_WHILE_DESERIALIZING_JSON_STRING =
      "Error while deserializing JSON string.";
  public static final String FILE_MISSING =
      "UnitConverter JS file not present in the provided path";
  public static final String ERROR_PROCESSING_JAVASCRIPT_ENGINE =
      "Error in processing script engine for " + "UnitCovertor";
  public static final String ACCESS_DENIED = "Access denied.";
  public static final String
      SENSORELEMENT_PARENT_ELEMENT_SHALL_CONTAIN_ONE_OR_MORE_SENSORREPORT_ELEMENTS =
          "A " + "SENSORELEMENT PARENT ELEMENT SHALL CONTAIN ONE OR MORE SENSORREPORT ELEMENTS";
  public static final String
      IF_MICROORGANISM_IS_PRESENT_SENSORREPORT_ELEMENT_SHALL_NOT_INCLUDE_CHEMICALSUBSTANCE =
          "microorganism and chemicalSubstance cannot be  present simultaneously in a sensorReport element.";
  public static final String SDEV_SHALL_ONLY_BE_USED_IN_CONJUNCTION_WITH_FIELD_MEANVALUE =
      "sDev SHALL only be used" + " in conjunction with the field meanValue.";
  public static final String PERCRANK_SHALL_ONLY_BE_USED_IN_CONJUNCTION_WITH_FIELD_PERCVALUE =
      "percRank SHALL only" + " be used in conjunction with the field percValue and vice-versa.";
  public static final String
      IF_THERE_IS_NO_VALUE_MINVALUE_MAXVALUE_AVERAGEVALUE_OR_PERCVALUE_FIELD_PRESENT_UOM_SHALL_BE_OMITTED =
          "If there is no value, minValue, maxValue, averageValue or percValue field present, uom SHALL be omitted.";
  public static final String TIME_VALUE_SHALL_BE_LESS_THAN_OR_EQUAL_TO_EVENTTIME_VALUE =
      "The %s value SHALL be " + "less than or equal to the eventTime value.";
  public static final String
      IN_SENSORELEMENT_CONTAINER_ATTRIBUTE_SHALL_EITHER_BE_SPECIFIED_IN_SENSORMETADATA_ELEMENT_OR_SENSORREPORT_ELEMENT =
          "In a sensorElement container, inline attribute: %s SHALL either be specified in the sensorMetaData element or in the sensorReport element(s).";
  public static final String STARTTIME_SHALL_BE_LESS_THAN_EVENTTIME =
      "The startTime SHALL be less  than the " + "eventTime value.";
  public static final String STARTTIME_SHALL_BE_LESS_THAN_ENDTIME =
      "The startTime SHALL be less  than the endTime " + "value.";
  public static final String
      IF_COMPONENT_FIELD_IS_PRESENT_SENSORREPORT_ELEMENT_MUST_ALSO_INCLUDE_FLOAT_VALUE_AND_UOM =
          "If a component field is present, a sensorReport element MUST also include a float value and the uom field.";
  public static final String QUERY_PARAMETER_MISSING = "Query parameter missing";
  public static final String QUERY_PARAM_LIST_NOT_AS_EXPECTED =
      "Query parameter list not as expected ";
  public static final String DESTINATION_URL_IS_MUST_TO_SUBSCRIBE_QUERY =
      "Destination URL is must to subscribe " + "query";
  public static final String INVALID_DESTINATION_URL = "Invalid destination URL";
  public static final String INVALID_CRON_EXPRESSION = "Invalid cron expression";
  public static final String ERROR_WHILE_UPDATING_QUERY_SUBSCRIPTION =
      "Error while updating query subscription";
  public static final String PARAMS_ARE_NOT_AS_EXPECTED_BY_NAMED_QUERY =
      "Params are not as expected by the named " + "query";
  public static final String VALUE_FOR_PARAM_NOT_AS_EXPECTED = "Value for param %s not as expected";
  public static final String EXPECTED_DATA_TYPE_FOR_FIELD = "Expected data type for field %s is %s";
  public static final String DUPLICATE_EVENT_CHECK_SKIPPED_FOR_CAPTURE_ID =
      "Due to unexpected response from event "
          + "hash generator, check for duplicate events remains skipped for capture ID: ";
  public static final String NAMESPACE_MISSING_FOR_USER_EXTENSIONS =
      "Namespace missing for user extension fields";
  public static final String SERVER_SIDE_ERROR_OCCURRED = "A server-side error occurred: ";
  public static final String ERROR_WHILE_DELETING_SUBSCRIPTION =
      "error while deleting query subscription";
  public static final String ERROR_WHILE_INVALIDATING_NEXTPAGETOKEN =
      "error while invalidating nextPageToken";
  public static final String NO_SUBSCRIPTION_FOUND = "No subscription found.";
  public static final String RESOURCE_NOT_FOUND = "Resource not found.";
  public static final String NEXT_PAGE_TOKEN_DOES_NOT_EXIST = "NextPageToken[%s] does not exist.";
  public static final String SCHEDULE_IS_MUST_TO_SUBSCRIBE_QUERY =
      "Schedule is must to subscribe query";
  public static final String ERROR_WHILE_FETCHING_RESOURCE = "error while fetching resource";
  public static final String ERROR_WHILE_FETCHING_NEXT_PAGE_RESOURCE =
      "error while fetching next page resource";
  public static final String SUBSCRIPTION_DENIED = "Subscription Denied";
  public static final String INVALID_URI = "Invalid URI";
  public static final String INVALID_SUBSCRIPTION_CONTROL = "Invalid Subscription Control";
  public static final String RESOURCE_DOES_NOT_EXIST = "Resource does not exist.";
  public static final String INVALID_EVENT_TYPE = "Invalid event type.";
  public static final String ERROR_IN_DATA_FORMAT = "Error in data format.";
  public static final String ERROR_WHILE_FETCHING_KEY_VALUE_FROM_ETCD =
      "error while fetching key-value from etcd";
  public static final String ERROR_WHILE_SAVING_KEY_VALUE_FROM_ETCD =
      "error while saving key-value from etcd";
  public static final String ERROR_WHILE_DELETING_KEY_VALUE_FROM_ETCD =
      "error while deleting key-value from etcd";
  public static final String EVENT_TYPE_NOT_ALLOWED_HERE =
      "Query param: eventType not allowed here.";
  public static final String NO_CAPTURE_JOB_FOUND = "No capture job found";
  public static final String NO_CAPTURE_DOCUMENT_FOUND = "No capture document found";
  public static final String CAPTURE_PAYLOAD_TOO_LARGE = "Capture Payload too large";
  public static final String UNSUPPORTED_VERSION_IN_GS1_EPCIS_VERSION =
      "Unsupported version in GS1-EPCIS-version. "
          + "Please refer OPTIONS / endpoint to know supported version.";
  public static final String UNSUPPORTED_VERSION_IN_GS1_EPCIS_MIN =
      "Unsupported version in GS1-EPCIS-min. Please "
          + "refer OPTIONS / endpoint to know supported version.";
  public static final String UNSUPPORTED_VERSION_IN_GS1_EPCIS_MAX =
      "Unsupported version in GS1-EPCIS-max. Please "
          + "refer OPTIONS / endpoint to know supported version.";
  public static final String UNSUPPORTED_VERSION_IN_GS1_CBV_MIN =
      "Unsupported version in GS1-CBV-min. Please "
          + "refer OPTIONS / endpoint to know supported version.";
  public static final String UNSUPPORTED_VERSION_IN_GS1_CBV_MAX =
      "Unsupported version in GS1-CBV-max. Please "
          + "refer OPTIONS / endpoint to know supported version.";
  public static final String UNSUPPORTED_VERSION_IN_GS1_CBV_VERSION =
      "Unsupported version in GS1-CBV-version. "
          + "Please refer OPTIONS / endpoint to know supported version.";
  public static final String SERVER_CANT_RETURN_RESPONSE_AS_EXPECTED =
      "The server cannot return the response as " + "requested.";
  public static final String USER_EXTENSION_CORRESPONDING_TO_NAMESPACE_DOES_NOT_COMPLY_WITH_SCHEMA =
      "User "
          + "extension corresponding to namespace %s does not comply with schema as follows: %s";
  public static final String PREFIX_NAME_ALREADY_MAPPED_TO_NAMESPACE =
      "Prefix name is already mapped to a namespace";
  public static final String NAMESPACE_ALREADY_MAPPED_JSON_SCHEMA =
      "Namespace %s is already mapped to the JSON schema";
  public static final String ERROR_WHILE_CONVERTING_EPC_TO_URN =
      "Error while converting epc to URN";
  public static final String
      NON_ZERO_CONCENTRATION_VALUE_IS_INCOMPATIBLE_WITH_BOOLEANVALUE_FALSE_IN_SENSOR_REPORT =
          "A non-zero concentration value is incompatible with booleanValue=false in sensor report";
  public static final String SUBSCRIPTION_STREAM_AND_SCHEDULE_ARE_MUTUALLY_EXCLUSIVE =
      "Query subscription stream and schedule are mutually exclusive";
  public static final String SIGNATURE_TOKEN_MUST_BE_256BITS_LONG =
      "The signatureToken provided must be at least 256 bits long";

  private ExceptionMessages() {
    // Bunch of constants so there should be no need to create object of this class
  }
}
