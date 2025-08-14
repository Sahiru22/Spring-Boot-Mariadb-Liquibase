package com.example.Spring_Boot_Mariadb_Liquibase.service;

import com.example.Spring_Boot_Mariadb_Liquibase.controller.request.BusRequest;
import com.example.Spring_Boot_Mariadb_Liquibase.controller.response.BusResponse;
import java.util.List;

public interface BusService {

  BusResponse create(BusRequest request);

  List<BusResponse> getAll();

  BusResponse getBusById(Long id);

  void updateById(BusRequest request, Long id);

  void deleteById(Long id);
}
