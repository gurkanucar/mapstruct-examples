package com.gucardev.mapstructexamples.repository;

import com.gucardev.mapstructexamples.model.ChildEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<ChildEntity, Long> {}
