package com.iunetworks.repositories;

import com.iunetworks.entities.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface PrivilegeRepository extends JpaRepository<Privilege, UUID> {
  Set<Privilege> findAllByNameInAndDeletedIsNull(Set<String> p);
}
