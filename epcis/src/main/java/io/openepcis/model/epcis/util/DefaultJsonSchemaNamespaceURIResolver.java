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
package io.openepcis.model.epcis.util;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultJsonSchemaNamespaceURIResolver {
  private static final DefaultJsonSchemaNamespaceURIResolver INSTANCE = new DefaultJsonSchemaNamespaceURIResolver();
  private final ThreadLocal<Map<String, String>> documentNamespaces = ThreadLocal.withInitial(ConcurrentHashMap::new);
  private final ThreadLocal<Map<String, String>> eventNamespaces = ThreadLocal.withInitial(ConcurrentHashMap::new);

  private DefaultJsonSchemaNamespaceURIResolver() {}

  public static synchronized DefaultJsonSchemaNamespaceURIResolver getContext() {
    return INSTANCE;
  }

  // Add all the Namespaces that are defined at the EPCIS document level.
  public synchronized void populateDocumentNamespaces(final String namespaceURI, final String prefix) {
    if (isNonEmpty(namespaceURI) && isNonEmpty(prefix)) {
      documentNamespaces.get().putIfAbsent(namespaceURI, prefix);
    }
  }

  // Add all the namespaces that are defined at the EPCIS event level.
  public synchronized void populateEventNamespaces(final String namespaceURI, final String prefix) {
    if (isNonEmpty(namespaceURI) && isNonEmpty(prefix)) {
      eventNamespaces.get().putIfAbsent(namespaceURI, prefix);
    }
  }

  // Clears all event-level namespaces.
  public synchronized void resetEventNamespaces() {
    eventNamespaces.get().clear();
  }

  //  Clears all document-level and event-level namespaces.
  public synchronized void resetAllNamespaces() {
    documentNamespaces.get().clear();
    eventNamespaces.get().clear();
  }

  // Finds the namespace URI associated with a given prefix. Searches both document and event namespaces.
  public synchronized Optional<String> findNamespaceByPrefix(final String prefix) {
    return getAllNamespaces().entrySet().stream()
            .filter(entry -> entry.getValue().equals(prefix))
            .map(Map.Entry::getKey)
            .findFirst();
  }

  // Retrieves a copy of the document-level namespaces.
  public synchronized Map<String, String> getDocumentNamespaces() {
    return new HashMap<>(documentNamespaces.get());
  }

  // Retrieves a copy of the event-level namespaces.
  public synchronized Map<String, String> getEventNamespaces() {
    return new HashMap<>(eventNamespaces.get());
  }

  // Retrieves a combined copy of document-level and event-level namespaces.
  public synchronized Map<String, String> getAllNamespaces() {
    final Map<String, String> allNamespaces = new HashMap<>();
    allNamespaces.putAll(documentNamespaces.get());
    allNamespaces.putAll(eventNamespaces.get());
    return allNamespaces;
  }

  // Helper method to check if a string is non-null and non-empty
  private boolean isNonEmpty(final String value) {
    return StringUtils.isNotBlank(value);
  }
}
