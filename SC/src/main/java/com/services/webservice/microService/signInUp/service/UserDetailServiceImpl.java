package com.services.webservice.microService.signInUp.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.webservice.domain.Member.Member;
import com.services.webservice.domain.Member.MemberRepository;
import com.services.webservice.security.MemberDetail;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String studentNum) throws UsernameNotFoundException {
			Member memberEntity = memberRepository.findByStudentNum(studentNum);
			if(memberEntity == null) {
				throw new UsernameNotFoundException(studentNum);
			}
			return new MemberDetail(memberEntity);
	}
}
