package com.iunetworks.service.mapper;

import com.iunetworks.entities.BankUser;
import com.iunetworks.entities.dto.request.BankUserRequestDto;
import com.iunetworks.entities.dto.response.BankUserResponseDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BankUserMapper {

  public BankUser toBankUser(BankUserRequestDto dto){

    BankUser bankUser = new BankUser();

    bankUser.setName(dto.getName());
    bankUser.setSurname(dto.getSurname());
    bankUser.setEmail(dto.getEmail());
    bankUser.setGender(dto.getGender());
    bankUser.setPassword(dto.getPassword());

    return bankUser;
  }

  public BankUserResponseDto  toBankUserResponseDto(BankUser bankUser){
    BankUserResponseDto bankUserResponseDto = new BankUserResponseDto();

    bankUserResponseDto.setId(bankUser.getId());
    bankUserResponseDto.setName(bankUser.getName());
    bankUserResponseDto.setSurname(bankUser.getSurname());
    bankUserResponseDto.setEmail(bankUser.getEmail());
    bankUserResponseDto.setDob(bankUser.getDob());
    bankUserResponseDto.setGender(bankUser.getGender());
    bankUserResponseDto.setRoles(bankUser.getRoles());
    bankUserResponseDto.setStatus(bankUser.getStatus());
    bankUserResponseDto.setCreated(bankUser.getCreated());

    return bankUserResponseDto;
  }
}
