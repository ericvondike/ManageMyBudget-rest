package com.daklan.controlbudget.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.daklan.controlbudget"})
public class ControlbugetRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlbugetRestApplication.class, args);
    }
}
