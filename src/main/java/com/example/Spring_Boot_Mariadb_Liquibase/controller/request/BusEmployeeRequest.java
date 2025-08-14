package com.example.Spring_Boot_Mariadb_Liquibase.controller.request;

import com.example.Spring_Boot_Mariadb_Liquibase.model.EmploymentType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class BusEmployeeRequest {

  private Long id;

  private String name;

  @Enumerated(EnumType.STRING)
  private EmploymentType employmentType = EmploymentType.DRIVER;

  private Long busId;
}
