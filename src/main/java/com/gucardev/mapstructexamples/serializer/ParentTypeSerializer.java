package com.gucardev.mapstructexamples.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.gucardev.mapstructexamples.model.ParentType;
import java.io.IOException;

public class ParentTypeSerializer extends JsonSerializer<ParentType> {

  @Override
  public void serialize(
      ParentType parentType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
      throws IOException {
    jsonGenerator.writeString(parentType.name());
  }
}
