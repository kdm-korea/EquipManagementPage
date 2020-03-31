package com.services.webservice.exception;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
	private LocalDateTime timestamp;
	private String message;
	private String error;
	private String path;
	
	@Builder
	public ExceptionResponse(String message, String error, String path) {
		super();
		this.timestamp = LocalDateTime.now();
		this.message = message;
		this.error = error;
		this.path = path;
	}
	
	
}
