package com.example.jwt_authentication.repository;

import com.example.jwt_authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);    // Finds a registered user using their email address

    boolean existsByEmail(String email);      // Checks whether the email already exists
}
