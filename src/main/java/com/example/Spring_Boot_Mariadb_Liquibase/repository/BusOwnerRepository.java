package com.example.Spring_Boot_Mariadb_Liquibase.repository;

import com.example.Spring_Boot_Mariadb_Liquibase.model.BusOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusOwnerRepository extends JpaRepository<BusOwner, Long> {

}
