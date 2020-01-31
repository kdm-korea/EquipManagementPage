package com.services.webservice.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.services.webservice.domain.User;
import com.services.webservice.domain.UserRepository;
import com.services.webservice.service.dto.UserLoginDto;
import com.services.webservice.service.dto.UserSignUpDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
	
	private UserRepository userRepository;
	
	@Transactional()
	public ApiResponse login(UserLoginDto dto) {
		//TODO: ����ó��
		return new ApiResponse(200, "Success", userRepository.findByStudentNum(dto.toEntity().getStudentNum())); 
	}
	
	@Transactional
	public ApiResponse signUp(UserSignUpDto dto) {
		//TODO: ����ó��
		return new ApiResponse(200, "SignUp Success", userRepository.save(dto.toEntity()));
	}
}
