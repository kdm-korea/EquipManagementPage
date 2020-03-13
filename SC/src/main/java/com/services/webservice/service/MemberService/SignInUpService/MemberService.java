package com.services.webservice.service.MemberService.SignInUpService;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.services.webservice.domain.ERole;
import com.services.webservice.domain.Member.Member;
import com.services.webservice.domain.Member.MemberRepository;
import com.services.webservice.domain.Member.RoleRepository;
import com.services.webservice.service.dto.Member.MemberForgetPwDto;
import com.services.webservice.service.dto.Member.MemberInfoModiifedDto;
import com.services.webservice.service.dto.SignUp.MemberSignUpDto;
import com.services.webservice.service.dto.SignUp.MemberStudentNumChkDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService {

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private MemberRepository memberRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	public String signUp(MemberSignUpDto userDto) {
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		userDto.setRoleId(roleRepository.findByRole(ERole.MEMBER.getValue()));
		return createMember(userDto);
	}

	@Transactional
	public void modifiedPw(MemberInfoModiifedDto dto) {
		Member member = memberRepo.getOne(dto.getId());
		
		if(member.getPassword() == passwordEncoder.encode(dto.getPassword())) {
			memberRepo.updatePw(passwordEncoder.encode(dto.getNewPassword()), dto.getId());
		}
	}
	
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
