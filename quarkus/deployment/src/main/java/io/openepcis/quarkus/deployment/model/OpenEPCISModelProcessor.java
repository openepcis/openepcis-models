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
package io.openepcis.quarkus.deployment.model;

import io.openepcis.quarkus.model.OpenEPCISJAXBContextProducer;
import io.openepcis.quarkus.model.OpenEPCISModelHealthCheck;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.smallrye.health.deployment.spi.HealthBuildItem;

public class OpenEPCISModelProcessor {

  private static final String FEATURE = "opensearch-epcis-model";


  @BuildStep
  FeatureBuildItem feature() {
    return new FeatureBuildItem(FEATURE);
  }

  @BuildStep()
  AdditionalBeanBuildItem buildOpenEPCISJAXBContext() {
    return AdditionalBeanBuildItem.unremovableOf(OpenEPCISJAXBContextProducer.class);
  }

  @BuildStep
  HealthBuildItem addHealthCheck(OpenEPCISBuildTimeConfig buildTimeConfig) {
    return new HealthBuildItem(OpenEPCISModelHealthCheck.class.getName(),
            buildTimeConfig.healthEnabled);
  }

}
