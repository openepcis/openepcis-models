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

  private static final Map<String, String> NAMESPACE_MAPS = new HashMap<>();
  private static final Map<String, String> MODIFIED_EVENT_NAMESPACES = new HashMap<>();

  private static DefaultJsonSchemaNamespaceURIResolver instance =
      new DefaultJsonSchemaNamespaceURIResolver();

  public static DefaultJsonSchemaNamespaceURIResolver getInstance() {
    return instance;
  }

  // Add the Namespaces obtained from JSON-LD if the already defined XSD namespaces exist
  public synchronized void namespacePopulater(String namespaceURI, String prefix) {
    if (!NAMESPACE_MAPS.containsKey(prefix)
        && !NAMESPACE_MAPS.containsValue(prefix)
        && namespaceURI != null
        && prefix != null) {
      NAMESPACE_MAPS.put(namespaceURI, prefix);
    }
  }

  public synchronized void namespaceReset() {
    NAMESPACE_MAPS.clear();
    MODIFIED_EVENT_NAMESPACES.clear();
  }

  public Optional<String> namespaceLocator(String prefix) {
    if (NAMESPACE_MAPS.containsValue(prefix)) {
      return Optional.of(
          NAMESPACE_MAPS.entrySet().stream()
              .filter(entry -> Objects.equals(entry.getValue(), prefix))
              .map(Map.Entry::getKey)
              .findFirst()
              .get());
    }
    return Optional.empty();
  }

  public Map<String, String> getOriginalNamespace() {
    return NAMESPACE_MAPS;
  }

  public Map<String, String> getModifiedNamespace() {
    return MODIFIED_EVENT_NAMESPACES;
  }

  // Method to add the trailing / or : based on URL or URN and remove the Predefined prefixes from
  // MAP
  public void modifyNamespaces() {
    NAMESPACE_MAPS.forEach(
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
            MODIFIED_EVENT_NAMESPACES.put(modifiedNamespace, value);
          }
        });
  }
}
