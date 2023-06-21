package com.gucardev.mapstructexamples.service;

import com.gucardev.mapstructexamples.dto.ParentDTO;
import com.gucardev.mapstructexamples.dto.ParentRequest;
import com.gucardev.mapstructexamples.mapper.ParentMapper;
import com.gucardev.mapstructexamples.model.ParentEntity;
import com.gucardev.mapstructexamples.repository.ParentRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ParentService {

  private final ParentRepository parentRepository;
  private final ParentMapper parentMapper;

  public ParentService(ParentRepository parentRepository, ParentMapper parentMapper) {
    this.parentRepository = parentRepository;
    this.parentMapper = parentMapper;
  }

  public ParentDTO createParent(ParentRequest parentRequest) {
    ParentEntity parentEntity = parentMapper.toEntityWithChildren(parentRequest);
    parentEntity = parentRepository.save(parentEntity);
    return parentMapper.toDto(parentEntity);
  }

  public List<ParentDTO> getAllParents() {
    List<ParentEntity> parentEntities = parentRepository.findAll();
    return parentEntities.stream().map(parentMapper::toDto).collect(Collectors.toList());
  }

  public ParentDTO getParentById(Long id) {
    ParentEntity parentEntity = parentRepository.findById(id).orElse(null);
    return parentMapper.toDto(parentEntity);
  }

  public ParentDTO updateParent(Long id, ParentRequest parentRequest) {
    ParentEntity parentEntity = parentMapper.toEntityWithChildren(parentRequest);
    parentEntity.setId(id);
    parentEntity = parentRepository.save(parentEntity);
    return parentMapper.toDto(parentEntity);
  }

  public void deleteParent(Long id) {
    parentRepository.deleteById(id);
  }
}
