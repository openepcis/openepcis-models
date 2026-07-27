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

import io.openepcis.constants.EPCIS;
import io.openepcis.model.epcis.util.ConversionNamespaceContext;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import java.util.*;

import static io.openepcis.constants.EPCIS.EPCIS_DEFAULT_NAMESPACES;
import static io.openepcis.constants.EPCIS.PROTECTED_NAMESPACE_OF_CONTEXT;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonExtensionModifier {

    /**
     * Unmarshals XML extension elements into a Map structure.
     *
     * @param value     the list of XML elements to unmarshal
     * @param nsContext the namespace context to use for resolving/storing namespaces
     * @return a map representation of the XML elements
     */
    public static Map<String, Object> unmarshaller(final List<Object> value, final ConversionNamespaceContext nsContext) {
        if (value == null) {
            return Collections.emptyMap();
        }

        return elementReader(value, "", nsContext);
    }

    // This method reads elements from a list and populates a LinkedHashMap with the elements.
    private static LinkedHashMap<String, Object> elementReader(
            final List<Object> value, final String parentPrefix, final ConversionNamespaceContext nsContext) {
        final LinkedHashMap<String, Object> multiExtensions = new LinkedHashMap<>();

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

                // Add namespace mapping for this prefix if not protected
                // Note: We must add ALL prefix->URI mappings, even when multiple prefixes use the same URI
                // (e.g., ns0, ns3, ns4 all mapping to http://example.com/cbvmda/)
                // The populateEventNamespaces method uses putIfAbsent to handle duplicate prefixes safely
                if (!StringUtils.isEmpty(namespaceURI)
                        && !PROTECTED_NAMESPACE_OF_CONTEXT.contains(namespaceURI)) {
                    if (nsContext != null) {
                        nsContext.populateEventNamespaces(namespaceURI, valueElement.getPrefix());
                    }
                }

                // If the element contains the default namespace but contains different prefix then replace
                // with right prefix from EPCIS default namespaces
                if (!StringUtils.isEmpty(namespaceURI)
                        && PROTECTED_NAMESPACE_OF_CONTEXT.contains(namespaceURI)) {
                    valueElement = replacePrefix(valueElement);
                    nodeName = valueElement.getNodeName();

                    // Populate the eventNamespaces with respective URI and Prefix
                    if (nsContext != null) {
                        nsContext.populateEventNamespaces(namespaceURI, valueElement.getPrefix());
                    }
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
                        if (parentNode.getNodeType() == Node.TEXT_NODE && !StringUtils.isBlank(parentNode.getTextContent())) {
                            // Convert the text using the element's xsi:type (integer/double/boolean); falls back to String
                            final Object typedValue = convertByXsiType(valueElement, parentNode.getTextContent().trim());  // type-aware leaf value
                            extensionPopulate(multiExtensions, nodeName, typedValue, hasAttribute);
                        } else if (parentNode.getNodeType() == Node.ELEMENT_NODE) {
                            // If complex node then recursively add them
                            final String complexPrefix = StringUtils.isNotBlank(valueElement.getPrefix()) ? valueElement.getPrefix() : parentPrefix;
                            final HashMap<String, Object> childNodes = elementReader(List.of(parentNode), complexPrefix, nsContext);
                            extensionPopulate(multiExtensions, nodeName, childNodes, hasAttribute);
                        }
                    }
                } else {
                    extensionPopulate(multiExtensions, nodeName, valueElement.getTextContent().trim(), hasAttribute);
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

    /**
     * Populates namespaces from JSON-LD context list.
     *
     * @param context   List of context objects (can contain Maps, Strings, or Lists)
     * @param nsContext the namespace context to populate
     */
    public static void populateNamespaces(final List<Object> context, final ConversionNamespaceContext nsContext) {
        if (context == null || context.isEmpty() || nsContext == null) {
            return;
        }

        // Reset event namespaces
        nsContext.resetEventNamespaces();

        for (final Object item : context) {
            processContextItem(item, nsContext);
        }
    }

    private static void processContextItem(Object item, ConversionNamespaceContext nsContext) {
        // Handle Map (JSON object style contexts)
        if (item instanceof Map<?, ?> mapItem) {
            mapItem.forEach((key, value) -> processMapEntry(key, value, nsContext));
            return;
        }

        // Handle String (plain URL contexts)
        if (item instanceof String url) {
            nsContext.populateEventNamespaces(url, null);
            return;
        }

        // Handle List (arrays of strings or maps)
        if (item instanceof List<?> list) {
            list.forEach(element -> {
                if (element instanceof String stringElement) {
                    nsContext.populateEventNamespaces(stringElement, null);
                } else if (element instanceof Map<?, ?> innerMap) {
                    innerMap.forEach((key, value) -> processMapEntry(key, value, nsContext));
                }
            });
        }
    }

    private static void processMapEntry(Object key, Object value, ConversionNamespaceContext nsContext) {
        if (value instanceof String stringValue) {
            nsContext.populateEventNamespaces(stringValue, String.valueOf(key));
        } else if (value instanceof List<?> listValue) {
            listValue.forEach(v -> {
                if (v instanceof String stringV) {
                    nsContext.populateEventNamespaces(stringV, String.valueOf(key));
                }
            });
        }
    }


    /**
     * Finds the required namespace prefix based on provided namespace URI.
     *
     * @param namespace the QName containing the namespace URI to look up
     * @param nsContext the namespace context to search in
     * @return the qualified name with prefix (e.g., "prefix:localPart")
     */
    public static String getNamespacePrefix(final QName namespace, final ConversionNamespaceContext nsContext) {
        // Get all namespaces from context
        final Map<String, String> allNamespaces = nsContext != null
                ? nsContext.getAllNamespaces()
                : Collections.emptyMap();

        // Try to find a prefix directly mapped to the namespace URI
        String prefix = allNamespaces.get(namespace.getNamespaceURI());

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

        return prefix + ":" + namespace.getLocalPart();
    }

    // Reads the element's xsi:type (e.g. xsd:integer) and converts the text to the matching Java type.
    private static Object convertByXsiType(final Element element, final String textValue) {
        // Try the namespace-aware lookup first, then fall back to the literal "xsi:type" attribute name
        String xsiType = element.getAttributeNS(EPCIS.XML_SCHEMA_INSTANCE, "type");
        if (StringUtils.isBlank(xsiType)) {
            xsiType = element.getAttribute("xsi:type"); // fallback for non-namespace-aware DOMs
        }
        if (StringUtils.isBlank(xsiType)) {
            return textValue; // No xsi:type, return as String
        }

        // Strip any prefix so "xsd:integer" and "integer" are treated the same
        final String type = xsiType.contains(":") ? xsiType.substring(xsiType.indexOf(":") + 1) : xsiType;

        try {
            switch (type) {
                // Integer family, prefer Integer and widen to Long only if it overflows
                case "integer", "int", "long", "short", "byte", "nonNegativeInteger", "positiveInteger", "nonPositiveInteger",
                        "negativeInteger", "unsignedInt", "unsignedLong", "unsignedShort", "unsignedByte" -> {
                    try {
                        return Integer.valueOf(textValue); // "10" -> 10
                    } catch (final NumberFormatException overflow) {
                        return Long.valueOf(textValue); // large value -> Long
                    }
                }

                // Floating point / decimal family
                case "double", "float", "decimal" -> {
                    return Double.valueOf(textValue); // "10.5" -> 10.5
                }

                // Boolean, accept the XSD-legal 1/0 as well as true/false
                case "boolean" -> {
                    if ("true".equalsIgnoreCase(textValue) || "1".equals(textValue)) {
                        return Boolean.TRUE;
                    }
                    if ("false".equalsIgnoreCase(textValue) || "0".equals(textValue)) {
                        return Boolean.FALSE;
                    }
                    return textValue;
                }

                // dateTime/date/time/string/anyURI and every unknown type stay as String,
                default -> {
                    return textValue;
                }
            }
        } catch (final NumberFormatException e) {
            // If conversion fails, return as String
            return textValue;
        }
    }
}
