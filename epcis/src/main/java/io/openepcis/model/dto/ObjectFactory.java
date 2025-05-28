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
package io.openepcis.model.dto;

import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public final class ObjectFactory {

  private ObjectFactory() {}

  public static EPCISEventResponse createEpcisEventResponse() {
    return new EPCISEventResponse();
  }

  public static CaptureJob createCaptureJob() {
    return new CaptureJob();
  }

  public static CaptureJobPageResult createCaptureJobPageResult() {
    return new CaptureJobPageResult();
  }

  public static InvalidEPCISEventInfo createInvalidEPCISEventInfo() {
    return new InvalidEPCISEventInfo();
  }

  public static TopLevelResource createTopLevelResource() {
    return new TopLevelResource();
  }
}
