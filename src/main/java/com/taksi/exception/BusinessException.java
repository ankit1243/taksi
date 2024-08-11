package com.taksi.exception;

public class BusinessException extends RuntimeException{

	public BusinessException(String errMsg) {
		super(errMsg);
	}
}
