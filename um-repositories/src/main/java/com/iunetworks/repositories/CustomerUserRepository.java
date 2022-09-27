package com.iunetworks.repositories;

import com.iunetworks.entities.CustomerUser;
import com.iunetworks.entities.dto.request.CustomerUserRequestDto;
import com.iunetworks.entities.dto.response.CustomerUserResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerUserRepository extends JpaRepository<CustomerUser, UUID> {

  boolean existsByEmail(String email);



}
