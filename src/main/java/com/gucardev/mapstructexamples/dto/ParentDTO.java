package com.gucardev.mapstructexamples.dto;

import com.gucardev.mapstructexamples.model.ParentType;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentDTO {
  private Long id;
  private String name;
  private List<ChildDTO> children;

  private ParentType parentType;
}
