package com.hy.ouch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MessageResponseDetailed<T> {

	private boolean isSuccess;

	private String code;

	private String message;

	private T data;
}
