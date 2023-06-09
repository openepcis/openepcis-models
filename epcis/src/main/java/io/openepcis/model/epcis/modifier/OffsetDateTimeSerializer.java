package io.openepcis.model.epcis.modifier;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;

public class OffsetDateTimeSerializer extends JsonSerializer<OffsetDateTime> {

  @Override
  public void serialize(OffsetDateTime value, JsonGenerator gen, SerializerProvider serializers)
      throws IOException {
    TemporalAccessor temporal = value.truncatedTo(ChronoUnit.MILLIS);
    gen.writeString(temporal.toString());
  }
}
