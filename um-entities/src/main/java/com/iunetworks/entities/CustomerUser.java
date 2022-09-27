package com.iunetworks.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_costomer_user")
public class CustomerUser extends User{


//  @ManyToMany(cascade = CascadeType.ALL)
  @ManyToMany
  @JoinTable(
    name = "t_costomer_users_roles",
    joinColumns = @JoinColumn(name = "costomer_user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
  private List<Role> roles;

  public CustomerUser() {

  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }





}
