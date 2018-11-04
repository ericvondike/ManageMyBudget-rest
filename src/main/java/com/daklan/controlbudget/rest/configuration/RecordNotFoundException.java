package com.daklan.controlbudget.rest.configuration;

/**
 * <b>The Exception class for the nonexistent record.</b>
 */
public class RecordNotFoundException extends Throwable {
    public RecordNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
