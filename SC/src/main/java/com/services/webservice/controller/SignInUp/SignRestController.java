package com.services.webservice.controller.SignInUp;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.services.webservice.library.ApiResponse;
import com.services.webservice.service.MemberService.SignInUpService.MemberService;
import com.services.webservice.service.dto.SignUp.MemberSignUpDto;
import com.services.webservice.service.dto.SignUp.UserStudentNumChkDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class SignRestController {

	private MemberService memberService;

	@PostMapping("/signup")
	public ApiResponse<String> signUp(@RequestBody MemberSignUpDto signUpDto) {
		if (ObjectUtils.isEmpty(signUpDto)) {
			return new ApiResponse<String>(200, "Fail", "");
		}
		return new ApiResponse<String>(200, "Sucess", memberService.signUp(signUpDto));
	}

	@PostMapping("/idChk")
	public ApiResponse<String> studentNumChk(@RequestBody UserStudentNumChkDto dto) {
		if(memberService.studentNumChk(dto)) {
			return new ApiResponse<String>(200, "Success", dto.getStudentNum());
		}
		return new ApiResponse<String>(300, "Fail", "");
	}
}
