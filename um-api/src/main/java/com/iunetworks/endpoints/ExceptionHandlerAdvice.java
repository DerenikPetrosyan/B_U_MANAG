package com.iunetworks.endpoints;

import com.iunetworks.exception.ApplicationException;

import com.iunetworks.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerAdvice {


  @ExceptionHandler({ApplicationException.class})
  public ResponseEntity<Object> handleAccessDeniedException(ResourceNotFoundException ex, WebRequest request) {
    return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), ex.status());
  }
}
