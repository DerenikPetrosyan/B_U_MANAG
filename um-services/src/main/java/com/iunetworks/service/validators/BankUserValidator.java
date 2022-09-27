package com.iunetworks.service.validators;

import com.iunetworks.entities.dto.request.BankUserRequestDto;
import com.iunetworks.exception.BadRequestException;
import com.iunetworks.exception.DuplicateException;
import com.iunetworks.exception.EmptyObjectException;
import com.iunetworks.exception.ResourceNotFoundException;
import com.iunetworks.repositories.BankUserRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BankUserValidator {
  private final BankUserRepository bankUserRepository;

  public BankUserValidator(BankUserRepository bankUserRepository) {
    this.bankUserRepository = bankUserRepository;
  }

  public void isValidBankUser(BankUserRequestDto dto) {

    if (bankUserRepository.existsByEmail(dto.getEmail())) {
      throw new DuplicateException("This email is already registered or does not exist, try a new email");
    } else if (dto.getPassword().compareTo(dto.getConfirmPassword()) != 0) {
      throw new BadRequestException("The Confirm Password field does not match the Password field");
    }
  }

  public void existsBankUser(UUID id) {
    if (!bankUserRepository.existsById(id)) {
      throw new ResourceNotFoundException(String.format("Resource with id : {%s} not found", id.toString()));
    }
  }

}

