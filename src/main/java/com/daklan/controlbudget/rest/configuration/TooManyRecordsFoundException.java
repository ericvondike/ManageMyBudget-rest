package com.daklan.controlbudget.rest.configuration;

/**
 * <b>The Exception class for finding too many records.</b>
 */
public class TooManyRecordsFoundException extends Throwable {
    public TooManyRecordsFoundException(String message) {
        super(message);
    }
}
