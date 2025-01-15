package com.springboot.basic.auth.service;

import com.springboot.basic.auth.dto.LoginRequestDto;
import com.springboot.basic.auth.dto.LoginResponseDto;
import com.springboot.basic.auth.dto.RegisterRequestDto;
import com.springboot.basic.auth.dto.RegisterResponseDto;
import com.springboot.basic.auth.entity.User;

import java.util.Optional;

public interface UserService {
    // 사용자 등록
    RegisterResponseDto register(RegisterRequestDto registerRequestDto);

    // 사용자 이름으로 조회
    Optional<User> findUserByUsername(String username);

    // 사용자 이메일로 조회
    Optional<User> findUserByUseremail(String useremail);

    // 로그인
    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
