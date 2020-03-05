package com.services.webservice.service.dto.SignIn;

import com.services.webservice.domain.Member.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberLoginDto {

	private String studentNum;
	
	private String password;

	@Builder
	public MemberLoginDto(String studentNum, String password) {
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
