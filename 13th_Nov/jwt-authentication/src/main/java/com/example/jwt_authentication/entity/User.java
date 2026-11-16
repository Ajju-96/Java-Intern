package com.example.jwt_authentication.entity;


import jakarta.persistence.*;

@Entity // Marks this class as a JPA entity
@Table(name = "users")  // Specifies the database table name

public class User {

    @Id // Defines the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generates the ID
    private Long id;

    @Column(nullable = false)   // Configures database column properties
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role = "ROLE_USER";

    //Default constructor
    public User(){

    }

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
