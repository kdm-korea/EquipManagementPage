package com.services.webservice.lib;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ErrorDetail {
	private String field;
	
	private String value;
	
	private String reason;
}
