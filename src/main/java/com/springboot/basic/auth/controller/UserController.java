package com.springboot.basic.auth.controller;

import com.springboot.basic.auth.dto.LoginRequestDto;
import com.springboot.basic.auth.dto.LoginResponseDto;
import com.springboot.basic.auth.dto.RegisterRequestDto;
import com.springboot.basic.auth.dto.RegisterResponseDto;
import com.springboot.basic.auth.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users") // API 기본 URL 경로 설정
public class UserController {

    private final UserService userService;

    // 생성자 주입
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Register
    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto registerRequestDto) {
        RegisterResponseDto responseDto = userService.register(registerRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    // login
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto loginResponseDto = userService.login(loginRequestDto);
        return ResponseEntity.ok(loginResponseDto);
    }

}
