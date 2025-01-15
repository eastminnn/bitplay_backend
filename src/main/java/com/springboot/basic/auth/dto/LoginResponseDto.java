package com.springboot.basic.auth.dto;

public class LoginResponseDto {
    private String token; // JWT 토큰
    private String username;

    public LoginResponseDto(String token, String username) {
        this.token = token;
        this.username = username;
    }
}
