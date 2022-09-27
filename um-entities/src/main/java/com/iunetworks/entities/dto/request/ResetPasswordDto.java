package com.iunetworks.entities.dto.request;

/**
 * A class used to send a request to reset the password
 */

public class ResetPasswordDto {


    private String email;

    private String token;

    private String newPassword;

    private String confirmPassword;

}
