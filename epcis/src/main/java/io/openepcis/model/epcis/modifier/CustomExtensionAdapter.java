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
import io.openepcis.model.epcis.MapWrapper;
import io.openepcis.model.epcis.util.ConversionNamespaceContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.util.*;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * JAXB XmlAdapter for marshalling/unmarshalling extension Maps.
 *
 * <p>This adapter requires a {@link ConversionNamespaceContext} to be provided via constructor.
 * Use {@code Marshaller.setAdapter(CustomExtensionAdapter.class, new CustomExtensionAdapter(nsContext))}
 * to inject the context before marshalling/unmarshalling.
 *
 * <p>Example usage:
 * <pre>
 * ConversionNamespaceContext nsContext = new ConversionNamespaceContext();
 * Marshaller marshaller = jaxbContext.createMarshaller();
 * marshaller.setAdapter(CustomExtensionAdapter.class, new CustomExtensionAdapter(nsContext));
 * marshaller.marshal(object, writer);
 * </pre>
 */
public class CustomExtensionAdapter extends XmlAdapter<MapWrapper, Map<String, Object>> {

  private final ConversionNamespaceContext nsContext;

  /**
   * Default constructor for JAXB auto-instantiation.
   * If JAXB auto-instantiates this adapter (instead of using setAdapter()),
   * operations will work with limited functionality (no namespace resolution).
   */
  public CustomExtensionAdapter() {
    this.nsContext = null;
  }

  /**
   * Constructor with namespace context.
   * Use this constructor with {@code Marshaller.setAdapter()} for full functionality.
   *
   * @param nsContext the namespace context to use for resolving namespaces
   */
  public CustomExtensionAdapter(ConversionNamespaceContext nsContext) {
    this.nsContext = nsContext;
  }

  public ConversionNamespaceContext getNsContext() {
    return nsContext;
  }

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
      final String namespaceURI = namespaceOf(prefix);

      if (value instanceof Map mapValue) {
        elements.add(mapElement(localPart, namespaceURI, prefix, mapValue));
      } else if (value instanceof List listValue) {
        for (Object item : listValue) {
          if (item instanceof Map mapValue) {
            elements.add(mapElement(localPart, namespaceURI, prefix, mapValue));
          } else {
            elements.add(
                new JAXBElement<>(
                    createQName(localPart, namespaceURI, prefix), String.class, item.toString()));
          }
        }
      } else if (value instanceof String stringValue) {
        elements.add(
            new JAXBElement<>(
                createQName(localPart, namespaceURI, prefix), String.class, stringValue));
      } else if (value instanceof Double doubleValue) {
        elements.add(
            new JAXBElement<>(
                createQName(localPart, namespaceURI, prefix), Double.class, doubleValue));
      } else if (value instanceof Integer integerValue) {
        elements.add(
            new JAXBElement<>(
                createQName(localPart, namespaceURI, prefix), Integer.class, integerValue));
      } else if (value instanceof Boolean booleanValue) {
        elements.add(
            new JAXBElement<>(
                createQName(localPart, namespaceURI, prefix), Boolean.class, booleanValue));
      } else {
        // Handle untyped or unexpected values
        String valueString = value.toString(); // Ensure conversion to String
        elements.add(
            new JAXBElement<>(
                createQName(localPart, namespaceURI, prefix), String.class, valueString));
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
    // Prefer ThreadLocal context (event-scoped) over constructor context (shared).
    // During XML-to-XML conversion, the ThreadLocal is set to the per-event context so that
    // namespace discoveries in ILMD (cbvmda, ext1, etc.) are captured in the event-scoped context.
    ConversionNamespaceContext ctx = ConversionNamespaceContext.getUnmarshalContext().orElse(this.nsContext);
    return CommonExtensionModifier.unmarshaller(value.elements, ctx);
  }

  // The namespace URI of a key's prefix: the EPCIS default namespaces first, then the context.
  private String namespaceOf(final String prefix) {
    if (prefix == null) {
      return null;
    }
    final Object defaultNs = EPCIS.EPCIS_DEFAULT_NAMESPACES.get(prefix);
    if (defaultNs != null) {
      return defaultNs.toString();
    }
    return nsContext != null ? nsContext.findNamespaceByPrefix(prefix).orElse(null) : null;
  }

  // A map with attributes ("@name") or text ("#text") is written as a DOM element, see
  // createAttributedElement; any other map is an element of child elements.
  @SuppressWarnings("unchecked")
  private Object mapElement(String localPart, String namespaceURI, String prefix, Map<?, ?> mapValue) {
    final boolean hasAttrKeys = mapValue.keySet().stream().anyMatch(k -> k.toString().startsWith("@"));
    if (hasAttrKeys || mapValue.containsKey(CommonExtensionModifier.MIXED_TEXT_KEY)) {
      return createAttributedElement(localPart, namespaceURI, prefix, mapValue);
    }
    return new JAXBElement<>(createQName(localPart, namespaceURI, prefix), MapWrapper.class, marshal((Map<String, Object>) mapValue));
  }

  // Creates a DOM Element with XML attributes, text and child elements.
  // When CommonExtensionModifier reads e.g. <cbvmda:drainedWeight measurementUnitCode="KGM">3.5</cbvmda:drainedWeight>,
  // it stores: {"cbvmda:drainedWeight": {"@measurementUnitCode": "KGM", "value": "3.5"}}
  // A JAXBElement<MapWrapper> would incorrectly create child elements; a DOM Element preserves attributes + text natively.
  // Which key is the text is decided by CommonExtensionModifier.textKey: every other non-@ key, including
  // a "value" next to other children, is written as a child element.
  private Element createAttributedElement(String localPart, String namespaceURI, String prefix, Map<?, ?> mapValue) {
    try {
      final Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      return fillElement(doc, newElement(doc, localPart, namespaceURI, prefix), mapValue);
    } catch (ParserConfigurationException e) {
      throw new RuntimeException("Failed to create DOM element for attributed extension element", e);
    }
  }

  private Element fillElement(final Document doc, final Element elem, final Map<?, ?> mapValue) {
    final String textKey = CommonExtensionModifier.textKey(mapValue);
    for (Map.Entry<?, ?> entry : mapValue.entrySet()) {
      final String key = String.valueOf(entry.getKey());
      if (key.startsWith("@") && entry.getValue() != null) {
        elem.setAttribute(key.substring(1), entry.getValue().toString());
      }
    }
    if (textKey != null && mapValue.get(textKey) != null && !mapValue.get(textKey).toString().isEmpty()) {
      elem.appendChild(doc.createTextNode(mapValue.get(textKey).toString()));
    }
    for (Map.Entry<?, ?> entry : mapValue.entrySet()) {
      final String key = String.valueOf(entry.getKey());
      if (key.startsWith("@") || key.equals(textKey)) {
        continue;
      }
      final String childPrefix = getPrefix(key);
      final String childNamespace = namespaceOf(childPrefix);
      final List<?> items = entry.getValue() instanceof List<?> list ? list : Collections.singletonList(entry.getValue());
      for (Object item : items) {
        final Element child = newElement(doc, getLocalPart(key), childNamespace, childPrefix);
        if (item instanceof Map<?, ?> childMap) {
          fillElement(doc, child, childMap);
        } else if (item != null) {
          child.setTextContent(item.toString());
        }
        elem.appendChild(child);
      }
    }
    return elem;
  }

  // An element in the key's namespace; unqualified when the prefix has no known namespace, as createQName does.
  private Element newElement(final Document doc, final String localPart, final String namespaceURI, final String prefix) {
    return (namespaceURI != null && prefix != null)
        ? doc.createElementNS(namespaceURI, prefix + ":" + localPart)
        : doc.createElementNS(null, localPart);
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
