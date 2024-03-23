package com.goorm.behindyou.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

public class NotificationRequestDTO {

    @Getter
    @AllArgsConstructor
    public static class NotificationDTO {
        @NotNull
        Long status;
    }
}
