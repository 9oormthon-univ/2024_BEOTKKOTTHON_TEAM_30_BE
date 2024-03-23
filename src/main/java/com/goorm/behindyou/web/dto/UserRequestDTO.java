package com.goorm.behindyou.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

public class UserRequestDTO {

    @Getter
    @AllArgsConstructor
    public static class joinUserDTO {
        @NotNull
        String nickName;
        @NotNull
        String email;
        @NotNull
        String password;
        @NotNull
        Long alarmStatus;
    }
}
