package com.iunetworks.service.validators;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

  // digit + lowercase char + uppercase char + punctuation + symbol
  private  final String PASSWORD_PATTERN =
    "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";

  private  final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

  public  boolean isValid(final String password) {
    Matcher matcher = pattern.matcher(password);
    return matcher.matches();
  }

}