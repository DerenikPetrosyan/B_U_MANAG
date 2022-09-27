package com.iunetworks.service.mapper;

import com.iunetworks.entities.CustomerUser;
import com.iunetworks.entities.dto.request.CustomerUserRequestDto;
import com.iunetworks.entities.dto.response.CustomerUserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerUserMapper {

    public CustomerUser toCustomerUser(CustomerUserRequestDto dto) {
      CustomerUser customerUser = new CustomerUser();

      return customerUser;
    }

  public CustomerUserResponseDto toCustomerUserResponseDto(CustomerUser customerUser) {
    CustomerUserResponseDto customerUsers = new CustomerUserResponseDto();

    return customerUsers;
  }
}
