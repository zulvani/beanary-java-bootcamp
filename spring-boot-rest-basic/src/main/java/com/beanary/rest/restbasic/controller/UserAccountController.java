package com.beanary.rest.restbasic.controller;

import com.beanary.rest.restbasic.auth.NeedLogin;
import com.beanary.rest.restbasic.dto.UserAccountDto;
import com.beanary.rest.restbasic.model.UserAccount;
import com.beanary.rest.restbasic.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/useraccounts")
public class UserAccountController {

    @Autowired
    UserAccountService userAccountService;

    @NeedLogin
    @GetMapping
    public List<UserAccount> get() {
        return userAccountService.get();
    }

    @PostMapping
    public UserAccount post(@RequestBody UserAccountDto dto) {
        return userAccountService.post(dto.getEmail(), dto.getName(), dto.getPassword());
    }

    @GetMapping("/{id}")
    public UserAccount getById(@PathVariable("id") long id) {
        return userAccountService.getById(id);
    }

    @PutMapping("/{id}")
    public UserAccount put(@PathVariable("id") long id, @RequestBody UserAccountDto dto) {
        return userAccountService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public UserAccount delete(@PathVariable("id") long id) {
        return userAccountService.delete(id);
    }


}