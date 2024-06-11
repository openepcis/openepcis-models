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
package io.openepcis.model.epcis;

import io.openepcis.core.model.PaginationSupport;
import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public final class ObjectFactory {

  private ObjectFactory() {}

  // Returns the ObjectEvent
  public static ObjectEvent createObjectEvent() {
    return new ObjectEvent();
  }

  // Returns AggregationEvent
  public static AggregationEvent createAggregationEvent() {
    return new AggregationEvent();
  }

  // Returns TransactionEvent
  public static TransactionEvent createTransactionEvent() {
    return new TransactionEvent();
  }

  // Returns TransformationEvent
  public static TransformationEvent createTransformationEvent() {
    return new TransformationEvent();
  }

  // Returns AssociationEvent
  public static AssociationEvent createAssociationEvent() {
    return new AssociationEvent();
  }

  public static SensorMetadata createSensorMetadata() {
    return new SensorMetadata();
  }

  public static EPCISQueryDocument createEpcisQueryDocument() {
    return new EPCISQueryDocument();
  }

  public static MapWrapper createMapWrapper() { return new MapWrapper();}
}
