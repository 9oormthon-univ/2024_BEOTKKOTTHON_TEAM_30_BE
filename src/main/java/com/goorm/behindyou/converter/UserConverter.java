package com.goorm.behindyou.converter;

import com.goorm.behindyou.web.dto.UserResponseDTO;

public class UserConverter {

    public static UserResponseDTO.updateUserResultDTO toUpdateUserDTO(Long userId) {
        return UserResponseDTO.updateUserResultDTO.builder()
                .userId(userId)
                .build();
    }
}
