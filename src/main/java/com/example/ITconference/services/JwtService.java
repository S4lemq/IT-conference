package com.example.ITconference.services;

import com.auth0.jwt.JWT;
import com.example.ITconference.security.JwtConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private final JwtConfig jwtConfig;

    public JwtService(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public String generateAccessJWTToken(UserDetails userDetails,
                                         HttpServletRequest request){
        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtConfig.getMillisecondsInDay()))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", userDetails.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .sign(jwtConfig.getSecretKey());
    }

    public String generateRefreshJWTToken(UserDetails userDetails,
                                          HttpServletRequest request){
        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtConfig.getMillisecondsInWeek()))
                .withIssuer(request.getRequestURL().toString())
                .sign(jwtConfig.getSecretKey());
    }
}
