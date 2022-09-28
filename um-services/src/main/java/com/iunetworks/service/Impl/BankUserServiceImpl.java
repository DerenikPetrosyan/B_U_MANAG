package com.iunetworks.service.Impl;

import com.iunetworks.entities.BankUser;
import com.iunetworks.entities.Role;
import com.iunetworks.entities.dto.request.BankUserRequestDto;
import com.iunetworks.entities.dto.response.BankUserResponseDto;
import com.iunetworks.entities.enums.UserStatus;
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

  public BankUserServiceImpl(BankUserRepository bankUserRepository, BankUserMapper bankUserMapper, BankUserValidator bankUserValidator, RoleService roleService) {
    this.bankUserRepository = bankUserRepository;
    this.bankUserMapper = bankUserMapper;
    this.bankUserValidator = bankUserValidator;
    this.roleService = roleService;
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
  public BankUserResponseDto getByBankUserId(UUID id) {
    bankUserValidator.existsBankUser(id);
    return bankUserMapper.toBankUserResponseDto( bankUserRepository.findById(id));
  }

  @Override
  public List<BankUser> getAll() {
    return bankUserRepository.findAll();
  }

  @Override
  public void update(BankUserRequestDto dto) {
    bankUserValidator.isValidBankUser(dto);
//    +

  }

  @Override
  public void delete(UUID id) {
    bankUserValidator.existsBankUser(id);
    bankUserRepository.deleteById(id);
  }

  @Override
  public void forgotPassword(String email) {

  }


  @Override
  public void changePassword(String email, String oldPassword, String newPassword) {

  }

  @Override
  @Transactional
  public void changeName(String name, String email) {
    
  }
}
