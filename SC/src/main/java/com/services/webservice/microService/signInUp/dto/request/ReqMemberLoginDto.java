package com.services.webservice.microService.signInUp.dto.request;

import com.services.webservice.domain.Member.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReqMemberLoginDto {

	private String studentNum;
	
	private String password;

	@Builder
	public ReqMemberLoginDto(String studentNum, String password) {
		this.studentNum = studentNum;
		this.password = password;
	}
	
	public Member toEntity() {
		return Member.builder()
				.studentNum(studentNum)
				.password(password)
				.build();
	}

}
