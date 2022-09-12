package com.iunetworks.entities.address;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "t_address")
public class Address {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @ManyToOne
  @Column(name = "country_id", nullable = false)
  private Country country;

  @ManyToOne
  @Column(name = "state_id", nullable = false)
  private State state;

  @ManyToOne
  @Column(name = "city_id", nullable = false)
  private City city;


  @Column(name = "zip_code", nullable = false)
  private String zipCode;

  @Column(name = "address", nullable = false)
  private String address;
}
