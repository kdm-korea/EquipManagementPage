package com.services.webservice.lib;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ErrorResponse {
	private String message;
	
	private int status;
	
	private List<ErrorDetail> errors;
	
	private String code;
}
