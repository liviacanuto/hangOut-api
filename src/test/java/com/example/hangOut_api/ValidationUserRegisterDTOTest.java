package com.example.hangOut_api;

import com.example.hangOut_api.model.user.UserRegisterDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationUserRegisterDTOTest {
    private final String EMAIL = "email@email.com";
    private final String PASSWORD = "password";
    private final String FIRST_NAME = "firstName";
    private final String LAST_NAME = "lastName";

    private Validator validator;

    @Test
    public void shouldThrowErrorWhenFirstNameIsNull() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO(null, this.LAST_NAME, this.EMAIL, this.PASSWORD);
        Set<ConstraintViolation<UserRegisterDTO>> errors = this.validator.validate(userRegisterDTO);
        assertEquals(1, errors.size());
        String message = errors.iterator().next().getMessage();
        assertEquals(UserRegisterDTO.FIRST_NAME_REQUIRED, message);
    }

    @Test
    public void shouldThrowErrorWhenLastNameIsNull() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO(this.FIRST_NAME, null, this.EMAIL, this.PASSWORD);
        Set<ConstraintViolation<UserRegisterDTO>> errors = this.validator.validate(userRegisterDTO);
        assertEquals(1, errors.size());
        String message = errors.iterator().next().getMessage();
        assertEquals(UserRegisterDTO.LAST_NAME_REQUIRED, message);
    }

    @Test
    public void shouldThrowErrorWhenEmailIsNull() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO(this.FIRST_NAME, this.LAST_NAME, null, this.PASSWORD);
        Set<ConstraintViolation<UserRegisterDTO>> errors = this.validator.validate(userRegisterDTO);
        assertEquals(1, errors.size());
        String message = errors.iterator().next().getMessage();
        assertEquals(UserRegisterDTO.EMAIL_NAME_REQUIRED, message);
    }

    @Test
    public void shouldThrowErrorWhenEmailIsNotValid() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO(this.FIRST_NAME, this.LAST_NAME, "invalid_email",
                                                              this.PASSWORD);
        Set<ConstraintViolation<UserRegisterDTO>> errors = this.validator.validate(userRegisterDTO);
        assertEquals(1, errors.size());
        String message = errors.iterator().next().getMessage();
        assertEquals(UserRegisterDTO.EMAIL_MUST_BE_VALID, message);
    }

    @Test
    public void shouldThrowErrorWhenPasswordIsNull() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO(this.FIRST_NAME, this.LAST_NAME, this.EMAIL, null);
        Set<ConstraintViolation<UserRegisterDTO>> errors = this.validator.validate(userRegisterDTO);
        assertEquals(1, errors.size());
        String message = errors.iterator().next().getMessage();
        assertEquals(UserRegisterDTO.PASSWORD_REQUIRED, message);
    }

    @Test
    public void shouldThrowErrorWhenPasswordIsNotValid() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO(this.FIRST_NAME, this.LAST_NAME, this.EMAIL, "0");
        Set<ConstraintViolation<UserRegisterDTO>> errors = this.validator.validate(userRegisterDTO);
        assertEquals(1, errors.size());
        String message = errors.iterator().next().getMessage();
        assertEquals(UserRegisterDTO.PASSWORD_MUST_BE_VALID, message);
    }
}
