package com.services.webservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EState {
	ACTIVATE("ACTIVATE"),
	USE("USE"),
	FIX("FIX"),
	DISABLE("DISABLE");
	
	private String value;
}
