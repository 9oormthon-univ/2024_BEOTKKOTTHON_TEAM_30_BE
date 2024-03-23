package com.goorm.behindyou.service.KeywordService;

import com.goorm.behindyou.apiPayload.code.status.ErrorStatus;
import com.goorm.behindyou.apiPayload.exception.handler.KeywordHandler;
import com.goorm.behindyou.apiPayload.exception.handler.UserHandler;
import com.goorm.behindyou.domain.keyword.Keyword;
import com.goorm.behindyou.domain.user.User;
import com.goorm.behindyou.repository.KeywordRepository;
import com.goorm.behindyou.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KeywordQueryServiceImpl implements KeywordQueryService {

    private final KeywordRepository keywordRepository;
    private final UserRepository userRepository;

    @Override
    public Keyword getKeywordContent(Long keywordId) {
        Keyword keyword = keywordRepository.findById(keywordId).orElseThrow(() -> new KeywordHandler(ErrorStatus.KEYWORD_NOT_FOUND));
        return keyword;
    }

    @Override
    public boolean isExistKeyword(Long keywordId) {
        return keywordRepository.existsById(keywordId);
    }

    @Override
    @Transactional
    public Page<Keyword> getMyKeywordList(Long userId, Integer page) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        Page<Keyword> keywordPage = keywordRepository.findAllByUser(user, PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "createdAt")));
        return keywordPage;
    }
}
