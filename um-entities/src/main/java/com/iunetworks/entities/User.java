package com.iunetworks.entities;

import com.iunetworks.entities.address.Address;
import com.iunetworks.entities.enums.Gender;
import com.iunetworks.entities.enums.UserStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public class User {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;


  @NotBlank
  @Column(name = "name", nullable = false)
  private String name;

  @NotBlank
  @Column(name = "surname", nullable = false)
  private String surname;

  @NotBlank
  @Column(name = "email", nullable = false)
  private String email;

  @NotBlank
  @Column(name = "u_password", nullable = false)
  private String password;

  @NotNull
  @Column(name = "gender", nullable = false)
  @Enumerated(value = EnumType.STRING)
  private Gender gender;


  @Column(name = "status", nullable = false)
  @Enumerated(value = EnumType.STRING)
  private UserStatus status;

//  @Column(name = "ver_code")
//  private String verCode;

  @Column(name = "reset_password_token")
  private String resetPasswordToken;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="`address_id`")
  private Address address;


  @Column(name = "created", nullable = false)
  private LocalDateTime created;

  @Column(name = "updated", nullable = false)
  private LocalDateTime updated;

  @Column(name = "deleted")
  private LocalDateTime deleted;

  public User() {
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public UserStatus getStatus() {
    return status;
  }

  public void setStatus(UserStatus status) {
    this.status = status;
  }

  public String getResetPasswordToken() {
    return resetPasswordToken;
  }

  public void setResetPasswordToken(String resetPasswordToken) {
    this.resetPasswordToken = resetPasswordToken;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
//
//  public String getVerCode() {
//    return verCode;
//  }
//
//  public void setVerCode(String verCode) {
//    this.verCode = verCode;
//  }

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

