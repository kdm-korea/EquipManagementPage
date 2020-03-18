package com.services.webservice.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.services.webservice.domain.ERole;
import com.services.webservice.domain.Member.Member;
import com.services.webservice.domain.Member.MemberRepository;
import com.services.webservice.domain.Member.RoleRepository;
import com.services.webservice.service.dto.Member.Request.ReqMemberForgetPwDto;
import com.services.webservice.service.dto.Member.Request.ReqMemberInfoModiifedDto;
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
		userDto.setRoleId(roleRepo.findByRole(ERole.MEMBER.getValue()));
		return createMember(userDto);
	}

	@Transactional
	public void modifiedPw(ReqMemberInfoModiifedDto dto) {
		Member member = memberRepo.getOne(dto.getId());
		
		if(member.getPassword() == passwordEncoder.encode(dto.getPassword())) {
			memberRepo.updatePw(passwordEncoder.encode(dto.getNewPassword()), dto.getId());
		}
	}
	
	@Transactional
	public void forgetPw(ReqMemberForgetPwDto dto) {
		Member member = memberRepo.getOne(dto.getId());
		
		if(member.getPhoneNumber() == dto.getPhoneNumber()) {
			memberRepo.updatePw(passwordEncoder.encode(dto.getNewPassword()), dto.getId());
		}
	}
	
	public boolean studentNumChk(MemberStudentNumChkDto dto) {
		try {
			return null != memberRepo.findByStudentNum(dto.getStudentNum()) ? false : true;
		} catch (NullPointerException e) {
			return true;
		}
	}

	@Transactional
	private String createMember(MemberSignUpDto userDto) {
		return memberRepo.save(userDto.toEntity()).getStudentNum();
	}
	
	
}
