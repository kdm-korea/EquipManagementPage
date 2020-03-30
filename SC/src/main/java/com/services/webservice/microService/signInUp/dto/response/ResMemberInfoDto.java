package com.services.webservice.microService.signInUp.dto.response;

import com.services.webservice.domain.Member.Member;

import lombok.Getter;

@Getter
public class ResMemberInfoDto {

	private long memberid;
	
	private String studentNum;
	
	private String name;
	
	private String phoneNumber;
	
	public ResMemberInfoDto(Member member) {
		this.memberid = member.getId();
		this.studentNum = member.getStudentNum();
		this.name = member.getName();
		this.phoneNumber = member.getPhoneNumber();
	}
}
