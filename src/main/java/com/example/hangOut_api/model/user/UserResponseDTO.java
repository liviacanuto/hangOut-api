package com.example.hangOut_api.model.user;

public record UserResponseDTO(Long id, String firstName, String lastName, String email) {
    public UserResponseDTO(User user) {
        this(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    }
}
