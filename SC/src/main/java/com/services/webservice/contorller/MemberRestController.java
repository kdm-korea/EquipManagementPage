package com.services.webservice.contorller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/memeber")
public class MemberRestController {

	@GetMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
	
}
