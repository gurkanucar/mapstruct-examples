package com.gucardev.mapstructexamples.repository;

import com.gucardev.mapstructexamples.model.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<ParentEntity, Long> {
}
