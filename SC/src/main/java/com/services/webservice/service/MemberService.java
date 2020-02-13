package com.services.webservice.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.services.webservice.domain.ERole;
import com.services.webservice.domain.Member.MemberRepository;
import com.services.webservice.domain.Member.Role;
import com.services.webservice.domain.Member.RoleRepository;
import com.services.webservice.service.dto.SignUp.MemberSignUpDto;
import com.services.webservice.service.dto.SignUp.UserStudentNumChkDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	public Long signUp(MemberSignUpDto userDto) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Role userRole = roleRepository.findByRole(ERole.MEMBER.getValue());
		userDto.setRoleId(userRole);

		return createMember(userDto);
	}

	public boolean studentNumChk(UserStudentNumChkDto dto) {
		try {
			return null != memberRepository.findByStudentNum(dto.getStudentNum()) ? false : true;
		} catch (NullPointerException e) {
			return true;
		}
	}

	@Transactional
	private Long createMember(MemberSignUpDto userDto) {
		return memberRepository.save(userDto.toEntity()).getId();
	}
}
