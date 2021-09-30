/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.duodu.rest.webservices.exception;

import com.ernest.duodu.rest.webservices.exception.user.UserNotFoundException;
import java.time.LocalDateTime;
import java.util.StringJoiner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *Customise the default exception handling provided by spring
 * @author ernest61523
 */
@ControllerAdvice
@RestController
public class CustomisedResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(Exception.class) //specify what exception to handle
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request)
    {
        ExceptionResponse exceptionResponse = 
                new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        
      return  new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(UserNotFoundException.class) //specify what exception to handle
    public ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException ex, WebRequest request)
    {
        ExceptionResponse exceptionResponse = 
                new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        
      return  new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        
        StringJoiner joiner = new StringJoiner("\n");
        
         ex.getBindingResult()
                 .getFieldErrors()
                 .forEach(e -> joiner.add(e.getField() +" " +e.getDefaultMessage()));
         
        ExceptionResponse exceptionResponse = 
                new ExceptionResponse(LocalDateTime.now(), "Validation Failed", joiner.toString());
        
        return  new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
