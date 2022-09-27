package com.iunetworks.service.mapper;

import com.iunetworks.entities.BankUser;
import com.iunetworks.entities.dto.request.BankUserRequestDto;
import org.springframework.stereotype.Component;

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
}
