package com.services.webservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ERole {
	ADMIN("ADMIN"),
	MEMBER("MEMBER");
	
	private String value;
}
