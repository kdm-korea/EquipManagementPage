package com.services.webservice.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {
	private LocalDateTime timestamp;
	private String message;
	private String error;
	private String path;
	
	public ExceptionResponse() {
		this.timestamp = LocalDateTime.now();
	}
}
