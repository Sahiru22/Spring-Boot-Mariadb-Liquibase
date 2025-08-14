package com.example.Spring_Boot_Mariadb_Liquibase.repository;

import com.example.Spring_Boot_Mariadb_Liquibase.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {

}
