package com.example.hangOut_api.model.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegisterDTO(
        @NotBlank(message = FIRST_NAME_REQUIRED) String firstName,

        @NotBlank(message = LAST_NAME_REQUIRED) String lastName,

        @NotBlank(message = EMAIL_NAME_REQUIRED) @Email(regexp = ".+[@].+[\\.].+", message = EMAIL_MUST_BE_VALID) String email,

        @NotBlank(message = PASSWORD_REQUIRED) @Size(min = 6, message = PASSWORD_MUST_BE_VALID ) String password) {

    public static final String FIRST_NAME_REQUIRED = "firstName is required";
    public static final String LAST_NAME_REQUIRED = "lastName is required";
    public static final String EMAIL_NAME_REQUIRED = "email is required";
    public static final String EMAIL_MUST_BE_VALID = "email must be valid";
    public static final String PASSWORD_REQUIRED = "password is required";
    public static final String PASSWORD_MUST_BE_VALID = "password must be 6 characters long";
}
