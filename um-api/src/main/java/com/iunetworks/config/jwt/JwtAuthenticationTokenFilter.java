package com.iunetworks.config.jwt;

import com.iunetworks.repositories.BankUserRepository;
import com.iunetworks.repositories.CustomerUserRepository;
import com.iunetworks.service.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;


public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

  @Autowired
  private JwtTokenUtil tokenUtil;


  @Autowired
  private BankUserRepository bankUserRepository;

  @Autowired
  private CustomerUserRepository customerUserRepository;

  @Autowired
  private UserDetailsService userDetailsService;


  @Override
  protected void doFilterInternal(HttpServletRequest request,
                                  HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {

    String requestHeader = request.getHeader("Authorization");
    String username = null;
    String authToken = null;
    if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
      authToken = requestHeader.substring(7);
      try {
        List<String> permissions = tokenUtil.getClaimFromToken(authToken, this.retrievePermissions());
        username = tokenUtil.getUsernameFromToken(authToken);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        UserDetails user = this.userDetailsService.loadUserByUsername(username);
        permissions.forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission)));
        UsernamePasswordAuthenticationToken authenticationToken =
          new UsernamePasswordAuthenticationToken(user, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);

      } catch (Exception e) {
        logger.error(e);
      }
    }
      else {
      filterChain.doFilter(request, response);
    }

  }
  private boolean validToken(String token) {
    try {
      Jwts.parser().setSigningKey("secret").parseClaimsJws(token);
      return true;
    } catch (RuntimeException exception) {
      //ignore me
    }
    return false;
  }

  private Function<Claims, List<String>> retrievePermissions() {
    return claims -> (List<String>) claims.get("permissions");
  }
}
