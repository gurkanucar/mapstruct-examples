package com.gucardev.mapstructexamples.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.gucardev.mapstructexamples.model.ParentType;
import java.io.IOException;

public class ParentTypeDeserializer extends JsonDeserializer<ParentType> {

  @Override
  public ParentType deserialize(
      JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    String parentTypeString = jsonParser.getText();
    return ParentType.valueOf(parentTypeString);
  }
}
