package com.iunetworks.service.Impl;

import com.iunetworks.entities.CustomerUser;
import com.iunetworks.entities.Role;
import com.iunetworks.entities.dto.request.CustomerUserRequestDto;
import com.iunetworks.entities.dto.response.CustomerUserResponseDto;
import com.iunetworks.entities.enums.UserStatus;
import com.iunetworks.repositories.CustomerUserRepository;
import com.iunetworks.service.CustomerUserService;
import com.iunetworks.service.RoleService;
import com.iunetworks.service.mapper.CustomerUserMapper;
import com.iunetworks.service.validators.CustomerUserValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerUserServiceImpl implements CustomerUserService {

  private final CustomerUserRepository customerUserRepository;

  private final CustomerUserMapper customerUserMapper;

  private final CustomerUserValidator customerUserValidator;

  private final RoleService roleService;

  public CustomerUserServiceImpl(CustomerUserRepository customerUserRepository, CustomerUserMapper customerUserMapper, CustomerUserValidator customerUserValidator, RoleService roleService) {
    this.customerUserRepository = customerUserRepository;
    this.customerUserMapper = customerUserMapper;
    this.customerUserValidator = customerUserValidator;
    this.roleService = roleService;
  }

  @Override
  @Transactional
  public void createCustomerUser(CustomerUserRequestDto dto) {
    customerUserValidator.isValidCustomerUser(dto);

    CustomerUser customerUser = customerUserMapper.toCustomerUser(dto);

    customerUser.setStatus(UserStatus.UNVERIFIED);


    List<Role> roles = new ArrayList<>();
    roles.add(roleService.getRoleByRoleName("CUSTOMER_USER"));

    customerUser.setRoles(roles);

    customerUserRepository.save(customerUser);
  }

  @Override
  public CustomerUserResponseDto getByCustomerUserId(UUID id) {
    customerUserValidator.existsCustomerUser(id);
    return customerUserMapper.toCustomerUserResponseDto(customerUserRepository.findById(id).orElse(null));
  }

  @Override
  public List<CustomerUserResponseDto> getAll() {
    List<CustomerUserResponseDto> customerUserResponseDtoList = new ArrayList<>();
    customerUserRepository.findAll().forEach(customerUser -> customerUserResponseDtoList.add(customerUserMapper.toCustomerUserResponseDto(customerUser)));
    return customerUserResponseDtoList;
  }

  @Override
  public void update(CustomerUserRequestDto dto) {
    customerUserValidator.isValidCustomerUser(dto);
    CustomerUser user = customerUserMapper.toCustomerUser(dto);
    customerUserRepository.save(user);
  }

  @Override
  public void delete(UUID id) {
    customerUserValidator.existsCustomerUser(id);
    customerUserRepository.deleteById(id);
  }

}
