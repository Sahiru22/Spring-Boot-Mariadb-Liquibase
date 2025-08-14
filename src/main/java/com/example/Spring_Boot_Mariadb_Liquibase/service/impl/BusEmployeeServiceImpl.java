package com.example.Spring_Boot_Mariadb_Liquibase.service.impl;

import com.example.Spring_Boot_Mariadb_Liquibase.controller.request.BusEmployeeRequest;
import com.example.Spring_Boot_Mariadb_Liquibase.controller.response.BusEmployeeResponse;
import com.example.Spring_Boot_Mariadb_Liquibase.model.Bus;
import com.example.Spring_Boot_Mariadb_Liquibase.model.BusEmployee;
import com.example.Spring_Boot_Mariadb_Liquibase.repository.BusEmployeeRepository;
import com.example.Spring_Boot_Mariadb_Liquibase.repository.BusRepository;
import com.example.Spring_Boot_Mariadb_Liquibase.service.BusEmployeeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class BusEmployeeServiceImpl implements BusEmployeeService {

  private final BusEmployeeRepository busEmployeeRepository;
  private final BusRepository busRepository;

  @Override
  public BusEmployeeResponse create(BusEmployeeRequest request) {

    BusEmployee busEmployee = new BusEmployee();
    busEmployee.setName(request.getName());
    busEmployee.setEmploymentType(request.getEmploymentType());

    Bus bus = busRepository.findById(request.getBusId())
        .orElseThrow(() -> new RuntimeException("Bus not found with ID: " + request.getBusId()));
    busEmployee.setBus(bus);

    busEmployeeRepository.save(busEmployee);

    busEmployeeRepository.save(busEmployee);

    BusEmployeeResponse response = new BusEmployeeResponse();
    response.setId(busEmployee.getId());

    log.info("Bus employee added successfully. Employee ID: {}", busEmployee.getId());

    return response;
  }

  @Override
  public List<BusEmployeeResponse> getAll() {
    log.info("Getting all employees");

    List<BusEmployee> busEmployees = busEmployeeRepository.findAll();
    List<BusEmployeeResponse> createBusEmployeeResponseList = new ArrayList<>();

    for (BusEmployee busEmployee : busEmployees) {
      BusEmployeeResponse response = new BusEmployeeResponse();

      response.setId(busEmployee.getId());

      createBusEmployeeResponseList.add(response);
    }

    return createBusEmployeeResponseList;
  }

  @Override
  public BusEmployeeResponse getById(Long id) {
    log.info("Get employee details by id. Employee ID: {}", id);

    Optional<BusEmployee> busEmployeeOptional = busEmployeeRepository.findById(id);

    if (busEmployeeOptional.isPresent()) {
      BusEmployee busEmployee = busEmployeeOptional.get();

      BusEmployeeResponse response = new BusEmployeeResponse();

      response.setId(busEmployee.getId());

      return response;
    }
    return null;
  }

  @Override
  public void updateById(BusEmployeeRequest request, Long id) {
    log.info("Update by id. Employee ID: {}", id);

    Optional<BusEmployee> busEmployeeOptional = busEmployeeRepository.findById(id);

    if (busEmployeeOptional.isPresent()) {
      BusEmployee busEmployee = busEmployeeOptional.get();

      busEmployee.setId(request.getId());
      busEmployee.setName(request.getName());
      busEmployee.setEmploymentType(request.getEmploymentType());

      Bus bus = busRepository.findById(request.getBusId())
          .orElseThrow(() -> new RuntimeException("Bus not found with ID: " + request.getBusId()));
      busEmployee.setBus(bus);

      busEmployeeRepository.save(busEmployee);

      busEmployeeRepository.save(busEmployee);
    }
  }

  @Override
  public void deleteById(Long id) {
    log.info("Employee delete by id. Employee ID: {}", id);
    busEmployeeRepository.deleteById(id);
  }
}
