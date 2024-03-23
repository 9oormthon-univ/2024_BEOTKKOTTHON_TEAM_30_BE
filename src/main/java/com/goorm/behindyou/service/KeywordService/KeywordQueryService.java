package com.goorm.behindyou.service.KeywordService;

import com.goorm.behindyou.domain.keyword.Keyword;
import org.springframework.data.domain.Page;

public interface KeywordQueryService {
    public Keyword getKeywordContent(Long keywordId);

    boolean isExistKeyword(Long keywordId);

    public Page<Keyword> getMyKeywordList(Long userId, Integer page);
}
