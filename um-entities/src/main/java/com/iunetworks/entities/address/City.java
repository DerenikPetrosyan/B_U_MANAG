package com.iunetworks.entities.address;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "t_city")
public class City {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;


  @Column(name = "city", nullable = false)
  private String city;

  @ManyToOne
  @Column(name = "state_id", nullable = false)
  private State state;

  @ManyToOne
  @Column(name = "country_id", nullable = false)
  private Country country;
}
