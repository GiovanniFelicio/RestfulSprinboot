/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwery.handler;

import com.softwery.error.ResourceNotFoundDetails;
import com.softwery.error.ResourceNotFoundException;
import com.softwery.error.ValidationErrorDetails;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author engcarvalho
 */
@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException rfnException) {
        ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.builder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource Not Found")
                .detail(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName()).build();
        
        return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> hanldlerMethodArgumentNotValidException(MethodArgumentNotValidException manvException) {
        
        Set<String> fields = new HashSet<>();
        
        List<Map<String,List<String>>> fieldsError = new ArrayList<>();
        
        for (FieldError error : manvException.getBindingResult().getFieldErrors()) {
            fields.add(error.getField());
        }
        
        for (String field : fields) {
            Map<String,List<String>> fieldError = new HashMap<>();
            
            List<String> messageError = new ArrayList<>();
            
            for (FieldError error : manvException.getBindingResult().getFieldErrors(field)) {
                messageError.add(error.getDefaultMessage());
            }
            fieldError.put(field, messageError);
            
            fieldsError.add(fieldError);
        }
        
        ValidationErrorDetails validationErrorDetails = ValidationErrorDetails.builder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .title("Fields Validation Error")
                .detail("Fields Validation Error")
                .developerMessage(manvException.getClass().getName())
                .fieldsError(fieldsError)
                .build();
        
        return new ResponseEntity(validationErrorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
        
    }
}
