package com.services.webservice.service;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ApiResponse {

	private int status;
	private String message;
	private Object result;

	public ApiResponse(int status, String message, Object result) {
		this.status = status;
		this.message = message;
		this.result = result;
	}
}
