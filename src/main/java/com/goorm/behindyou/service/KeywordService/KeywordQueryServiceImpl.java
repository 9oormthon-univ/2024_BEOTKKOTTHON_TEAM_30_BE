package com.goorm.behindyou.service.KeywordService;

import com.goorm.behindyou.apiPayload.code.status.ErrorStatus;
import com.goorm.behindyou.apiPayload.exception.handler.KeywordHandler;
import com.goorm.behindyou.domain.keyword.Keyword;
import com.goorm.behindyou.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KeywordQueryServiceImpl implements KeywordQueryService {

    private final KeywordRepository keywordRepository;

    @Override
    public Keyword getKeywordContent(Long keywordId) {
        Keyword keyword = keywordRepository.findById(keywordId).orElseThrow(() -> new KeywordHandler(ErrorStatus.KEYWORD_NOT_FOUND));
        return keyword;
    }

    @Override
    public boolean isExistKeyword(Long keywordId) {
        return keywordRepository.existsById(keywordId);
    }
}
