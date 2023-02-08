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
package io.openepcis.model.epcis.modifier;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.openepcis.model.epcis.util.DefaultJsonSchemaNamespaceURIResolver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomContextDeserialize extends JsonDeserializer<List<Object>> {
  @Override
  public List<Object> deserialize(JsonParser jsonParser, DeserializationContext ctxt)
      throws IOException {
    final List<Object> namespaceNode =
        new ObjectMapper().treeToValue(jsonParser.readValueAsTree(), ArrayList.class);

    // If the @Context has been populated with values then write the namespaces to Defaulter's using
    // the custom deserialize
    if (namespaceNode != null) {
      for (Object contextItem : namespaceNode) {
        if (contextItem instanceof Map) {
          final Map<String, String> namespaceLoc = (Map<String, String>) contextItem;
          namespaceLoc.forEach(
              (key, value) -> {
                DefaultJsonSchemaNamespaceURIResolver.getInstance().namespacePopulater(value, key);
              });
        }
      }
    }
    return null;
  }
}
