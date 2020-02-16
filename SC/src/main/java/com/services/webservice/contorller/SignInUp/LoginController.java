package com.services.webservice.contorller.SignInUp;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class LoginController {

	@GetMapping("/")
	public String main() {
		return "index";
	}

//	@PostMapping("login")
//	public void login(HttpSession session) {
//		System.out.println("============================");
//		session.setAttribute("studentNum", "2019631001");
//	}
	
	@GetMapping("/logout")
	public String logout() {
		
		return "redirect:/";
	}
	
	// 접근 거부 페이지
	@GetMapping("/user/denied")
	public String dispDenied() {
		return "/denied";
	}

	// 어드민 페이지
	@GetMapping("/admin")
	public String dispAdmin() {
		return "/admin";
	}
}
