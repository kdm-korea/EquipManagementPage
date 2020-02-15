package com.services.webservice.contorller.Member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.services.webservice.service.EquipmentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/memeber")
public class MemberController {

	private EquipmentService euqipService;

	@GetMapping("/mypage")
	public String memberMypage(Model model) {
		model.addAttribute("equiplist", euqipService.getEuqipList());
		return "memberMypage";
	}

	@GetMapping("/equip")
	public String memberEquip(Model model) {
		return "memberEquip";
	}
}
