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
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.util.*;
import javax.xml.namespace.QName;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CustomExtensionAdapter extends XmlAdapter<MapWrapper, Map<String, Object>> {

  private static final String EMPTY_STRING_CHECKER = "[\\n\\t ]";

  @Override
  public Map<String, Object> unmarshal(MapWrapper value) {
    if (value == null) {
      return Collections.emptyMap();
    }
    // Loop across all elements within ILMD tag
    Map<String, Object> extensions = new HashMap<>();

    for (Object obj : value.getElements()) {

      final org.w3c.dom.Element element = (org.w3c.dom.Element) obj;
      final NodeList children = element.getChildNodes();

      DefaultJsonSchemaNamespaceURIResolver.getInstance()
          .namespacePopulator(element.getNamespaceURI(), element.getPrefix());

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
            final org.w3c.dom.Element innerElement = (org.w3c.dom.Element) n;
            final NodeList innerChildren = innerElement.getChildNodes();

            DefaultJsonSchemaNamespaceURIResolver.getInstance()
                .namespacePopulator(innerElement.getNamespaceURI(), innerElement.getPrefix());

            if (innerChildren.getLength() == 1
                && !innerElement.getTextContent().replaceAll(EMPTY_STRING_CHECKER, "").equals("")) {
              innerExtensions =
                  extensionPopulate(
                      innerExtensions, innerElement.getNodeName(), innerElement.getTextContent());
            } else if (innerChildren.getLength() > 1) {
              MapWrapper wrapper = new MapWrapper();
              List<Object> innerComplexChild =
                  new ArrayList<Object>() {
                    {
                      add(n);
                    }
                  };
              wrapper.setElements(innerComplexChild);
              Map<String, Object> complexExtensions = unmarshal(wrapper);
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

  @Override
  public MapWrapper marshal(Map<String, Object> extensions) {
    if (extensions == null) {
      return null;
    }

    MapWrapper wrapper = new MapWrapper();
    List<Object> elements = new ArrayList<>();

    // Loop through the Extensions MAP
    for (Map.Entry<String, Object> property : extensions.entrySet()) {

      final String localPart = getLocalPart(property.getKey());

      if (getPrefix(property.getKey()) != null
          && DefaultJsonSchemaNamespaceURIResolver.getInstance()
              .namespaceLocator(getPrefix(property.getKey()))
              .isPresent()) {
        final String namespaceURI =
            DefaultJsonSchemaNamespaceURIResolver.getInstance()
                .namespaceLocator(getPrefix(property.getKey()))
                .get();
        final String prefix = getPrefix(property.getKey());

        // If the Value type is MAP then recurse through the loop
        if (property.getValue() instanceof Map) {
          elements.add(
              new JAXBElement<>(
                  new QName(namespaceURI, localPart, prefix),
                  MapWrapper.class,
                  marshal((Map) property.getValue())));
        } else if (property.getValue() instanceof String) {
          // If the Value type is String then directly create JAXBElement
          elements.add(
              new JAXBElement<>(
                  new QName(namespaceURI, localPart, prefix),
                  String.class,
                  property.getValue().toString()));
        } else if (property.getValue() instanceof ArrayList) {
          // If the Value type is ArrayList then it contains Duplicate key values so Loop through it
          for (Object dupItems : (ArrayList<String>) property.getValue()) {
            if (dupItems instanceof Map) {
              elements.add(
                  new JAXBElement<>(
                      new QName(namespaceURI, localPart, prefix),
                      MapWrapper.class,
                      marshal((Map) dupItems)));
            } else {
              elements.add(
                  new JAXBElement<>(
                      new QName(namespaceURI, localPart, prefix),
                      String.class,
                      dupItems.toString()));
            }
          }
        }
      } else {
        // If the Value type is MAP then recurse through the loop
        if (property.getValue() instanceof Map) {
          elements.add(
              new JAXBElement<>(
                  new QName(localPart), MapWrapper.class, marshal((Map) property.getValue())));
        } else if (property.getValue() instanceof String) {
          // If the Value type is String then directly create JAXBElement
          elements.add(
              new JAXBElement<>(
                  new QName(localPart), String.class, property.getValue().toString()));
        } else if (property.getValue() instanceof ArrayList) {
          // If the Value type is ArrayList then it contains Duplicate key values so Loop through it
          for (Object dupItems : (ArrayList<String>) property.getValue()) {
            if (dupItems instanceof Map) {
              elements.add(
                  new JAXBElement<>(
                      new QName(localPart), MapWrapper.class, marshal((Map) dupItems)));
            } else {
              elements.add(
                  new JAXBElement<>(new QName(localPart), String.class, dupItems.toString()));
            }
          }
        }
      }
    }
    wrapper.elements = elements;
    return wrapper;
  }

  // Formats the LocalPart of the XML Tag (after ":")
  private String getLocalPart(String localPart) {
    if (localPart.contains(":")) {
      localPart = localPart.substring(localPart.indexOf(":") + 1);
      return localPart;
    }
    return localPart;
  }

  // Formats the Prefix of the XML Tag (before ":")
  private String getPrefix(String prefix) {
    if (prefix.contains(":")) {
      prefix = prefix.substring(0, prefix.indexOf(":"));
      return prefix;
    }
    return null;
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

class MapWrapper {

  @Getter @Setter @XmlAnyElement List<Object> elements;
}
