/*
 * Copyright 2022-2024 benelog GmbH & Co. KG
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

public class EpcisEventFieldConstants {

  public static final String UOM = "uom";
  public static final String PERC_VALUE = "percValue";
  public static final String PERC_RANK = "percRank";
  public static final String SDEV = "sDev";
  public static final String MEAN_VALUE = "meanValue";
  public static final String MAX_VALUE = "maxValue";
  public static final String MIN_VALUE = "minValue";
  public static final String COMPONENT = "component";
  public static final String VALUE = "value";
  public static final String BOOLEAN_VALUE = "booleanValue";
  public static final String CHEMICAL_SUBSTANCE = "chemicalSubstance";
  public static final String MICROORGANISM = "microorganism";
  public static final String TIME = "time";
  public static final String DATA_PROCESSING_METHOD = "dataProcessingMethod";
  public static final String RAW_DATA = "rawData";
  public static final String DEVICE_METADATA = "deviceMetadata";
  public static final String DEVICE_ID = "deviceID";
  public static final String START_TIME = "startTime";
  public static final String END_TIME = "endTime";
  public static final String EVENT_TIME = "eventTime";
  public static final String SENSOR_ELEMENT_LIST = "sensorElementList";
  public static final String SENSOR_METADATA = "sensorMetadata";
  public static final String SENSOR_REPORT = "sensorReport";
  public static final String QUERY = "query";
  public static final String EPCIS_QUERY = "epcisQuery";
  public static final String EPCIS_BODY = "epcisBody";
  public static final String EVENT_LIST = "eventList";
  public static final String PARAMS = "params";
  public static final String ERROR_DECLARATION = "errorDeclaration";
  public static final String ERRORS = "errors";
  public static final String RUNNING = "running";
  public static final String SUCCESS = "success";
  public static final String CREATED_AT = "createdAt";

  private EpcisEventFieldConstants() {
    // Bunch of constants so there should be a no need to create object for this class
  }
}
