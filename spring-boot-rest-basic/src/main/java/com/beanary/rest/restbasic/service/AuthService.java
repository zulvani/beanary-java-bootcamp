package com.beanary.rest.restbasic.service;

import com.beanary.rest.restbasic.dto.UserAccountDto;
import com.beanary.rest.restbasic.exceptions.AuthException;

public interface AuthService {
    UserAccountDto login(String username, String password) throws AuthException;
}
