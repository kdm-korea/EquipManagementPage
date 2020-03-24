package com.services.webservice.service.dto.SignUp;

import com.services.webservice.domain.Member.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberStudentNumChkDto {
	private String studentNum;

	public Member toEntity() {
		return Member.builder()
				.studentNum(studentNum)
				.build();
	}

	@Builder
	public MemberStudentNumChkDto(String studentNum) {
		this.studentNum = studentNum;
	}
}
