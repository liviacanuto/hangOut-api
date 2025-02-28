package com.example.hangOut_api.controller;

import com.example.hangOut_api.model.user.UserRegisterDTO;
import com.example.hangOut_api.model.user.UserResponseDTO;
import com.example.hangOut_api.service.user.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody @Valid UserRegisterDTO userRegisterDTO) {
        UserResponseDTO savedUser = this.userService.addUser(userRegisterDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
