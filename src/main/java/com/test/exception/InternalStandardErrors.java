package com.test.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum InternalStandardErrors {

	EMP_ID_NOT_EXIST("Emp Id not exist", "6000", HttpStatus.NOT_FOUND);

	private final String message;
	private final String errorCode;
	private final HttpStatus status;
}
