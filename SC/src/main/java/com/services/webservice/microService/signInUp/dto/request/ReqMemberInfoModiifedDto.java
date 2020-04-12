package com.services.webservice.microService.signInUp.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ReqMemberInfoModiifedDto {
	private long memberId;
	
	private String password;
	
	private String newPassword;

	@Builder
	public ReqMemberInfoModiifedDto(long memberId, String password, String newPassword) {
		super();
		this.memberId = memberId;
		this.password = password;
		this.newPassword = newPassword;
	}
}
