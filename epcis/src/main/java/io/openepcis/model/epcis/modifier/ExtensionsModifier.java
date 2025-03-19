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
package io.openepcis.model.epcis.modifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ExtensionsModifier {
  private final Document document;

  public ExtensionsModifier() throws ParserConfigurationException {
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

      final Element rootElement = document.createElement(property.getKey());

      if (property.getValue() instanceof Map) {
        final Map<String, Object> mapPropertyValues = (Map<String, Object>) property.getValue();

        // Attach attributes to the current element based on their property.getValue() if any entry
        // contains @
        addAttributes(mapPropertyValues, rootElement);

        // Recursively add the elements for children/values based on their type
        final List<Object> mapElements = createXmlElement(mapPropertyValues);
        mapElements.forEach(
            innerChildren -> {
              if (innerChildren instanceof Element element && element.getTextContent() != null) {
                rootElement.appendChild(document.appendChild((Element) innerChildren));
              }
            });
        elements.add(rootElement);
      } else if (property.getValue() instanceof ArrayList<?> arrayPropertyValues) {
        for (Object dupItems : arrayPropertyValues) {
          if (dupItems instanceof Map mapElements) {
            final Element arrayElement = document.createElement(property.getKey());

            // Attach attributes to the element based on their values if any entry contains @
            addAttributes(mapElements, arrayElement);

            final List<Object> arrayMapElements = createXmlElement(mapElements);
            arrayMapElements.forEach(
                mapChildren -> {
                  if (mapChildren instanceof Element arrElement
                      && arrElement.getTextContent() != null) {
                    arrayElement.appendChild(document.appendChild((arrElement)));
                  }
                });
            elements.add(arrayElement);
          } else if (dupItems instanceof String stringValue) {
            final Element arrayString = document.createElement(property.getKey());
            arrayString.setTextContent(stringValue);
            elements.add(arrayString);
          }
        }
      } else {
        rootElement.setTextContent(String.valueOf(property.getValue()));
        elements.add(rootElement);
      }
    }
    return elements;
  }

  public Map<String, Object> createObject(final List<Object> value) {
    return CommonExtensionModifier.unmarshaller(value);
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
}
