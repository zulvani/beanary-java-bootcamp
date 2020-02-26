package com.beanary.rest.restbasic.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.beanary.rest.restbasic.dto.UserAccountDto;

public class JWTVerificator {
    public static UserAccountDto verifyToken(String token) throws JWTVerificationException {
        Algorithm algorithm = Algorithm.HMAC256(JWTBuilder.SECRET_KEY);
        JWTVerifier verifier = JWT.require(algorithm)
                .acceptLeeway(1)
                .withIssuer("auth0")
                .build(); //Reusable verifier instance

        DecodedJWT jwt = verifier.verify(token);
        UserAccountDto loggedUserVo = new UserAccountDto();
        return loggedUserVo;
    }
}
