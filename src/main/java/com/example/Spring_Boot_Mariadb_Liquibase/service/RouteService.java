package com.example.Spring_Boot_Mariadb_Liquibase.service;

import com.example.Spring_Boot_Mariadb_Liquibase.controller.request.RouteRequest;
import com.example.Spring_Boot_Mariadb_Liquibase.controller.response.RouteResponse;
import java.util.List;

public interface RouteService {

  RouteResponse create(RouteRequest request);

  List<RouteResponse> getAll();

  RouteResponse getById(Long id);

  void updateById(RouteRequest request, Long id);

  void deleteById(Long id);
}
