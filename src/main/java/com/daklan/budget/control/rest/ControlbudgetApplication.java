package com.daklan.budget.control.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan({"com.daklan.budget.control"})
public class ControlbudgetApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlbudgetApplication.class, args);
    }
}
