package com.iunetworks.config;

import com.iunetworks.entities.BankUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CurrentUser implements UserDetails {
  private final BankUser bankUser;

  public CurrentUser(BankUser bankUser) {
    this.bankUser = bankUser;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.bankUser.getRoles().stream()
      .map(r -> new SimpleGrantedAuthority(r.getRoleName()))
      .collect(Collectors.toList());
  }

  @Override
  public String getPassword() {
    return this.bankUser.getPassword();
  }

  @Override
  public String getUsername() {
    return this.bankUser.getEmail();
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
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


