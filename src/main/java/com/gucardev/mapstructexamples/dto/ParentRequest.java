package com.gucardev.mapstructexamples.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gucardev.mapstructexamples.model.ParentType;
import com.gucardev.mapstructexamples.serializer.ParentTypeDeserializer;
import com.gucardev.mapstructexamples.serializer.ParentTypeSerializer;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentRequest {
  private Long id;
  private String name;
  private List<ChildDTO> children;

  @JsonSerialize(using = ParentTypeSerializer.class)
  @JsonDeserialize(using = ParentTypeDeserializer.class)
  private ParentType parentType;
}
