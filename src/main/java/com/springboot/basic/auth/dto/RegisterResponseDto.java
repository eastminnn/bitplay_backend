package com.springboot.basic.auth.dto;

public class RegisterResponseDto {
    private Long id;
    private String username;
    private String useremail;

    public RegisterResponseDto(Long id, String username, String useremail) {
        this.id = id;
        this.username = username;
        this.useremail = useremail;
    }
}
