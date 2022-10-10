package com.iunetworks.config.jwt;

import com.iunetworks.entities.BankUser;
import com.iunetworks.entities.BankUserDetails;
import com.iunetworks.entities.CustomerUser;
import com.iunetworks.entities.CustomerUserDetails;
import com.iunetworks.service.BankUserService;
import com.iunetworks.service.CustomerUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("myUserDetailsService")
public class JwtUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

  //todo: need to add your service info: for example
  private final BankUserService bankUserService;
  private final CustomerUserService customerUserService;

  public JwtUserDetailsService(BankUserService bankUserService, CustomerUserService customerUserService) {
    this.bankUserService = bankUserService;
    this.customerUserService = customerUserService;
  }

  //todo: need to add your user options
  @Transactional
  @Override
  public UserDetails loadUserByUsername(String username) {

    boolean existsByBankUser = bankUserService.getByUsername(username) == null;
    boolean existsByCustomerUser = customerUserService.getByUsername(username) == null;

//    Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//    grantedAuthorities.add((GrantedAuthority) Collections.emptyList());

    if(existsByBankUser && existsByCustomerUser){
      throw new UsernameNotFoundException("Wrong username: " + username);
    }

    if(!existsByBankUser){
      BankUser user = bankUserService.getByUsername(username);
//      user.getRoles().forEach(role -> {
//        grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//      });
//      return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
      return new BankUserDetails(user);
    }
    else {
      CustomerUser user = customerUserService.getByUsername(username);
//      user.getRoles().forEach(role -> {
//        grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//      });
//      return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
      return new CustomerUserDetails(user);
    }
  }
}

