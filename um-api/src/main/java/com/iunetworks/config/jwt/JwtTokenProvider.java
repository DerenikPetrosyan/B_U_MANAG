package com.iunetworks.config.jwt;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;

@Component
public class JwtTokenProvider implements Serializable {

    @Value("${jwt.access.token.expired}")
    private long ACCESS_TOKEN_VALIDITY;

    @Value("${jwt.refresh.token.expired}")
    private long REFRESH_TOKEN_VALIDITY;

    @Value("${jwt.secret}")
    private String JWT_TOKEN_SECRET;

    @Value("${jwt.header}")
    private String AUTHORIZATION_HEADER;

    @PostConstruct
    protected void init() {
        JWT_TOKEN_SECRET = Base64.getEncoder().encodeToString(JWT_TOKEN_SECRET.getBytes());
    }

    public String createJwt(UUID userId, String username, int authorityId, List<String> roles, boolean isAccessToken) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("role", roles);
        claims.put("userId", userId);
        //claims.put("authorityId", authorityId);

        String tokenType;

        Date now = new Date();
        Date validity;
        if (isAccessToken) {
            validity = new Date(now.getTime() + ACCESS_TOKEN_VALIDITY);
            tokenType = JwtTokenType.ACCESS_TOKEN.name();
        } else {
            validity = new Date(now.getTime() + REFRESH_TOKEN_VALIDITY);
            tokenType = JwtTokenType.REFRESH_TOKEN.name();
        }

        claims.put("tokenType", tokenType);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, JWT_TOKEN_SECRET)
                .compact();
    }

    /*public boolean validateToken(String token, HttpServletRequest servletRequest) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(JWT_TOKEN_SECRET).parseClaimsJws(token);
            return !claimsJws.getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            servletRequest.setAttribute("expired", e.getMessage());
            return false;
        }
    }*/


    public boolean validateToken(String token) {

        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(JWT_TOKEN_SECRET).parseClaimsJws(token);
            return !claimsJws.getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public Authentication getAuthentication(String token) {

        String username = getUsername(token);

        String[] roles = getRoles(token);

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (String r : roles) {

            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(r.trim());
            grantedAuthorities.add(grantedAuthority);
        }

        UserDetails userDetails = new User(username, "[PROTECTED]", grantedAuthorities);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(JWT_TOKEN_SECRET).parseClaimsJws(token).getBody().getSubject();
    }

    public String[] getRoles(String token) {
        String role = getClaims(token).get("role").toString();

        return role.substring(1, role.length() - 1).split(", ");
    }

    public Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(JWT_TOKEN_SECRET).parseClaimsJws(token).getBody();
    }

    public String resolveToken(HttpServletRequest request) {
        String header = request.getHeader(AUTHORIZATION_HEADER);
        return header == null ? null : header.replaceAll("Bearer ", "");
    }
}
