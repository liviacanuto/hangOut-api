package com.example.hangOut_api.service.cryptography;

public interface IPassword {
    String encrypt(String password);

    boolean verifyPassword(String password, String encryptedPassword);
}
