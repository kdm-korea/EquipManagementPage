package com.services.webservice.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.services.webservice.domain.ERole;
import com.services.webservice.domain.Member.MemberRepository;
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

	@Autowired
	private PasswordEncoder passwordEncoder;

	public String signUp(MemberSignUpDto userDto) {
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		userDto.setRoleId(roleRepository.findByRole(ERole.MEMBER.getValue()));
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
	private String createMember(MemberSignUpDto userDto) {
		return memberRepository.save(userDto.toEntity()).getStudentNum();
	}
}
