package com.services.webservice.microService.signInUp.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReqMemberInfoModiifedDto {
	private long id;
	
	private String password;
	
	private String newPassword;

	@Builder
	public ReqMemberInfoModiifedDto(long id, String password, String newPassword) {
		super();
		this.id = id;
		this.password = password;
		this.newPassword = newPassword;
	}
}
