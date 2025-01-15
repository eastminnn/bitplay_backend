package com.springboot.basic.auth.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegisterRequestDto {
    @NotBlank(message = "Username 이 입력되지않음.")
    private String username;

    @NotBlank(message = "password 가 입력되지않음.")
    private String userpassword;

    @NotBlank(message = "email 이 입력되지않음.")
    @Email(message = "email 형식이 아닙니다.")
    private String useremail;

    // getter, setter
    public String getEmail() {
        return useremail;
    }
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userpassword;
    }

    public void setUserpassword() {
        this.userpassword = userpassword;
    }
}
