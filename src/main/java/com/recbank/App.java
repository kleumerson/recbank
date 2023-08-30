package com.kbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.efficient.controller", "com.efficient.model"})
public class Efficient {

    public static void main(String[] args) {
        SpringApplication.run(Efficient.class, args);
    }

}
