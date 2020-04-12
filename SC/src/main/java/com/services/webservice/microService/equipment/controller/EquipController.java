package com.services.webservice.microService.equipment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.services.webservice.microService.equipment.service.EquipService;
import com.services.webservice.security.MemberDetail;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/member/equip")
public class EquipController {

	@Autowired
	private EquipService equipService;
	
	@GetMapping()
	public String equipList(@AuthenticationPrincipal MemberDetail member, Model model) {
		model.addAttribute("rentalequiplist", equipService.rentalEquipList(member.getId()));
		model.addAttribute("equiplist", equipService.equipList());
		return "equipment/equip";
	}
}
