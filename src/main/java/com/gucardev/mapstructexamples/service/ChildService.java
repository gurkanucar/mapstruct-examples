package com.gucardev.mapstructexamples.service;

import com.gucardev.mapstructexamples.dto.ChildDTO;
import com.gucardev.mapstructexamples.dto.ChildRequest;
import com.gucardev.mapstructexamples.mapper.ChildMapper;
import com.gucardev.mapstructexamples.model.ChildEntity;
import com.gucardev.mapstructexamples.repository.ChildRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ChildService {

  private final ChildRepository childRepository;
  private final ChildMapper childMapper;

  public ChildService(ChildRepository childRepository, ChildMapper childMapper) {
    this.childRepository = childRepository;
    this.childMapper = childMapper;
  }

  public ChildDTO createChild(ChildRequest childRequest) {
    ChildEntity childEntity = childMapper.toEntityFromRequest(childRequest);
    childEntity = childRepository.save(childEntity);
    return childMapper.toDtoWithParent(childEntity);
  }

  public List<ChildDTO> getAllChildren() {
    List<ChildEntity> childEntities = childRepository.findAll();
    return childEntities.stream().map(childMapper::toDtoWithParent).collect(Collectors.toList());
  }

  public ChildDTO getChildById(Long id) {
    ChildEntity childEntity = childRepository.findById(id).orElse(null);
    return childMapper.toDtoWithParent(childEntity);
  }

  public ChildDTO updateChild(Long id, ChildRequest childRequest) {
    ChildEntity childEntity = childMapper.toEntityFromRequest(childRequest);
    childEntity.setId(id);
    childEntity = childRepository.save(childEntity);
    return childMapper.toDtoWithParent(childEntity);
  }

  public void deleteChild(Long id) {
    childRepository.deleteById(id);
  }
}
