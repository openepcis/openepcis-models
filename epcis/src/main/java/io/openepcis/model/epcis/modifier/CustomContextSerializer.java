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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.openepcis.model.epcis.util.DefaultJsonSchemaNamespaceURIResolver;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CustomContextSerializer extends JsonSerializer<List<Object>> {

  private final DefaultJsonSchemaNamespaceURIResolver namespaceResolver =
      DefaultJsonSchemaNamespaceURIResolver.getContext();

  @Override
  public void serialize(
      final List<Object> contextValue,
      final JsonGenerator jsonGenerator,
      final SerializerProvider serializers)
      throws IOException {
    try {
      jsonGenerator.writeStartArray();

      final Map<String, String> modifiedNamespaces = namespaceResolver.getEventNamespaces();

      for (final Map.Entry<String, String> entry : modifiedNamespaces.entrySet()) {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField(entry.getValue(), entry.getKey());
        jsonGenerator.writeEndObject();
      }

      jsonGenerator.writeEndArray();
      namespaceResolver.resetEventNamespaces();
    } catch (IOException e) {
      throw new IOException(
          "Exception occurred during the writing of context elements: " + e.getMessage(), e);
    }
  }
}
