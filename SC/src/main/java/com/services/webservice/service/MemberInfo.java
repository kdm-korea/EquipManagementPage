package com.services.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.services.webservice.domain.Member.MemberRepository;
import com.services.webservice.service.dto.MemberInfo.ResMemberInfoDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MemberInfo {

	@Autowired
	private MemberRepository memberRepo;
	
	public ResMemberInfoDto findByMemeberInfo() throws NullPointerException {
		String studentNum = ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		return new ResMemberInfoDto(memberRepo.findByStudentNum(studentNum));
	}
}
