package com.gucardev.mapstructexamples.controller;

import com.gucardev.mapstructexamples.dto.ParentDTO;
import com.gucardev.mapstructexamples.dto.ParentRequest;
import com.gucardev.mapstructexamples.service.ParentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parents")
public class ParentController {

  @Autowired
  private ParentService parentService;

  @PostMapping
  public ParentDTO createParent(@RequestBody ParentRequest parentRequest) {
    return parentService.createParent(parentRequest);
  }

  @GetMapping
  public List<ParentDTO> getAllParents() {
    return parentService.getAllParents();
  }

  @GetMapping("/{id}")
  public ParentDTO getParentById(@PathVariable Long id) {
    return parentService.getParentById(id);
  }

  @PutMapping("/{id}")
  public ParentDTO updateParent(@PathVariable Long id, @RequestBody ParentRequest parentRequest) {
    return parentService.updateParent(id, parentRequest);
  }

  @DeleteMapping("/{id}")
  public void deleteParent(@PathVariable Long id) {
    parentService.deleteParent(id);
  }
}
