package com.goorm.behindyou.repository;

import com.goorm.behindyou.domain.keyword.Keyword;
import com.goorm.behindyou.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {

    Page<Keyword> findAllByUser(User user, PageRequest pageRequest);

    List<Keyword> findAllByUserId(Long userId);
}
