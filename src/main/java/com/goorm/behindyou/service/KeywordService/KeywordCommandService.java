package com.goorm.behindyou.service.KeywordService;

import com.goorm.behindyou.domain.keyword.Keyword;
import com.goorm.behindyou.web.dto.KeywordRequestDTO;

public interface KeywordCommandService {

    public Keyword uploadKeyword(Long userId, KeywordRequestDTO.UploadKeywordDTO request);
}
