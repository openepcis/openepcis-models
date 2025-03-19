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

import static io.openepcis.constants.EPCIS.EPCIS_DEFAULT_NAMESPACES;
import static io.openepcis.constants.EPCIS.PROTECTED_NAMESPACE_OF_CONTEXT;

import io.openepcis.model.epcis.util.DefaultJsonSchemaNamespaceURIResolver;
import java.util.*;
import javax.xml.namespace.QName;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonExtensionModifier {

  public static Map<String, Object> unmarshaller(final List<Object> value) {
    if (value == null) {
      return Collections.emptyMap();
    }

    return elementReader(value, "");
  }

  // This method reads elements from a list and populates a LinkedHashMap with the elements.
  private static LinkedHashMap<String, Object> elementReader(
      final List<Object> value, final String parentPrefix) {
    final LinkedHashMap<String, Object> multiExtensions = new LinkedHashMap<>();
    final DefaultJsonSchemaNamespaceURIResolver namespaceResolver =
        DefaultJsonSchemaNamespaceURIResolver.getContext();

    // Loop over the elements in list
    for (final Object obj : value) {
      if (obj instanceof Element) {
        Element valueElement = (Element) obj;
        boolean hasAttribute = false;

        // If namespaces not already included then add them
        final String namespaceURI = valueElement.getNamespaceURI();
        String nodeName = valueElement.getNodeName();

        // Check if th element has namespace/prefix and if not then add the parent prefix to its
        // child elements as well
        if (StringUtils.isBlank(valueElement.getPrefix()) && StringUtils.isNotBlank(parentPrefix)) {
          // If no prefix exists on the element, append parent's prefix, Assuming the format:
          // <prefix:name> in getNodeName
          nodeName = parentPrefix + ":" + nodeName;
        }

        if (!namespaceResolver.getAllNamespaces().containsKey(namespaceURI)
            && !StringUtils.isEmpty(namespaceURI)
            && !PROTECTED_NAMESPACE_OF_CONTEXT.contains(namespaceURI)) {
          namespaceResolver.populateEventNamespaces(namespaceURI, valueElement.getPrefix());
        }

        // If the element contains the default namespace but contains different prefix then replace
        // with right prefix from EPCIS default namespaces
        if (!StringUtils.isEmpty(namespaceURI)
            && PROTECTED_NAMESPACE_OF_CONTEXT.contains(namespaceURI)) {
          valueElement = replacePrefix(valueElement);

          // Populate the eventNamespaces with respective URI and Prefix
          namespaceResolver.populateEventNamespaces(namespaceURI, valueElement.getPrefix());
        }

        // Process all the attributes and store them during the conversion from XML to JSON if
        // present
        if (valueElement.hasAttributes()) {
          // Create a new map to store the current element's attribute data <ex1:test id="some
          // random value">
          final LinkedHashMap<String, Object> elementData = new LinkedHashMap<>();

          final NamedNodeMap attributes = valueElement.getAttributes();

          for (int attr = 0; attr < attributes.getLength(); attr++) {
            final Node attrNode = attributes.item(attr);
            final String attrNodeName = attrNode.getNodeName();
            final String attributeName =
                attrNodeName.contains(":") ? attrNodeName.split(":")[1] : attrNodeName;

            // Exclude attributes related to namespaces (e.g., xmlns, xsi: or xmlns:prefix)
            if (!attributeName.equalsIgnoreCase("xmlns")
                && !attrNodeName.startsWith("xmlns:")
                && !attrNodeName.startsWith("xsi:")) {
              final String attributeKey =
                  attrNodeName.contains(":") ? attrNodeName : "@" + attrNodeName;
              elementData.put(attributeKey, attrNode.getNodeValue().trim());
            }
          }

          // Add all attributes data along with elements values & children if present
          if (!MapUtils.isEmpty(elementData)) {
            hasAttribute = true;
            extensionPopulate(multiExtensions, nodeName, elementData, hasAttribute);
          }
        }

        // If there are many elements then loop over them and add
        final NodeList valueList = valueElement.getChildNodes();

        if (valueList.getLength() > 0) {
          // Loop over the valueList and add to Map
          for (int parent = 0; parent < valueList.getLength(); parent++) {
            final Node parentNode = valueList.item(parent);

            // If text node then directly add with value
            if (parentNode.getNodeType() == Node.TEXT_NODE
                && !StringUtils.isBlank(parentNode.getTextContent())) {
              extensionPopulate(
                  multiExtensions, nodeName, parentNode.getTextContent().trim(), hasAttribute);
            } else if (parentNode.getNodeType() == Node.ELEMENT_NODE) {
              // If complex node then recursively add them
              final String complexPrefix =
                  StringUtils.isNotBlank(valueElement.getPrefix())
                      ? valueElement.getPrefix()
                      : parentPrefix;
              final HashMap<String, Object> childNodes =
                  elementReader(List.of(parentNode), complexPrefix);
              extensionPopulate(multiExtensions, nodeName, childNodes, hasAttribute);
            }
          }
        } else {
          extensionPopulate(
              multiExtensions, nodeName, valueElement.getTextContent().trim(), hasAttribute);
        }
      }
    }
    return multiExtensions;
  }

  // Based on obtained name and value populate the LinkedHashMap to either simple key, value or
  // complex key with value list
  public static void extensionPopulate(
      final LinkedHashMap<String, Object> multiExtensions,
      final String nodeName,
      Object nodeContent,
      final boolean isXmlAttribute) {
    // Check for null and empty strings to skip adding to the map.
    if (nodeContent instanceof String stringValue && StringUtils.isBlank(stringValue)) {
      return; // Skip adding if nodeContent is null or an empty string.
    }

    // For storing the values with XML attribute and values differentiate the values with keyword
    // value
    if (isXmlAttribute) {
      nodeContent = nodeContent instanceof String ? Map.of("value", nodeContent) : nodeContent;
    }

    // Check if MAP already has an entry with respective key
    if (multiExtensions.containsKey(nodeName)) {
      final Object existingValue = multiExtensions.get(nodeName);

      // Check if the MAP values for key is of ArrayList type
      if (existingValue instanceof List<?>) {
        // If values are of array type then add current value to existing array
        ((List<Object>) existingValue).add(nodeContent);
      } else if (existingValue instanceof Map && nodeContent instanceof Map) {
        final HashMap<String, Object> existingMapValues = (HashMap<String, Object>) existingValue;
        final Map<String, Object> newMapValues = (Map<String, Object>) nodeContent;

        newMapValues.forEach(
            (key, value) -> {
              if (existingMapValues.containsKey(key)) {
                final Object existingKeyValue = existingMapValues.get(key);
                if (existingKeyValue instanceof List) {
                  ((List<Object>) existingKeyValue).add(value);
                } else {
                  final List<Object> values = new ArrayList<>();
                  values.add(existingKeyValue);
                  values.add(value);
                  existingMapValues.put(key, values);
                }
              } else {
                existingMapValues.put(key, value);
              }
            });

        multiExtensions.put(nodeName, existingMapValues);

      } else {
        final List<Object> values = new ArrayList<>();
        values.add(existingValue);
        values.add(nodeContent);
        multiExtensions.put(nodeName, values);
      }
    } else {
      // If the entry does not exist for the key in Map then add a new entry
      multiExtensions.put(nodeName, nodeContent);
    }
  }

  // Converting from XML to JSON for default namespace if prefix is different then replace with
  // right prefix from EPCIS Default Namespaces
  public static Element replacePrefix(final Element valueElement) {
    // Find the right default prefix for the corresponding default namespace URI from the Map
    final String correctPrefix =
        EPCIS_DEFAULT_NAMESPACES.entrySet().stream()
            .filter(entry -> valueElement.getNamespaceURI().equals(entry.getValue()))
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(null);

    // If the default namespace prefix does not match the one present in tag then replace with right
    // prefix
    if (!StringUtils.isEmpty(correctPrefix) && !correctPrefix.equals(valueElement.getPrefix())) {
      valueElement.setPrefix(correctPrefix);
    }

    return valueElement;
  }

  // Method to populate the namespaces from the List<Object> context values.
  public static void populateNamespaces(final List<Object> context) {
    // Populating the namespaces directly from context during xml query
    if (context != null && !context.isEmpty()) {
      final DefaultJsonSchemaNamespaceURIResolver namespaceResolver =
          DefaultJsonSchemaNamespaceURIResolver.getContext();
      namespaceResolver.resetEventNamespaces();

      for (final Object item : context) {
        if (item instanceof Map<?, ?>) {
          final Map<String, String> namespaces = (Map<String, String>) item;
          namespaces.forEach((key, value) -> namespaceResolver.populateEventNamespaces(value, key));
        }
      }
    }
  }

  // Method to find the required namespace prefix based on provided namespace URI
  public static String getNamespacePrefix(final QName namespace) {
    final DefaultJsonSchemaNamespaceURIResolver instance =
        DefaultJsonSchemaNamespaceURIResolver.getContext();

    // Try to find a prefix directly mapped to the namespace URI
    String prefix = instance.getAllNamespaces().get(namespace.getNamespaceURI());

    // If the prefix is not found then get the prefix from the namespaceURI by extracting the
    // trailing values
    if (StringUtils.isBlank(prefix)) {
      // Remove trailing '/' if present for uniform handling and build the prefix
      final String namespaceURI = namespace.getNamespaceURI();
      final String processedURI = StringUtils.removeEnd(namespaceURI, "/");
      final int lastSlashIndex = processedURI.lastIndexOf('/');
      prefix = lastSlashIndex != -1 ? processedURI.substring(lastSlashIndex + 1) : "";
      return prefix + ":" + namespace.getLocalPart();
    }

    // final String qualifiedPrefix = StringUtils.isNotBlank(prefix) ? prefix :
    return prefix + ":" + namespace.getLocalPart();
  }
}
