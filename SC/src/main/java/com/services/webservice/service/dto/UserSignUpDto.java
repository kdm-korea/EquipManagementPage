package com.services.webservice.service.dto;

import javax.persistence.Column;

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
	
	private Long studentNum;

	private String name;

	private String phoneNumber;
	
	public User toEntity() {
		return User.builder()
				.id(id)
				.studentNum(studentNum)
				.name(name)
				.phoneNumber(phoneNumber)
				.build();
	}

	@Builder
	public UserSignUpDto(Long id, Long studentNum, String name, String phoneNumber) {
		super();
		this.id = id;
		this.studentNum = studentNum;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	
}
