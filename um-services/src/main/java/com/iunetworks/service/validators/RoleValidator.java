package com.iunetworks.service.validators;

import com.iunetworks.entities.Role;
import com.iunetworks.exception.DuplicateException;
import com.iunetworks.exception.ResourceNotFoundException;
import com.iunetworks.repositories.RoleRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RoleValidator {

  private final RoleRepository roleRepository;

  public RoleValidator(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  public void isValidRole(Role role){
    if(roleRepository.existsByRoleName(role.getRoleName())){
        throw new DuplicateException("This role already exists");
    }
  }

  public void existsRole(UUID id) {
    if (!roleRepository.existsById(id)) {
      throw new ResourceNotFoundException(String.format("Resource with id : {%s} not found", id.toString()));
    }
  }

}
