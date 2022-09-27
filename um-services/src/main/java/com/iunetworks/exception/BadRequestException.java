package com.iunetworks.exception;

import org.springframework.http.HttpStatus;


public class BadRequestException extends ApplicationException{


  public BadRequestException(final String message) {
    super(HttpStatus.BAD_REQUEST, message);
  }

//  public BadRequestException(UUID id) {
//    super(HttpStatus.NOT_FOUND, String.format("Resource with id : {%s} not found", id.toString()));
//  }

  public String getMessage() {
    return super.getMessage();
  }

  public HttpStatus status() {
    return super.status();
  }
}
