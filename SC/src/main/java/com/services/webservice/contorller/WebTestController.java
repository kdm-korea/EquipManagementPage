package com.services.webservice.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class WebTestController {

	@GetMapping("/")
	public String main() {
		return "index";
	}

	// 로그인 성공 페이지
	@GetMapping("/user/chooseEuqip")
	public String loginin() {
		return "chooseEquip";
	}

	// 접근 거부 페이지
	@GetMapping("/user/denied")
	public String dispDenied() {
		return "/denied";
	}

	// 내 정보 페이지
	@GetMapping("/user/info")
	public String dispMyInfo() {
		return "/myinfo";
	}

	// 어드민 페이지
	@GetMapping("/admin")
	public String dispAdmin() {
		return "/admin";
	}
}
