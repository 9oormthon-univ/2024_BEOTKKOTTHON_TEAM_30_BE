package com.goorm.behindyou.web.controller;

import com.goorm.behindyou.apiPayload.ApiResponse;
import com.goorm.behindyou.converter.KeywordConverter;
import com.goorm.behindyou.domain.keyword.Keyword;
import com.goorm.behindyou.service.KeywordService.KeywordCommandService;
import com.goorm.behindyou.web.dto.KeywordRequestDTO;
import com.goorm.behindyou.web.dto.KeywordResponseDTO;
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
@Tag(name = "keyword", description = "키워드 관련 API")
@RequestMapping("/api")
public class KeywordRestController {

    private final KeywordCommandService keywordCommandService;

    @PostMapping("/keyword")
    @Operation(summary = "키워드 등록 API", description = "키워드 등록을 위한 API이며, requset 파라미터로 입력 값을 받는다. " +
            "userId : 등록하는 사용자의 id")
    @Parameters(value = {
            @Parameter(name = "userId", description = "사용자 아이디, 키워드를 등록하는 사용자를 식별하기 위해 사용.")
    })
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<KeywordResponseDTO.UploadKeywordResultDTO> upload(@RequestBody @Valid KeywordRequestDTO.UploadKeywordDTO request,
                                                                         @RequestParam(name = "userId") Long userId) {
        Keyword keyword = keywordCommandService.uploadKeyword(userId, request);
        return ApiResponse.onSuccess(KeywordConverter.toUploadKeywordResultDTO(keyword));
    }

}
