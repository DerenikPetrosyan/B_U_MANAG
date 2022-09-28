package com.iunetworks.service.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

  // digit + lowercase char + uppercase char + punctuation + symbol
  private  final String EMAIL_PATTERN =
    " ^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$";

  private  final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

  public  boolean isValid(final String email) {
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }
}
