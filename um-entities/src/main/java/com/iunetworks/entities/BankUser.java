package com.iunetworks.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "t_bank_user")
public class BankUser extends User{


  @ManyToMany
  @JoinTable(
    name = "t_bank_users_roles",
    joinColumns = @JoinColumn(name = "bank_user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;

  public BankUser() {
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
