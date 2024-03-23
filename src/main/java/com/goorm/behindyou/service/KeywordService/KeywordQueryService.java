package com.goorm.behindyou.service.KeywordService;

import com.goorm.behindyou.domain.keyword.Keyword;

public interface KeywordQueryService {
    public Keyword getKeywordContent(Long keywordId);

    boolean isExistKeyword(Long keywordId);
}
