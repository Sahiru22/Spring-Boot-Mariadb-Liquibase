package com.example.Spring_Boot_Mariadb_Liquibase.repository;

import com.example.Spring_Boot_Mariadb_Liquibase.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}
