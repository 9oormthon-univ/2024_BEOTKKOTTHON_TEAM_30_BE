package com.goorm.behindyou.validation.validator;

import com.goorm.behindyou.apiPayload.code.status.ErrorStatus;
import com.goorm.behindyou.service.KeywordService.KeywordQueryService;
import com.goorm.behindyou.validation.annotation.ExistKeyword;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class KeywordExistValidator implements ConstraintValidator<ExistKeyword, Long> {

    private final KeywordQueryService keywordQueryService;

    @Override
    public void initialize(ExistKeyword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = keywordQueryService.isExistKeyword(value);
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.KEYWORD_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
