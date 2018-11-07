package com.daklan.controlbudget.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
//@EnableAutoConfiguration
public class ControlbugetRestApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("kmsTest");
        context.refresh();

        SpringApplication.run(ControlbugetRestApplication.class, args);
    }
}
