package com.iunetworks.repositories;

import com.iunetworks.entities.CustomerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerUserRepository extends JpaRepository<CustomerUser, UUID> {

  boolean existsByEmail(String email);


    CustomerUser findByEmailAndDeletedIsNull(String username);
}
