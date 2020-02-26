package com.beanary.rest.restbasic.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.beanary.rest.restbasic.dto.UserAccountDto;

import java.time.LocalDateTime;

public class JWTBuilder {

    public static final String SECRET_KEY = "BOOTCAMP";

    public static String createJWT(UserAccountDto dto) {
        try {
            LocalDateTime dt = LocalDateTime.now();
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            String token = JWT.create()
                    .withClaim("email", dto.getEmail())
                    .withClaim("name", dto.getName())
                    .withIssuer("auth0")
                    // will be expired for 5 minutes
                    .withExpiresAt(java.sql.Timestamp.valueOf(dt.plusMinutes(5)))
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            return null;
        }
    }
}
