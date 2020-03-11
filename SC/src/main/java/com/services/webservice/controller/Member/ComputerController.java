package com.services.webservice.controller.Member;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/member/computer")
public class ComputerController {
	
	@GetMapping("/list")
	public String computer(HttpSession session, Model model) {
		return "Member/memberComputer";
	}

	@PostMapping("/rent")
	public String computerRent(HttpSession session) {
		return "";
	}
	
	@PostMapping("return")
	public String computerReturn(HttpSession session) {
		return "";
	}
	
	@GetMapping("/chkAlreadyHaveComputer")
	public String chkAlreadyHaveComputer(Principal principal, Model model) {
		return "";
	}
	
}
