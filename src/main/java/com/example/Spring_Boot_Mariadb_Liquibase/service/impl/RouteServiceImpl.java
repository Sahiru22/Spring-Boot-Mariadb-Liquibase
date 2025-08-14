package com.example.Spring_Boot_Mariadb_Liquibase.service.impl;

import com.example.Spring_Boot_Mariadb_Liquibase.controller.request.RouteRequest;
import com.example.Spring_Boot_Mariadb_Liquibase.controller.response.RouteResponse;
import com.example.Spring_Boot_Mariadb_Liquibase.model.Route;
import com.example.Spring_Boot_Mariadb_Liquibase.repository.RouteRepository;
import com.example.Spring_Boot_Mariadb_Liquibase.service.RouteService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RouteServiceImpl implements RouteService {

  private final RouteRepository routeRepository;

  @Override
  public RouteResponse create(RouteRequest request) {
    Route route = new Route();
    route.setName(request.getName());

    routeRepository.save(route);

    RouteResponse response = new RouteResponse();
    response.setId(route.getId());
    response.setName(route.getName());

    log.info("Route added successfully. Route ID: {}", route.getId());

    return response;
  }

  @Override
  public List<RouteResponse> getAll() {
    log.info("Getting all routes");

    List<Route> routes = routeRepository.findAll();
    List<RouteResponse> createRouteResponseList = new ArrayList<>();

    for (Route route : routes) {
      RouteResponse response = new RouteResponse();

      response.setId(route.getId());
      response.setName(route.getName());

      createRouteResponseList.add(response);
    }

    return createRouteResponseList;
  }

  @Override
  public RouteResponse getById(Long id) {
    log.info("Get route details by id. Route ID: {}", id);

    Optional<Route> routeOptional = routeRepository.findById(id);

    if (routeOptional.isPresent()) {
      Route route = routeOptional.get();

      RouteResponse response = new RouteResponse();

      response.setId(route.getId());
      response.setName(route.getName());

      return response;
    }
    return null;
  }

  @Override
  public void updateById(RouteRequest request, Long id) {
    log.info("Update by id. Route ID: {}", id);

    Optional<Route> routeOptional = routeRepository.findById(id);

    if (routeOptional.isPresent()) {
      Route route = routeOptional.get();

      route.setId(request.getId());
      route.setName(request.getName());

      routeRepository.save(route);
    }
  }

  @Override
  public void deleteById(Long id) {
    log.info("Route delete by id. Route ID: {}", id);
    routeRepository.deleteById(id);
  }
}
