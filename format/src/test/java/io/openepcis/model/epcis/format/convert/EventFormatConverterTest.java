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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.openepcis.model.epcis.Action;
import io.openepcis.model.epcis.AggregationEvent;
import io.openepcis.model.epcis.AssociationEvent;
import io.openepcis.model.epcis.BizLocation;
import io.openepcis.model.epcis.DestinationList;
import io.openepcis.model.epcis.EPCISEvent;
import io.openepcis.model.epcis.ObjectEvent;
import io.openepcis.model.epcis.QuantityList;
import io.openepcis.model.epcis.ReadPoint;
import io.openepcis.model.epcis.SourceList;
import io.openepcis.model.epcis.TransactionEvent;
import io.openepcis.model.epcis.TransformationEvent;
import io.openepcis.model.epcis.format.CBVFormat;
import io.openepcis.model.epcis.format.EPCFormat;
import io.openepcis.model.epcis.format.FormatPreference;
import java.net.URI;
import java.util.List;
import org.junit.jupiter.api.Test;

class EventFormatConverterTest {

  private static final String URN_EPC = "urn:epc:id:sgtin:0614141.107346.2017";
  private static final String URN_CLASS_EPC = "urn:epc:idpat:sgtin:4012345.012345.*";
  private static final String URN_BIZSTEP = "urn:epcglobal:cbv:bizstep:shipping";
  private static final String URN_DISPOSITION = "urn:epcglobal:cbv:disp:in_transit";
  private static final String URN_SDT = "urn:epcglobal:cbv:sdt:owning_party";
  private static final String URN_PARTY = "urn:epc:id:sgln:0614141.00777.0";
  private static final URI READ_POINT = URI.create("urn:epc:id:sgln:0614141.07346.1234");

  private static final FormatPreference DL_WEBURI =
      FormatPreference.getInstance(EPCFormat.Always_GS1_Digital_Link, CBVFormat.Always_Web_URI);
  private static final FormatPreference URN_URN =
      FormatPreference.getInstance(EPCFormat.Always_EPC_URN, CBVFormat.Always_URN);

  // ---------------------------------------------------------------------------------------------

  @Test
  void objectEvent_digitalLinkAndWebUri() {
    final ObjectEvent event =
        ObjectEvent.objectEventBuilder()
            .action(Action.OBSERVE)
            .bizStep(URN_BIZSTEP)
            .disposition(URN_DISPOSITION)
            .epcList(List.of(URN_EPC))
            .readPoint(ReadPoint.builder().id(READ_POINT).build())
            .sourceList(List.of(SourceList.builder().type(URN_SDT).source(URN_PARTY).build()))
            .destinationList(
                List.of(DestinationList.builder().type(URN_SDT).destination(URN_PARTY).build()))
            .quantityList(
                List.of(QuantityList.builder().epcClass(URN_CLASS_EPC).quantity(5f).uom("KGM").build()))
            .build();

    final ObjectEvent dl =
        (ObjectEvent) EventFormatConverter.translate(event, DL_WEBURI, null);
    assertTrue(dl.getEpcList().get(0).startsWith("https://"), "epc should be a Digital Link");
    assertTrue(dl.getEpcList().get(0).contains("/01/"), "DL should contain GTIN AI");
    assertTrue(
        dl.getBizStep().startsWith("https://"), "bizStep should be a web URI: " + dl.getBizStep());
    assertTrue(dl.getDisposition().startsWith("https://"));
    assertTrue(dl.getReadPoint().getId().toString().startsWith("https://"));
    assertTrue(dl.getSourceList().get(0).getType().startsWith("https://"));
    assertTrue(dl.getSourceList().get(0).getSource().startsWith("https://"));
    assertTrue(dl.getDestinationList().get(0).getDestination().startsWith("https://"));
    assertTrue(dl.getQuantityList().get(0).getEpcClass().startsWith("https://"));
    assertEquals(Action.OBSERVE, dl.getAction());

    final ObjectEvent urn = (ObjectEvent) EventFormatConverter.translate(event, URN_URN, null);
    assertEquals(URN_EPC, urn.getEpcList().get(0));
    assertEquals(URN_BIZSTEP, urn.getBizStep());
    assertEquals(URN_DISPOSITION, urn.getDisposition());
    assertEquals(URN_PARTY, urn.getSourceList().get(0).getSource());
    assertEquals(URN_SDT, urn.getSourceList().get(0).getType());
    assertTrue(urn.getReadPoint().getId().toString().startsWith("urn:"));
  }

  @Test
  void aggregationEvent() {
    final AggregationEvent event =
        AggregationEvent.aggregationEventBuilder()
            .action(Action.ADD)
            .bizStep(URN_BIZSTEP)
            .parentID(URN_PARTY)
            .childEPCs(List.of(URN_EPC))
            .build();

    final AggregationEvent dl =
        (AggregationEvent) EventFormatConverter.translate(event, DL_WEBURI, null);
    assertTrue(dl.getParentID().startsWith("https://"));
    assertTrue(dl.getChildEPCs().get(0).startsWith("https://"));
    assertTrue(dl.getBizStep().startsWith("https://"));

    final AggregationEvent urn =
        (AggregationEvent) EventFormatConverter.translate(event, URN_URN, null);
    assertEquals(URN_PARTY, urn.getParentID());
    assertEquals(URN_EPC, urn.getChildEPCs().get(0));
    assertEquals(URN_BIZSTEP, urn.getBizStep());
  }

  @Test
  void associationEvent() {
    final AssociationEvent event =
        AssociationEvent.associationEventBuilder()
            .action(Action.ADD)
            .bizStep(URN_BIZSTEP)
            .parentID(URN_PARTY)
            .childEPCs(List.of(URN_EPC))
            .build();

    final AssociationEvent dl =
        (AssociationEvent) EventFormatConverter.translate(event, DL_WEBURI, null);
    assertTrue(dl.getParentID().startsWith("https://"));
    assertTrue(dl.getChildEPCs().get(0).startsWith("https://"));
    assertTrue(dl.getBizStep().startsWith("https://"));

    final AssociationEvent urn =
        (AssociationEvent) EventFormatConverter.translate(event, URN_URN, null);
    assertEquals(URN_PARTY, urn.getParentID());
    assertEquals(URN_BIZSTEP, urn.getBizStep());
  }

  @Test
  void transactionEvent() {
    final TransactionEvent event =
        TransactionEvent.transactionEventBuilder()
            .action(Action.OBSERVE)
            .bizStep(URN_BIZSTEP)
            .disposition(URN_DISPOSITION)
            .parentID(URN_PARTY)
            .epcList(List.of(URN_EPC))
            .build();

    final TransactionEvent dl =
        (TransactionEvent) EventFormatConverter.translate(event, DL_WEBURI, null);
    assertTrue(dl.getEpcList().get(0).startsWith("https://"));
    assertTrue(dl.getParentID().startsWith("https://"));
    assertTrue(dl.getBizStep().startsWith("https://"));
    assertTrue(dl.getDisposition().startsWith("https://"));

    final TransactionEvent urn =
        (TransactionEvent) EventFormatConverter.translate(event, URN_URN, null);
    assertEquals(URN_EPC, urn.getEpcList().get(0));
    assertEquals(URN_BIZSTEP, urn.getBizStep());
  }

  @Test
  void transformationEvent() {
    final TransformationEvent event =
        TransformationEvent.transformationEventBuilder()
            .bizStep(URN_BIZSTEP)
            .disposition(URN_DISPOSITION)
            .inputEPCList(List.of(URN_EPC))
            .outputEPCList(List.of(URN_EPC))
            .bizLocation(BizLocation.builder().id(READ_POINT).build())
            .transformationID("trans-1")
            .build();

    final TransformationEvent dl =
        (TransformationEvent) EventFormatConverter.translate(event, DL_WEBURI, null);
    assertTrue(dl.getInputEPCList().get(0).startsWith("https://"));
    assertTrue(dl.getOutputEPCList().get(0).startsWith("https://"));
    assertTrue(dl.getBizStep().startsWith("https://"));
    assertTrue(dl.getBizLocation().getId().toString().startsWith("https://"));
    assertEquals("trans-1", dl.getTransformationID());

    final TransformationEvent urn =
        (TransformationEvent) EventFormatConverter.translate(event, URN_URN, null);
    assertEquals(URN_EPC, urn.getInputEPCList().get(0));
    assertEquals(URN_BIZSTEP, urn.getBizStep());
    assertTrue(urn.getBizLocation().getId().toString().startsWith("urn:"));
  }

  @Test
  void nullsArePreserved() {
    final ObjectEvent event =
        ObjectEvent.objectEventBuilder().action(Action.OBSERVE).epcList(List.of(URN_EPC)).build();
    final ObjectEvent dl = (ObjectEvent) EventFormatConverter.translate(event, DL_WEBURI, null);
    assertNotNull(dl);
    // unset CBV/sub-object fields stay null
    org.junit.jupiter.api.Assertions.assertNull(dl.getBizStep());
    org.junit.jupiter.api.Assertions.assertNull(dl.getReadPoint());
    org.junit.jupiter.api.Assertions.assertNull(dl.getSourceList());
  }
}
