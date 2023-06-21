package com.gucardev.mapstructexamples.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentDTO {
  private Long id;
  private String name;
  private List<ChildDTO> children;
}
