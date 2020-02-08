package com.services.webservice.contorller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.services.webservice.lib.ApiResponse;
import com.services.webservice.service.MemberService;
import com.services.webservice.service.dto.SignUp.MemberSignUpDto;
import com.services.webservice.service.dto.SignUp.UserStudentNumChkDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class SignRestController {

	private MemberService memberService;

	@PostMapping("/signup")
	public ApiResponse<Long> signUp(@RequestBody MemberSignUpDto signUpDto) {
		if (memberService.signUp(signUpDto) == null) {
			return new ApiResponse(200, "Fail", null);
		}
		return new ApiResponse(200, "Sucess", signUpDto.getStudentNum());
	}

	@PostMapping("/idChk")
	public ApiResponse<Long> studentNumChk(@RequestBody UserStudentNumChkDto dto) {
//		dto.getStudentNum().isEmpty()
		// long studentNum = userService.studentNumChk(dto);

		return memberService.studentNumChk(dto);
	}
}
