package com.iunetworks.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "t_roles")
public class Role {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  private String roleName;



  @ManyToMany
  @JoinTable(
    name = "roles_privileges",
    joinColumns = @JoinColumn(
      name = "role_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(
      name = "privilege_id", referencedColumnName = "id"))
  private List<Privilege> privileges;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public List<Privilege> getPrivileges() {
    return privileges;
  }

  public void setPrivileges(List<Privilege> privileges) {
    this.privileges = privileges;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public Role() {
  }

  @Override
  public String toString() {
    return "Role{" +
      "id=" + id +
      ", roleName='" + roleName + '\'' +
      ", privileges=" + privileges +
      '}';
  }
}
