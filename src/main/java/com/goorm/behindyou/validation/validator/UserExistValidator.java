package com.goorm.behindyou.validation.validator;

import com.goorm.behindyou.apiPayload.code.status.ErrorStatus;
import com.goorm.behindyou.service.UserService.UserQueryService;
import com.goorm.behindyou.validation.annotation.ExistUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class UserExistValidator implements ConstraintValidator<ExistUser, Long> {

    private final UserQueryService userQueryService;

    @Override
    public void initialize(ExistUser constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = userQueryService.isExistUser(value);
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.USER_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
