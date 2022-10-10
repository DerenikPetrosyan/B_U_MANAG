package com.iunetworks.service.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.function.Function;

@Component
public class JwtTokenUtil {

  @Value("${jwt.secret}")
  private String secret;
  @Value("${jwt.expiration}")
  private Long expiration;

  public String getUsernameFromToken(String token) {
    return getClaimFromToken(token, Claims::getSubject);
  }

  public Set<String> permissionsFromToken(String token) {
    return getClaimFromToken(token, new Function<Claims, Set<String>>() {
      @Override
      public Set<String> apply(Claims claims) {
        return claims.get("permissions", Set.class);
      }
    });
  }

  public Date getExpirationDateFromToken(String token) {
    return getClaimFromToken(token, Claims::getExpiration);
  }

  public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  private Claims getAllClaimsFromToken(String token) {
    return Jwts.parser()
      .setSigningKey(secret)
      .parseClaimsJws(token)
      .getBody();
  }

  private Boolean isTokenExpired(String token) {
    final Date expiration = getExpirationDateFromToken(token);
    return expiration.before(new Date());
  }

  public String generateToken(String email, Collection<String> permissions) {
    return doGenerateToken(email, permissions);
  }

  private String doGenerateToken(String subject, Collection<String> permissions) {
    final Date createdDate = new Date();
    final Date expirationDate = calculateAcssesTokenExpirationDate(createdDate);
    Claims claims = Jwts.claims().setSubject(subject);
    claims.put("permissions", permissions);
    return Jwts.builder()
      .setClaims(claims)
      .setSubject(subject)
      .setIssuedAt(createdDate)
      .setExpiration(expirationDate)
      .signWith(SignatureAlgorithm.HS512, secret)
      .compact();
  }

  public String generateRefreshToken(String subject,Collection<String> permissions) {
    return doGenerateRefreshToken(subject,permissions);
  }

  private String doGenerateRefreshToken(String subject,Collection<String> permissions) {
    final Date createdDate = new Date();
    final Date refreshExpirationDate = calculateRefreshTokenExpirationDate(createdDate);
    Claims claims = Jwts.claims().setSubject(subject);
    claims.put("permissions", permissions);
    return Jwts.builder()
      .setClaims(claims)
      .setSubject(subject)
      .setIssuedAt(createdDate)
      .setExpiration(refreshExpirationDate)
      .signWith(SignatureAlgorithm.HS256, secret)
      .compact();
  }

  public Boolean validateToken(String token, String username) {
    final String usernameToken = getUsernameFromToken(token);
    return (
      usernameToken.equals(username)
        && !isTokenExpired(token));
  }


  private Date calculateAcssesTokenExpirationDate(Date createdDate) {
    return new Date(createdDate.getTime() + expiration * 10000);
  }

  private Date calculateRefreshTokenExpirationDate(Date createdDate) {
    return new Date(createdDate.getTime() + expiration * 200000);
  }

}
