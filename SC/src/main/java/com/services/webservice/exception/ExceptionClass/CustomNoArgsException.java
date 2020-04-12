package com.services.webservice.exception.ExceptionClass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
public class CustomNoArgsException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomNoArgsException(String reason) {
		super(reason);
	}
	
	public CustomNoArgsException(Exception error, String reason) {
		super(reason, error);
	}
	
	public CustomNoArgsException(Exception error) {
		super(error);
	}
}
