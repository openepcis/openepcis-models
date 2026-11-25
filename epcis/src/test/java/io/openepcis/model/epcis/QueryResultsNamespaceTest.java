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
package io.openepcis.model.epcis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

class QueryResultsNamespaceTest {

  @Test
  @DisplayName("QueryResults is marshalled as the global element epcisq:QueryResults")
  void queryResultsIsQualified() throws Exception {
    final EpcisQueryResult result = new EpcisQueryResult(null, "SimpleEventQuery", null, new QueryResultsBody(java.util.List.of()));
    final EPCISQueryDocument document =
        new EPCISQueryDocument(new EPCISQueryBody(result), Optional.empty());

    final Marshaller marshaller = JAXBContext.newInstance(EPCISQueryDocument.class).createMarshaller();
    final StringWriter xml = new StringWriter();
    marshaller.marshal(document, xml);

    final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    final Document dom =
        factory
            .newDocumentBuilder()
            .parse(new ByteArrayInputStream(xml.toString().getBytes(StandardCharsets.UTF_8)));
    final Node queryResults = dom.getElementsByTagNameNS("*", "QueryResults").item(0);
    assertNotNull(queryResults, xml.toString());
    assertEquals("urn:epcglobal:epcis-query:xsd:2", queryResults.getNamespaceURI(), xml.toString());
    // its children stay unqualified, as the schema (elementFormDefault unqualified) defines them
    final Node queryName = dom.getElementsByTagNameNS("*", "queryName").item(0);
    assertEquals(null, queryName.getNamespaceURI(), xml.toString());
  }
}
