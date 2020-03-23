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
	public String signUp(MemberSignUpDto dto) {
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		dto.setRoleId(roleRepo.findByRole(ERole.MEMBER.getValue()));
		return createMember(dto);
	}

	@Transactional
	public void modifiedPw(ReqMemberInfoModiifedDto dto) {
		if (passwordEncoder.matches(dto.getPassword(), memberRepo.getOne(dto.getId()).getPassword())) {
			memberRepo.updatePw(passwordEncoder.encode(dto.getNewPassword()), dto.getId());
		}else {
			
		}
	}

	@Transactional
	public void forgetPw(ReqMemberForgetPwDto dto) {
		if (memberRepo.getOne(dto.getId()).getPhoneNumber() == dto.getPhoneNumber()) {
			memberRepo.updatePw(passwordEncoder.encode(dto.getNewPassword()), dto.getId());
		}
	}

	public boolean studentNumChk(MemberStudentNumChkDto dto) {
		return (memberRepo.countByStudentNum(dto.getStudentNum()) == 0) ? true : false;
	}

	@Transactional
	private String createMember(MemberSignUpDto userDto) {
		return memberRepo.save(userDto.toEntity()).getStudentNum();
	}

}
