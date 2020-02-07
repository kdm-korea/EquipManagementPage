package com.services.webservice.service.dto;

import com.services.webservice.domain.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserStudentNumChkDto {
	private String studentNum;

	public User toEntity() {
		return User.builder().studentNum(studentNum).build();
	}
}
