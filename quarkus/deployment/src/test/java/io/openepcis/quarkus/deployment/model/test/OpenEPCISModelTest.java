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
package io.openepcis.quarkus.deployment.model.test;

import io.openepcis.quarkus.model.OpenEPCISJAXBContextProducer;
import io.quarkus.test.QuarkusUnitTest;
import jakarta.inject.Inject;
import jakarta.xml.bind.JAXBContext;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class OpenEPCISModelTest {

    @RegisterExtension
    static final QuarkusUnitTest TEST = new QuarkusUnitTest()
            .setArchiveProducer(
                    () -> ShrinkWrap.create(JavaArchive.class));

    @Inject
    OpenEPCISJAXBContextProducer openEPCISJAXBContext;

    @Inject
    JAXBContext jaxbContext;


    @Test
    void testOpenSearchClient() throws Exception {
        assertNotNull(openEPCISJAXBContext);
        assertNotNull(jaxbContext);
        assertNotNull(jaxbContext.createMarshaller());
        assertNotNull(jaxbContext.createUnmarshaller());
    }

}
