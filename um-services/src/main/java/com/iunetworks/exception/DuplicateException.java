package com.iunetworks.exception;

import org.springframework.http.HttpStatus;

import java.util.UUID;

public class DuplicateException extends ApplicationException{



  public DuplicateException(final String message) {
    super(HttpStatus.CONFLICT, message);
  }

//  public DuplicateException() {
//    super(HttpStatus.CONFLICT,"");
//  }

  public String getMessage() {
    return super.getMessage();
  }

  public HttpStatus status() {
    return super.status();
  }
}
