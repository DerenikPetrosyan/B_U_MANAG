package com.iunetworks.entities.address;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "t_state")
public class State {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "state", nullable = false)
  private String state;

  @ManyToOne
  @JoinColumn(name = "country_id", referencedColumnName = "id")
  private Country country;

}
