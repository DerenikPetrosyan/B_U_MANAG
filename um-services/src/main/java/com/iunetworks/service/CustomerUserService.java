package com.iunetworks.service;

import com.iunetworks.entities.dto.request.CustomerUserRequestDto;
import com.iunetworks.entities.dto.response.CustomerUserResponseDto;

import java.util.List;
import java.util.UUID;

public interface CustomerUserService {

  void createCustomerUser(CustomerUserRequestDto dto);

   CustomerUserResponseDto getByCustomerUserId(UUID id);

  List<CustomerUserResponseDto> getAll();

  void forgotPassword(String email);


  void changePassword(String username, String oldPassword, String newPassword);

  void update(CustomerUserRequestDto dto);

  void delete(UUID id);
}
