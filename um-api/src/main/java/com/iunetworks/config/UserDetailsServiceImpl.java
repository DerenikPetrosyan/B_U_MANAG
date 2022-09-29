package com.iunetworks.config;

import com.iunetworks.entities.BankUser;
import com.iunetworks.repositories.BankUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private final BankUserRepository bankUserRepository;

  @Autowired
  public UserDetailsServiceImpl(BankUserRepository bankUserRepository) {
    this.bankUserRepository = bankUserRepository;
  }


  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    BankUser bankUser = bankUserRepository.findByEmailAndDeletedIsNull(email);
    if (bankUser == null) {
      throw new UsernameNotFoundException("User with email" + email + " is not found");
    }
    return new CurrentUser(bankUser);
  }


}
