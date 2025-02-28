package com.example.hangOut_api;

import com.example.hangOut_api.exception.AlreadyExistsException;
import com.example.hangOut_api.model.user.User;
import com.example.hangOut_api.model.user.UserRegisterDTO;
import com.example.hangOut_api.model.user.UserResponseDTO;
import com.example.hangOut_api.repository.IUserRepository;
import com.example.hangOut_api.service.cryptography.Password;
import com.example.hangOut_api.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    private final String EMAIL = "email@email.com";
    private final String PASSWORD = "password";
    private final String FIRST_NAME = "firstName";
    private final String LAST_NAME = "lastName";
    private final String ENCRYPTED_PASSWORD = "encryptedPassword";

    @InjectMocks
    private UserService userService;

    @Mock
    private IUserRepository userRepository;

    @Mock
    private Password passwordService;

    @Test
    public void shouldAddUserSuccessfully() {
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO(this.FIRST_NAME, this.LAST_NAME, this.EMAIL,
                                                              this.PASSWORD);

        User userToSave = new User(userRegisterDTO);
        userToSave.setPassword(this.ENCRYPTED_PASSWORD);

        User userSaved = new User(userRegisterDTO);
        userSaved.setId(1);

        when(this.userRepository.existsByEmail(this.EMAIL)).thenReturn(false);
        when(this.passwordService.encrypt(this.PASSWORD)).thenReturn(this.ENCRYPTED_PASSWORD);
        when(this.userRepository.save(userToSave)).thenReturn(userSaved);

        UserResponseDTO response = this.userService.addUser(userRegisterDTO);

        assertNotNull(response);
        assertEquals(userSaved.getEmail(), response.email());
        verify(this.userRepository, times(1)).existsByEmail(this.EMAIL);
        verify(this.passwordService, times(1)).encrypt(this.PASSWORD);
        verify(this.userRepository, times(1)).save(userToSave);

    }

    @Test
    public void shouldThrowEmailAlreadyExistsError() {
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO(this.FIRST_NAME, this.LAST_NAME, this.EMAIL,
                                                              this.PASSWORD);

        when(this.userRepository.existsByEmail(this.EMAIL)).thenReturn(true);
        assertThrows(AlreadyExistsException.class, () -> this.userService.addUser(userRegisterDTO));
    }
}
