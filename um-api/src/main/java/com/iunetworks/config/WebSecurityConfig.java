package com.iunetworks.config;


import com.iunetworks.filter.CustomAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  private final UserDetailsServiceImpl userDetailsService;

  private final PasswordEncoder passwordEncoder;


  public WebSecurityConfig(UserDetailsServiceImpl userDetailsService, PasswordEncoder passwordEncoder) {
    this.userDetailsService = userDetailsService;
    this.passwordEncoder = passwordEncoder;
  }

  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
  }



  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {

    return  http.csrf(csrf ->csrf.disable())
      .authorizeHttpRequests(auth -> {
        auth.antMatchers("/").permitAll();
        auth.antMatchers("/bank_user").hasRole("BANKUSER");
        auth.antMatchers("/customer_user").hasRole("CUSTOMER");
      })
      .httpBasic(Customizer.withDefaults())
      .build();
//    CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
//    http.csrf().disable();
//    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    http.authorizeHttpRequests().anyRequest().permitAll();
//    http.addFilter(customAuthenticationFilter);
  }

//  @Bean
//  @Override
//  public AuthenticationManager authenticationManagerBean() throws Exception{
//    return super.authenticationManagerBean();
//  }
}
