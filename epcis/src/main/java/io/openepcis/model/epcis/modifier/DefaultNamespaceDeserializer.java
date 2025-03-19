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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.openepcis.model.epcis.util.DefaultJsonSchemaNamespaceURIResolver;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * This class will detect any default EPCIS namespaces in userExtension, ilmd, or errorExtension. If
 * the namespaces aren't detected and included in the DefaultJsonSchemaNamespaceURIResolver
 * EventNamespaces then during the marshalling it produces error
 */
@Slf4j
@NoArgsConstructor
public class DefaultNamespaceDeserializer extends JsonDeserializer<Object> {

  private static DefaultNamespaceDeserializer instance;
  private final DefaultJsonSchemaNamespaceURIResolver namespaceResolver =
      DefaultJsonSchemaNamespaceURIResolver.getContext();
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public Object deserialize(final JsonParser jp, final DeserializationContext ctxt)
      throws IOException {
    final JsonToken currentToken = jp.currentToken();

    if (currentToken == JsonToken.START_OBJECT) {
      // Handle Map for ILMD, User Extensions, Error Extensions
      final Map<String, Object> result = objectMapper.readValue(jp, new TypeReference<>() {});
      processExtensions(result);
      return result;
    } else if (currentToken == JsonToken.START_ARRAY) {
      // Handle List for certificationInfo
      final List<Object> result = objectMapper.readValue(jp, new TypeReference<>() {});
      processListExtensions(result);
      return result;
    } else {
      throw new IOException(
          "Unexpected JSON token for Deserialization of UserExtension/ILMD/ErrorExtension/CertificationInfo : "
              + currentToken);
    }
  }

  public static synchronized DefaultNamespaceDeserializer getInstance() {
    if (instance == null) {
      instance = new DefaultNamespaceDeserializer();
    }
    return instance;
  }

  // Process the list extensions to obtain the context for fields such as certificationInfo
  public void processListExtensions(List<Object> certificationInfo) {
    certificationInfo.forEach(
        entry -> {
          if (entry instanceof Map<?, ?>) {
            @SuppressWarnings("unchecked")
            final Map<String, Object> mapEntry = (Map<String, Object>) entry;
            processExtensions(mapEntry);
          } else if (entry instanceof List) {
            @SuppressWarnings("unchecked")
            final List<Object> listEntry = (List<Object>) entry;
            processListExtensions(listEntry);
          } else if (entry instanceof String) {
            findNamespace((String) entry);
          }
        });
  }

  // Process the Map extension to obtain the context for fields such as ILMD, UserExtensions, Error
  // Extensions
  public void processExtensions(Map<String, Object> extensionsNode) {
    extensionsNode.forEach(
        (key, value) -> {
          findNamespace(key);
          if (value instanceof Map<?, ?>) {
            @SuppressWarnings("unchecked")
            final Map<String, Object> mapEntry = (Map<String, Object>) value;
            processExtensions(mapEntry);
          } else if (value instanceof List) {
            @SuppressWarnings("unchecked")
            final List<Object> listEntry = (List<Object>) value;
            processListExtensions(listEntry);
          } else if (value instanceof String) {
            findNamespace(key);
          }
        });
  }

  /**
   * Based on the key present for the extension get the prefix and get corresponding namespaceURI
   * and if not present already then populate in namespaceResolver
   *
   * @param key key of the userExtension gs1:lotNumber, etc.
   */
  private void findNamespace(final String key) {
    final String prefix =
        key != null && key.contains(":") ? key.substring(0, key.indexOf(":")) : "";
    final Optional<String> namespaceOpt =
        EPCIS_DEFAULT_NAMESPACES.entrySet().stream()
            .filter(entry -> entry.getKey().equals(prefix))
            .map(entry -> (String) entry.getValue())
            .findFirst();
    namespaceOpt.ifPresent(
        entry -> namespaceResolver.populateEventNamespaces(namespaceOpt.get(), prefix));
  }
}
