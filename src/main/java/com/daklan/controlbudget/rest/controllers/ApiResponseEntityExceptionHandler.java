package com.daklan.controlbudget.rest.controllers;

import com.daklan.controlbudget.rest.configuration.RecordNotFoundException;
import com.daklan.controlbudget.rest.model.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiResponseEntityExceptionHandler.class);

    @Value("${message.error.record.not.found}")
    String recordNotFoundGenericMessage;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
                                                                  final HttpHeaders headers,
                                                                  final HttpStatus status,
                                                                  final WebRequest request) {
        final List<String> errors = ex.getBindingResult().getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        LOGGER.info("An error corresponding to an entry parameter in one DTO is detected : {}", errors);
        LOGGER.debug("An error corresponding to an entry parameter in one DTO is detected ", ex);

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Invalid request", request.getDescription(false), errors);

        return ResponseEntity.badRequest().body(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(final MissingPathVariableException ex,
                                                               final HttpHeaders headers,
                                                               final HttpStatus status,
                                                               final WebRequest request) {

        final List<String> errors = new ArrayList<>();
        errors.add(ex.getParameter().getParameterName());
        errors.add(ex.getVariableName());
        errors.add(ex.getMessage());

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Invalid or nonexistent path variable.", request.getDescription(false), errors);

        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ApiError> handleRecordNotFoundException(final RecordNotFoundException ex,
                                                                        final WebRequest request) {

        final List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());

        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, recordNotFoundGenericMessage, request.getDescription(false), errors);

        return ResponseEntity.badRequest().body(apiError);
    }
}
