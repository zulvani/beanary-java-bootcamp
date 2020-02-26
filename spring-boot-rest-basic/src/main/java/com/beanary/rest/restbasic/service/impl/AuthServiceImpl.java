package com.beanary.rest.restbasic.service.impl;

import com.beanary.rest.restbasic.dto.UserAccountDto;
import com.beanary.rest.restbasic.exceptions.AuthException;
import com.beanary.rest.restbasic.jwt.JWTBuilder;
import com.beanary.rest.restbasic.model.UserAccount;
import com.beanary.rest.restbasic.service.AuthService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserAccountDto login(String username, String password) throws AuthException {
        Query q = entityManager
                .createQuery("from UserAccount where email = :email")
                .setParameter("email", username);
        List<UserAccount> list = q.getResultList();

        if(list.size() > 0){
            UserAccount ua = list.get(0);
            if(ua.getPassword().equals(password)){
                UserAccountDto dto = new UserAccountDto();
                dto.setEmail(ua.getEmail());
                dto.setName(ua.getName());
                dto.setToken(JWTBuilder.createJWT(dto));
                return dto;
            }
            throw new AuthException("Invalid password");
        }
        throw new AuthException("Username not found");
    }
}