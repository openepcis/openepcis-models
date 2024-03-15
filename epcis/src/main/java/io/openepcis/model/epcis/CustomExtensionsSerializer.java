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
package io.openepcis.model.epcis;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Map;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomExtensionsSerializer extends JsonSerializer<Map<String, Object>>
    implements ContextualSerializer {

  private String context = "";

  public CustomExtensionsSerializer(String context) {
    this.context = context;
  }

  @Override
  public JsonSerializer<?> createContextual(
      SerializerProvider serializerProvider, BeanProperty beanProperty) {
    UserExtensions extensions = beanProperty.getAnnotation(UserExtensions.class);
    if (extensions != null) {
      return new CustomExtensionsSerializer(extensions.extension());
    }
    return this;
  }

  @Override
  public void serialize(
      Map<String, Object> value, JsonGenerator gen, SerializerProvider serializers)
      throws IOException {
    if (this.context.equals("userExtensions")) {
      recursiveSerializer(value, gen);
    } else if (this.context.equals("ilmd") || this.context.equals("extension")) {
      gen.writeStartObject();
      recursiveSerializer(value, gen);
      gen.writeEndObject();
    }
  }

  public void recursiveSerializer(Map<String, Object> value, JsonGenerator gen) throws IOException {
    for (Map.Entry<String, Object> extension : value.entrySet()) {
      if (extension.getValue() instanceof Map) {
        // If instance is MAP then call the recursive method
        gen.writeFieldName(extension.getKey());
        gen.writeStartObject();
        recursiveSerializer((Map<String, Object>) extension.getValue(), gen);
        gen.writeEndObject();
      } else if (extension.getValue() instanceof String) {
        // If instance is String directly add it to the JSON
        gen.writeStringField(extension.getKey(), (String) extension.getValue());
      } else if (extension.getValue() instanceof ArrayList) {
        // If instance is ArrayList then loop over it and add it to the JSON after calling recursive
        // method
        gen.writeFieldName(extension.getKey());
        gen.writeStartArray();
        for (Object dupItems : (ArrayList<Object>) extension.getValue()) {
          if (dupItems instanceof Map) {
            gen.writeStartObject();
            recursiveSerializer((Map<String, Object>) dupItems, gen);
            gen.writeEndObject();
          } else if (dupItems instanceof String) {
            gen.writeString((String) dupItems);
          } else if (dupItems instanceof Number){
            gen.writeNumber( ((Number) dupItems).doubleValue());
          }
        }
        gen.writeEndArray();
      }
    }
  }
}

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface UserExtensions {
  String extension();
}
