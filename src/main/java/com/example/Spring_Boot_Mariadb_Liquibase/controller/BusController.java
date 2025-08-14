package com.example.Spring_Boot_Mariadb_Liquibase.controller;

import com.example.Spring_Boot_Mariadb_Liquibase.controller.request.BusRequest;
import com.example.Spring_Boot_Mariadb_Liquibase.controller.response.BusResponse;
import com.example.Spring_Boot_Mariadb_Liquibase.service.BusService;
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
@AllArgsConstructor
@RequestMapping("/buses")
public class BusController {

  private final BusService busService;

  @PostMapping("")
  public BusResponse create(@RequestBody BusRequest request) {
    return busService.create(request);
  }

  @GetMapping("")
  public List<BusResponse> getAll() {
    return busService.getAll();
  }

  @GetMapping("/{id}")
  public BusResponse getById(@PathVariable Long id) {
    return busService.getBusById(id);
  }

  @PutMapping("/{id}")
  public void updateBus(@RequestBody BusRequest request, @PathVariable Long id) {
    busService.updateById(request, id);
  }

  @DeleteMapping("/{id}")
  public void deleteBus(@PathVariable Long id) {
    busService.deleteById(id);
  }
}
