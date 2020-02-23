package com.beanary.rest.restbasic.service;

import com.beanary.rest.restbasic.dto.UserAccountDto;
import com.beanary.rest.restbasic.model.UserAccount;

import java.util.List;

public interface UserAccountService {
    List<UserAccount> get();
    UserAccount getById(long id);
    UserAccount update(long id, UserAccountDto dto);
    UserAccount delete(long id);
    UserAccount post(String email, String name, String password);
}
