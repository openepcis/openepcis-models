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
package io.openepcis.model.epcis.util;

import io.openepcis.model.epcis.modifier.Constants;
import java.net.URL;
import java.util.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DefaultJsonSchemaNamespaceURIResolver {

  private static final ThreadLocal<Map<String, String>> DOCUMENT_NAMESPACES =
      ThreadLocal.withInitial(HashMap::new);
  private static final ThreadLocal<Map<String, String>> EVENT_NAMESPACES =
      ThreadLocal.withInitial(HashMap::new);
  private static final DefaultJsonSchemaNamespaceURIResolver INSTANCE =
      new DefaultJsonSchemaNamespaceURIResolver();

  public static DefaultJsonSchemaNamespaceURIResolver getInstance() {
    return INSTANCE;
  }

  // Add all the Namespaces that are defined at the EPCIS document level.
  public synchronized void populateDocumentNamespaces(
      final String namespaceURI, final String prefix) {
    if (!DOCUMENT_NAMESPACES.get().containsKey(prefix)
        && !DOCUMENT_NAMESPACES.get().containsValue(prefix)
        && namespaceURI != null
        && prefix != null) {
      DOCUMENT_NAMESPACES.get().put(namespaceURI, prefix);
    }
  }

  // Add all the namespaces that are defined at the EPCIS event level.
  public synchronized void populateEventNamespaces(final String namespaceURI, final String prefix) {
    if (!EVENT_NAMESPACES.get().containsKey(prefix)
        && !EVENT_NAMESPACES.get().containsValue(prefix)
        && namespaceURI != null
        && prefix != null) {
      EVENT_NAMESPACES.get().put(namespaceURI, prefix);
    }
  }

  // Reset the event namespaces after completing each event.
  public synchronized void resetEventNamespaces() {
    EVENT_NAMESPACES.remove();
  }

  // Reset all the document & event namespaces after completing the document.
  public synchronized void resetAllNamespaces() {
    DOCUMENT_NAMESPACES.remove();
    EVENT_NAMESPACES.remove();
  }

  // Find the appropriate namespace based on the provided prefix.
  public Optional<String> findNamespaceByPrefix(final String prefix) {
    return getAllNamespaces().entrySet().stream()
        .filter(entry -> entry.getValue().equals(prefix))
        .map(Map.Entry::getKey)
        .findFirst();
  }

  // Method that returns the saved Document namespaces.
  public Map<String, String> getDocumentNamespaces() {
    return DOCUMENT_NAMESPACES.get();
  }

  // Method that returns the saved Event namespaces.
  public Map<String, String> getEventNamespaces() {
    return EVENT_NAMESPACES.get();
  }

  // Method that returns all the namespaces Document + Event combined.
  public Map<String, String> getAllNamespaces() {
    final Map<String, String> allNamespaces = new HashMap<>();
    allNamespaces.putAll(DOCUMENT_NAMESPACES.get());
    allNamespaces.putAll(EVENT_NAMESPACES.get());
    return allNamespaces;
  }

  // Method to add the trailing / or : based on URL or URN and remove the Predefined prefixes for
  // Document.
  public void modifyDocumentNamespaces() {
    modifyNamespaces(DOCUMENT_NAMESPACES);
  }

  // Method to add the trailing / or : based on URL or URN and remove the Predefined prefixes for
  // Event.
  public void modifyEventNamespaces() {
    modifyNamespaces(EVENT_NAMESPACES);
  }

  // Common method to modify the Document & Event namespaces.
  private void modifyNamespaces(final ThreadLocal<Map<String, String>> namespaces) {
    namespaces
        .get()
        .forEach(
            (key, value) -> {
              String modifiedNamespace = key;
              try {
                // If URL then add trailing /
                URL url = new URL(key);
                modifiedNamespace = url.toString().endsWith("/") ? url.toString() : url + "/";
              } catch (Exception e) {
                // If URN then add trailing :
                modifiedNamespace =
                    modifiedNamespace.endsWith(":") ? modifiedNamespace : modifiedNamespace + ":";
              }

              // If the value is not part of default then add it to the Map
              if (!Arrays.asList(Constants.PROTECTED_TERMS_OF_CONTEXT).contains(value)) {
                namespaces.get().put(modifiedNamespace, value);
              }
            });
  }
}
