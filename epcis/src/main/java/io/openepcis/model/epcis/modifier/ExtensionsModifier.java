/*
 * Copyright 2022-2023 benelog GmbH & Co. KG
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

  public List<Object> createXmlElement(Map<String, Object> extensions) {
    if (extensions == null) {
      return Collections.emptyList();
    }

    List<Object> elements = new ArrayList<>();

    for (Map.Entry<String, Object> property : extensions.entrySet()) {
      final Element root = document.createElement(property.getKey());

      if (property.getValue() instanceof Map) {
        final List<Object> mapElements =
            createXmlElement((Map<String, Object>) property.getValue());
        mapElements.forEach(
            innerChildren -> {
              if (innerChildren instanceof Element element && element.getTextContent() != null) {
                root.appendChild(document.appendChild((Element) innerChildren));
              }
            });
        elements.add(root);
      } else if (property.getValue() instanceof String string) {
        root.setTextContent(string);
        elements.add(root);
      } else if (property.getValue() instanceof ArrayList arrayList) {
        for (Object dupItems : arrayList) {
          if (dupItems instanceof Map mapElements) {
            final Element arrayMap = document.createElement(property.getKey());
            final List<Object> arrayMapElements = createXmlElement(mapElements);
            arrayMapElements.forEach(
                mapChildren -> {
                  if (mapChildren instanceof Element arrElement
                      && arrElement.getTextContent() != null) {
                    arrayMap.appendChild(document.appendChild((arrElement)));
                  }
                });
            elements.add(arrayMap);
          } else if (dupItems instanceof String stringValue) {
            final Element arrayString = document.createElement(property.getKey());
            arrayString.setTextContent(stringValue);
            elements.add(arrayString);
          }
        }
      }
    }
    return elements;
  }

  public Map<String, Object> createObject(final List<Object> value) {
    return CommonExtensionModifier.unmarshaller(value);
  }
}
