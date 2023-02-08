/*
 * Copyright 2022 benelog GmbH & Co. KG
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

import io.openepcis.model.epcis.util.DefaultJsonSchemaNamespaceURIResolver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ExtensionsModifier {
  private final org.w3c.dom.Document document;
  private static final String EMPTY_STRING_CHECKER = "[\\n\\t ]";

  public ExtensionsModifier() throws ParserConfigurationException {
    document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
  }

  public List<Object> Marshalling(Map<String, Object> userExtensions) {
    if (userExtensions == null) {
      return null;
    }

    List<Object> tempElement = new ArrayList<>();

    for (Map.Entry<String, Object> property : userExtensions.entrySet()) {
      final Element root = document.createElement(property.getKey());
      if (property.getValue() instanceof Map) {
        final List<Object> mapElements = Marshalling((Map<String, Object>) property.getValue());
        mapElements.forEach(
            innerChildren -> {
              if (innerChildren instanceof Element
                  && ((Element) innerChildren).getTextContent() != null) {
                root.appendChild(document.appendChild((Element) innerChildren));
              }
            });
        tempElement.add(root);
      } else if (property.getValue() instanceof String) {
        root.setTextContent(((String) property.getValue()));
        tempElement.add(root);
      } else if (property.getValue() instanceof ArrayList) {
        for (Object dupItems : (ArrayList<Object>) property.getValue()) {
          if (dupItems instanceof Map) {
            final Element arrayMap = document.createElement(property.getKey());
            final List<Object> arrayMapElements = Marshalling((Map<String, Object>) dupItems);
            arrayMapElements.forEach(
                mapChildren -> {
                  if (mapChildren instanceof Element
                      && ((Element) mapChildren).getTextContent() != null) {
                    arrayMap.appendChild(document.appendChild((Element) mapChildren));
                  }
                });
            tempElement.add(arrayMap);
          } else if (dupItems instanceof String) {
            final Element arrayString = document.createElement(property.getKey());
            arrayString.setTextContent((String) dupItems);
            tempElement.add(arrayString);
          }
        }
      }
    }
    return tempElement;
  }

  public Map<String, Object> Unmarshalling(List<Object> value) {
    if (value == null) {
      return null;
    }
    Map<String, Object> extensions = new HashMap<>();

    for (Object obj : value) {
      final Element element = (Element) obj;
      final NodeList children = element.getChildNodes();

      DefaultJsonSchemaNamespaceURIResolver.getInstance()
          .namespacePopulater(element.getNamespaceURI(), element.getPrefix());

      // If simple type then directly add text to MAP
      if (children.getLength() == 1
          && !element.getTextContent().replaceAll(EMPTY_STRING_CHECKER, "").equals("")) {
        extensions = extensionPopulate(extensions, element.getNodeName(), element.getTextContent());
      } else if (children.getLength() > 1) {
        // Loop through children elements for complex type of elements
        Map<String, Object> innerExtensions = new HashMap<>();

        for (int i = 0; i < children.getLength(); i++) {
          final Node n = children.item(i);
          if (n.getNodeType() == Node.ELEMENT_NODE) {
            final Element innerElement = (Element) n;
            final NodeList innerChildren = innerElement.getChildNodes();

            DefaultJsonSchemaNamespaceURIResolver.getInstance()
                .namespacePopulater(innerElement.getNamespaceURI(), innerElement.getPrefix());

            if (innerChildren.getLength() == 1
                && !innerElement.getTextContent().replaceAll(EMPTY_STRING_CHECKER, "").equals("")) {
              innerExtensions =
                  extensionPopulate(
                      innerExtensions, innerElement.getNodeName(), innerElement.getTextContent());
            } else if (innerChildren.getLength() > 1) {
              Map<String, Object> complexExtensions =
                  Unmarshalling(
                      new ArrayList<Object>() {
                        {
                          add(n);
                        }
                      });
              innerExtensions =
                  extensionPopulate(
                      innerExtensions,
                      innerElement.getNodeName(),
                      complexExtensions.get(innerElement.getNodeName()));
            }
          }
        }
        extensions = extensionPopulate(extensions, element.getNodeName(), innerExtensions);
      }
    }
    return extensions;
  }

  private Map<String, Object> extensionPopulate(
      Map<String, Object> extensionsPop, String nodeName, Object nodeContent) {
    // Check if MAP already has an entry with respective key
    if (extensionsPop.containsKey(nodeName)) {
      // Check if the MAP values for key is of ArrayList type
      if (extensionsPop.get(nodeName) instanceof ArrayList) {
        // If values are of array type then add current value to existing array
        ((List<Object>) extensionsPop.get(nodeName)).add(nodeContent);
      } else {
        List<Object> values = new ArrayList<>();
        values.add(extensionsPop.get(nodeName));
        values.add(nodeContent);
        extensionsPop.put(nodeName, values);
      }
    } else {
      // If the entry does not exist for the key in Map then add a new entry
      extensionsPop.put(nodeName, nodeContent);
    }
    return extensionsPop;
  }
}
