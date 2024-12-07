package com.hy.ouch.apiPayload.exception.handler;

import com.hy.ouch.apiPayload.code.BaseErrorCode;
import com.hy.ouch.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

	public TempHandler(BaseErrorCode errorCode) {
		super(errorCode);
	}
}
