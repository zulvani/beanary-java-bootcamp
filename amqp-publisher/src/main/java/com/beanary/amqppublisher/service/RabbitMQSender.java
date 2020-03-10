package com.beanary.amqppublisher.service;

import com.beanary.amqppublisher.model.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    AmqpTemplate myRabbitTemplate;

    @Value("${beancamp.rabbitmq.exchange}")
    String exchange;

    @Value("${beancamp.rabbitmq.routingkey}")
    String routingkey;

    public void send(Employee company) {
        myRabbitTemplate.convertAndSend(exchange, routingkey, company);
        System.out.println("Send msg = " + company);

    }
}
