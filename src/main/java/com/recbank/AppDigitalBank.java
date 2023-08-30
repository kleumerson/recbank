package com.recbank;

import com.recbank.queue.ManagerQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.recbank.controller", "com.recbank.model"})
public class AppDigitalBank{
    public static void main(String[] args) {
        SpringApplication.run(AppDigitalBank.class, args);

        ManagerQueue managerQueue = new ManagerQueue();
        managerQueue.createQueue();
        managerQueue.pushMessage();
    }
}
