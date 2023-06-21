package com.gucardev.mapstructexamples.mapper;

import com.gucardev.mapstructexamples.dto.ChildDTO;
import com.gucardev.mapstructexamples.dto.ChildRequest;
import com.gucardev.mapstructexamples.model.ChildEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = ParentMapper.class)
public interface ChildMapper {

  @Named("toDto")
  ChildDTO toDto(ChildEntity entity);

  @Named("toDtoWithParent")
  @Mapping(target = "parentDTO", source = "myParent", qualifiedByName = "toDtoWithoutChildren")
  ChildDTO toDtoWithParent(ChildEntity entity);

  @Mapping(target = "myParent.id", source = "parentId")
  ChildEntity toEntityFromRequest(ChildRequest request);
}
