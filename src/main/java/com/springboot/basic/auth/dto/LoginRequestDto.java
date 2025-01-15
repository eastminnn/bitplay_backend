package com.springboot.basic.auth.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequestDto {
    @NotBlank(message = "Username 또는 Email 이 입력되지않음.")
    private String usernameOrEmail;

    @NotBlank(message = "Password 가 입력되지않음.")
    private String userpassword;
}
