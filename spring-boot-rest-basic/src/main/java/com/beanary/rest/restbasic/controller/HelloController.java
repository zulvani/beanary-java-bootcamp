package com.beanary.rest.restbasic.controller;

import com.beanary.rest.restbasic.dto.UserAccountDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // POST http://localhost:8080/bankaccount ==> create entity bank acount
    // GET  http://localhost:8080/bankaccount ==> retrieve all bank accounts entity
    // GET  http://localhost:8080/bankaccount/1 ==> retrieve bank account id = 1
    // PUT  http://localhost:8080/bankaccount/1 ==> modify entity bank acount id = 1
    // DELETE http://localhost:8080/bankaccount/1 ==> delete entity bank account id = 1

    // GET  http://localhost:8080/getAllBankAccount

    @GetMapping("/greeting")
    public UserAccountDto greeting(@RequestParam(value = "name", defaultValue = "No Name")
                                 String name) {
        UserAccountDto ua = new UserAccountDto();
        ua.setName(name);
        return ua;
    }
}
