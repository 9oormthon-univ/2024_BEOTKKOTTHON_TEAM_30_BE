package com.goorm.behindyou.apiPayload.exception.handler;


import com.goorm.behindyou.apiPayload.code.BaseErrorCode;
import com.goorm.behindyou.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
