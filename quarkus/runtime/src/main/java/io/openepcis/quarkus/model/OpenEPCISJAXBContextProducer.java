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
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;
import jakarta.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.jaxb.JAXBContextProperties;

import java.util.HashMap;

@ApplicationScoped
@RegisterForReflection(targets = {
        jakarta.xml.bind.JAXBElement.class,
        javax.xml.namespace.QName.class,
        org.eclipse.persistence.asm.ASMFactory.class,
        org.eclipse.persistence.asm.internal.platform.ow2.SerialVersionUIDAdderImpl.class,
        org.eclipse.persistence.asm.internal.platform.ow2.ClassReaderImpl.class,
        org.eclipse.persistence.asm.internal.platform.ow2.FieldVisitorImpl.class,
        org.eclipse.persistence.asm.internal.platform.ow2.AnnotationVisitorImpl.class,
        org.eclipse.persistence.asm.internal.platform.ow2.MethodVisitorImpl.class,
        org.eclipse.persistence.sessions.coordination.jms.JMSPublishingTransportManager.class,
        org.eclipse.persistence.eis.EISLogin.class,
        org.eclipse.persistence.eis.EISPlatform.class,
        org.eclipse.persistence.eis.EISConnectionSpec.class,
        org.eclipse.persistence.internal.databaseaccess.DatasourcePlatform.class,
        org.eclipse.persistence.internal.sessions.coordination.jms.JMSTopicRemoteConnection.class,
        org.eclipse.persistence.sessions.coordination.RemoteCommandManager.class,
        org.eclipse.persistence.sessions.coordination.broadcast.BroadcastTransportManager.class,
        org.eclipse.persistence.sessions.coordination.TransportManager.class,
        org.eclipse.persistence.sessions.DatasourceLogin.class,
        org.eclipse.persistence.internal.sessions.coordination.jms.JMSTopicRemoteConnection.class
})
public class OpenEPCISJAXBContextProducer {

  @Produces
  @Singleton
  public JAXBContext createJAXBContext() throws JAXBException {
    return JAXBContextFactory.createContext(
            "io.openepcis.model.epcis:io.openepcis.model.dto:io.openepcis.model.rest:io.openepcis.model.core",
            Thread.currentThread().getContextClassLoader(),
            new HashMap<>() {
              {
                put(
                        JAXBContextProperties.NAMESPACE_PREFIX_MAPPER,
                        new EPCISNamespacePrefixMapper());
              }
            });
  }

}
