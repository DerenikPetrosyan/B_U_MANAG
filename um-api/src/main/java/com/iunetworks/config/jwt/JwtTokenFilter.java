package com.iunetworks.config.jwt;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class JwtTokenFilter extends GenericFilterBean {

    @Value(value = "${re.login.url}")
    private String reLoginUrl;

    private final JwtTokenProvider jwtTokenProvider;

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

//    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {

        addFilters(servletRequest, servletResponse);

        String token = jwtTokenProvider.resolveToken((HttpServletRequest) servletRequest);

        try {
            if (token != null && jwtTokenProvider.validateToken(token)) {

                String tokenType = jwtTokenProvider.getClaims(token).get("tokenType").toString();

                //todo: need to add database checks: for example

                //userService.isExistInDB((int)jwtTokenProvider.getClaims(token).get("userId"));

                if (tokenType.equals(JwtTokenType.REFRESH_TOKEN.name())) {
                    String servletPath = ((HttpServletRequest) servletRequest).getServletPath();
                    if (!servletPath.equals(reLoginUrl))
                        throw new AuthenticationException("Unauthorized");
                }

                Authentication authentication = jwtTokenProvider.getAuthentication(token);
                if (authentication != null) {
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (AuthenticationException e) {
            SecurityContextHolder.clearContext();
            servletRequest.setAttribute("expired", e.getMessage());
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }


    private void addFilters(ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, PATCH");
        response.setHeader("Access-Control-Max-Age", "1000");
        response.addHeader("Access-Control-Allow-Headers", "Authorization, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Allow-Origin, Content-Encoding");
        response.addHeader("Origin", "*");
        response.addHeader("Accept", "application/x-www-form-urlencoded; text/plain; application/gzip; application/json;charset=UTF-8; application/octet-stream; ");
        response.addHeader("Access-Control-Allow-Credentials", "true");


        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
