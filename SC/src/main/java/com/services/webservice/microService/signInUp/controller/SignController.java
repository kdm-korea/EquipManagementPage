package com.services.webservice.microService.signInUp.controller;

import java.security.Principal;

import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class SignController {

	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout() {
		//alert msg add
		return "redirect:/";
	}
	
	// 접근 거부 페이지
	@GetMapping("/user/denied")
	public String dispDenied() {
		return "/denied";
	}
	
	@GetMapping("/member/info")
	public String getMyPage() {
		return "/member/mypage";
	}
	
	@GetMapping("/login")
	public String Login() {
		return "redirect:/";
	}
}
