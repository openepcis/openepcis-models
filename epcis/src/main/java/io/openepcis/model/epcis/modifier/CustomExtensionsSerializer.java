/*
 * Copyright 2022-2026 benelog GmbH & Co. KG
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
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomExtensionsSerializer extends JsonSerializer<Map<String, Object>>
    implements ContextualSerializer {
  private String context = "";

  public CustomExtensionsSerializer(final String context) {
    this.context = context;
  }

  @Override
  public JsonSerializer<?> createContextual(
      final SerializerProvider serializerProvider, final BeanProperty beanProperty) {
    UserExtensions extensions = beanProperty.getAnnotation(UserExtensions.class);
    if (extensions != null) {
      return new CustomExtensionsSerializer(extensions.extension());
    }
    return this;
  }

  @Override
  public void serialize(
      final Map<String, Object> value,
      final JsonGenerator gen,
      final SerializerProvider serializers)
      throws IOException {
    if (this.context.equals("userExtensions")) {
      recursiveSerializer(value, gen);
    } else if (this.context.equals("ilmd")
        || this.context.equals("extension")
        || this.context.equals("certificationInfo")) {
      gen.writeStartObject();
      recursiveSerializer(value, gen);
      gen.writeEndObject();
    }
  }

  private void recursiveSerializer(final Map<String, Object> value, final JsonGenerator gen)
      throws IOException {
    for (Map.Entry<String, Object> extension : value.entrySet()) {
      if (extension.getValue() instanceof Map) {
        // If instance is MAP then call the recursive method
        gen.writeFieldName(extension.getKey());
        gen.writeStartObject();
        recursiveSerializer((Map<String, Object>) extension.getValue(), gen);
        gen.writeEndObject();
      } else if (extension.getValue() instanceof String stringValue) {
        // If instance is String directly add it to the JSON
        gen.writeStringField(extension.getKey(), stringValue);
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
          } else if (dupItems instanceof String stringValue) {
            gen.writeString(stringValue);
          } else if (dupItems instanceof Number numberValue) {
            writeNumberKeepingType(gen, numberValue);
          } else if (dupItems instanceof Date) {
            gen.writeString(value.toString());
          } else if (dupItems instanceof Boolean booleanValue) {
            gen.writeBoolean(booleanValue);
          } else {
            gen.writeObject(value);
          }
        }
        gen.writeEndArray();
      } else if (extension.getValue() instanceof Number numberValue) {
        gen.writeFieldName(extension.getKey());
        writeNumberKeepingType(gen, numberValue);
      } else if (extension.getValue() instanceof Date) {
        gen.writeStringField(extension.getKey(), value.toString());
      } else if (extension.getValue() instanceof Boolean booleanValue) {
        gen.writeBooleanField(extension.getKey(), booleanValue);
      } else {
        gen.writeObject(value);
      }
    }
  }

  // Writes a number keeping its real JSON type: integers stay integers, doubles/decimals stay decimals.
  private void writeNumberKeepingType(final JsonGenerator gen, final Number number) throws IOException {
    if (number instanceof Integer intValue) {
      gen.writeNumber(intValue);           // 12 -> 12
    } else if (number instanceof Long longValue) {
      gen.writeNumber(longValue);          // large integer stays an integer
    } else if (number instanceof java.math.BigInteger bigIntValue) {
      gen.writeNumber(bigIntValue);        // arbitrary-precision integer
    } else if (number instanceof java.math.BigDecimal bigDecValue) {
      gen.writeNumber(bigDecValue);        // arbitrary-precision decimal
    } else {
      gen.writeNumber(number.doubleValue()); // Double/Float -> 22.0
    }
  }

}
