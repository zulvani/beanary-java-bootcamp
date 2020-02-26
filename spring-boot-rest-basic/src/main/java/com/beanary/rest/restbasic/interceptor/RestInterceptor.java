package com.beanary.rest.restbasic.interceptor;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.beanary.rest.restbasic.auth.NeedLogin;
import com.beanary.rest.restbasic.dto.UserAccountDto;
import com.beanary.rest.restbasic.exceptions.AuthException;
import com.beanary.rest.restbasic.jwt.JWTVerificator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

@Component
public class RestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws AuthException, InvocationTargetException, IllegalAccessException {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            if (method.getMethod().isAnnotationPresent(NeedLogin.class)) {
                //do processing
                String token = request.getHeader("token");

                if(token == null){
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    throw new AuthException("Token does not exist, this method required permission");
                }

                try {
                    UserAccountDto loggedUser = JWTVerificator.verifyToken(token);
                } catch (JWTVerificationException e) {
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    throw new AuthException("Invalid token");
                }
            }
        }
        return true;
    }
}
