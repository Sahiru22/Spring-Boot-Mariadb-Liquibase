package com.example.Spring_Boot_Mariadb_Liquibase.controller;

import com.example.Spring_Boot_Mariadb_Liquibase.controller.request.RouteRequest;
import com.example.Spring_Boot_Mariadb_Liquibase.controller.response.RouteResponse;
import com.example.Spring_Boot_Mariadb_Liquibase.service.RouteService;
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
@RequestMapping("/routes")
@AllArgsConstructor
public class RouteController {

  private final RouteService routeService;

  @PostMapping("")
  public RouteResponse create(@RequestBody RouteRequest request) {
    return routeService.create(request);
  }

  @GetMapping("")
  public List<RouteResponse> getAll() {
    return routeService.getAll();
  }

  @GetMapping("/{id}")
  public RouteResponse getById(@PathVariable Long id) {
    return routeService.getById(id);
  }

  @PutMapping("/{id}")
  public void update(@RequestBody RouteRequest request, @PathVariable Long id) {
    routeService.updateById(request, id);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    routeService.deleteById(id);
  }
}
