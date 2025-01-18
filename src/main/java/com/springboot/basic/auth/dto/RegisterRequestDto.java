package com.springboot.basic.auth.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegisterRequestDto {
    @NotBlank(message = "Username 이 입력되지않음.")
    private String username;

    @NotBlank(message = "password 가 입력되지않음.")
    private String userPassword;

    @NotBlank(message = "email 이 입력되지않음.")
    @Email(message = "email 형식이 아닙니다.")
    private String userEmail;

    // getter, setter
    public String getEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserpassword() {
        this.userPassword = userPassword;
    }
}
