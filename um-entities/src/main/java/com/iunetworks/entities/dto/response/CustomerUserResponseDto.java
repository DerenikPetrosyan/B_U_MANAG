package com.iunetworks.entities.dto.response;

import com.iunetworks.entities.Role;
import com.iunetworks.entities.enums.Gender;
import com.iunetworks.entities.enums.UserStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CustomerUserResponseDto {
  private UUID id;

  private String name;

  private String surname;

  private String email;

  private Gender gender;

  private List<Role> roles;

  private UserStatus status;

  private LocalDateTime created;

  private LocalDateTime updeted;

  public CustomerUserResponseDto() {
  }

  public CustomerUserResponseDto(UUID id, String name, String surname, String email, Gender gender, List<Role> roles, UserStatus status, LocalDateTime created, LocalDateTime updeted) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.gender = gender;
    this.roles = roles;
    this.status = status;
    this.created = created;
    this.updeted = updeted;
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

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public UserStatus getStatus() {
    return status;
  }

  public void setStatus(UserStatus status) {
    this.status = status;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public LocalDateTime getUpdeted() {
    return updeted;
  }

  public void setUpdeted(LocalDateTime updeted) {
    this.updeted = updeted;
  }
}
