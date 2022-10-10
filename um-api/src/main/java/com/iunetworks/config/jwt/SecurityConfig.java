package com.iunetworks.config.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
// todo: in your spring version "extends WebSecurityConfigurerAdapter" is deprecated(for more see documentation for your version)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

  private final JwtConfigurer jwtConfigurer;

  private final JwtUserDetailsService userDetailsService;

  private final PasswordEncoder passwordEncoder;

  @Autowired
  public SecurityConfig(JwtConfigurer jwtConfigurer, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtUserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
    this.jwtConfigurer = jwtConfigurer;
    this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    this.userDetailsService = userDetailsService;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
      .and().authorizeRequests()
      .antMatchers("/bank_user/sign_in_user").permitAll()
      .antMatchers("/customer_user/sign_in_user").permitAll();
    http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
  }


  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
  }

  @Bean
  public JwtAuthenticationTokenFilter authenticationTokenFilterBean() {
    return new JwtAuthenticationTokenFilter();
  }


}
