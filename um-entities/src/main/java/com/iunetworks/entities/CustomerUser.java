package com.iunetworks.entities;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "t_costomer_user")
public class CustomerUser extends User{

  @ManyToMany
  @JoinTable(
    name = "t_costomer_users_roles",
    joinColumns = @JoinColumn(name = "costomer_user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;

  public CustomerUser() {

  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
