package com.services.webservice.microService.signInUp.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ReqSignInDto {
	private String studentNum;
	
	private String password;

	@Builder
	public ReqSignInDto(String studentNum, String password) {
		super();
		this.studentNum = studentNum;
		this.password = password;
	}
}
