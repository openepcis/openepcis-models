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
      DefaultJsonSchemaNamespaceURIResolver.getInstance();

  @Override
  public void serialize(
      final List<Object> contextValue,
      final JsonGenerator jsonGenerator,
      final SerializerProvider serializers)
      throws IOException {
    try {
      namespaceResolver.modifyEventNamespaces();
      jsonGenerator.writeStartArray();

      final Map<String, String> modifiedNamespaces = namespaceResolver.getModifiedNamespaces();

      for (final Map.Entry<String, String> entry : modifiedNamespaces.entrySet()) {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField(entry.getValue(), entry.getKey());
        jsonGenerator.writeEndObject();
      }

      jsonGenerator.writeEndArray();
      namespaceResolver.resetEventNamespaces();
      namespaceResolver.resetModifiedNamespaces();
    } catch (IOException e) {
      throw new IOException(
          "Exception occurred during the writing of context elements: " + e.getMessage(), e);
    }
  }
}
