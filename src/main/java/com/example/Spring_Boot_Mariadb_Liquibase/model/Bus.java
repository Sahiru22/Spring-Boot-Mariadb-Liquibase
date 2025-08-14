package com.example.Spring_Boot_Mariadb_Liquibase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "buses")
public class Bus {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String registrationNo;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private BusOwner owner;

  @OneToMany(mappedBy = "bus")
  private List<BusEmployee> employees = new ArrayList<>();

  @ManyToMany
  @JoinTable(name = "bus_routes", joinColumns = {
      @JoinColumn(name = "bus_id")
  }, inverseJoinColumns = {@JoinColumn(name = "route_id")})
  private List<Route> routes = new ArrayList<>();
}
