package com.kannan.sample.user.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.kannan.sample.util.Custom404Exception;
import com.kannan.sample.util.CustomErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Custom404Exception.class)
	public ResponseEntity<Object> handleResourceNotFound(Custom404Exception ex) {
		CustomErrorResponse response = new CustomErrorResponse.CustomResponseBuilder().withStatus(HttpStatus.NO_CONTENT)
				.withError_code(HttpStatus.NOT_FOUND.name()).withMessage(ex.getLocalizedMessage())
				.withDetail(ex.getMessage()).build();
		return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
	}

}
