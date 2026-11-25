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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.openepcis.constants.EPCIS;
import io.openepcis.model.epcis.MapWrapper;
import io.openepcis.model.epcis.util.ConversionNamespaceContext;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.Marshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * XML -> JSON -> XML for extension elements, through both writers: the event's user extensions
 * ({@link ExtensionsModifier#createXmlElement}) and the adapter used for ilmd and the extension
 * field ({@link CustomExtensionAdapter}, marshalled by MOXy). Nothing of the XML may be lost.
 */
class ExtensionRoundTripTest {

  private static final String REFERENCE_DOCUMENTS = "2.0/EPCIS/XML/Capture/Documents/";
  private static final ObjectMapper JSON = new ObjectMapper();

  @Test
  @DisplayName("text next to a child named value: neither overwrites the other")
  void textAndChildNamedValue() throws Exception {
    final List<Element> extensions =
        extensionsOf("<ex:a xmlns:ex=\"urn:ex\">t<value>u</value></ex:a>");
    final Map<String, Object> read = read(extensions, new ConversionNamespaceContext());
    assertEquals(Map.of("ex:a", Map.of("#text", "t", "value", "u")), read);
    assertRoundTrip(extensions);
  }

  @Test
  @DisplayName("attributes with a child named value and another child: all children are written")
  void attributesWithValueChildAndSibling() throws Exception {
    assertRoundTrip(
        extensionsOf("<ex:a xmlns:ex=\"urn:ex\" id=\"1\"><value>u</value><other>x</other></ex:a>"));
  }

  @Test
  @DisplayName("attributes with only a child named value: the child is not turned into text")
  void attributesWithOnlyValueChild() throws Exception {
    assertRoundTrip(extensionsOf("<ex:a xmlns:ex=\"urn:ex\" id=\"1\"><value>u</value></ex:a>"));
  }

  @Test
  @DisplayName("attributes with text stay attributes with text")
  void attributedText() throws Exception {
    final List<Element> extensions =
        extensionsOf("<ex:w xmlns:ex=\"urn:ex\" unit=\"KGM\">3.5</ex:w>");
    assertEquals(
        Map.of("ex:w", Map.of("@unit", "KGM", "value", "3.5")),
        read(extensions, new ConversionNamespaceContext()));
    assertRoundTrip(extensions);
  }

  @Test
  @DisplayName("text next to other children is not written as a <value> element")
  void textNextToChildren() throws Exception {
    assertRoundTrip(
        extensionsOf("<ex:a xmlns:ex=\"urn:ex\" id=\"1\">t<ex:b>x</ex:b><ex:b>y</ex:b></ex:a>"));
  }

  static Stream<String> referenceDocuments() {
    return Stream.of(
        "AggregationEvent_all_possible_fields.xml",
        "AggregationEvent_with_userExtensions.xml",
        "AssociationEvent_all_possible_fields.xml",
        "AssociationEvent_with_userExtensions.xml",
        "Combination_of_different_event.xml",
        "Namespaces_at_different_level.xml",
        "Namespaces_document_and_event.xml",
        "ObjectEvent_all_possible_fields.xml",
        "ObjectEvent_with_masterDataAvailableFor.xml",
        "ObjectEvent_with_masterDataAvailableFor_deforestation.xml",
        "ObjectEvent_with_masterDataAvailableFor_gs1_webVoc_only.xml",
        "ObjectEvent_with_masterDataAvailableFor_gs1de_webVoc.xml",
        "ObjectEvent_with_masterDataAvailableFor_mixed_voc.xml",
        "ObjectEvent_with_masterDataAvailableFor_very_mixed_voc.xml",
        "ObjectEvent_with_single_element_lists.xml",
        "ObjectEvent_with_userExtensions.xml",
        "SensorData_and_extension.xml",
        "SensorData_with_combined_events.xml",
        "TransactionEvent_all_possible_fields.xml",
        "TransactionEvent_with_userExtensions.xml",
        "TransformationEvent_all_possible_fields.xml",
        "TransformationEvent_with_userExtensions.xml");
  }

  @ParameterizedTest
  @MethodSource("referenceDocuments")
  @DisplayName("extensions of the reference capture documents survive XML -> JSON -> XML")
  void referenceDocument(final String name) throws Exception {
    final Document document;
    try (InputStream in =
        getClass().getClassLoader().getResourceAsStream(REFERENCE_DOCUMENTS + name)) {
      assertNotNull(in, name);
      document = parse(in.readAllBytes());
    }
    // every group of extension elements: the namespaced children of one standard (unqualified)
    // element inside the event list, e.g. an event, its ilmd, readPoint or sensorElement
    final List<List<Element>> groups = new ArrayList<>();
    final NodeList all = document.getElementsByTagName("*");
    for (int i = 0; i < all.getLength(); i++) {
      final Element parent = (Element) all.item(i);
      if (parent.getNamespaceURI() != null || !insideEventList(parent)) {
        continue;
      }
      final List<Element> group = new ArrayList<>();
      for (Node child = parent.getFirstChild(); child != null; child = child.getNextSibling()) {
        if (child instanceof Element element && element.getNamespaceURI() != null) {
          group.add(element);
        }
      }
      if (!group.isEmpty()) {
        groups.add(group);
      }
    }
    assertFalse(groups.isEmpty(), name + " has no extension elements");
    for (final List<Element> group : groups) {
      assertRoundTrip(group);
    }
  }

  private static boolean insideEventList(final Element element) {
    for (Node n = element.getParentNode(); n instanceof Element e; n = e.getParentNode()) {
      if ("EventList".equals(e.getLocalName())) {
        return true;
      }
    }
    return false;
  }

  // ---------------------------------------------------------------------------------------------

  private static void assertRoundTrip(final List<Element> extensions) throws Exception {
    final ConversionNamespaceContext nsContext = new ConversionNamespaceContext();
    final Map<String, Object> read = read(extensions, nsContext);
    // the JSON leg
    final Map<String, Object> json =
        JSON.readValue(JSON.writeValueAsString(read), new TypeReference<LinkedHashMap<String, Object>>() {});
    final String expected = canonical(extensions);

    final List<Element> written = new ArrayList<>();
    for (final Object o : new ExtensionsModifier(nsContext).createXmlElement(json)) {
      written.add((Element) o);
    }
    assertEquals(expected, canonical(written), "user extension writer, JSON was " + json);

    assertEquals(expected, canonical(marshalWithAdapter(json, nsContext)), "CustomExtensionAdapter, JSON was " + json);
  }

  private static Map<String, Object> read(
      final List<Element> extensions, final ConversionNamespaceContext nsContext) {
    return CommonExtensionModifier.unmarshaller(new ArrayList<>(extensions), nsContext);
  }

  private static List<Element> marshalWithAdapter(
      final Map<String, Object> json, final ConversionNamespaceContext nsContext) throws Exception {
    final MapWrapper wrapper = new CustomExtensionAdapter(nsContext).marshal(json);
    final Marshaller marshaller = JAXBContext.newInstance(MapWrapper.class).createMarshaller();
    final StringWriter xml = new StringWriter();
    marshaller.marshal(new JAXBElement<>(new QName("urn:test", "root"), MapWrapper.class, wrapper), xml);
    final Element root = parse(xml.toString().getBytes(StandardCharsets.UTF_8)).getDocumentElement();
    final List<Element> children = new ArrayList<>();
    for (Node child = root.getFirstChild(); child != null; child = child.getNextSibling()) {
      if (child instanceof Element element) {
        children.add(element);
      }
    }
    return children;
  }

  private static List<Element> extensionsOf(final String xml) throws Exception {
    final Element root =
        parse(("<root xmlns:ex=\"urn:ex\">" + xml + "</root>").getBytes(StandardCharsets.UTF_8))
            .getDocumentElement();
    final List<Element> elements = new ArrayList<>();
    for (Node child = root.getFirstChild(); child != null; child = child.getNextSibling()) {
      if (child instanceof Element element) {
        elements.add(element);
      }
    }
    return elements;
  }

  private static Document parse(final byte[] xml) throws Exception {
    final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    return factory.newDocumentBuilder().parse(new ByteArrayInputStream(xml));
  }

  // Namespace URI, local name, attributes (without xmlns and xsi), trimmed text and children, in
  // document order. Prefixes are not compared.
  private static String canonical(final List<Element> elements) {
    final StringBuilder out = new StringBuilder();
    for (final Element element : elements) {
      canonical(element, out);
    }
    return out.toString();
  }

  private static void canonical(final Element element, final StringBuilder out) {
    final String ns = element.getNamespaceURI();
    final String local = element.getLocalName() != null ? element.getLocalName() : element.getNodeName();
    out.append('<').append(ns == null ? "" : "{" + ns + "}").append(local);
    final Map<String, String> attributes = new TreeMap<>();
    final StringBuilder children = new StringBuilder();
    final NamedNodeMap attrs = element.getAttributes();
    for (int i = 0; i < attrs.getLength(); i++) {
      final Node attr = attrs.item(i);
      final String name = attr.getNodeName();
      if (name.equals("xmlns") || name.startsWith("xmlns:")
          || EPCIS.XML_SCHEMA_INSTANCE.equals(attr.getNamespaceURI())) {
        continue;
      }
      if (attr.getNamespaceURI() != null) {
        // The reference pairs map a qualified attribute (example2:assemblyLine="2") to the same
        // JSON key as a child element ("example2:assemblyLine": "2"), so JSON -> XML writes it
        // as a child element. Compare it as one.
        children.append('<').append('{').append(attr.getNamespaceURI()).append('}')
            .append(attr.getLocalName()).append('>').append(normalized(attr.getNodeValue())).append("</>");
        continue;
      }
      attributes.put(name, attr.getNodeValue().trim());
    }
    attributes.forEach((k, v) -> out.append(' ').append(k).append("=\"").append(v).append('"'));
    out.append('>');
    final StringBuilder text = new StringBuilder();
    for (Node child = element.getFirstChild(); child != null; child = child.getNextSibling()) {
      if (child instanceof Element e) {
        canonical(e, children);
      } else if (child.getNodeType() == Node.TEXT_NODE
          || child.getNodeType() == Node.CDATA_SECTION_NODE) {
        text.append(child.getNodeValue());
      }
    }
    out.append(normalized(text.toString())).append(children).append("</>");
  }

  // Typed values (xsi:type xsd:float "20") come back in their Java form ("20.0"): compare numbers
  // by value.
  private static String normalized(final String text) {
    final String trimmed = text.trim();
    try {
      return new java.math.BigDecimal(trimmed).stripTrailingZeros().toPlainString();
    } catch (final NumberFormatException notANumber) {
      return trimmed;
    }
  }
}
