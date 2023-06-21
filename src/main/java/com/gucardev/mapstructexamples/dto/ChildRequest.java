package com.gucardev.mapstructexamples.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChildRequest {
  private Long id;
  private String name;
  private Long parentId;
}
