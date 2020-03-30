package com.services.webservice.library.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RestResponseBaseDto<T> {
	
	private LocalDateTime timestamp;
	
	private boolean result;
	
	private String msg;
	
	private T data;

	@Builder
	public RestResponseBaseDto(boolean result, String msg, T data) {
		this.timestamp = LocalDateTime.now();
		this.result = result;
		this.msg = msg;
		this.data = data;
	}
}
