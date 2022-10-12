package com.iunetworks.config.jwt;

import com.iunetworks.entities.BankUserDetails;
import com.iunetworks.entities.CustomerUserDetails;
import com.iunetworks.repositories.BankUserRepository;
import com.iunetworks.repositories.CustomerUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("myUserDetailsService")
public class JwtUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

  //todo: need to add your repository info: for example
  private final BankUserRepository bankUserRepository;
  private final CustomerUserRepository customerUserRepository;
  public JwtUserDetailsService(BankUserRepository bankUserRepository, CustomerUserRepository customerUserRepository) {
    this.bankUserRepository = bankUserRepository;
    this.customerUserRepository = customerUserRepository;
  }
  //todo: need to add your user options
  @Transactional
  @Override
  public UserDetails loadUserByUsername(String username) {
    boolean existsByBankUser = bankUserRepository.existsByEmail(username) ;
    boolean existsByCustomerUser = customerUserRepository.existsByEmail(username);
    if(existsByBankUser && existsByCustomerUser){
      throw new UsernameNotFoundException("Wrong username: " + username);
    }else if(existsByBankUser){
      return new BankUserDetails(bankUserRepository.findByEmailAndDeletedIsNull(username));
    }
    else {
      return new CustomerUserDetails(customerUserRepository.findByEmailAndDeletedIsNull(username));
    }
  }
}
