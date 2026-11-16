package com.example.jwt_authentication.controller;


import com.example.jwt_authentication.dto.LoginRequest;
import com.example.jwt_authentication.dto.LoginResponse;
import com.example.jwt_authentication.dto.RegisterRequest;
import com.example.jwt_authentication.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.AuthenticationException;

@RestController                 // Makes this class a REST API controller
@RequestMapping("/api/auth")    // Defines the common URL path
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    // Handles HTTP POST requests
    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request){    // "RequestBody" Converts incoming JSON into a Java object
        String response = authService.register(request);                                    // "Valid" Executes DTO validation rule

        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request) {

        try {
            LoginResponse response = authService.login(request);
            return ResponseEntity.ok(response);

        } catch (AuthenticationException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
