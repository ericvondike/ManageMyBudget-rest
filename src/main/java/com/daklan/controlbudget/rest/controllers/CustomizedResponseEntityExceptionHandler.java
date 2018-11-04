//package com.daklan.controlbudget.rest.controllers;
//
//import com.daklan.controlbudget.rest.configuration.RecordNotFoundException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//@ControllerAdvice
//@RestController
//public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
//    @ExceptionHandler(RecordNotFoundException.class)
//    public final ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request) {
//        return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
//    }
//}
