package com.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeMgmtExceptionHandler {


	@ExceptionHandler(EmployeeManagementException.class)
	public ResponseEntity<ErrorMessage> handleError(EmployeeManagementException ex) {
		InternalStandardErrors errors = ex.getErrors();
		return new ResponseEntity<>(ErrorMessage.builder()
				.message(errors.getMessage())
				.statusCode(errors.getErrorCode())
				.build(),errors.getStatus());
	}



	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleError(Exception ex) {
		return new ResponseEntity<>(ErrorMessage.builder()
				.message("Internal error occurred")
				.statusCode("-1")
				.build(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
