package com.iunetworks.exception;

import org.springframework.http.HttpStatus;

public class EmptyObjectException extends ApplicationException{

  public EmptyObjectException(final String message) {
    super(HttpStatus.NOT_FOUND, message);
  }

  public EmptyObjectException(Object o) {
    super(HttpStatus.NOT_FOUND, "This object is empty fill in the fields");
  }

  public String getMessage() {
    return super.getMessage();
  }

  public HttpStatus status() {
    return super.status();
  }
}
