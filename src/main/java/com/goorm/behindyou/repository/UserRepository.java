package com.goorm.behindyou.repository;

import com.goorm.behindyou.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
