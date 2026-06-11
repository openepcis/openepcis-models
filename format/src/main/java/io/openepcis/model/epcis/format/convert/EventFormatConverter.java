/*
 * Copyright 2022-2026 benelog GmbH & Co. KG
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
package io.openepcis.model.epcis.format.convert;

import io.openepcis.model.epcis.AggregationEvent;
import io.openepcis.model.epcis.AssociationEvent;
import io.openepcis.model.epcis.BizLocation;
import io.openepcis.model.epcis.BizTransactionList;
import io.openepcis.model.epcis.DestinationList;
import io.openepcis.model.epcis.EPCISEvent;
import io.openepcis.model.epcis.ErrorDeclaration;
import io.openepcis.model.epcis.ObjectEvent;
import io.openepcis.model.epcis.PersistentDisposition;
import io.openepcis.model.epcis.QuantityList;
import io.openepcis.model.epcis.ReadPoint;
import io.openepcis.model.epcis.SensorElementList;
import io.openepcis.model.epcis.SensorMetadata;
import io.openepcis.model.epcis.SensorReport;
import io.openepcis.model.epcis.SourceList;
import io.openepcis.model.epcis.TransactionEvent;
import io.openepcis.model.epcis.TransformationEvent;
import io.openepcis.model.epcis.constants.CBVUrnPrefix;
import io.openepcis.model.epcis.extension.OpenEPCISExtension;
import io.openepcis.model.epcis.format.CBVFormat;
import io.openepcis.model.epcis.format.EPCFormat;
import io.openepcis.model.epcis.format.FormatPreference;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;

/**
 * Applies a GS1 EPC/CBV {@link FormatPreference} to a public {@link EPCISEvent}, returning a new,
 * translated event instance.
 *
 * <p>Behaviour-preserving port of the proprietary {@code EventConvertor.getESRepresentation(event,
 * new HashMap<>(), context).getCoreModel(preference, context)} round-trip, operating directly on the
 * public model. All value-level EPC/CBV translation is delegated to the package-private primitives
 * {@link IdentifierFormatUtil}, {@link VocabularyFormatUtil} and {@link UserExtensionFormatUtil}.
 *
 * <p>The per-field mapping replicates the concrete subtype renderers (a real event is always a
 * concrete subtype). Notable subtype divergences from the abstract base are preserved, e.g.
 * {@code ObjectEvent} renders {@code errorDeclaration} through the preference path while the other
 * subtypes render it through the context-only ({@code No_Preference}) path.
 */
public final class EventFormatConverter {

  /**
   * Apply a format preference to an event.
   *
   * @param event the source event (a concrete {@code EPCISEvent} subtype)
   * @param preference the EPC/CBV format preference
   * @param context the event's JSON-LD {@code @context}; when {@code null}, the event's own
   *     contextInfo is used
   * @return a new translated event instance
   */
  public EPCISEvent applyFormatPreference(
      final EPCISEvent event, final FormatPreference preference, final List<Object> context) {
    if (event == null) {
      return null;
    }
    final List<Object> ctx = context != null ? context : event.getContextInfo();
    final EPCFormat epcFormat =
        preference.getEpcFormat() != null
            ? preference.getEpcFormat()
            : EPCFormat.Always_GS1_Digital_Link;
    final CBVFormat cbvFormat =
        preference.getCbvFormat() != null ? preference.getCbvFormat() : CBVFormat.No_Preference;

    if (event instanceof AggregationEvent aggregationEvent) {
      return aggregation(aggregationEvent, epcFormat, cbvFormat, ctx);
    } else if (event instanceof AssociationEvent associationEvent) {
      return association(associationEvent, epcFormat, cbvFormat, ctx);
    } else if (event instanceof ObjectEvent objectEvent) {
      return object(objectEvent, epcFormat, cbvFormat, ctx);
    } else if (event instanceof TransformationEvent transformationEvent) {
      return transformation(transformationEvent, epcFormat, cbvFormat, ctx);
    } else if (event instanceof TransactionEvent transactionEvent) {
      return transaction(transactionEvent, epcFormat, cbvFormat, ctx);
    }
    return base(event, epcFormat, cbvFormat, ctx);
  }

  /** Static convenience entry point. */
  public static EPCISEvent translate(
      final EPCISEvent event, final FormatPreference preference, final List<Object> context) {
    return new EventFormatConverter().applyFormatPreference(event, preference, context);
  }

  // ---------------------------------------------------------------------------------------------
  // Concrete subtype renderers
  // ---------------------------------------------------------------------------------------------

  private EPCISEvent object(
      final ObjectEvent e,
      final EPCFormat epcFormat,
      final CBVFormat cbvFormat,
      final List<Object> ctx) {
    return ObjectEvent.objectEventBuilder()
        .eventID(e.getEventID())
        .openEPCISExtension(copyExtension(e))
        .eventTimeZoneOffset(e.getEventTimeZoneOffset())
        .eventTime(e.getEventTime())
        .recordTime(e.getRecordTime())
        .action(e.getAction())
        .bizStep(cbv(e.getBizStep(), cbvFormat, CBVUrnPrefix.BIZSTEP, ctx))
        .disposition(cbv(e.getDisposition(), cbvFormat, CBVUrnPrefix.DISPOSITION, ctx))
        .readPoint(readPoint(e.getReadPoint(), epcFormat, ctx))
        .bizLocation(bizLocation(e.getBizLocation(), epcFormat, ctx))
        .contextInfo(e.getContextInfo())
        .persistentDisposition(persistentDisposition(e.getPersistentDisposition(), cbvFormat, ctx))
        .destinationList(destinationList(e.getDestinationList(), epcFormat, cbvFormat, ctx))
        .sourceList(sourceList(e.getSourceList(), epcFormat, cbvFormat, ctx))
        .sensorElementList(sensorElementList(e.getSensorElementList(), epcFormat, cbvFormat, ctx))
        .quantityList(quantityList(e.getQuantityList(), epcFormat, ctx))
        .epcList(epcList(e.getEpcList(), epcFormat, ctx))
        .bizTransactionList(bizTransactionList(e.getBizTransactionList(), cbvFormat, ctx))
        .ilmd(e.getIlmd())
        .ilmdXml(UserExtensionFormatUtil.translate(e.getIlmdXml(), epcFormat, ctx))
        .certificationInfo(e.getCertificationInfo())
        // ObjectEvent renders errorDeclaration through the preference path (reason = cbvFormat)
        .errorDeclaration(errorDeclaration(e.getErrorDeclaration(), cbvFormat, epcFormat, ctx, true))
        .extension(UserExtensionFormatUtil.translate(e.getExtension(), epcFormat, ctx))
        .userExtensions(UserExtensionFormatUtil.translate(e.getUserExtensions(), epcFormat, ctx))
        .innerUserExtensions(
            UserExtensionFormatUtil.translate(e.getInnerUserExtensions(), epcFormat, ctx))
        .build();
  }

  private EPCISEvent aggregation(
      final AggregationEvent e,
      final EPCFormat epcFormat,
      final CBVFormat cbvFormat,
      final List<Object> ctx) {
    return AggregationEvent.aggregationEventBuilder()
        .eventID(e.getEventID())
        .openEPCISExtension(copyExtension(e))
        .eventTimeZoneOffset(e.getEventTimeZoneOffset())
        .eventTime(e.getEventTime())
        .recordTime(e.getRecordTime())
        .action(e.getAction())
        .bizStep(cbv(e.getBizStep(), cbvFormat, CBVUrnPrefix.BIZSTEP, ctx))
        .disposition(cbv(e.getDisposition(), cbvFormat, CBVUrnPrefix.DISPOSITION, ctx))
        .readPoint(readPoint(e.getReadPoint(), epcFormat, ctx))
        .bizLocation(bizLocation(e.getBizLocation(), epcFormat, ctx))
        // non-Object subtypes render errorDeclaration through the context-only (No_Preference) path
        .errorDeclaration(errorDeclaration(e.getErrorDeclaration(), cbvFormat, epcFormat, ctx, false))
        .contextInfo(e.getContextInfo())
        .destinationList(destinationList(e.getDestinationList(), epcFormat, cbvFormat, ctx))
        .sourceList(sourceList(e.getSourceList(), epcFormat, cbvFormat, ctx))
        .sensorElementList(sensorElementList(e.getSensorElementList(), epcFormat, cbvFormat, ctx))
        .childQuantityList(quantityList(e.getChildQuantityList(), epcFormat, ctx))
        .parentID(epcString(e.getParentID(), epcFormat, ctx))
        .childEPCs(epcList(e.getChildEPCs(), epcFormat, ctx))
        .bizTransactionList(bizTransactionList(e.getBizTransactionList(), cbvFormat, ctx))
        .certificationInfo(e.getCertificationInfo())
        .extension(UserExtensionFormatUtil.translate(e.getExtension(), epcFormat, ctx))
        .userExtensions(UserExtensionFormatUtil.translate(e.getUserExtensions(), epcFormat, ctx))
        .innerUserExtensions(
            UserExtensionFormatUtil.translate(e.getInnerUserExtensions(), epcFormat, ctx))
        .build();
  }

  private EPCISEvent association(
      final AssociationEvent e,
      final EPCFormat epcFormat,
      final CBVFormat cbvFormat,
      final List<Object> ctx) {
    return AssociationEvent.associationEventBuilder()
        .eventID(e.getEventID())
        .openEPCISExtension(copyExtension(e))
        .eventTimeZoneOffset(e.getEventTimeZoneOffset())
        .eventTime(e.getEventTime())
        .recordTime(e.getRecordTime())
        .action(e.getAction())
        .bizStep(cbv(e.getBizStep(), cbvFormat, CBVUrnPrefix.BIZSTEP, ctx))
        .disposition(cbv(e.getDisposition(), cbvFormat, CBVUrnPrefix.DISPOSITION, ctx))
        .readPoint(readPoint(e.getReadPoint(), epcFormat, ctx))
        .bizLocation(bizLocation(e.getBizLocation(), epcFormat, ctx))
        .errorDeclaration(errorDeclaration(e.getErrorDeclaration(), cbvFormat, epcFormat, ctx, false))
        .contextInfo(e.getContextInfo())
        .destinationList(destinationList(e.getDestinationList(), epcFormat, cbvFormat, ctx))
        .sourceList(sourceList(e.getSourceList(), epcFormat, cbvFormat, ctx))
        .sensorElementList(sensorElementList(e.getSensorElementList(), epcFormat, cbvFormat, ctx))
        .childQuantityList(quantityList(e.getChildQuantityList(), epcFormat, ctx))
        .parentID(epcString(e.getParentID(), epcFormat, ctx))
        .childEPCs(epcList(e.getChildEPCs(), epcFormat, ctx))
        .bizTransactionList(bizTransactionList(e.getBizTransactionList(), cbvFormat, ctx))
        .certificationInfo(e.getCertificationInfo())
        .extension(UserExtensionFormatUtil.translate(e.getExtension(), epcFormat, ctx))
        .userExtensions(UserExtensionFormatUtil.translate(e.getUserExtensions(), epcFormat, ctx))
        .innerUserExtensions(
            UserExtensionFormatUtil.translate(e.getInnerUserExtensions(), epcFormat, ctx))
        .build();
  }

  private EPCISEvent transaction(
      final TransactionEvent e,
      final EPCFormat epcFormat,
      final CBVFormat cbvFormat,
      final List<Object> ctx) {
    return TransactionEvent.transactionEventBuilder()
        .eventID(e.getEventID())
        .openEPCISExtension(copyExtension(e))
        .eventTimeZoneOffset(e.getEventTimeZoneOffset())
        .eventTime(e.getEventTime())
        .recordTime(e.getRecordTime())
        .action(e.getAction())
        .bizStep(cbv(e.getBizStep(), cbvFormat, CBVUrnPrefix.BIZSTEP, ctx))
        .disposition(cbv(e.getDisposition(), cbvFormat, CBVUrnPrefix.DISPOSITION, ctx))
        .readPoint(readPoint(e.getReadPoint(), epcFormat, ctx))
        .bizLocation(bizLocation(e.getBizLocation(), epcFormat, ctx))
        .errorDeclaration(errorDeclaration(e.getErrorDeclaration(), cbvFormat, epcFormat, ctx, false))
        .contextInfo(e.getContextInfo())
        .destinationList(destinationList(e.getDestinationList(), epcFormat, cbvFormat, ctx))
        .sourceList(sourceList(e.getSourceList(), epcFormat, cbvFormat, ctx))
        .sensorElementList(sensorElementList(e.getSensorElementList(), epcFormat, cbvFormat, ctx))
        .quantityList(quantityList(e.getQuantityList(), epcFormat, ctx))
        .epcList(epcList(e.getEpcList(), epcFormat, ctx))
        .bizTransactionList(bizTransactionList(e.getBizTransactionList(), cbvFormat, ctx))
        .parentID(epcString(e.getParentID(), epcFormat, ctx))
        .certificationInfo(e.getCertificationInfo())
        .extension(UserExtensionFormatUtil.translate(e.getExtension(), epcFormat, ctx))
        .userExtensions(UserExtensionFormatUtil.translate(e.getUserExtensions(), epcFormat, ctx))
        .innerUserExtensions(
            UserExtensionFormatUtil.translate(e.getInnerUserExtensions(), epcFormat, ctx))
        .build();
  }

  private EPCISEvent transformation(
      final TransformationEvent e,
      final EPCFormat epcFormat,
      final CBVFormat cbvFormat,
      final List<Object> ctx) {
    final OpenEPCISExtension ext = e.getOpenEPCISExtension();
    return TransformationEvent.transformationEventBuilder()
        .eventID(e.getEventID())
        .hash(ext != null ? ext.getHash() : null)
        .captureId(ext != null ? ext.getCaptureID() : null)
        .sequenceInEPCISDoc(
            ext != null && ext.getSequenceInEPCISDoc() != null ? ext.getSequenceInEPCISDoc() : 0)
        .eventTimeZoneOffset(e.getEventTimeZoneOffset())
        .eventTime(e.getEventTime())
        .recordTime(e.getRecordTime())
        .bizStep(cbv(e.getBizStep(), cbvFormat, CBVUrnPrefix.BIZSTEP, ctx))
        .disposition(cbv(e.getDisposition(), cbvFormat, CBVUrnPrefix.DISPOSITION, ctx))
        .readPoint(readPoint(e.getReadPoint(), epcFormat, ctx))
        .bizLocation(bizLocation(e.getBizLocation(), epcFormat, ctx))
        .errorDeclaration(errorDeclaration(e.getErrorDeclaration(), cbvFormat, epcFormat, ctx, false))
        .contextInfo(e.getContextInfo())
        .persistentDisposition(persistentDisposition(e.getPersistentDisposition(), cbvFormat, ctx))
        .destinationList(destinationList(e.getDestinationList(), epcFormat, cbvFormat, ctx))
        .sourceList(sourceList(e.getSourceList(), epcFormat, cbvFormat, ctx))
        .sensorElementList(sensorElementList(e.getSensorElementList(), epcFormat, cbvFormat, ctx))
        .inputEPCList(epcList(e.getInputEPCList(), epcFormat, ctx))
        .outputEPCList(epcList(e.getOutputEPCList(), epcFormat, ctx))
        .inputQuantityList(quantityList(e.getInputQuantityList(), epcFormat, ctx))
        .outputQuantityList(quantityList(e.getOutputQuantityList(), epcFormat, ctx))
        .transformationID(e.getTransformationID())
        .bizTransactionList(bizTransactionList(e.getBizTransactionList(), cbvFormat, ctx))
        .ilmd(e.getIlmd())
        .ilmdXml(UserExtensionFormatUtil.translate(e.getIlmdXml(), epcFormat, ctx))
        .certificationInfo(e.getCertificationInfo())
        .extension(UserExtensionFormatUtil.translate(e.getExtension(), epcFormat, ctx))
        .userExtensions(UserExtensionFormatUtil.translate(e.getUserExtensions(), epcFormat, ctx))
        .innerUserExtensions(
            UserExtensionFormatUtil.translate(e.getInnerUserExtensions(), epcFormat, ctx))
        .build();
  }

  private EPCISEvent base(
      final EPCISEvent e,
      final EPCFormat epcFormat,
      final CBVFormat cbvFormat,
      final List<Object> ctx) {
    // The abstract base passes No_Preference for bizStep/disposition; preserved here.
    return EPCISEvent.builder()
        .eventID(e.getEventID())
        .openEPCISExtension(copyExtension(e))
        .eventTimeZoneOffset(e.getEventTimeZoneOffset())
        .eventTime(e.getEventTime())
        .recordTime(e.getRecordTime())
        .bizStep(cbv(e.getBizStep(), CBVFormat.No_Preference, CBVUrnPrefix.BIZSTEP, ctx))
        .disposition(cbv(e.getDisposition(), CBVFormat.No_Preference, CBVUrnPrefix.DISPOSITION, ctx))
        .readPoint(readPoint(e.getReadPoint(), epcFormat, ctx))
        .bizLocation(bizLocation(e.getBizLocation(), epcFormat, ctx))
        .errorDeclaration(errorDeclaration(e.getErrorDeclaration(), cbvFormat, epcFormat, ctx, false))
        .contextInfo(e.getContextInfo())
        .destinationList(destinationList(e.getDestinationList(), epcFormat, cbvFormat, ctx))
        .sourceList(sourceList(e.getSourceList(), epcFormat, cbvFormat, ctx))
        .sensorElementList(sensorElementList(e.getSensorElementList(), epcFormat, cbvFormat, ctx))
        .certificationInfo(e.getCertificationInfo())
        .extension(UserExtensionFormatUtil.translate(e.getExtension(), epcFormat, ctx))
        .userExtensions(UserExtensionFormatUtil.translate(e.getUserExtensions(), epcFormat, ctx))
        .innerUserExtensions(
            UserExtensionFormatUtil.translate(e.getInnerUserExtensions(), epcFormat, ctx))
        .build();
  }

  // ---------------------------------------------------------------------------------------------
  // Value-level helpers
  // ---------------------------------------------------------------------------------------------

  private static OpenEPCISExtension copyExtension(final EPCISEvent e) {
    final OpenEPCISExtension ext = e.getOpenEPCISExtension();
    return OpenEPCISExtension.builder()
        .hash(ext != null ? ext.getHash() : null)
        .captureID(ext != null ? ext.getCaptureID() : null)
        .sequenceInEPCISDoc(ext != null ? ext.getSequenceInEPCISDoc() : null)
        .build();
  }

  /** CBV value translation (String field). */
  private static String cbv(
      final String captured,
      final CBVFormat cbvFormat,
      final String urnPrefix,
      final List<Object> ctx) {
    if (captured == null || captured.isEmpty()) {
      return captured;
    }
    return VocabularyFormatUtil.translateCbv(captured, cbvFormat, urnPrefix, ctx);
  }

  /** Instance-level EPC value translation for a String field (uriField = false). */
  private static String epcString(
      final String captured, final EPCFormat epcFormat, final List<Object> ctx) {
    if (captured == null || captured.isEmpty()) {
      return captured;
    }
    return IdentifierFormatUtil.translateEpc(captured, epcFormat, ctx, false, false);
  }

  /** Instance-level EPC value translation for a URI field (uriField = true). */
  private static URI epcUri(final URI captured, final EPCFormat epcFormat, final List<Object> ctx) {
    if (captured == null) {
      return null;
    }
    final String translated =
        IdentifierFormatUtil.translateEpc(captured.toString(), epcFormat, ctx, false, true);
    return translated != null ? URI.create(translated) : null;
  }

  private static List<String> epcList(
      final List<String> list, final EPCFormat epcFormat, final List<Object> ctx) {
    if (CollectionUtils.isEmpty(list)) {
      return list;
    }
    return list.stream().map(epc -> epcString(epc, epcFormat, ctx)).collect(Collectors.toList());
  }

  private static List<QuantityList> quantityList(
      final List<QuantityList> list, final EPCFormat epcFormat, final List<Object> ctx) {
    if (CollectionUtils.isEmpty(list)) {
      return null;
    }
    return list.stream()
        .map(
            q ->
                QuantityList.builder()
                    .epcClass(classLevelEpc(q.getEpcClass(), epcFormat, ctx))
                    .quantity(q.getQuantity())
                    .uom(q.getUom())
                    .build())
        .collect(Collectors.toList());
  }

  /** Class-level EPC value translation (uriField = false). */
  private static String classLevelEpc(
      final String captured, final EPCFormat epcFormat, final List<Object> ctx) {
    if (captured == null || captured.isEmpty()) {
      return captured;
    }
    return IdentifierFormatUtil.translateEpc(captured, epcFormat, ctx, true, false);
  }

  private static ReadPoint readPoint(
      final ReadPoint readPoint, final EPCFormat epcFormat, final List<Object> ctx) {
    if (readPoint == null) {
      return null;
    }
    return ReadPoint.builder()
        .id(epcUri(readPoint.getId(), epcFormat, ctx))
        .userExtensions(UserExtensionFormatUtil.translate(readPoint.getUserExtensions(), epcFormat, ctx))
        .innerUserExtensions(
            UserExtensionFormatUtil.translate(readPoint.getInnerUserExtensions(), epcFormat, ctx))
        .build();
  }

  private static BizLocation bizLocation(
      final BizLocation bizLocation, final EPCFormat epcFormat, final List<Object> ctx) {
    if (bizLocation == null) {
      return null;
    }
    return BizLocation.builder()
        .id(epcUri(bizLocation.getId(), epcFormat, ctx))
        .userExtensions(
            UserExtensionFormatUtil.translate(bizLocation.getUserExtensions(), epcFormat, ctx))
        .innerUserExtensions(
            UserExtensionFormatUtil.translate(bizLocation.getInnerUserExtensions(), epcFormat, ctx))
        .build();
  }

  private static List<SourceList> sourceList(
      final List<SourceList> list,
      final EPCFormat epcFormat,
      final CBVFormat cbvFormat,
      final List<Object> ctx) {
    if (CollectionUtils.isEmpty(list)) {
      return null;
    }
    return list.stream()
        .map(
            s ->
                SourceList.builder()
                    .type(cbv(s.getType(), cbvFormat, CBVUrnPrefix.SOURCE_DEST_TYPE, ctx))
                    .source(epcString(s.getSource(), epcFormat, ctx))
                    .build())
        .collect(Collectors.toList());
  }

  private static List<DestinationList> destinationList(
      final List<DestinationList> list,
      final EPCFormat epcFormat,
      final CBVFormat cbvFormat,
      final List<Object> ctx) {
    if (CollectionUtils.isEmpty(list)) {
      return null;
    }
    return list.stream()
        .map(
            d ->
                DestinationList.builder()
                    .type(cbv(d.getType(), cbvFormat, CBVUrnPrefix.SOURCE_DEST_TYPE, ctx))
                    .destination(epcString(d.getDestination(), epcFormat, ctx))
                    .build())
        .collect(Collectors.toList());
  }

  private static List<BizTransactionList> bizTransactionList(
      final List<BizTransactionList> list, final CBVFormat cbvFormat, final List<Object> ctx) {
    if (CollectionUtils.isEmpty(list)) {
      return null;
    }
    return list.stream()
        .map(
            b ->
                BizTransactionList.builder()
                    .type(cbv(b.getType(), cbvFormat, CBVUrnPrefix.BIZTRANSACTION, ctx))
                    .bizTransaction(b.getBizTransaction())
                    .build())
        .collect(Collectors.toList());
  }

  private static PersistentDisposition persistentDisposition(
      final PersistentDisposition pd, final CBVFormat cbvFormat, final List<Object> ctx) {
    if (pd == null) {
      return null;
    }
    return PersistentDisposition.builder()
        .set(cbvStringList(pd.getSet(), cbvFormat, ctx))
        .unset(cbvStringList(pd.getUnset(), cbvFormat, ctx))
        .build();
  }

  private static List<String> cbvStringList(
      final List<String> list, final CBVFormat cbvFormat, final List<Object> ctx) {
    if (CollectionUtils.isEmpty(list)) {
      return list;
    }
    return list.stream()
        .map(v -> cbv(v, cbvFormat, CBVUrnPrefix.DISPOSITION, ctx))
        .collect(Collectors.toList());
  }

  /**
   * @param preferencePath {@code true} for the ObjectEvent path (reason = cbvFormat,
   *     userExtensions translated with the preference EPC format); {@code false} for the
   *     context-only path used by the other subtypes (reason = No_Preference).
   */
  private static ErrorDeclaration errorDeclaration(
      final ErrorDeclaration ed,
      final CBVFormat cbvFormat,
      final EPCFormat epcFormat,
      final List<Object> ctx,
      final boolean preferencePath) {
    if (ed == null) {
      return null;
    }
    final CBVFormat reasonFormat = preferencePath ? cbvFormat : CBVFormat.No_Preference;
    final EPCFormat extFormat = preferencePath ? epcFormat : EPCFormat.No_Preference;
    return ErrorDeclaration.builder()
        .reason(cbv(ed.getReason(), reasonFormat, CBVUrnPrefix.ERROR_REASON, ctx))
        .correctiveEventIDs(ed.getCorrectiveEventIDs())
        .declarationTime(ed.getDeclarationTime())
        .userExtensions(UserExtensionFormatUtil.translate(ed.getUserExtensions(), extFormat, ctx))
        .innerUserExtensions(
            UserExtensionFormatUtil.translate(ed.getInnerUserExtensions(), extFormat, ctx))
        .build();
  }

  private static List<SensorElementList> sensorElementList(
      final List<SensorElementList> list,
      final EPCFormat epcFormat,
      final CBVFormat cbvFormat,
      final List<Object> ctx) {
    if (CollectionUtils.isEmpty(list)) {
      return null;
    }
    return list.stream()
        .map(s -> sensorElement(s, epcFormat, cbvFormat, ctx))
        .collect(Collectors.toList());
  }

  private static SensorElementList sensorElement(
      final SensorElementList s,
      final EPCFormat epcFormat,
      final CBVFormat cbvFormat,
      final List<Object> ctx) {
    return SensorElementList.builder()
        .sensorMetadata(sensorMetadata(s.getSensorMetadata(), epcFormat, ctx))
        .sensorReport(sensorReports(s.getSensorReport(), epcFormat, cbvFormat, ctx))
        .userExtensions(UserExtensionFormatUtil.translate(s.getUserExtensions(), epcFormat, ctx))
        .innerUserExtensions(
            UserExtensionFormatUtil.translate(s.getInnerUserExtensions(), epcFormat, ctx))
        .build();
  }

  private static SensorMetadata sensorMetadata(
      final SensorMetadata m, final EPCFormat epcFormat, final List<Object> ctx) {
    if (m == null) {
      return null;
    }
    return SensorMetadata.builder()
        .time(m.getTime())
        .deviceID(epcUri(m.getDeviceID(), epcFormat, ctx))
        .deviceMetadata(epcUri(m.getDeviceMetadata(), epcFormat, ctx))
        .rawData(epcUri(m.getRawData(), epcFormat, ctx))
        .startTime(m.getStartTime())
        .endTime(m.getEndTime())
        .dataProcessingMethod(m.getDataProcessingMethod())
        .bizRules(m.getBizRules())
        .userExtensions(UserExtensionFormatUtil.translate(m.getUserExtensions(), epcFormat, ctx))
        .innerUserExtensions(
            UserExtensionFormatUtil.translate(m.getInnerUserExtensions(), epcFormat, ctx))
        .build();
  }

  private static List<SensorReport> sensorReports(
      final List<SensorReport> list,
      final EPCFormat epcFormat,
      final CBVFormat cbvFormat,
      final List<Object> ctx) {
    if (CollectionUtils.isEmpty(list)) {
      return null;
    }
    return list.stream()
        .map(r -> sensorReport(r, epcFormat, cbvFormat, ctx))
        .collect(Collectors.toList());
  }

  private static SensorReport sensorReport(
      final SensorReport r,
      final EPCFormat epcFormat,
      final CBVFormat cbvFormat,
      final List<Object> ctx) {
    return SensorReport.builder()
        .type(sensorType(r.getType(), cbvFormat, ctx))
        .exception(r.getException())
        .coordinateReferenceSystem(r.getCoordinateReferenceSystem())
        .deviceID(epcUri(r.getDeviceID(), epcFormat, ctx))
        .deviceMetadata(epcUri(r.getDeviceMetadata(), epcFormat, ctx))
        .rawData(epcUri(r.getRawData(), epcFormat, ctx))
        .dataProcessingMethod(r.getDataProcessingMethod())
        .time(r.getTime())
        .microorganism(r.getMicroorganism())
        .chemicalSubstance(r.getChemicalSubstance())
        .value(r.getValue())
        .component(r.getComponent())
        .stringValue(r.getStringValue())
        .booleanValue(r.getBooleanValue())
        .hexBinaryValue(r.getHexBinaryValue())
        .uriValue(r.getUriValue())
        .minValue(r.getMinValue())
        .maxValue(r.getMaxValue())
        .meanValue(r.getMeanValue())
        .sDev(r.getSDev())
        .percRank(r.getPercRank())
        .percValue(r.getPercValue())
        .uom(r.getUom())
        .bizRules(r.getBizRules())
        .userExtensions(UserExtensionFormatUtil.translate(r.getUserExtensions(), epcFormat, ctx))
        .innerUserExtensions(
            UserExtensionFormatUtil.translate(r.getInnerUserExtensions(), epcFormat, ctx))
        .build();
  }

  private static URI sensorType(
      final URI type, final CBVFormat cbvFormat, final List<Object> ctx) {
    if (type == null) {
      return null;
    }
    final String translated =
        VocabularyFormatUtil.translateCbv(type.toString(), cbvFormat, CBVUrnPrefix.SENSOR_TYPE, ctx);
    return translated != null ? URI.create(translated) : null;
  }

  // package-private no-op to keep the class final-with-public-ctor footprint minimal
}
