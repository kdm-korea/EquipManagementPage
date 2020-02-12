package com.services.webservice.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.services.webservice.lib.ApiResponse;
import com.services.webservice.service.dto.SignUp.MemberSignUpDto;
import com.services.webservice.service.dto.SignUp.UserStudentNumChkDto;
import com.services.webservice.domain.ERole;
import com.services.webservice.domain.Member.Member;
import com.services.webservice.domain.Member.MemberRepository;
import com.services.webservice.domain.Member.Role;
import com.services.webservice.domain.Member.RoleRepository;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MemberService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private RoleRepository roleRepository;

	public Long signUp(MemberSignUpDto userDto) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Role userRole = roleRepository.findByRole(ERole.MEMBER.getValue());
		userDto.setRoleId(userRole);

		return createMember(userDto);
	}

	@Override
	public UserDetails loadUserByUsername(String studentNum) throws UsernameNotFoundException {
		Member memberEntity;
		List<GrantedAuthority> authorities;

		try {
			memberEntity = memberRepository.findByStudentNum(studentNum);
			authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(memberEntity.getRoleId().getRole()));
		} catch (Exception e) {
			throw new UsernameNotFoundException(studentNum);
		}
		return new User(memberEntity.getStudentNum(), memberEntity.getPassword(), authorities);
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