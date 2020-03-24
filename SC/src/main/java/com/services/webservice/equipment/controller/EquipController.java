package com.services.webservice.controller.Member;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.services.webservice.service.MemberService.MemberInfo;
import com.services.webservice.service.EquipService.EquipService;
import com.services.webservice.service.dto.Equip.Request.ReqEquipRentalDto;
import com.services.webservice.service.dto.Equip.Request.ReqEquipReturnDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/member/equip")
public class EquipController {

	@Autowired
	private EquipService equipService;
	
	@Autowired
	private MemberInfo memberInfo;
	
	@GetMapping("/list")
	public String equipList(HttpSession session, Principal principal, Model model) {
		if (principal != null) {
			model.addAttribute("memberInfo", memberInfo.findByMemeberInfo());
			model.addAttribute("equiplist", equipService.equipList());
		} else {
			return "redirect:/";
		}
		return "Member/memberEquip";
	}
	
	@PostMapping("/rent")
	public String equipRent(HttpSession session, ReqEquipRentalDto dto) {
		if(session != null) {
			equipService.equipRent(dto);
		}
		return "";
	}

	@PostMapping("/return")
	public String equipRetrun(HttpSession session, ReqEquipReturnDto dto) {
		if (session != null) {
			equipService.equipReturn(dto);
		}
		return "";
	}
}
