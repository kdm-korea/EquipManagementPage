package com.services.webservice.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.services.webservice.domain.ERole;
import com.services.webservice.domain.Role;
import com.services.webservice.domain.UserRepository;
import com.services.webservice.service.dto.UserLoginDto;
import com.services.webservice.service.dto.UserSignUpDto;

import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public ApiResponse signUp(UserSignUpDto userDto) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

		return new ApiResponse(200, "Sucess", userRepository.save(userDto.toEntity()).getId()) ;
	}

	@Override
	public UserDetails loadUserByUsername(String studentNum) throws UsernameNotFoundException {
		com.services.webservice.domain.User userEntity = userRepository.findByStudentNum(studentNum);

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		System.out.println(userEntity.getStudentNum());
		if ("2019631001".equals(userEntity.getStudentNum())) {
			authorities.add(new SimpleGrantedAuthority(ERole.ADMIN.getValue()));
		} else {
			authorities.add(new SimpleGrantedAuthority(ERole.MEMBER.getValue()));
		}

		return new User(userEntity.getStudentNum(), userEntity.getPassword(), authorities);
	}
}
