package com.daklan.controlbudget.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"com.daklan.controlbudget"})
@EnableAutoConfiguration
public class ControlbugetRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlbugetRestApplication.class, args);
    }
}
