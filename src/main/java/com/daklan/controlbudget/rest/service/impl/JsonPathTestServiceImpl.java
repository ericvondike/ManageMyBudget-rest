package com.daklan.controlbudget.rest.service.impl;

import com.daklan.controlbudget.rest.configuration.KmsProperties;
import com.daklan.controlbudget.rest.service.JsonPathTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsonPathTestServiceImpl implements JsonPathTestService {

    KmsProperties kmsProperties;

    @Autowired
    public JsonPathTestServiceImpl(final KmsProperties kmsProperties) {
        this.kmsProperties = kmsProperties;
    }

    @Override
    public String callPropertiesFile() {
        String filePath = kmsProperties.getProspect().getTemplate().getFilePath();

        return filePath;

    }
}
