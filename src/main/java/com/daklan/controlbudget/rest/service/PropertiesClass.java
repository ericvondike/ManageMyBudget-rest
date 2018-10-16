package com.daklan.controlbudget.rest.service;

import com.daklan.controlbudget.rest.configuration.KmsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertiesClass {

    private KmsProperties kmsProperties;

    @Autowired
    public PropertiesClass(KmsProperties kmsProperties) {
        this.kmsProperties = kmsProperties;
    }

    String birthdatePath = this.kmsProperties.getTariffication().getTarificationTemplate().getBirthDatePath();

    

    private void textmethod(String text) {
        System.out.println(text);
    }

    private static void myMethod() {

    }
}





