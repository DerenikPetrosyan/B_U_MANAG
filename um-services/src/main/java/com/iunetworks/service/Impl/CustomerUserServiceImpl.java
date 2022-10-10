package com.iunetworks.service.Impl;

import com.iunetworks.entities.CustomerUser;
import com.iunetworks.entities.Role;
import com.iunetworks.entities.dto.request.CustomerUserRequestDto;
import com.iunetworks.entities.dto.request.SignInDto;
import com.iunetworks.entities.dto.response.CustomerUserResponseDto;
import com.iunetworks.entities.enums.UserStatus;
import com.iunetworks.repositories.CustomerUserRepository;
import com.iunetworks.service.CustomerUserService;
import com.iunetworks.service.PrivilegeService;
import com.iunetworks.service.RoleService;
import com.iunetworks.service.mapper.CustomerUserMapper;
import com.iunetworks.service.util.JwtTokenUtil;
import com.iunetworks.service.validators.CustomerUserValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CustomerUserServiceImpl implements CustomerUserService {

  private final CustomerUserRepository customerUserRepository;

  private final CustomerUserMapper customerUserMapper;

  private final CustomerUserValidator customerUserValidator;

  private final RoleService roleService;

  private final PrivilegeService privilegeService;

  private final JwtTokenUtil jwtTokenUtil;

  public CustomerUserServiceImpl(CustomerUserRepository customerUserRepository, CustomerUserMapper customerUserMapper, CustomerUserValidator customerUserValidator, RoleService roleService, PrivilegeService privilegeService, JwtTokenUtil jwtTokenUtil) {
    this.customerUserRepository = customerUserRepository;
    this.customerUserMapper = customerUserMapper;
    this.customerUserValidator = customerUserValidator;
    this.roleService = roleService;
    this.privilegeService = privilegeService;
    this.jwtTokenUtil = jwtTokenUtil;
  }

  @Override
  @Transactional
  public void createCustomerUser(CustomerUserRequestDto dto) {
    customerUserValidator.isValidCustomerUser(dto);

    CustomerUser customerUser = customerUserMapper.toCustomerUser(dto);

    customerUser.setStatus(UserStatus.UNVERIFIED);


    Set<Role> roles = new HashSet<>();
    roles.add(roleService.getRoleByRoleName("CUSTOMER_USER"));

    customerUser.setRoles(roles);

    customerUserRepository.save(customerUser);
  }

  @Override
  public void cratetoCustomer(CustomerUserRequestDto dto) {
    customerUserValidator.isValidCustomerUser(dto);
    CustomerUser customerUser = customerUserMapper.toCustomerUser(dto);

    customerUser.setStatus(UserStatus.ACTIVE);


    Set<Role> roles = new HashSet<>();
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
  public CustomerUser getByUsername(String username){
    customerUserValidator.existsByUsername(username);
    return customerUserRepository.findByEmailAndDeletedIsNull(username);
  }

//   todo:implement this method
  @Override
  public ResponseEntity<?> signIn(SignInDto dto) {
    customerUserValidator.existsByUsername(dto.getUsername());
    CustomerUser customerUser = customerUserRepository.findByEmailAndDeletedIsNull(dto.getUsername());
    Set<String> permissions = privilegeService.permissions((Set<Role>) customerUser.getRoles());
    Map<String, String> tokens = new HashMap<>();
    tokens.put("access_token", jwtTokenUtil.generateToken(customerUser.getEmail(), permissions));
    tokens.put("refresh_token", jwtTokenUtil.generateRefreshToken(customerUser.getEmail(),permissions));

    return new ResponseEntity<>(tokens, HttpStatus.OK);
  }

  @Override
  public void delete(UUID id) {
    customerUserValidator.existsCustomerUser(id);
    customerUserRepository.deleteById(id);
  }



}
