package io.openepcis.model.epcis.modifier;

import io.openepcis.model.epcis.util.DefaultJsonSchemaNamespaceURIResolver;
import java.util.*;
import javax.xml.namespace.QName;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonExtensionModifier {

  private static final String EMPTY_STRING_CHECKER = "[\\n\\t ]";

  public static Map<String, Object> extensionPopulate(
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

  public static Map<String, Object> unmarshaller(final List<Object> value) {
    if (value == null) {
      return Collections.emptyMap();
    }

    Map<String, Object> extensions = new HashMap<>();
    final DefaultJsonSchemaNamespaceURIResolver namespaceResolver =
        DefaultJsonSchemaNamespaceURIResolver.getContext();

    for (Object obj : value) {
      final Element element = (Element) obj;
      final NodeList children = element.getChildNodes();

      // If namespaces not already included then add them
      if (!namespaceResolver.getAllNamespaces().containsKey(element.getNamespaceURI())) {
        namespaceResolver.populateEventNamespaces(element.getNamespaceURI(), element.getPrefix());
      }

      // If simple type then directly add text to MAP
      if (children.getLength() == 1
          && !element.getTextContent().replaceAll(EMPTY_STRING_CHECKER, "").equals("")) {
        extensions =
            CommonExtensionModifier.extensionPopulate(
                extensions, element.getNodeName(), element.getTextContent());
      } else if (children.getLength() > 1) {
        // Loop through children elements for complex type of elements
        Map<String, Object> innerExtensions = new HashMap<>();

        for (int i = 0; i < children.getLength(); i++) {
          final Node n = children.item(i);
          if (n.getNodeType() == Node.ELEMENT_NODE) {
            final Element innerElement = (Element) n;
            final NodeList innerChildren = innerElement.getChildNodes();

            if (!namespaceResolver.getAllNamespaces().containsKey(innerElement.getNamespaceURI())) {
              namespaceResolver.populateEventNamespaces(
                  innerElement.getNamespaceURI(), innerElement.getPrefix());
            }

            if (innerChildren.getLength() == 1
                && !innerElement.getTextContent().replaceAll(EMPTY_STRING_CHECKER, "").equals("")) {
              innerExtensions =
                  CommonExtensionModifier.extensionPopulate(
                      innerExtensions, innerElement.getNodeName(), innerElement.getTextContent());
            } else if (innerChildren.getLength() > 1) {
              Map<String, Object> complexExtensions =
                  unmarshaller(
                      new ArrayList<>() {
                        {
                          add(n);
                        }
                      });
              innerExtensions =
                  CommonExtensionModifier.extensionPopulate(
                      innerExtensions,
                      innerElement.getNodeName(),
                      complexExtensions.get(innerElement.getNodeName()));
            }
          }
        }
        extensions =
            CommonExtensionModifier.extensionPopulate(
                extensions, element.getNodeName(), innerExtensions);
      }
    }
    return extensions;
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
