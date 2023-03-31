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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultJsonSchemaNamespaceURIResolver {

  private static DefaultJsonSchemaNamespaceURIResolver context;
  private final Map<String, String> DOCUMENT_NAMESPACES;
  private final Map<String, String> EVENT_NAMESPACES;

  private DefaultJsonSchemaNamespaceURIResolver() {
    this.DOCUMENT_NAMESPACES = new ConcurrentHashMap<>();
    this.EVENT_NAMESPACES = new ConcurrentHashMap<>();
  }

  public static synchronized DefaultJsonSchemaNamespaceURIResolver getContext() {
    if (context == null) {
      context = new DefaultJsonSchemaNamespaceURIResolver();
    }
    return context;
  }

  // Add all the Namespaces that are defined at the EPCIS document level.
  public synchronized void populateDocumentNamespaces(
      final String namespaceURI, final String prefix) {
    if (namespaceURI != null
        && prefix != null
        && !DOCUMENT_NAMESPACES.containsKey(prefix)
        && !DOCUMENT_NAMESPACES.containsValue(prefix)) {
      DOCUMENT_NAMESPACES.put(namespaceURI, prefix);
    }
  }

  // Add all the namespaces that are defined at the EPCIS event level.
  public synchronized void populateEventNamespaces(final String namespaceURI, final String prefix) {
    if (namespaceURI != null
        && prefix != null
        && !EVENT_NAMESPACES.containsKey(prefix)
        && !EVENT_NAMESPACES.containsValue(prefix)) {
      EVENT_NAMESPACES.put(namespaceURI, prefix);
    }
  }

  // Reset the event namespaces after completing each event.
  public synchronized void resetEventNamespaces() {
    EVENT_NAMESPACES.clear();
  }

  // Reset all the document & event namespaces after completing the document.
  public synchronized void resetAllNamespaces() {
    DOCUMENT_NAMESPACES.clear();
    EVENT_NAMESPACES.clear();
  }

  // Find the appropriate namespace based on the provided prefix.
  public synchronized Optional<String> findNamespaceByPrefix(final String prefix) {
    return getAllNamespaces().entrySet().stream()
        .filter(entry -> entry.getValue().equals(prefix))
        .map(Map.Entry::getKey)
        .findFirst();
  }

  // Method that returns the saved Document namespaces.
  public synchronized Map<String, String> getDocumentNamespaces() {
    return new HashMap<>(DOCUMENT_NAMESPACES);
  }

  // Method that returns the saved Event namespaces.
  public synchronized Map<String, String> getEventNamespaces() {
    return new HashMap<>(EVENT_NAMESPACES);
  }

  // Method that returns all the namespaces Document + Event combined.
  public synchronized Map<String, String> getAllNamespaces() {
    final Map<String, String> allNamespaces = new HashMap<>();
    allNamespaces.putAll(DOCUMENT_NAMESPACES);
    allNamespaces.putAll(EVENT_NAMESPACES);
    return allNamespaces;
  }
}
