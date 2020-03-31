package com.services.webservice.exception;

import javax.servlet.http.HttpServletRequest;
import javax.validation.UnexpectedTypeException;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.services.webservice.exception.ExceptionClass.CustomNoArgsException;

@RestController
@ControllerAdvice
public class GlobalControllerExceptionHandler {
	
	@ExceptionHandler(CustomNoArgsException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ExceptionResponse noHaveArgsHandler(Exception e, HttpServletRequest request) {
		return ExceptionResponse.builder()
			.message(e.getMessage())
		 	.path(request.getRequestURL().toString())
		 	.error("noHaveArgsHandler")
		 	.build();
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ExceptionResponse noTypeMatch(Exception e, HttpServletRequest request) {
		return ExceptionResponse.builder()
				.message(e.getMessage())
				.path(request.getRequestURL().toString())
			 	.error("noTypeMatch")
			 	.build();
	}
	
	@ExceptionHandler(UnexpectedTypeException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ExceptionResponse notPassValidation(Exception e, HttpServletRequest request) {
		return ExceptionResponse.builder()
				.message(e.getMessage())
				.path(request.getRequestURL().toString())
			 	.error("notPassValidation")
			 	.build();
	}
}
