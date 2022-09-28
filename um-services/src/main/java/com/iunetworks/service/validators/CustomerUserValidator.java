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

  private final CustomerUserRepository customerUserRepository;
  private final EmailValidator emailValidator = new EmailValidator();
  private final PasswordValidator passwordValidator = new PasswordValidator();

  public CustomerUserValidator(CustomerUserRepository customerUserRepository) {
    this.customerUserRepository = customerUserRepository;
  }

  public void isValidCustomerUser(CustomerUserRequestDto dto) {

    if (customerUserRepository.existsByEmail(dto.getEmail())) {
      throw new DuplicateException("This email is already registered or does not exist, try a new email");
    } else if (dto.getPassword().compareTo(dto.getConfirmPassword()) != 0) {
      throw new BadRequestException("The Confirm Password field does not match the Password field");
    }else if (dto.getName().charAt(0) < 65 && dto.getName().charAt(0) > 90 ||  dto.getName().charAt(0) < 97 && dto.getName().charAt(0) > 122 ){
      throw new BadRequestException("The name fild must begin with an uppercase or lowercase English letter");
    }else if (dto.getSurname().charAt(0) < 65 && dto.getSurname().charAt(0) > 90 ||  dto.getSurname().charAt(0) < 97 && dto.getSurname().charAt(0) > 122 ){
      throw new BadRequestException("The surname fild must begin with an uppercase or lowercase English letter");
    }else if(emailValidator.isValid(dto.getEmail())){
      throw new BadRequestException("email must contain '@' and '.',must be entered as *******@***.***");
    }else if(passwordValidator.isValid(dto.getPassword())){
      throw new BadRequestException("password must be 8 - 20 characters");
    }
  }

  public void existsCustomerUser(UUID id) {
    if (!customerUserRepository.existsById(id)) {
      throw new ResourceNotFoundException(String.format("Resource with id : {%s} not found", id.toString()));
    }
  }
}
