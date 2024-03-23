package com.goorm.behindyou.web.controller;

import com.goorm.behindyou.apiPayload.ApiResponse;
import com.goorm.behindyou.converter.KeywordConverter;
import com.goorm.behindyou.service.KeywordService.KeywordCommandService;
import com.goorm.behindyou.validation.annotation.ExistKeyword;
import com.goorm.behindyou.web.dto.KeywordResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@Tag(name = "notification", description = "알림 관련 API")
@RequestMapping("/api")
public class NotificationRestController {

    private final KeywordCommandService keywordCommandService;

    @GetMapping("/notification/status")
    @Operation(summary = "키워드 알림 여부 수정 API", description = "키워드 알림 여부 수정을 위한 API이며, query string으로 입력 값을 받는다. " +
            "keywordId : 알람 여부를 수정하고자 하는 키워드의 id")
    @Parameters(value = {
            @Parameter(name = "keywordId", description = "키워드 아이디, 알람 여부를 수정하고자 하는 키워드를 식별하기 위해 사용.")
    })
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<KeywordResponseDTO.updateNotificationResultDTO> getKeyword(@ExistKeyword @RequestParam(name = "keywordId") Long keywordId) {
        keywordCommandService.updateNotification(keywordId);
        return ApiResponse.onSuccess(KeywordConverter.toUpdateNotificationStatusResultDTO(keywordId));
    }
}
