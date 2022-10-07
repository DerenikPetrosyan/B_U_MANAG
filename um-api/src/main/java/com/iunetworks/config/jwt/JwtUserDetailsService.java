package com.iunetworks.config.jwt;

import com.nga.model.User;
import com.nga.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Component("myUserDetailsService")
public class JwtUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

  //todo: need to add your service info: for example
    /*private final UserService userService;

    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }*/

  @Override
  @Transactional
  //todo: need to add your user options
  public UserDetails loadUserByUsername(final String username) {

    User user = userService.getByUsername(username);

    Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    //GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getAuthority().getRole());
    grantedAuthorities.add((GrantedAuthority) Collections.emptyList());

    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
  }
}
