package com.iunetworks.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Component
public class CustomerUserDetails implements UserDetails {

  private CustomerUser customerUser;

  public CustomerUserDetails() {
  }

  public CustomerUserDetails(CustomerUser customerUser) {
    this.customerUser = customerUser;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

    grantedAuthorities.add((GrantedAuthority) Collections.emptyList());

    customerUser.getRoles().forEach(role -> {
      grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
    });

    return grantedAuthorities;
  }

  @Override
  public String getPassword() {
    return customerUser.getPassword();
  }

  @Override
  public String getUsername() {
    return customerUser.getEmail();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
