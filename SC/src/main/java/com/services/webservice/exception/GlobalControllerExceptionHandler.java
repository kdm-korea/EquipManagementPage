package com.services.webservice.exception;

import java.time.LocalDateTime;

import javax.servlet.annotation.HttpConstraint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.services.webservice.exception.ExceptionClass.CustomNoArgsException;

@RestController
@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@Autowired
	private ExceptionResponse response;	
	
	@ExceptionHandler(CustomNoArgsException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ExceptionResponse noHaveArgsHandler(CustomNoArgsException e) throws Exception {
		response.setMessage(e.getMessage());
		response.setPath("");
		return response;
	}
	
//	@ExceptionHandler(CustomAlreadyHaveSameEquip.class)
//	@ResponseStatus(code = HttpStatus.)
//	public ExceptionResponse alReadyHaveSameEquip(CustomAlreadyHaveSameEquip e) {
//		
//	}
}
