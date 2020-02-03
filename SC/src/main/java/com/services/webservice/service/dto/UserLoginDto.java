package com.services.webservice.service.dto;

import com.services.webservice.domain.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginDto {

	private String studentNum;
	
	private String password;

	@Builder
	public UserLoginDto(String studentNum, String password) {
		this.studentNum = studentNum;
		this.password = password;
	}
	
	public User toEntity() {
		return User.builder()
				.studentNum(studentNum)
				.password(password)
				.build();
	}

}
