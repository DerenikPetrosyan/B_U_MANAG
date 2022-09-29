package com.iunetworks.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
  private final UserDetailsServiceImpl userDetailsService;
  private final JwtAuthenticationEntryPoint unauthorizedHandler;

  public ApplicationSecurityConfig(UserDetailsServiceImpl userDetailsService, JwtAuthenticationEntryPoint unauthorizedHandler) {
    this.userDetailsService = userDetailsService;
    this.unauthorizedHandler = unauthorizedHandler;
  }

  //  @Override
//  public void configure(WebSecurity web) {
//    web.ignoring()
//      .antMatchers("/**");
//  }
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and().exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
      .and().authorizeRequests()
      .antMatchers("/users").permitAll();
//      .antMatchers(HttpMethod.GET,"/users/bankusers").hasAnyRole("ADMIN");
    // .antMatchers("/users/bankusers").hasAnyAuthority("ADMIN");
    // .antMatchers("/users/bankusers").hasRole("ADMIN");
//      .antMatchers("/api/companies/signin").permitAll()
//      .antMatchers("/api/companies/updatebytin").hasAuthority("ROLE_USER")
//      .antMatchers("/api/companies/bytin").hasAuthority("ROLE_USER")
//      .antMatchers("/api/companies/updatebytin").hasAuthority("ROLE_USER")
//      .antMatchers("/api/invoices/all").hasAuthority("ROLE_USER");
    http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("7@.com").password("123").roles("ADMIN");
  }

  @Bean
  public JwtAuthenticationTokenFilter authenticationTokenFilterBean() {
    return new JwtAuthenticationTokenFilter();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}



