package com.iunetworks.service.validators;

import com.iunetworks.entities.dto.request.BankUserRequestDto;
import com.iunetworks.exception.BadRequestException;
import com.iunetworks.exception.DuplicateException;
import com.iunetworks.exception.ResourceNotFoundException;
import com.iunetworks.repositories.BankUserRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class BankUserValidator {
  private final BankUserRepository bankUserRepository;
  private final EmailValidator emailValidator = new EmailValidator();
  private final PasswordValidator passwordValidator = new PasswordValidator();

  public BankUserValidator(BankUserRepository bankUserRepository) {
    this.bankUserRepository = bankUserRepository;
  }

  public void isValidBankUser(BankUserRequestDto dto) {

    if (bankUserRepository.existsByEmail(dto.getEmail())) {
      throw new DuplicateException("This email is already registered or does not exist, try a new email");
    }
    if (dto.getPassword().compareTo(dto.getConfirmPassword()) != 0) {
      throw new BadRequestException("The Confirm Password field does not match the Password field");
    }
    if (dto.getName().charAt(0) < 65 && dto.getName().charAt(0) > 90 ||  dto.getName().charAt(0) < 97 && dto.getName().charAt(0) > 122 ){
      throw new BadRequestException(String.format("The name fild must begin with an uppercase or lowercase English letter " + dto.getName().charAt(0)));
    }
    if (dto.getSurname().charAt(0) < 65 && dto.getSurname().charAt(0) > 90 ||  dto.getSurname().charAt(0) < 97 && dto.getSurname().charAt(0) > 122 ){
      throw new BadRequestException("The surname fild must begin with an uppercase or lowercase English letter");
    }

    if(!emailValidator.isValid(dto.getEmail())){
      throw new BadRequestException("email must contain '@' and '.',must be entered as *******@***.***");
    }
    if(!passwordValidator.isValid(dto.getPassword())){
      throw new BadRequestException("password must be 8 - 20 characters");
    }


  }


  public void existsBankUser(UUID id) {
    if (!bankUserRepository.existsById(id)) {
      throw new ResourceNotFoundException(String.format("Resource with id : {%s} not found", id.toString()));
    }
  }

  public void existsByUsername(String username){
    if(!bankUserRepository.existsByEmail(username)){
      throw new ResourceNotFoundException(String.format("Resource with user : {%s} not found",username));
    }
  }

}

