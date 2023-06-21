package com.gucardev.mapstructexamples.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChildDTO {
  private Long id;
  private String name;
  private ParentDTO parentDTO;
}
