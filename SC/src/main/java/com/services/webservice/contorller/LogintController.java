package com.services.webservice.contorller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.services.webservice.service.dto.SignIn.MemberLoginDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class LogintController {

	@GetMapping("/")
	public String main() {
		return "index";
	}

	@PostMapping("/login")
	public String login(MemberLoginDto dto) {
		System.out.println();
		System.out.println("public String login() { :::::");
		System.out.println();
		return "login";
	}

	@GetMapping("/logout")
	public String logout() {
		
		return "redirect:/";
	}
	
	@GetMapping("/member")
	public String loginin() {
		return "member";
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
