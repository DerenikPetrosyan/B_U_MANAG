package com.iunetworks.entities;

import com.iunetworks.entities.address.Address;
import com.iunetworks.entities.enums.Gender;
import com.iunetworks.entities.enums.UserRole;
import com.iunetworks.entities.enums.UserStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "t_users")
public class User {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "surname", nullable = false)
  private String surname;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "u_password", nullable = false)
  private String password;

  @Column(name = "gender", nullable = false)
  @Enumerated(value = EnumType.STRING)
  private Gender gender;

  @Column(name = "status", nullable = false)
  @Enumerated(value = EnumType.STRING)
  private UserStatus status;

  @Column(name = "ver_code", nullable = false)
  private String verCode;

  @Column(name = "reset_password_token", nullable = false)
  private String resetPasswordToken;

  @Column(name = "role", nullable = false)
  @Enumerated(value = EnumType.STRING)
  private UserRole role;

  @Column(name = "role", nullable = false)
  @Enumerated(value = EnumType.STRING)
  private UserRole role;

  @Column(name = "address_id", nullable = false)
  @OneToOne(cascade = CascadeType.ALL)
  private Address address;

  @Column(name = "created", nullable = false)
  private LocalDateTime created;

  @Column(name = "updated", nullable = false)
  private LocalDateTime updated;

  @Column(name = "deleted")
  private LocalDateTime deleted;

  public User() {

  }

  @PrePersist
  protected void onCreate() {
    this.created = LocalDateTime.now();
    this.updated = this.created;
  }

  @PreUpdate
  protected void onUpdate() {
    this.updated = LocalDateTime.now();
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public LocalDateTime getUpdated() {
    return updated;
  }

  public void setUpdated(LocalDateTime updated) {
    this.updated = updated;
  }

  public LocalDateTime getDeleted() {
    return deleted;
  }

  public void setDeleted(LocalDateTime deleted) {
    this.deleted = deleted;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}

