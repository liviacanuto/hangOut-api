package com.example.hangOut_api.service.user;

import com.example.hangOut_api.model.user.UserRegisterDTO;
import com.example.hangOut_api.model.user.UserResponseDTO;

public interface IUserService {
    UserResponseDTO addUser(UserRegisterDTO userRegisterDTO);
}
