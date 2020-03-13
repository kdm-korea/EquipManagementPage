package com.services.webservice.service.dto.Member.Request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReqMemberForgetPwDto {
	private long id;
	
	private String phoneNumber;
	
	private String newPassword;

	@Builder
	public ReqMemberForgetPwDto(long id, String phoneNumber, String newPassword) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.newPassword = newPassword;
	}
}
