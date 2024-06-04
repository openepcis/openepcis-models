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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.openepcis.model.epcis.util.DefaultJsonSchemaNamespaceURIResolver;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static io.openepcis.constants.EPCIS.EPCIS_DEFAULT_NAMESPACES;

/**
 * This class will detect any default EPCIS namespaces in userExtension, ilmd, or errorExtension. If the namespaces aren't detected and included in the DefaultJsonSchemaNamespaceURIResolver EventNamespaces then during the marshalling it produces
 * error
 */
@Slf4j
@NoArgsConstructor
public class DefaultNamespaceDeserializer extends JsonDeserializer<Map<String, Object>> {

    private static DefaultNamespaceDeserializer instance;
    private final DefaultJsonSchemaNamespaceURIResolver namespaceResolver = DefaultJsonSchemaNamespaceURIResolver.getContext();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Map<String, Object> deserialize(final JsonParser jsonParser, final DeserializationContext context) throws IOException {
        final Map<String, Object> extensionsNode = objectMapper.readValue(jsonParser, new TypeReference<>() {});
        processExtensions(extensionsNode);
        return extensionsNode;
    }


    public static synchronized DefaultNamespaceDeserializer getInstance() {
        if (instance == null) {
            instance = new DefaultNamespaceDeserializer();
        }
        return instance;
    }

    /**
     * This method will detect if the userExtensions, ILMD or errorExtensions contain any default namespace related prefixes. If so then include the corresponding namespace in the namespaceResolver eventNamespaces for the XML Marshalling
     *
     * @param extensionsNode Map of all the userExtension for which default namespace needs to be detected ex: {cbvmda:lotNumber=1234}
     */
    public void processExtensions(final Map<String, Object> extensionsNode) {
        extensionsNode.forEach((key, value) -> {
            if (value instanceof Map) {
                findNamespace(key);
                processExtensions((Map<String, Object>) value);
            } else if (value instanceof List<?>) {
                ((List<?>) value).forEach(item -> {
                    if (item instanceof Map) {
                        findNamespace(key);
                        processExtensions((Map<String, Object>) item);
                    } else if (item instanceof String || item instanceof Number) {
                        findNamespace(key);
                    }
                });
            } else if (value instanceof String) {
                findNamespace(key);
            }
        });
    }

    /**
     * Based on the key present for the extension get the prefix and get corresponding namespaceURI and if not present already then populate in namespaceResolver
     *
     * @param key key of the userExtension gs1:lotNumber, etc.
     */
    private void findNamespace(final String key) {
        final String prefix = key != null && key.contains(":") ? key.substring(0, key.indexOf(":")) : "";
        final Optional<String> namespaceOpt = EPCIS_DEFAULT_NAMESPACES.entrySet().stream()
                .filter(entry -> entry.getKey().equals(prefix))
                .map(entry -> (String) entry.getValue())
                .findFirst();
        namespaceOpt.ifPresent(entry -> namespaceResolver.populateEventNamespaces(namespaceOpt.get(), prefix));
    }
}
