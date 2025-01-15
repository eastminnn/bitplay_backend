package com.springboot.basic.auth.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegisterRequestDto {
    @NotBlank(message = "Username 이 입력되지않음.")
    private String username;

    @NotBlank(message = "password 가 입력되지않음.")
    private String password;

    @NotBlank(message = "email 이 입력되지않음.")
    @Email(message = "email 형식이 아닙니다.")
    private String useremail;
}
