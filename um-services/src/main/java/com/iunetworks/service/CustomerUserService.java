package com.iunetworks.service;

import com.iunetworks.entities.CustomerUser;
import com.iunetworks.entities.dto.request.CustomerUserRequestDto;
import com.iunetworks.entities.dto.request.SignInDto;
import com.iunetworks.entities.dto.response.CustomerUserResponseDto;

import java.util.List;
import java.util.UUID;

public interface CustomerUserService {

  void createCustomerUser(CustomerUserRequestDto dto);

  CustomerUserResponseDto getByCustomerUserId(UUID id);

  List<CustomerUserResponseDto> getAll();

  void update(CustomerUserRequestDto dto);

  void delete(UUID id);

  void cratetoCustomer(CustomerUserRequestDto dto);

  CustomerUser getByUsername(String username);

  void signIn(SignInDto dto);
}
