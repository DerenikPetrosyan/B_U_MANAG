package com.iunetworks.service;

import com.iunetworks.entities.Role;

import java.util.List;
import java.util.UUID;

public interface RoleService {
  void createRole(Role role);

  List<Role> getRoles();

  Role getRoleByRoleName(String userRole);

  Role getRoleId(UUID id);

  void updateRoleName(UUID id, String roleName);

  void delete(UUID id);
}
