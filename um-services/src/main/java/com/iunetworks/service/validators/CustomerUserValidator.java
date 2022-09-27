package com.iunetworks.service.validators;

import com.iunetworks.entities.dto.request.CustomerUserRequestDto;
import com.iunetworks.exception.BadRequestException;
import com.iunetworks.exception.DuplicateException;
import com.iunetworks.exception.ResourceNotFoundException;
import com.iunetworks.repositories.CustomerUserRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomerUserValidator {

  private final CustomerUserRepository CustomerUserRepository;

  public CustomerUserValidator(CustomerUserRepository CustomerUserRepository) {
    this.CustomerUserRepository = CustomerUserRepository;
  }

  public void isValidCustomerUser(CustomerUserRequestDto dto) {

    if (CustomerUserRepository.existsByEmail(dto.getEmail())) {
      throw new DuplicateException("This email is already registered or does not exist, try a new email");
    } else if (dto.getPassword().compareTo(dto.getConfirmPassword()) != 0) {
      throw new BadRequestException("The Confirm Password field does not match the Password field");
    }
  }

  public void existsCustomerUser(UUID id) {
    if (!CustomerUserRepository.existsById(id)) {
      throw new ResourceNotFoundException(String.format("Resource with id : {%s} not found", id.toString()));
    }
  }
}
