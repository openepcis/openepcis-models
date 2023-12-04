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

import io.openepcis.model.epcis.util.DefaultJsonSchemaNamespaceURIResolver;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import java.util.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonExtensionModifier {

    public static Map<String, Object> unmarshaller(final List<Object> value) {
        if (value == null) {
            return Collections.emptyMap();
        }

        return elementReader(value);
    }

    private static LinkedHashMap<String, Object> elementReader(List<Object> value) {
        LinkedHashMap<String, Object> multiExtensions = new LinkedHashMap<>();

        final DefaultJsonSchemaNamespaceURIResolver namespaceResolver = DefaultJsonSchemaNamespaceURIResolver.getContext();

        //Loop over the elements in list
        for (Object obj : value) {
            if (obj instanceof Element) {
                final Element valueElement = (Element) obj;

                // If namespaces not already included then add them
                final String namespaceURI = valueElement.getNamespaceURI();
                if (!namespaceResolver.getAllNamespaces().containsKey(namespaceURI)) {
                    namespaceResolver.populateEventNamespaces(namespaceURI, valueElement.getPrefix());
                }

                //If there are many elements then loop over them and add
                final NodeList valueList = valueElement.getChildNodes();
                if (valueList.getLength() > 0) {
                    //Loop over the valueList and add to Map
                    for (int parent = 0; parent < valueList.getLength(); parent++) {
                        final Node parentNode = valueList.item(parent);

                        //If text node then directly add with value
                        if (parentNode.getNodeType() == Node.TEXT_NODE) {
                            extensionPopulate(multiExtensions, valueElement.getNodeName(), valueElement.getTextContent().trim());
                        } else if (parentNode.getNodeType() == Node.ELEMENT_NODE) {
                            //If complex node then recursively add them
                            HashMap<String, Object> childNodes = elementReader(List.of(parentNode));
                            extensionPopulate(multiExtensions, valueElement.getNodeName(), childNodes);
                        }
                    }
                } else {
                    extensionPopulate(multiExtensions, valueElement.getNodeName(), valueElement.getTextContent().trim());
                }
            }
        }
        return multiExtensions;
    }

    public static LinkedHashMap<String, Object> extensionPopulate(final LinkedHashMap<String, Object> multiExtensions, final String nodeName, final Object nodeContent) {
        // Check if MAP already has an entry with respective key
        if (multiExtensions.containsKey(nodeName)) {
            final Object existingValue = multiExtensions.get(nodeName);

            // Check if the MAP values for key is of ArrayList type
            if (existingValue instanceof List<?>) {
                // If values are of array type then add current value to existing array
                ((List<Object>) existingValue).add(nodeContent);
            } else if (existingValue instanceof Map && nodeContent instanceof Map) {
                final HashMap<String, Object> existingMapValues = (HashMap<String, Object>) existingValue;
                final HashMap<String, Object> newMapValues = (HashMap<String, Object>) nodeContent;

                newMapValues.forEach((key, value) -> {
                    if (existingMapValues.containsKey(key)) {
                        Object existingKeyValue = existingMapValues.get(key);
                        if (existingKeyValue instanceof List) {
                            ((List<Object>) existingKeyValue).add(value);
                        } else {
                            List<Object> values = new ArrayList<>();
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
                List<Object> values = new ArrayList<>();
                values.add(existingValue);
                values.add(nodeContent);
                multiExtensions.put(nodeName, values);
            }
        } else {
            // If the entry does not exist for the key in Map then add a new entry
            multiExtensions.put(nodeName, nodeContent);
        }
        return multiExtensions;
    }

    // Method to populate the namespaces from the List<Object> context values.
    public static void populateNamespaces(final List<Object> context) {
        // Populating the namespaces directly from context during xml query
        if (context != null && !context.isEmpty()) {
            final DefaultJsonSchemaNamespaceURIResolver namespaceResolver =
                    DefaultJsonSchemaNamespaceURIResolver.getContext();
            namespaceResolver.resetEventNamespaces();

            for (Object item : context) {
                if (item instanceof Map<?, ?>) {
                    final Map<String, String> namespaces = (Map<String, String>) item;
                    namespaces.forEach((key, value) -> namespaceResolver.populateEventNamespaces(value, key));
                }
            }
        }
    }

    // Method to find the required namespace prefix based on provided namespace URI
    public static String getNamespacePrefix(final QName namespace) {
        return DefaultJsonSchemaNamespaceURIResolver.getContext()
                .getAllNamespaces()
                .get(namespace.getNamespaceURI())
                + ":"
                + namespace.getLocalPart();
    }
}
