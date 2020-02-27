package com.beanary.rest.restbasic.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("account-service")
public interface UserAccountInterface {

    @RequestMapping("/greeting")
    String greeting();

}
