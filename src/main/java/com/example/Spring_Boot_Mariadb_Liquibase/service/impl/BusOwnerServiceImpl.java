package com.example.Spring_Boot_Mariadb_Liquibase.service.impl;

import com.example.Spring_Boot_Mariadb_Liquibase.controller.request.BusOwnerRequest;
import com.example.Spring_Boot_Mariadb_Liquibase.controller.response.BusOwnerResponse;
import com.example.Spring_Boot_Mariadb_Liquibase.model.BusOwner;
import com.example.Spring_Boot_Mariadb_Liquibase.repository.BusOwnerRepository;
import com.example.Spring_Boot_Mariadb_Liquibase.service.BusOwnerService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class BusOwnerServiceImpl implements BusOwnerService {

  private final BusOwnerRepository busOwnerRepository;

  @Override
  public BusOwnerResponse create(BusOwnerRequest request) {
    BusOwner busOwner = new BusOwner();
    busOwner.setName(request.getName());

    busOwnerRepository.save(busOwner);

    BusOwnerResponse response = new BusOwnerResponse();
    response.setId(busOwner.getId());
    response.setName(busOwner.getName());

    log.info("Bus Owner added successfully. Bus ID: {}", busOwner.getId());

    return response;
  }

  @Override
  public List<BusOwnerResponse> getAll() {
    log.info("Getting all bus owners");

    List<BusOwner> busOwners = busOwnerRepository.findAll();
    List<BusOwnerResponse> createBusOwnerResponseList = new ArrayList<>();

    for (BusOwner busOwner : busOwners) {
      BusOwnerResponse response = new BusOwnerResponse();

      response.setId(busOwner.getId());
      response.setName(busOwner.getName());

      createBusOwnerResponseList.add(response);
    }

    return createBusOwnerResponseList;
  }

  @Override
  public BusOwnerResponse getById(Long id) {
    log.info("Get bus owner details by id. Bus Owner ID: {}", id);

    Optional<BusOwner> busOwnerOptional = busOwnerRepository.findById(id);

    if (busOwnerOptional.isPresent()) {
      BusOwner busOwner = busOwnerOptional.get();

      BusOwnerResponse response = new BusOwnerResponse();

      response.setId(busOwner.getId());
      response.setName(busOwner.getName());

      return response;
    }
    return null;
  }

  @Override
  public void updateById(BusOwnerRequest request, Long id) {
    log.info("Update by id. Bus Owner ID: {}", id);

    Optional<BusOwner> busOwnerOptional = busOwnerRepository.findById(id);

    if (busOwnerOptional.isPresent()) {
      BusOwner busOwner = busOwnerOptional.get();

      busOwner.setId(request.getId());
      busOwner.setName(request.getName());

      busOwnerRepository.save(busOwner);
    }
  }

  @Override
  public void deleteById(Long id) {
    log.info("Bus Owner delete by id. Bus Owner ID: {}", id);
    busOwnerRepository.deleteById(id);
  }
}
