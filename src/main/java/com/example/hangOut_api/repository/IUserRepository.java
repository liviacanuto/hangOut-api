package com.example.hangOut_api.repository;

import com.example.hangOut_api.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
