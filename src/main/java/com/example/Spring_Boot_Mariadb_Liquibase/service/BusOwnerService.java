package com.example.Spring_Boot_Mariadb_Liquibase.service;

import com.example.Spring_Boot_Mariadb_Liquibase.controller.request.BusOwnerRequest;
import com.example.Spring_Boot_Mariadb_Liquibase.controller.response.BusOwnerResponse;
import java.util.List;

public interface BusOwnerService {

  BusOwnerResponse create(BusOwnerRequest request);

  List<BusOwnerResponse> getAll();

  BusOwnerResponse getById(Long id);

  void updateById(BusOwnerRequest request, Long id);

  void deleteById(Long id);
}
