package com.gucardev.mapstructexamples.mapper;

import com.gucardev.mapstructexamples.dto.ParentDTO;
import com.gucardev.mapstructexamples.dto.ParentRequest;
import com.gucardev.mapstructexamples.model.ChildEntity;
import com.gucardev.mapstructexamples.model.ParentEntity;
import java.util.stream.Collectors;
import org.mapstruct.AfterMapping;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = ChildMapper.class)
public interface ParentMapper {

  @Named("toDtoWithoutChildren")
  @Mapping(target = "children", ignore = true)
  ParentDTO toDtoWithoutChildren(ParentEntity entity);

  @Mapping(target = "children", source = "children")
  @IterableMapping(qualifiedByName = "toDto")
  ParentDTO toDto(ParentEntity entity);

  @Mapping(target = "children", ignore = true)
  ParentEntity toEntity(ParentDTO dto);

  @Mapping(target = "children", ignore = true)
  ParentEntity toEntityWithChildren(ParentRequest request);

  @AfterMapping
  default void setChildren(ParentRequest request, @MappingTarget ParentEntity entity) {
    if (request.getChildren() != null) {
      entity.setChildren(
          request.getChildren().stream()
              .map(
                  childDTO -> {
                    ChildEntity childEntity = new ChildEntity();
                    childEntity.setId(childDTO.getId());
                    childEntity.setName(childDTO.getName());
                    childEntity.setMyParent(entity);
                    return childEntity;
                  })
              .collect(Collectors.toList()));
    }
  }
}
