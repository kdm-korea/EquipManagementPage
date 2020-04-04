package com.services.webservice.library.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RestResponse<T> {
	
	private LocalDateTime timestamp;
	
	private int code;
	
	private String msg;
	
	private T data = null;

	@Builder
	public RestResponse(int code, String msg, T data) {
		this.timestamp = LocalDateTime.now();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
}
