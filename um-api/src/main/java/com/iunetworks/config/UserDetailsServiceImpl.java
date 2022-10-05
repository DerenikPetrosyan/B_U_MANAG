package com.iunetworks.config;

import com.iunetworks.entities.BankUser;
import com.iunetworks.entities.CustomerUser;
import com.iunetworks.repositories.BankUserRepository;
import com.iunetworks.repositories.CustomerUserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class UserDetailsServiceImpl implements UserDetailsService {

  private final BankUserRepository bankUserRepository;

  private final CustomerUserRepository customerUserRepository;

  public UserDetailsServiceImpl(BankUserRepository bankUserRepository, CustomerUserRepository customerUserRepository) {
    this.bankUserRepository = bankUserRepository;
    this.customerUserRepository = customerUserRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    boolean existsByBankUser = bankUserRepository.existsByEmail(username);
    boolean existsByCustomerUser = customerUserRepository.existsByEmail(username);
    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

    if(!existsByBankUser && !existsByCustomerUser){
      throw new UsernameNotFoundException("Wrong username: " + username);
    }

    if(existsByBankUser){
      BankUser user = bankUserRepository.findByEmailAndDeletedIsNull(username);
      user.getRoles().forEach(role -> {
        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
      });
      return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
    else {
      CustomerUser user = customerUserRepository.findByEmailAndDeletedIsNull(username);
      user.getRoles().forEach(role -> {
        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
      });
      return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
  }
}
