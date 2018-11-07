package com.daklan.controlbudget.rest.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface JsonPathTestService {

    String callPropertiesFile() throws IOException;

}
