package com.hy.ouch.apiPayload.handler;

import com.hy.ouch.apiPayload.code.error.ErrorCode;
import com.hy.ouch.apiPayload.exception.OuchException;

import lombok.Getter;

@Getter
public class TempHandler extends OuchException {

	public TempHandler(ErrorCode errorCode) {
		super(errorCode);
	}
}
