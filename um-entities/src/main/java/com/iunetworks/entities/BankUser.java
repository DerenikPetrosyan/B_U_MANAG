package com.iunetworks.entities;

import com.iunetworks.entities.enums.Gender;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "t_bank_user")
public class BankUser extends User{


  @ManyToMany
  @JoinTable(
    name = "t_bank_users_roles",
    joinColumns = @JoinColumn(name = "bank_user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
  private List<Role> roles;

  public BankUser() {
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }
}
