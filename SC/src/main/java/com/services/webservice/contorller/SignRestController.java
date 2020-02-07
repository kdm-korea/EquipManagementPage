package com.services.webservice.contorller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.services.webservice.service.ApiResponse;
import com.services.webservice.service.UserService;
import com.services.webservice.service.dto.UserSignUpDto;
import com.services.webservice.service.dto.UserStudentNumChkDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class SignRestController {

	private UserService userService;

	@PostMapping("/signup")
	@ResponseBody
	public ApiResponse signUp(@RequestBody UserSignUpDto signUpDto) {
		return userService.signUp(signUpDto);
	}

	@PostMapping("/idChk")
	@ResponseBody
	public ApiResponse studentNumChk(@RequestBody UserStudentNumChkDto dto) {
		System.out.println(dto.getStudentNum());
		return userService.studentNumChk(dto);
	}
}
