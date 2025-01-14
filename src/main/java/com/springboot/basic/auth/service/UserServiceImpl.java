package com.springboot.basic.auth.service;

import com.springboot.basic.auth.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    // 사용자 등록
    @Override
    public User registerUser(User user) {
        return null;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findUserByUseremail(String useremail) {
        return Optional.empty();
    }
}
