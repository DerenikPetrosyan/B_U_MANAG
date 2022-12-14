package com.iunetworks.endpoints;

import com.iunetworks.exception.ApplicationException;

import com.iunetworks.exception.BadRequestException;
import com.iunetworks.exception.DuplicateException;
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

  @ExceptionHandler({BadRequestException.class})
  public ResponseEntity<Object> handleAccessDeniedException(BadRequestException ex, WebRequest request) {
    return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), ex.status());
  }

  @ExceptionHandler({DuplicateException.class})
  public ResponseEntity<Object> handleAccessDeniedException(DuplicateException ex, WebRequest request) {
    return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), ex.status());
  }

}
