package com.services.webservice.controller.Member;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.services.webservice.service.MemberService.MemberInfo;
import com.services.webservice.service.EquipService.EquipService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/memeber")
public class MemberController {

	private EquipService memberEquipService;

	private MemberInfo memberInfo;
		
	@GetMapping("/mypage/view")
	public String mypage() {
		//have Info
		return "Member/memberMypage";
	}
}
