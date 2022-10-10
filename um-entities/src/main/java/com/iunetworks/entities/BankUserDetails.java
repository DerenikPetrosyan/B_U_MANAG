package com.iunetworks.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Component
public class BankUserDetails implements UserDetails {

  private BankUser bankUser;

  public BankUserDetails(BankUser bankUser) {
    this.bankUser = bankUser;
  }

  public BankUserDetails() {
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

    grantedAuthorities.add((GrantedAuthority) Collections.emptyList());

    bankUser.getRoles().forEach(role -> {
      grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
    });

    return grantedAuthorities;
  }

  @Override
  public String getPassword() {
    return bankUser.getPassword();
  }

  @Override
  public String getUsername() {
    return bankUser.getEmail();
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
