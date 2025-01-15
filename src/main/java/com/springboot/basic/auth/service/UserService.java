package com.springboot.basic.auth.service;

import com.springboot.basic.auth.entity.User;

import java.util.Optional;

public interface UserService {
    // 사용자 등록
    User registerUser(User user);

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByUseremail(String useremail);
}
