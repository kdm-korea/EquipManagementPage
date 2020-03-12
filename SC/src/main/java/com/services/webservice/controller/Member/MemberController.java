package com.services.webservice.controller.Member;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.services.webservice.service.MemberService.MemberInfo;
import com.services.webservice.service.MemberService.EquipService.EquipService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/memeber")
public class MemberController {

	private EquipService memberEquipService;

	private MemberInfo memberInfo;
		
	@GetMapping("/mypage")
	public String mypage() {
		return "Member/memberMypage";
	}

	@GetMapping("/board")
	public String boardQA() {
		return "Member/memberQABoard";
	}

	@GetMapping("/computerRent")
	public String memberComputer(Model model) {

		return "";
	}

	@GetMapping("/QABoard")
	public String memberQABoard(Model model) {
		return "";
	}
}
