package com.springboot.basic.auth.dto;

import lombok.Data;

@Data
public class RegisterResponseDto {
    private Long id;
    private String username;
    private String userEmail;

    public RegisterResponseDto(Long id, String username, String useremail) {
        this.id = id;
        this.username = username;
        this.userEmail = useremail;
    }
}
