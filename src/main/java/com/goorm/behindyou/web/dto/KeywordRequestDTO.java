package com.goorm.behindyou.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class KeywordRequestDTO {

    @Getter
    @AllArgsConstructor
    public static class UploadKeywordDTO {
        @NotBlank
        String name;
        @NotNull
        String type;
        @NotNull
        Long urgency;
        @Nullable
        Long callingCount;
        @NotNull
        String alertInfo;
    }
}
