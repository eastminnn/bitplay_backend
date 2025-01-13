package com.springboot.basic.auth.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 자동 생성
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false, unique = true, length = 50)
    private String useremail;

    @CreationTimestamp // 생성시간 자동기록
    @Column(updatable = false) // 생성시간 수정 불가
    private LocalDateTime created;

    @Enumerated(EnumType.STRING) // 사용자 관리 (열거형)
    @Column(nullable = false)
    private Role role; // 사용자 권한

    public enum Role {
        USER, ADMIN
    }

}
