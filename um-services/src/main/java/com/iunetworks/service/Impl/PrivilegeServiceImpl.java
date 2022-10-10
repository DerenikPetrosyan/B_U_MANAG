package com.iunetworks.service.Impl;

import com.iunetworks.entities.Privilege;
import com.iunetworks.entities.Role;
import com.iunetworks.service.PrivilegeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

  @Override
  public Set<String> permissions( Set<Role> roles) {
     Set<String> permissions = new HashSet<>();

    roles.forEach(role -> permissions.addAll(role.getPrivileges().stream()
      .map(Privilege::getName)
      .collect(Collectors.toSet())
    ));

    return permissions;
  }
}
