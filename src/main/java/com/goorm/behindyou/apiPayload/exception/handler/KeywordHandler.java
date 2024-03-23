package com.goorm.behindyou.apiPayload.exception.handler;

import com.goorm.behindyou.apiPayload.code.BaseErrorCode;
import com.goorm.behindyou.apiPayload.exception.GeneralException;

public class KeywordHandler extends GeneralException {

    public KeywordHandler(BaseErrorCode code) {
        super(code);
    }
}
