package com.recbank.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ManagerQueue {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Bean
    public Queue createQueue(){
        return new Queue("person", true);
    }
    @Bean
    @Scheduled(fixedDelay = 5000)
    public void pushMessage(){
        String message = "Hello Rabbit @" + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
        rabbitTemplate.convertAndSend("person", message);
    }
}
