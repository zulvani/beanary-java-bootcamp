package com.beanary.rest.restbasic.service.impl;

import com.beanary.rest.restbasic.service.ArithmeticService;
import org.springframework.stereotype.Component;

@Component
public class ArithmeticServiceImpl implements ArithmeticService {
    public int add(Integer...numbers){
        int r = 0;
        for(int i = 0; i < numbers.length; i++){
            r += numbers[i];
        }
        return r;
    }
}
