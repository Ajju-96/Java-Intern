package com.example.jwt_authentication.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){     // "passwordEncoder" Interface provided by Spring Security
        return new BCryptPasswordEncoder();  // Actual implementation that hashes passwords
    }
}
