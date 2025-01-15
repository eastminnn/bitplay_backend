package com.springboot.basic.auth.service;

import com.springboot.basic.auth.dto.LoginRequestDto;
import com.springboot.basic.auth.dto.LoginResponseDto;
import com.springboot.basic.auth.dto.RegisterRequestDto;
import com.springboot.basic.auth.dto.RegisterResponseDto;
import com.springboot.basic.auth.entity.User;
import com.springboot.basic.auth.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 사용자 등록
    @Override
    public RegisterResponseDto register(RegisterRequestDto registerRequestDto) {
        // 이메일 중복 확인
        if (userRepository.findByUseremail(registerRequestDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email이 이미 사용 중입니다.");
        }

        // 엔티티 생성
        User user = new User();
        user.setUsername(registerRequestDto.getUsername());
        user.setUserpassword(passwordEncoder.encode(registerRequestDto.getUserPassword()));
        user.setUseremail(registerRequestDto.getEmail());

        // 사용자 저장
        User savedUser = userRepository.save(user);

        // 응답 DTO 생성
        return new RegisterResponseDto(savedUser.getId(), savedUser.getUseremail(), savedUser.getUserpassword());
    }


    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        // 사용자 조회
        User user = userRepository.findByUsername(loginRequestDto.getUsernameOrEmail())
                .or(() -> userRepository.findByUseremail(loginRequestDto.getUsernameOrEmail()))
                .orElseThrow(() -> new IllegalArgumentException("username 또는 email이 맞지않습니다."));

        // 비밀번호 확인
        if (!passwordEncoder.matches(loginRequestDto.getUserpassword(), user.getUserpassword()))
            throw new IllegalArgumentException("password가 맞지않음.");

        // JWT Token 생성
        String token = "sample-jwt-token";

        // 응답 DTO 생성
        return new LoginResponseDto(token, user.getUsername());
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findUserByUseremail(String useremail) {
        return userRepository.findByUseremail(useremail);
    }
}
