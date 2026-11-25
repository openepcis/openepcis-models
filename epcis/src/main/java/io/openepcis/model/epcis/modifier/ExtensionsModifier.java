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

import io.openepcis.model.epcis.util.ConversionNamespaceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ExtensionsModifier {
  private final Document document;
  private final ConversionNamespaceContext nsContext;

  public ExtensionsModifier() throws ParserConfigurationException {
    this(null);
  }

  public ExtensionsModifier(ConversionNamespaceContext nsContext) throws ParserConfigurationException {
    this.nsContext = nsContext;
    document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
  }

  /**
   * Method to create XML element during XML -> JSON/JSON-LD conversion for extensions in readPoint,
   * bizLocation, userExtensions in event, sensorElements, etc.
   *
   * @param extensions Map of detected extensions from elements
   * @return returns created XML elements list
   */
  public List<Object> createXmlElement(final Map<String, Object> extensions) {
    // If the extensions are null then return empty list
    if (extensions == null) {
      return Collections.emptyList();
    }

    // List to store all the created Elements based on provided extensions Map
    final List<Object> elements = new ArrayList<>();

    for (final Map.Entry<String, Object> property : extensions.entrySet()) {

      // Skip creation of elements with @ ex: @id as XML Element instead add them as attributes
      // later using addAttributes method
      if (isSpecialAttribute(property.getKey())) {
        continue;
      }

      if (property.getValue() instanceof List<?> arrayPropertyValues) {
        // N elements of the same name
        for (final Object item : arrayPropertyValues) {
          if (item != null) {
            elements.add(createElement(property.getKey(), item));
          }
        }
      } else {
        elements.add(createElement(property.getKey(), property.getValue()));
      }
    }
    return elements;
  }

  // One element: a map gives attributes ("@name"), text (see CommonExtensionModifier.textKey) and
  // child elements, anything else is the text.
  @SuppressWarnings("unchecked")
  private Element createElement(final String name, final Object value) {
    final Element element = createNamespacedElement(name);
    if (value instanceof Map<?, ?> mapValue) {
      final Map<String, Object> content = (Map<String, Object>) mapValue;
      // Attach attributes to the element if any entry contains @
      addAttributes(content, element);
      final String textKey = CommonExtensionModifier.textKey(content);
      final Map<String, Object> children = new LinkedHashMap<>(content);
      if (textKey != null) {
        final Object text = children.remove(textKey);
        if (text != null && !String.valueOf(text).isEmpty()) {
          element.appendChild(document.createTextNode(String.valueOf(text)));
        }
      }
      for (final Object child : createXmlElement(children)) {
        element.appendChild((Element) child);
      }
    } else {
      element.setTextContent(String.valueOf(value));
    }
    return element;
  }

  public Map<String, Object> createObject(final List<Object> value) {
    return createObject(value, null);
  }

  public Map<String, Object> createObject(final List<Object> value, final io.openepcis.model.epcis.util.ConversionNamespaceContext nsContext) {
    return CommonExtensionModifier.unmarshaller(value, nsContext);
  }

  /**
   * Detect if UserExtensions keys that starts with @ such as @id for EmbeddedWebVoc during JSON to
   * XML conversion. If starts with @ then consider them as special
   *
   * @param extensionKey key that needs to be checked before converting to XML
   * @return true if starts with @ else false
   */
  private boolean isSpecialAttribute(final String extensionKey) {
    return extensionKey.startsWith("@");
  }

  // Attach attributes to the current XML element based on their property.getValue() if any entry
  // contains @ ex: @id
  private void addAttributes(final Map<String, Object> propertyValueMap, final Element element) {
    propertyValueMap.entrySet().stream()
        .filter(propEntry -> isSpecialAttribute(propEntry.getKey()))
        .filter(propEntry -> propEntry.getValue() instanceof String)
        .forEach(
            attributeEntry -> {
              final String attributeName = attributeEntry.getKey().substring(1);
              element.setAttribute(attributeName, (String) attributeEntry.getValue());
            });
  }

  /**
   * Creates a DOM Element with proper namespace handling for prefixed element names.
   * For keys like "ext1:name", looks up the namespace URI from the context and uses createElementNS().
   * For keys without a prefix, uses standard createElement().
   *
   * @param qualifiedName the element name, potentially with namespace prefix (e.g., "ext1:name")
   * @return the created DOM Element with proper namespace binding
   */
  private Element createNamespacedElement(final String qualifiedName) {
    // Check if the name contains a prefix (has a colon)
    int colonIndex = qualifiedName.indexOf(':');
    if (colonIndex > 0 && nsContext != null) {
      String prefix = qualifiedName.substring(0, colonIndex);
      // Look up the namespace URI from the context
      return nsContext.findNamespaceByPrefix(prefix)
          .map(namespaceURI -> document.createElementNS(namespaceURI, qualifiedName))
          .orElseGet(() -> document.createElement(qualifiedName));
    }
    return document.createElement(qualifiedName);
  }
}
