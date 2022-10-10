package com.iunetworks.service;

import com.iunetworks.entities.BankUser;
import com.iunetworks.entities.dto.request.BankUserRequestDto;
import com.iunetworks.entities.dto.request.CustomerUserRequestDto;
import com.iunetworks.entities.dto.request.SignInDto;
import com.iunetworks.entities.dto.response.BankUserResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface BankUserService {

  void createBankUser(BankUserRequestDto dto);

  void createCustomer(CustomerUserRequestDto dto);

  BankUserResponseDto getByBankUserId(UUID id);

  List<BankUserResponseDto> getAll();

  void update(BankUserRequestDto dto);

  void delete(UUID id);

  ResponseEntity<?> signIn(SignInDto dto);

  public BankUser getByUsername(String username);
}
