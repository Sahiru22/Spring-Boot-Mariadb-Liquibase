package com.example.Spring_Boot_Mariadb_Liquibase.controller.request;

import java.util.List;
import lombok.Data;

@Data
public class BusRequest {

  private Long id;

  private String registrationNo;

  private Long ownerId;

  private List<Long> routeIds;
}
