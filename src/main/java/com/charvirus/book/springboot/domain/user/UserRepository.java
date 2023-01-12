package com.charvirus.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    // 소셜 로그인을 할때 반환 되는 값중 이메일을 통해 이미 생성된 사용자인지 확인하기 위한 메소드
}
