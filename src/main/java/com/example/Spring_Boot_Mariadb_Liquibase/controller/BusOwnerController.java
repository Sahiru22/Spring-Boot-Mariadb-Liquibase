package com.example.Spring_Boot_Mariadb_Liquibase.controller;

import com.example.Spring_Boot_Mariadb_Liquibase.controller.request.BusOwnerRequest;
import com.example.Spring_Boot_Mariadb_Liquibase.controller.response.BusOwnerResponse;
import com.example.Spring_Boot_Mariadb_Liquibase.service.BusOwnerService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bus-owners")
@AllArgsConstructor
public class BusOwnerController {

  private final BusOwnerService busOwnerService;

  @PostMapping("")
  public BusOwnerResponse create(@RequestBody BusOwnerRequest request) {
    return busOwnerService.create(request);
  }

  @GetMapping("")
  public List<BusOwnerResponse> getAll() {
    return busOwnerService.getAll();
  }

  @GetMapping("/{id}")
  public BusOwnerResponse getById(@PathVariable Long id) {
    return busOwnerService.getById(id);
  }

  @PutMapping("/{id}")
  public void update(@RequestBody BusOwnerRequest request, @PathVariable Long id) {
    busOwnerService.updateById(request, id);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    busOwnerService.deleteById(id);
  }
}
