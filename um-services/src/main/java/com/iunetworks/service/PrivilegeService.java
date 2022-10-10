package com.iunetworks.service;

import com.iunetworks.entities.Role;

import java.util.Set;

public interface PrivilegeService {
  Set<String> permissions( Set<Role> roles);
}
