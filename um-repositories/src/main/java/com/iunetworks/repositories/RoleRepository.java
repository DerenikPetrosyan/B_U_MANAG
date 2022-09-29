package com.iunetworks.repositories;

import com.iunetworks.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;


public interface RoleRepository extends JpaRepository<Role, UUID> {

  boolean  existsByRoleName(String roleName);

  Role findByRoleName(String roleName);
}
