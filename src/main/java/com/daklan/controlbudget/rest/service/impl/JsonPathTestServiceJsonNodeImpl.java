package com.daklan.controlbudget.rest.service.impl;

import com.daklan.controlbudget.rest.configuration.KmsProperties;
import com.daklan.controlbudget.rest.service.JsonPathTestService;
import com.daklan.controlbudget.rest.utils.JsonTemplatesUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Profile("kms")
public class JsonPathTestServiceJsonNodeImpl implements JsonPathTestService {

    KmsProperties kmsProperties;
    JsonTemplatesUtils jsonTemplatesUtils;

    @Autowired
    public JsonPathTestServiceJsonNodeImpl(final KmsProperties kmsProperties,
                                           final JsonTemplatesUtils jsonTemplatesUtils) {
        this.kmsProperties = kmsProperties;
        this.jsonTemplatesUtils = jsonTemplatesUtils;
    }

    @Override
    public String callPropertiesFile() throws IOException {
        String filePath = kmsProperties.getProspect().getTemplate().getFilePath();
        JsonNode inputTestNode = jsonTemplatesUtils.getTemplate(filePath);
        System.out.println("I am inside the kms profile");

        return filePath;

    }
}
