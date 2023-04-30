package com.miniproject.Spring.Mini.Project.security;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class JWTUtils {
    Logger logger = Logger.getLogger(JWTUtils.class.getName());

    @Value("${jwt-secret}")
    private String jwtSecret;

    @Value("${jwt-expiration-ms}")
    private int jwtExpirationMs;

    public String generateJwtToken(MyUserDetails myUserDetails) {
        return Jwts.builder()
                .setSubject((myUserDetails.getUsername()))
                .se
    }
}
