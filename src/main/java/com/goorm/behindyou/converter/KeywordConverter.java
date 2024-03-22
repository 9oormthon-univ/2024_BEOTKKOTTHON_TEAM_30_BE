package com.goorm.behindyou.converter;

import com.goorm.behindyou.domain.keyword.Keyword;
import com.goorm.behindyou.web.dto.KeywordRequestDTO;
import com.goorm.behindyou.web.dto.KeywordResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class KeywordConverter {

    public static Keyword toKeyword(KeywordRequestDTO.UploadKeywordDTO request) {

        return Keyword.builder()
                .name(request.getName())
                .type(request.getType())
                .alertInfo(request.getAlertInfo())
                .urgency(request.getUrgency())
                .callingCount(0L)
                .notificationList(new ArrayList<>())
                .build();
    }

    public static KeywordResponseDTO.UploadKeywordResultDTO toUploadKeywordResultDTO(Keyword keyword) {
        return KeywordResponseDTO.UploadKeywordResultDTO.builder()
                .keywordId(keyword.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
