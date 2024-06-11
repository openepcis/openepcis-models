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
package io.openepcis.quarkus.model;

import io.openepcis.model.epcis.util.EPCISNamespacePrefixMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.eclipse.persistence.jaxb.JAXBContextProperties;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

@ApplicationScoped
public class OpenEPCISJAXBContextProducer {

  /**
   * use static jaxbContext to support generated classes for GraalVM Quarkus native builds
   */
  private static final JAXBContext jaxbContext = createContext();

  private static final AtomicReference<JAXBException> jaxbException = new AtomicReference<>();

  public static final String CONTEXT_PATH = "io.openepcis.model.epcis:io.openepcis.model.epcis.modifier:io.openepcis.model.dto:io.openepcis.model.rest:io.openepcis.core.mocel";

  private static JAXBContext createContext() {
    try {
      return org.eclipse.persistence.jaxb.JAXBContextFactory.createContext(
              CONTEXT_PATH,
              OpenEPCISJAXBContextProducer.class.getClassLoader(),
              new HashMap<>() {
                {
                  put(
                          JAXBContextProperties.NAMESPACE_PREFIX_MAPPER,
                          new EPCISNamespacePrefixMapper());
                }
              });
    } catch (JAXBException e) {
      jaxbException.set(e);
    }
    return null;
  }


  @Produces
  @Singleton
  public JAXBContext createJAXBContext() throws JAXBException {
    if (jaxbException.get() != null) {
      throw jaxbException.get();
    }
    return OpenEPCISJAXBContextProducer.jaxbContext;
  }

}
