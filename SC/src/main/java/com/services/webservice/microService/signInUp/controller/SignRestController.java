package com.services.webservice.microService.signInUp.controller;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.services.webservice.microService.signInUp.dto.request.ReqMemberSignUpDto;
import com.services.webservice.microService.signInUp.service.MemberService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(produces = "application/json")
public class SignRestController {

	private MemberService memberService;

	@PostMapping("/signup")
	public String signUp(@RequestBody ReqMemberSignUpDto signUpDto) {
		if (ObjectUtils.isEmpty(signUpDto)) {
			//throws Exception
		}
		return memberService.signUp(signUpDto);
	}

	@GetMapping("/idcheck")
	public boolean studentNumChk(@RequestParam("studentNum")String studentNum) {
		System.out.println(studentNum);
		if(studentNum == null) {
//			throws Exception
		}
		return memberService.studentNumChk(studentNum);
	}
}
