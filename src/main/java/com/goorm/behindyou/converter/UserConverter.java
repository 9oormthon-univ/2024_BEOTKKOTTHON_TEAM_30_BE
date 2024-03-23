package com.goorm.behindyou.converter;

import com.goorm.behindyou.domain.user.User;
import com.goorm.behindyou.web.dto.UserRequestDTO;
import com.goorm.behindyou.web.dto.UserResponseDTO;

public class UserConverter {

    public static UserResponseDTO.joinUserResultDTO toJoinResultDTO(User user) {
        return UserResponseDTO.joinUserResultDTO.builder()
                .userId(user.getId())
                .createdAt(user.getCreatedAt())
                .build();
    }

    public static User toJoinUserDTO(UserRequestDTO.joinUserDTO request) {
        return User.builder()
                .nickName(request.getNickName())
                .email(request.getEmail())
                .password(request.getPassword())
                .alarmStatus(request.getAlarmStatus())
                .build();
    }

    public static UserResponseDTO.updateUserResultDTO toUpdateUserDTO(Long userId) {
        return UserResponseDTO.updateUserResultDTO.builder()
                .userId(userId)
                .build();
    }
}
