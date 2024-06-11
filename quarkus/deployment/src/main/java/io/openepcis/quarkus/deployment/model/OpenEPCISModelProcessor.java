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
import io.quarkus.deployment.builditem.nativeimage.NativeImageConfigBuildItem;
import io.quarkus.deployment.builditem.nativeimage.NativeImageResourcePatternsBuildItem;
import io.quarkus.deployment.builditem.nativeimage.ReflectiveClassBuildItem;
import io.quarkus.logging.Log;
import io.quarkus.smallrye.health.deployment.spi.HealthBuildItem;
import lombok.extern.slf4j.Slf4j;
import org.jboss.logging.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class OpenEPCISModelProcessor {

  private static final String FEATURE = "openepcis-epcis-model";


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

  @BuildStep
  ReflectiveClassBuildItem addReflectiveClass() {
    final Set<String> reflectiveClassNames = new HashSet<>();
    // loop through context paths and read jaxb.index to add all EPCIS Model Classes
    for (String path : OpenEPCISJAXBContextProducer.CONTEXT_PATH.split(":")) {
      final InputStream jaxbIndex = getClass().getResourceAsStream(path.replace('.', '/') + "/jaxb.index");
      if (jaxbIndex != null) {
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(jaxbIndex))) {
          for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            final String className = path + "." + line.trim();
            reflectiveClassNames.add(className);
          }
        } catch (Exception e) {
          Log.log(Logger.Level.ERROR, e.getMessage(), e);
        }
      }
    }
    // add other classes
    Stream.of("jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter",
            "jakarta.xml.bind.annotation.adapters.XmlAdapter",
            "jakarta.xml.bind.annotation.adapters.HexBinaryAdapter",
            "jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter",
            "JAXBElement",
            "QName",
            "ASMFactory",
            "SerialVersionUIDAdderImpl",
            "ClassReaderImpl",
            "FieldVisitorImpl",
            "AnnotationVisitorImpl",
            "MethodVisitorImpl",
            "JMSPublishingTransportManager",
            "EISLogin",
            "EISPlatform",
            "EISConnectionSpec",
            "DatasourcePlatform",
            "JMSTopicRemoteConnection",
            "RemoteCommandManager",
            "BroadcastTransportManager",
            "TransportManager",
            "DatasourceLogin",
            "JMSTopicRemoteConnection"
    ).forEach(reflectiveClassNames::add);

    return ReflectiveClassBuildItem.builder(
                    reflectiveClassNames.toArray(new String[0])
            )
            .constructors()
            .fields()
            .methods()
            .serialization()
            .unsafeAllocated()
            .build();
  }


  @BuildStep
  NativeImageConfigBuildItem addNativeImageConfigBuildItem() {
    final NativeImageConfigBuildItem.Builder builder = NativeImageConfigBuildItem.builder();
    Stream.of(
            "sun.rmi.transport.Transport",
            "sun.rmi.transport.DGCClient",
            "sun.rmi.transport.tcp.TCPEndpoint",
            "java.rmi.server.ObjID",
            "java.security.SecureRandom",
            "sun.rmi.transport.DGCImpl",
            "org.eclipse.persistence.sessions.coordination.jms.JMSPublishingTransportManager",
            "org.eclipse.persistence.internal.sessions.coordination.jms.JMSTopicRemoteConnection",
            "io.netty.handler.codec.compression.ZstdConstants"
    ).forEach(builder::addRuntimeInitializedClass);

    Stream.of(
            "jakarta.xml.bind.Messages",
            "org.eclipse.persistence.exceptions.i18n.BeanValidationExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.CommunicationExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.ConcurrencyExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.ConversionExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.DatabaseExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.DBWSExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.DescriptorExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.DiscoveryExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.EISExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.EntityManagerSetupExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.ExceptionMessageGenerator",
            "org.eclipse.persistence.exceptions.i18n.ExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.JAXBExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.JMSProcessingExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.JPARSExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.JPQLExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.JSONExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.OptimisticLockExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.PersistenceUnitLoadingExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.QueryExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.RemoteCommandManagerExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.SDOExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.ServerPlatformExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.SessionLoaderExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.StaticWeaveExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.TransactionExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.ValidationExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.XMLConversionExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.XMLMarshalExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.XMLParseExceptionResource",
            "org.eclipse.persistence.exceptions.i18n.XMLPlatformExceptionResource",
            "org.eclipse.persistence.internal.localization.i18n.DMSLocalizationResource",
            "org.eclipse.persistence.internal.localization.i18n.EclipseLinkLocalizationResource",
            "org.eclipse.persistence.internal.localization.i18n.ExceptionLocalizationResource",
            "org.eclipse.persistence.internal.localization.i18n.JAXBLocalizationResource",
            "org.eclipse.persistence.internal.localization.i18n.LoggingLocalizationResource",
            "org.eclipse.persistence.internal.localization.i18n.ToStringLocalizationResource",
            "org.eclipse.persistence.internal.localization.i18n.TraceLocalizationResource"
    ).forEach(builder::addResourceBundle);
    return builder.build();
  }

  /*

  @BuildStep
  NativeImageResourceBundleBuildItem addJakartaBindMessages() {
    return new NativeImageResourceBundleBuildItem("jakarta.xml.bind.Messages");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceBeanValidationExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.BeanValidationExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceCommunicationExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.CommunicationExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceConcurrencyExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.ConcurrencyExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceConversionExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.ConversionExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceDatabaseExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.DatabaseExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceDBWSExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.DBWSExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceDescriptorExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.DescriptorExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceDiscoveryExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.DiscoveryExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceEISExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.EISExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceEntityManagerSetupExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.EntityManagerSetupExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceExceptionMessageGenerator() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.ExceptionMessageGenerator");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.ExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceJAXBExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.JAXBExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceJMSProcessingExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.JMSProcessingExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceJPARSExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.JPARSExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceJPQLExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.JPQLExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceJSONExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.JSONExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceOptimisticLockExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.OptimisticLockExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistencePersistenceUnitLoadingExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.PersistenceUnitLoadingExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceQueryExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.QueryExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceRemoteCommandManagerExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.RemoteCommandManagerExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceSDOExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.SDOExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceServerPlatformExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.ServerPlatformExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceSessionLoaderExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.SessionLoaderExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceStaticWeaveExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.StaticWeaveExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceTransactionExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.TransactionExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceValidationExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.ValidationExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceXMLConversionExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.XMLConversionExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceXMLMarshalExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.XMLMarshalExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceXMLParseExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.XMLParseExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceXMLPlatformExceptionResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.exceptions.i18n.XMLPlatformExceptionResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceEclipseLinkLocalizationResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.internal.localization.i18n.EclipseLinkLocalizationResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceDMSLocalizationResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.internal.localization.i18n.DMSLocalizationResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceExceptionLocalizationResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.internal.localization.i18n.ExceptionLocalizationResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceJAXBLocalizationResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.internal.localization.i18n.JAXBLocalizationResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceLoggingLocalizationResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.internal.localization.i18n.LoggingLocalizationResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceToStringLocalizationResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.internal.localization.i18n.ToStringLocalizationResource");
  }

  @BuildStep
  NativeImageResourceBundleBuildItem addEclipsePersistenceTraceLocalizationResource() {
    return new NativeImageResourceBundleBuildItem("org.eclipse.persistence.internal.localization.i18n.TraceLocalizationResource");
  }
*/
  @BuildStep
  NativeImageResourcePatternsBuildItem addNativeImageResourceBuildItem() {
    return NativeImageResourcePatternsBuildItem.builder().includeGlobs(
            "jakarta/**/*.properties",
            "**/jaxb.properties",
            "**/jaxb.index",
            "META-INF/services/.*",
            "META-INF/.*.kotlin_module$"
    ).build();
  }

}
