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

public class QueryParameterConstants {

  public static final String DAY_OF_WEEK = "dayOfWeek";
  public static final String MONTH = "month";
  public static final String DAY_OF_MONTH = "dayOfMonth";
  public static final String SECOND = "second";
  public static final String MINUTE = "minute";
  public static final String HOUR = "hour";
  public static final String PER_PAGE = "perPage";
  public static final String NEXT_PAGE_TOKEN = "nextPageToken";
  public static final String NEXT = "next";
  public static final String REL = "rel";
  public static final String DEST = "dest";
  public static final String SCROLL_ID = "scrollID";
  public static final String SUBSCRIPTION_ID = "subscriptionID";
  public static final String INITIAL_RECORD_TIME = "initialRecordTime";
  public static final String REPORT_IF_EMPTY = "reportIfEmpty";
  public static final String EVENT_COUNT_LIMIT = "eventCountLimit";
  public static final String MAX_EVENT_COUNT = "maxEventCount";
  public static final String ORDERBY = "orderBy";
  public static final String ORDER_DIRECTION = "orderDirection";
  public static final String PARAMETERS = "Parameters";
  public static final String CONTEXT = "@context";

  private QueryParameterConstants() {
    // Bunch of constants so there should be a no need to create object for this class
  }
}
