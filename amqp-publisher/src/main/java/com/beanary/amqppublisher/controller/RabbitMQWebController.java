package com.beanary.amqppublisher.controller;

import com.beanary.amqppublisher.model.Employee;
import com.beanary.amqppublisher.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/beancamp-rabbitmq/")
public class RabbitMQWebController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName,@RequestParam("empId") String empId) {
        Employee emp=new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        rabbitMQSender.send(emp);
        return "Message sent to the RabbitMQ Beancamp Successfully";
    }
}
