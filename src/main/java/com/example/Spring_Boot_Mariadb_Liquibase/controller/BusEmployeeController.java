package com.example.Spring_Boot_Mariadb_Liquibase.controller;

import com.example.Spring_Boot_Mariadb_Liquibase.controller.request.BusEmployeeRequest;
import com.example.Spring_Boot_Mariadb_Liquibase.controller.response.BusEmployeeResponse;
import com.example.Spring_Boot_Mariadb_Liquibase.service.BusEmployeeService;
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
@RequestMapping("/bus-employees")
@AllArgsConstructor
public class BusEmployeeController {

  private final BusEmployeeService busEmployeeService;

  @PostMapping("")
  public BusEmployeeResponse create(@RequestBody BusEmployeeRequest request) {
    return busEmployeeService.create(request);
  }

  @GetMapping("")
  public List<BusEmployeeResponse> getAll() {
    return busEmployeeService.getAll();
  }

  @GetMapping("/{id}")
  public BusEmployeeResponse getById(@PathVariable Long id) {
    return busEmployeeService.getById(id);
  }

  @PutMapping("/{id}")
  public void update(@RequestBody BusEmployeeRequest request, @PathVariable Long id) {
    busEmployeeService.updateById(request, id);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    busEmployeeService.deleteById(id);
  }
}
