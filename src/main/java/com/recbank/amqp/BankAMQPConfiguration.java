package com.recbank.amqp;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankAMQPConfiguration {
    @Bean
    public RabbitTemplate connectionFactory(ConnectionFactory connectionFactory){
       RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
       return rabbitTemplate;
    }
}
