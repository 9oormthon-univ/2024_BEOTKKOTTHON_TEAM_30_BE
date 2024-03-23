package com.goorm.behindyou.repository;

import com.goorm.behindyou.domain.keyword.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
}
