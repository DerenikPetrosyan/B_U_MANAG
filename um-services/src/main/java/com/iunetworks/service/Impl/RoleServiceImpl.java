package com.iunetworks.service.Impl;

import com.iunetworks.entities.Role;
import com.iunetworks.repositories.RoleRepository;
import com.iunetworks.service.RoleService;
import com.iunetworks.service.validators.RoleValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

  private final RoleValidator roleValidator;

  public RoleServiceImpl(RoleRepository roleRepository, RoleValidator roleValidator) {
    this.roleRepository = roleRepository;
    this.roleValidator = roleValidator;
  }

  @Override
  public void createRole(Role role) {
    roleValidator.isValidRole(role);
    roleRepository.save(role);
  }

  @Override
  public Role getRoleId(UUID id) {
    roleValidator.existsRole(id);
    return roleRepository.findById(id).get();
  }

  @Override
  public List<Role> getRoles() {
    return roleRepository.findAll();
  }

  @Override
  public Role getRoleByRoleName(String userRole) {
    return roleRepository.findByRoleName(userRole);
  }

  @Override
  public void updateRoleName(UUID id, String roleName) {
    roleValidator.existsRole(id);
    Role role = roleRepository.findById(id).get();
    role.setRoleName(roleName);
    roleRepository.save(role);
  }

  @Override
  public void delete(UUID id) {
    roleValidator.existsRole(id);
    roleRepository.deleteById(id);
  }
}
