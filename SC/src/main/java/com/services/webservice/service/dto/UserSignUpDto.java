package com.services.webservice.service.dto;

import com.services.webservice.domain.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSignUpDto {

	private Long id;
	
	private String studentNum;
	
	private String password;

	private String name;

	private String phoneNumber;
	
	public User toEntity() {
		return User.builder()
				.id(id)
				.studentNum(studentNum)
				.password(password)
				.name(name)
				.phoneNumber(phoneNumber)
				.build();
	}

	@Builder
	public UserSignUpDto(Long id, String studentNum, String password, String name, String phoneNumber) {
		this.id = id;
		this.studentNum = studentNum;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}	
}
