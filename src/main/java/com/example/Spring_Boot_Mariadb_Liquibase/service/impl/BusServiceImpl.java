package com.example.Spring_Boot_Mariadb_Liquibase.service.impl;

import com.example.Spring_Boot_Mariadb_Liquibase.controller.request.BusRequest;
import com.example.Spring_Boot_Mariadb_Liquibase.controller.response.BusResponse;
import com.example.Spring_Boot_Mariadb_Liquibase.model.Bus;
import com.example.Spring_Boot_Mariadb_Liquibase.repository.BusRepository;
import com.example.Spring_Boot_Mariadb_Liquibase.service.BusService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class BusServiceImpl implements BusService {

  private final BusRepository busRepository;

  @Override
  public BusResponse create(BusRequest request) {

    Bus bus = new Bus();
    bus.setRegistrationNo(request.getRegistrationNo());

    busRepository.save(bus);

    BusResponse response = new BusResponse();
    response.setId(bus.getId());
    response.setRegistrationNo(bus.getRegistrationNo());

    log.info("Bus added successfully. Bus ID: {}", bus.getId());

    return response;
  }

  @Override
  public List<BusResponse> getAll() {
    log.info("Getting all buses");

    List<Bus> buses = busRepository.findAll();
    List<BusResponse> createBusResponseList = new ArrayList<>();

    for (Bus bus : buses) {
      BusResponse response = new BusResponse();

      response.setId(bus.getId());
      response.setRegistrationNo(bus.getRegistrationNo());

      createBusResponseList.add(response);
    }

    return createBusResponseList;
  }

  @Override
  public BusResponse getBusById(Long id) {
    log.info("Get bus details by id. Bus ID: {}", id);

    Optional<Bus> busOptional = busRepository.findById(id);

    if (busOptional.isPresent()) {
      Bus bus = busOptional.get();

      BusResponse response = new BusResponse();

      response.setId(bus.getId());
      response.setRegistrationNo(bus.getRegistrationNo());

      return response;
    }
    return null;
  }

  @Override
  public void updateById(BusRequest request, Long id) {
    log.info("Update by id. Bus ID: {}", id);

    Optional<Bus> busOptional = busRepository.findById(id);

    if (busOptional.isPresent()) {
      Bus bus = busOptional.get();

      bus.setId(request.getId());
      bus.setRegistrationNo(request.getRegistrationNo());

      busRepository.save(bus);
    }
  }

  @Override
  public void deleteById(Long id) {
    log.info("Bus delete by id. Bus ID: {}", id);
    busRepository.deleteById(id);
  }
}
