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
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.util.*;
import javax.xml.namespace.QName;
import lombok.Getter;
import lombok.Setter;

public class CustomExtensionAdapter extends XmlAdapter<MapWrapper, Map<String, Object>> {

  private final DefaultJsonSchemaNamespaceURIResolver namespaceResolver =
      DefaultJsonSchemaNamespaceURIResolver.getContext();

  @Override
  public MapWrapper marshal(final Map<String, Object> extensions) {
    if (extensions == null) {
      return null;
    }

    // Elements to store the information
    final MapWrapper wrapper = new MapWrapper();
    final List<Object> elements = new ArrayList<>();

    // Loop through the Extensions MAP
    for (Map.Entry<String, Object> property : extensions.entrySet()) {

      final String key = property.getKey();
      final Object value = property.getValue();
      final String localPart = getLocalPart(key);
      final String prefix = getPrefix(key);
      String namespaceURI = null;

      if (prefix != null) {
        Optional<String> namespace = namespaceResolver.findNamespaceByPrefix(prefix);
        if (namespace.isPresent()) {
          namespaceURI = namespace.get();
        }
      }

      if (value instanceof Map mapValue) {
        elements.add(new JAXBElement<>(createQName(localPart, namespaceURI, prefix), MapWrapper.class, marshal(mapValue)));
      } else if (value instanceof String stringValue) {
        elements.add(new JAXBElement<>(createQName(localPart, namespaceURI, prefix), String.class, stringValue));
      } else if (value instanceof List listValue) {
        for (Object item : listValue) {
          if (item instanceof Map mapValue) {
            elements.add(new JAXBElement<>(createQName(localPart, namespaceURI, prefix), MapWrapper.class, marshal(mapValue)));
          } else {
            elements.add(new JAXBElement<>(createQName(localPart, namespaceURI, prefix), String.class, item.toString()));
          }
        }
      }
    }
    wrapper.elements = elements;
    return wrapper;
  }

  @Override
  public Map<String, Object> unmarshal(final MapWrapper value) {
    if (value == null) {
      return Collections.emptyMap();
    }
    return CommonExtensionModifier.unmarshaller(value.elements);
  }

  // Creates the QName based on the provided values
  private QName createQName(
      final String localPart, final String namespaceURI, final String prefix) {
    if (prefix != null && namespaceURI != null) {
      return new QName(namespaceURI, localPart, prefix);
    } else {
      return new QName(localPart);
    }
  }

  // Formats the LocalPart of the XML Tag (after ":")
  private String getLocalPart(final String qName) {
    int index = qName != null ? qName.indexOf(":") : 0;
    return (index > 0) ? qName.substring(index + 1) : qName;
  }

  // Formats the Prefix of the XML Tag (before ":")
  private String getPrefix(final String qName) {
    final int index = qName != null ? qName.indexOf(":") : 0;
    return (index > 0) ? qName.substring(0, index) : null;
  }
}

@XmlAccessorType(XmlAccessType.FIELD)
class MapWrapper {
  @XmlAnyElement List<Object> elements = new ArrayList<>();
}
