package com.services.webservice.service.MemberService.SignInUpService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.webservice.Security.SecurityMember;
import com.services.webservice.domain.Member.Member;
import com.services.webservice.domain.Member.MemberRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String studentNum) throws UsernameNotFoundException {
		try {
			Member memberEntity = memberRepository.findByStudentNum(studentNum);
			if (memberEntity != null) {
				return new SecurityMember(memberEntity);
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
