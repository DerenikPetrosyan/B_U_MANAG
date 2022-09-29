package com.iunetworks.service.Impl;

import com.iunetworks.entities.BankUser;
import com.iunetworks.entities.Role;
import com.iunetworks.entities.dto.request.BankUserRequestDto;
import com.iunetworks.entities.dto.request.CustomerUserRequestDto;
import com.iunetworks.entities.dto.response.BankUserResponseDto;
import com.iunetworks.entities.enums.UserStatus;
import com.iunetworks.service.CustomerUserService;
import com.iunetworks.service.RoleService;
import com.iunetworks.service.mapper.BankUserMapper;
import com.iunetworks.repositories.BankUserRepository;
import com.iunetworks.service.BankUserService;
import com.iunetworks.service.validators.BankUserValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class BankUserServiceImpl implements BankUserService {

  private final BankUserRepository bankUserRepository;

  private final BankUserMapper bankUserMapper;

  private final BankUserValidator bankUserValidator;

  private final RoleService roleService;

  private final CustomerUserService customerUserService;

  public BankUserServiceImpl(BankUserRepository bankUserRepository, BankUserMapper bankUserMapper, BankUserValidator bankUserValidator, RoleService roleService, CustomerUserService customerUserService) {
    this.bankUserRepository = bankUserRepository;
    this.bankUserMapper = bankUserMapper;
    this.bankUserValidator = bankUserValidator;
    this.roleService = roleService;
    this.customerUserService = customerUserService;
  }

  @Override
  @Transactional
  public void createBankUser(BankUserRequestDto dto) {

    bankUserValidator.isValidBankUser(dto);

    BankUser bankUser = bankUserMapper.toBankUser(dto);

    bankUser.setStatus(UserStatus.UNVERIFIED);

    List<Role> roles = new ArrayList<>();
    roles.add(roleService.getRoleByRoleName("BANK_USER"));

    bankUser.setRoles(roles);

    bankUserRepository.save(bankUser);

  }

  @Override
  public void createCustomer(CustomerUserRequestDto dto) {
    customerUserService.cratetoCustomer(dto);
  }

  @Override
  public BankUserResponseDto getByBankUserId(UUID id) {
    bankUserValidator.existsBankUser(id);
    return bankUserMapper.toBankUserResponseDto( bankUserRepository.findById(id).get());
  }

  @Override
  public List<BankUserResponseDto> getAll() {
    List<BankUserResponseDto> bankUserResponseDtoList = new ArrayList<>();
    bankUserRepository.findAll().forEach(bankUser -> bankUserResponseDtoList.add(bankUserMapper.toBankUserResponseDto(bankUser)));
    return bankUserResponseDtoList;
  }

  @Override
  public void update(BankUserRequestDto dto) {
    bankUserValidator.isValidBankUser(dto);
    bankUserRepository.save(bankUserMapper.toBankUser(dto));
  }

  @Override
  public void delete(UUID id) {
    bankUserValidator.existsBankUser(id);
    bankUserRepository.deleteById(id);
  }

}
