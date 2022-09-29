package com.iunetworks.service.util;


import com.iunetworks.entities.BankUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.util.Date;
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

  public String generateToken(BankUser bankUser) {
    return doGenerateToken(bankUser.getEmail());
  }

  private String doGenerateToken(String subject) {
    final Date createdDate = new Date();
    final Date expirationDate = calculateExpirationDate(createdDate);
    Claims claims = Jwts.claims().setSubject(subject);

    return Jwts.builder()
      .setClaims(claims)
      .setSubject(subject)
      .setIssuedAt(createdDate)
      .setExpiration(expirationDate)
      .signWith(SignatureAlgorithm.HS512, secret)
      .compact();
  }

  public Boolean validateToken(String token, String username) {
    final String usernameToken = getUsernameFromToken(token);
    return (
      usernameToken.equals(username)
        && !isTokenExpired(token));
  }

  private Date calculateExpirationDate(Date createdDate) {
    return new Date(createdDate.getTime() + expiration * 2000);
  }
}
