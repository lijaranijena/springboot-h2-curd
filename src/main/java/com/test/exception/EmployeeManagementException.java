package com.test.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class EmployeeManagementException extends RuntimeException {
	private final InternalStandardErrors errors;
}
