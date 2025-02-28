package com.example.hangOut_api.service.user;

import com.example.hangOut_api.exception.AlreadyExistsException;
import com.example.hangOut_api.model.user.User;
import com.example.hangOut_api.model.user.UserRegisterDTO;
import com.example.hangOut_api.model.user.UserResponseDTO;
import com.example.hangOut_api.repository.IUserRepository;
import com.example.hangOut_api.service.cryptography.Password;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private Password passwordService;

    @Override
    public UserResponseDTO addUser(@Valid UserRegisterDTO userRegisterDTO) {
        User user = new User(userRegisterDTO);
        user.setPassword(this.passwordService.encrypt(userRegisterDTO.password()));

        user = this.userRepository.save(user);
        return new UserResponseDTO(user);
    }

}
