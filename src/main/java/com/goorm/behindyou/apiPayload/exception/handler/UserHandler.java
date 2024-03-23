package com.goorm.behindyou.apiPayload.exception.handler;

import com.goorm.behindyou.apiPayload.code.BaseErrorCode;
import com.goorm.behindyou.apiPayload.exception.GeneralException;

public class UserHandler extends GeneralException {
    public UserHandler(BaseErrorCode code) {
        super(code);
    }
}
