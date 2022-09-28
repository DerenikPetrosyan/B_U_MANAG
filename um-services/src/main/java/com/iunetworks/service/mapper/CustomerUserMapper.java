package com.iunetworks.service.mapper;

import com.iunetworks.entities.CustomerUser;
import com.iunetworks.entities.dto.request.CustomerUserRequestDto;
import com.iunetworks.entities.dto.response.CustomerUserResponseDto;

import org.springframework.stereotype.Component;

@Component
public class CustomerUserMapper {

  public CustomerUser toCustomerUser(CustomerUserRequestDto dto){

    CustomerUser customerUser = new CustomerUser();

    customerUser.setName(dto.getName());
    customerUser.setSurname(dto.getSurname());
    customerUser.setEmail(dto.getEmail());
    customerUser.setGender(dto.getGender());
    customerUser.setPassword(dto.getPassword());

    return customerUser;
  }

  public CustomerUserResponseDto toCustomerUserResponseDto(CustomerUser CustomerUser){
    CustomerUserResponseDto customerUserResponseDto = new CustomerUserResponseDto();

    customerUserResponseDto.setId(CustomerUser.getId());
    customerUserResponseDto.setName(CustomerUser.getName());
    customerUserResponseDto.setSurname(CustomerUser.getSurname());
    customerUserResponseDto.setEmail(CustomerUser.getEmail());
    customerUserResponseDto.setDob(CustomerUser.getDob());
    customerUserResponseDto.setGender(CustomerUser.getGender());
    customerUserResponseDto.setRoles(CustomerUser.getRoles());
    customerUserResponseDto.setStatus(CustomerUser.getStatus());
    customerUserResponseDto.setCreated(CustomerUser.getCreated());

    return customerUserResponseDto;
  }
}
