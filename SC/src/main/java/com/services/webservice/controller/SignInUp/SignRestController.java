package com.services.webservice.controller.SignInUp;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.services.webservice.service.MemberService.MemberService;
import com.services.webservice.service.dto.SignUp.MemberSignUpDto;
import com.services.webservice.service.dto.SignUp.MemberStudentNumChkDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(produces = "application/json")
public class SignRestController {

	private MemberService memberService;

	@PostMapping("/signup")
	public String signUp(@RequestBody MemberSignUpDto signUpDto) {
		if (ObjectUtils.isEmpty(signUpDto)) {
			//throws Exception
		}
		return memberService.signUp(signUpDto);
	}

	@GetMapping("/idcheck")
	public boolean studentNumChk(@RequestBody MemberStudentNumChkDto dto) {
		System.out.println(dto.getStudentNum());
		if(dto.getStudentNum() == null) {
			//throws Exception
		}
		return memberService.studentNumChk(dto);
	}
}
