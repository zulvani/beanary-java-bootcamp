package com.beanary.rest.restbasic.service.impl;

import com.beanary.rest.restbasic.service.ArithmeticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ArithmeticServiceImpl implements ArithmeticService {

    Logger logger = LoggerFactory.getLogger(ArithmeticServiceImpl.class);

    public int add(Integer...numbers){
        logger.debug("start calculation");
        int r = 0;
        for(int i = 0; i < numbers.length; i++){
            r += numbers[i];
        }
        logger.debug("completed calculation");
        return r;
    }
}
