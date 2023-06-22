package com.gucardev.mapstructexamples.controller;

import com.gucardev.mapstructexamples.dto.ChildDTO;
import com.gucardev.mapstructexamples.dto.ChildRequest;
import com.gucardev.mapstructexamples.service.ChildService;
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
@RequestMapping("/children")
public class ChildController {

  @Autowired private ChildService childService;

  @PostMapping
  public ChildDTO createChild(@RequestBody ChildRequest childRequest) {
    return childService.createChild(childRequest);
  }

  @GetMapping
  public List<ChildDTO> getAllChildren() {
    return childService.getAllChildren();
  }

  @GetMapping("/{id}")
  public ChildDTO getChildById(@PathVariable Long id) {
    return childService.getChildById(id);
  }

  @PutMapping("/{id}")
  public ChildDTO updateChild(@PathVariable Long id, @RequestBody ChildRequest childRequest) {
    return childService.updateChild(id, childRequest);
  }

  @DeleteMapping("/{id}")
  public void deleteChild(@PathVariable Long id) {
    childService.deleteChild(id);
  }
}
