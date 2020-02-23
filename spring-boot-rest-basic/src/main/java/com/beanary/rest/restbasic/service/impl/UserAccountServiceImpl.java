package com.beanary.rest.restbasic.service.impl;

import com.beanary.rest.restbasic.dto.UserAccountDto;
import com.beanary.rest.restbasic.model.UserAccount;
import com.beanary.rest.restbasic.repository.UserAccountRepository;
import com.beanary.rest.restbasic.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public List<UserAccount> get() {
        List<UserAccount> list = new ArrayList<>();
        userAccountRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public UserAccount getById(long id) {
        return userAccountRepository.findById(id).get();
    }

    @Override
    public UserAccount update(long id, UserAccountDto dto) {
        Optional<UserAccount> ua = userAccountRepository.findById(id);
        if(ua.get() != null){
            UserAccount up = ua.get();
            up.setName(dto.getName());
            up.setPassword(dto.getPassword());
            userAccountRepository.save(up);
            return up;
        }
        return null;
    }

    @Override
    public UserAccount delete(long id) {
        Optional<UserAccount> ua = userAccountRepository.findById(id);
        if(ua.get() != null){
            UserAccount d = ua.get();
            userAccountRepository.delete(d);
            return d;
        }
        return null;
    }

    @Override
    public UserAccount post(String email, String name, String password) {
        UserAccount ua = new UserAccount();
        ua.setEmail(email);
        ua.setName(name);
        ua.setPassword(password); // we will encrypt the password later
        userAccountRepository.save(ua);
        return ua;
    }
}