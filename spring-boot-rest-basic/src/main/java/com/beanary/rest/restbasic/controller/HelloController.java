package com.beanary.rest.restbasic.controller;

import com.beanary.rest.restbasic.dto.UserAccountDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/greeting")
    public UserAccountDto greeting(@RequestParam(value = "name", defaultValue = "No Name") String name) {
        log.trace("Trace Hallo {}", name);
        log.debug("Debug Hallo {}", name);
        log.warn("Warn Hallo {}", name);
        log.info("Info Hallo {}", name);
        log.error("Error Hallo {}", name);
        UserAccountDto ua = new UserAccountDto();
        ua.setName(name);
        return ua;
    }
}
