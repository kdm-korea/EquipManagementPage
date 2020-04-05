package com.services.webservice.microService.signInUp.controller;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.services.webservice.library.dto.RestResponse;
import com.services.webservice.microService.signInUp.dto.request.ReqMemberInfoModiifedDto;
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
	
	@PostMapping("/modifiedPw")
	public RestResponse<?> modifiedPw(@RequestBody ReqMemberInfoModiifedDto dto){
		if(memberService.modifiedPw(dto) == 1) {
			return RestResponse.builder()
					.code(1)
					.msg("완료되었습니다")
					.build();
		}else {
			return RestResponse.builder()
					.code(0)
					.msg("실패하였습니다")
					.build();
		}
	}
}
