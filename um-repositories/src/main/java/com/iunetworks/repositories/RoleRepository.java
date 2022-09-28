package com.iunetworks.repositories;

import com.iunetworks.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;


public interface RoleRepository extends JpaRepository<Role, UUID> {

  Role getById(UUID id);


  @Query(
    value = "SELECT * FROM db_bank_management_um.t_roles  WHERE role_name = ?1",
    nativeQuery = true)
  Role getRoleByRoleName(String roleName);

  @Modifying
  @Query(nativeQuery = true,
    value = "update db_bank_management_um.t_roles set role_name = ?2 where id = ?1")
    void updateRoleName(UUID id, String roleName);


  boolean  existsByRoleName(String roleName);
}
