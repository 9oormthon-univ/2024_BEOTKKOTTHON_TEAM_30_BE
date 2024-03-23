package com.goorm.behindyou.web.controller;

import com.goorm.behindyou.apiPayload.ApiResponse;
import com.goorm.behindyou.converter.UserConverter;
import com.goorm.behindyou.domain.user.User;
import com.goorm.behindyou.service.UserService.UserCommandService;
import com.goorm.behindyou.validation.annotation.ExistUser;
import com.goorm.behindyou.web.dto.UserRequestDTO;
import com.goorm.behindyou.web.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
@Tag(name = "user", description = "사용자 관련 API")
@RequestMapping("/api")
public class UserRestController {

    private final UserCommandService userCommandService;

    @GetMapping("/user/notification")
    @Operation(summary = "사용자 알림 여부 수정 API", description = "사용자 알림 여부 수정을 위한 API이며, query string으로 입력 값을 받는다. " +
            "userId : 알람 여부를 수정하고자 하는 키워드의 id")
    @Parameters(value = {
            @Parameter(name = "userId", description = "사용자 아이디, 알람 여부를 수정하고자 하는 사용자를 식별하기 위해 사용.")
    })
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<UserResponseDTO.updateUserResultDTO> updateUserNotification(@RequestParam(name = "userId") @ExistUser Long userId) {
        userCommandService.updateUser(userId);
        return ApiResponse.onSuccess(UserConverter.toUpdateUserDTO(userId));
    }

    @PostMapping("/join")
    @Operation(summary = "사용자 회원가입 API", description = "회원가입을 위한 API이며, request body로 입력 값을 받는다. ")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<UserResponseDTO.joinUserResultDTO> join(@RequestBody @Valid UserRequestDTO.joinUserDTO request) {

        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }
}
