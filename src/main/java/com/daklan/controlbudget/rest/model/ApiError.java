package com.daklan.controlbudget.rest.model;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ApiError {

    private HttpStatus status;
    private String message;
    private String uri;
    private List<String> errors;

    /**
     * <b>This constructor is to make a message composed of a list of all errors.</b>
     * @param status The {@link HttpStatus} of the error.
     * @param message The description of the error.
     * @param errors The error list.
     */
    public ApiError(final HttpStatus status,
                    final String message,
                    final String uri,
                    final List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.uri = uri;
        this.errors = errors;
    }

    /**
     * <b>This constructor is to make a message composed of just one error.</b>
     * @param status The {@link HttpStatus} of the error.
     * @param message The description of the error.
     * @param error The error.
     */
    public ApiError(final HttpStatus status,
                    final String message,
                    final String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
