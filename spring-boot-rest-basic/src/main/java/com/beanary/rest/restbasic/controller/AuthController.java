package com.beanary.rest.restbasic.controller;

import com.beanary.rest.restbasic.dto.UserAccountDto;
import com.beanary.rest.restbasic.exceptions.AuthException;
import com.beanary.rest.restbasic.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping
    public ResponseEntity login(@RequestBody UserAccountDto dto) {
        try {
            return new ResponseEntity(authService.login(dto.getEmail(), dto.getPassword()), HttpStatus.OK);
        } catch (AuthException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
