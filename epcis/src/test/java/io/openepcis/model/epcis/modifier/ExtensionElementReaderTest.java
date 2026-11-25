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
package io.openepcis.model.epcis.modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.openepcis.model.epcis.util.ConversionNamespaceContext;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * XML to JSON for event extensions, checked against the reference pairs in openepcis-test-resources
 * (2.0/EPCIS/{XML,JSON}/Capture/Documents). There an unqualified child of a prefixed extension
 * stays an unprefixed JSON key, and N repeated extension elements are a JSON array of N objects.
 */
class ExtensionElementReaderTest {

  // What JAXB hands EPCISEvent.afterUnmarshal: the namespaced (extension) children of the event,
  // as DOM elements of a namespace-aware parse.
  private static Map<String, Object> userExtensionsOf(final String objectEvent) throws Exception {
    final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setNamespaceAware(true);
    final Document doc =
        dbf.newDocumentBuilder()
            .parse(new ByteArrayInputStream(objectEvent.getBytes(StandardCharsets.UTF_8)));
    final List<Object> anyElements = new ArrayList<>();
    final NodeList children = doc.getDocumentElement().getChildNodes();
    for (int i = 0; i < children.getLength(); i++) {
      if (children.item(i) instanceof Element element && element.getNamespaceURI() != null) {
        anyElements.add(element);
      }
    }
    return new ExtensionsModifier().createObject(anyElements, new ConversionNamespaceContext());
  }

  @Test
  @DisplayName("ObjectEvent_with_masterDataAvailableFor_gs1_webVoc_only: three elements, three objects, unprefixed children")
  void repeatedExtensionElementsStayApart() throws Exception {
    final Map<String, Object> extensions =
        userExtensionsOf(
            """
            <ObjectEvent xmlns:gs1="https://ref.gs1.org/voc/">
              <eventTime>2024-11-22T11:30:00+01:00</eventTime>
              <eventTimeZoneOffset>+01:00</eventTimeZoneOffset>
              <action>ADD</action>
              <gs1:masterDataAvailableFor>
                <id>https://id.gs1.de/01/04012345999969/10/Batch1</id>
                <expirationDate>2024-11-20</expirationDate>
              </gs1:masterDataAvailableFor>
              <gs1:masterDataAvailableFor>
                <id>https://id.example.com/01/04012345123456/10/LOT1</id>
                <expirationDate>2024-11-21</expirationDate>
              </gs1:masterDataAvailableFor>
              <gs1:masterDataAvailableFor>
                <id>https://id.gs1.org/414/4262431780029</id>
                <locationRoleType>BACKROOM</locationRoleType>
              </gs1:masterDataAvailableFor>
            </ObjectEvent>
            """);

    assertEquals(
        Map.of(
            "gs1:masterDataAvailableFor",
            List.of(
                Map.of(
                    "id", "https://id.gs1.de/01/04012345999969/10/Batch1",
                    "expirationDate", "2024-11-20"),
                Map.of(
                    "id", "https://id.example.com/01/04012345123456/10/LOT1",
                    "expirationDate", "2024-11-21"),
                Map.of(
                    "id", "https://id.gs1.org/414/4262431780029",
                    "locationRoleType", "BACKROOM"))),
        extensions);
  }

  @Test
  @DisplayName("ObjectEvent_with_userExtensions: an unqualified child keeps its plain name")
  void unqualifiedChildIsNotGivenTheParentPrefix() throws Exception {
    final Map<String, Object> extensions =
        userExtensionsOf(
            """
            <ObjectEvent xmlns:example="http://ns.example.com/epcis/">
              <eventTime>2005-04-03T20:33:31.116-06:00</eventTime>
              <eventTimeZoneOffset>-06:00</eventTimeZoneOffset>
              <action>OBSERVE</action>
              <example:userElement>
                <anotherElement>elementData</anotherElement>
              </example:userElement>
            </ObjectEvent>
            """);

    assertEquals(
        Map.of("example:userElement", Map.of("anotherElement", "elementData")), extensions);
  }

  @Test
  @DisplayName("ObjectEvent_with_masterDataAvailableFor_very_mixed_voc: qualified, unqualified and nested children")
  void mixedChildren() throws Exception {
    final Map<String, Object> extensions =
        userExtensionsOf(
            """
            <ObjectEvent xmlns:gs1="https://ref.gs1.org/voc/" xmlns:schema="https://schema.org/">
              <eventTime>2024-11-22T11:30:00+01:00</eventTime>
              <eventTimeZoneOffset>+01:00</eventTimeZoneOffset>
              <action>ADD</action>
              <gs1:masterDataAvailableFor>
                <id>https://id.gs1.de/01/04012345999969/10/Batch1</id>
                <expirationDate>2024-11-20</expirationDate>
                <schema:countryOfOrigin>EC</schema:countryOfOrigin>
              </gs1:masterDataAvailableFor>
              <gs1:masterDataAvailableFor>
                <id>https://id.gs1.org/414/4262431780029</id>
                <locationRoleType>BACKROOM</locationRoleType>
                <schema:about>
                  <schema:name>Example Inc.</schema:name>
                </schema:about>
              </gs1:masterDataAvailableFor>
            </ObjectEvent>
            """);

    assertEquals(
        Map.of(
            "gs1:masterDataAvailableFor",
            List.of(
                Map.of(
                    "id", "https://id.gs1.de/01/04012345999969/10/Batch1",
                    "expirationDate", "2024-11-20",
                    "schema:countryOfOrigin", "EC"),
                Map.of(
                    "id", "https://id.gs1.org/414/4262431780029",
                    "locationRoleType", "BACKROOM",
                    "schema:about", Map.of("schema:name", "Example Inc.")))),
        extensions);
  }

  @Test
  @DisplayName("a child repeated inside one element is still a list, and attributes still carry a value")
  void repeatedChildAndAttributedValue() throws Exception {
    final Map<String, Object> extensions =
        userExtensionsOf(
            """
            <ObjectEvent xmlns:example="http://ns.example.com/epcis/">
              <eventTime>2005-04-03T20:33:31.116-06:00</eventTime>
              <eventTimeZoneOffset>-06:00</eventTimeZoneOffset>
              <action>OBSERVE</action>
              <example:list>
                <example:item>1</example:item>
                <example:item>2</example:item>
              </example:list>
              <example:weight unit="KGM">3.5</example:weight>
            </ObjectEvent>
            """);

    assertEquals(
        Map.of(
            "example:list", Map.of("example:item", List.of("1", "2")),
            "example:weight", Map.of("@unit", "KGM", "value", "3.5")),
        extensions);
  }

  @Test
  @DisplayName("an empty extension element stays an empty string, as before")
  void emptyElementIsKept() throws Exception {
    final Map<String, Object> extensions =
        userExtensionsOf(
            """
            <ObjectEvent xmlns:example="http://ns.example.com/epcis/">
              <action>ADD</action>
              <example:flag/>
              <example:wrapper><example:inner/></example:wrapper>
            </ObjectEvent>
            """);
    org.junit.jupiter.api.Assertions.assertEquals("", extensions.get("example:flag"), extensions.toString());
    org.junit.jupiter.api.Assertions.assertEquals(
        Map.of("example:inner", ""), extensions.get("example:wrapper"), extensions.toString());
  }
}
