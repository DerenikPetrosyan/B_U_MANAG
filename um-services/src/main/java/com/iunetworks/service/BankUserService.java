package com.iunetworks.service;

import com.iunetworks.entities.dto.request.BankUserRequestDto;
import com.iunetworks.entities.dto.response.BankUserResponseDto;

import java.util.List;
import java.util.UUID;

public interface BankUserService {

  void createBankUser(BankUserRequestDto dto);

  BankUserResponseDto getByBankUserId(UUID id);

  List<BankUserResponseDto> getAll();

  void update(BankUserRequestDto dto);

  void delete(UUID id);
}
