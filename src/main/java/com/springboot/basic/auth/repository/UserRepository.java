package com.springboot.basic.auth.repository;
import com.springboot.basic.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 사용자 이름으로 조회
    Optional<User> findByUsername(String username);

    // 이메일로 조회
    Optional<User> findByUseremail(String useremail);

    // 특정 역할을 가진 사용자 목록을 조회
    List<User> findByRole(User.Role role);
}