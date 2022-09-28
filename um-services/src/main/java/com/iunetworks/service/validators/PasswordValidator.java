package com.iunetworks.service.validators;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

  // digit + lowercase char + uppercase char + punctuation + symbol
  private  final String PASSWORD_PATTERN =
    "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

  private  final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

  public  boolean isValid(final String password) {
    Matcher matcher = pattern.matcher(password);
    return matcher.matches();
  }

}