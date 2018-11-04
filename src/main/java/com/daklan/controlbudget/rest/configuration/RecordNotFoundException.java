package com.daklan.controlbudget.rest.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <b>The Exception class for the nonexistent record.</b>
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
