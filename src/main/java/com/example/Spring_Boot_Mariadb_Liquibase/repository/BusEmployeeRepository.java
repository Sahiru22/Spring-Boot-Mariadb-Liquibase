package com.example.Spring_Boot_Mariadb_Liquibase.repository;

import com.example.Spring_Boot_Mariadb_Liquibase.model.BusEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusEmployeeRepository extends JpaRepository<BusEmployee, Long> {

}
