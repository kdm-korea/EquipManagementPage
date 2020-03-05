package com.services.webservice.service.dto.MemberInfo;

import com.services.webservice.domain.Member.Member;

import lombok.Getter;

@Getter
public class ResMemberInfoDto {

	private String studentNum;
	
	private String name;
	
	private String phoneNumber;
	
	public ResMemberInfoDto(Member member) {
		this.studentNum = member.getStudentNum();
		this.name = member.getName();
		this.phoneNumber = member.getPhoneNumber();
	}
}
