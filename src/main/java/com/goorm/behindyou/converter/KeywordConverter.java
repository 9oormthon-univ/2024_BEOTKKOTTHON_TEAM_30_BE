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
                .alertMessage(request.getAlertMessage())
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

    public static KeywordResponseDTO.DeleteKeywordResultDTO toDeleterKeywordResultDTO(Long keywordId) {
        return KeywordResponseDTO.DeleteKeywordResultDTO.builder()
                .keywordId(keywordId)
                .build();
    }

    public static KeywordResponseDTO.updateNotificationResultDTO toUpdateNotificationStatusResultDTO(Long keywordId) {
        return KeywordResponseDTO.updateNotificationResultDTO.builder()
                .keywordId(keywordId)
                .build();
    }

    public static KeywordResponseDTO.KeywordContentDTO toGetKeywordContentDTO(Keyword keyword) {
        return KeywordResponseDTO.KeywordContentDTO.builder()
                .name(keyword.getName())
                .type(keyword.getType())
                .urgency(keyword.getUrgency())
                .alertMessage(keyword.getAlertMessage())
                .callingCount(keyword.getCallingCount())
                .build();
    }
}
