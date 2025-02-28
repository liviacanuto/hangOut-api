package com.example.hangOut_api.service.cryptography;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Password implements IPassword {
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @Override
    public String encrypt(String password) {
        return this.encoder.encode(password);
    }

    @Override
    public boolean verifyPassword(String password, String encryptedPassword) {
        return this.encoder.matches(password, encryptedPassword);
    }
}
