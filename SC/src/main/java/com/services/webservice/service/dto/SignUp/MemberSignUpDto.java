package com.services.webservice.service.dto.SignUp;

import com.services.webservice.domain.Member.Member;
import com.services.webservice.domain.Member.Role;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberSignUpDto {
	
	private String studentNum;
	
	private String password;

	private String name;

	private String phoneNumber;
	
	private Role roleId;
	
	public Member toEntity() {
		return Member.builder()
				.studentNum(studentNum)
				.password(password)
				.name(name)
				.phoneNumber(phoneNumber)
				.roleId(roleId)
				.build();
	}
	
	@Builder
	public MemberSignUpDto(String studentNum, String password, String name, String phoneNumber,
			Role roleId) {
		this.studentNum = studentNum;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.roleId = roleId;
	}	
}
