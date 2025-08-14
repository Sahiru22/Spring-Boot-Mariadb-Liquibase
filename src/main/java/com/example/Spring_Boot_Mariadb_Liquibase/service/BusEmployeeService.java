package com.example.Spring_Boot_Mariadb_Liquibase.service;

import com.example.Spring_Boot_Mariadb_Liquibase.controller.request.BusEmployeeRequest;
import com.example.Spring_Boot_Mariadb_Liquibase.controller.response.BusEmployeeResponse;
import java.util.List;

public interface BusEmployeeService {

  BusEmployeeResponse create(BusEmployeeRequest request);

  List<BusEmployeeResponse> getAll();

  BusEmployeeResponse getById(Long id);

  void updateById(BusEmployeeRequest request, Long id);

  void deleteById(Long id);
}
