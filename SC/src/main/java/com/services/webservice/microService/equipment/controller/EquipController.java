package com.services.webservice.microService.equipment.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.services.webservice.microService.equipment.service.EquipService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/member/equip")
public class EquipController {

	@Autowired
	private EquipService equipService;
	
	@GetMapping()
	public String equipList(Principal principal, Model model) {
		if (principal != null) {
			model.addAttribute("rentalequiplist", equipService.rentalEquipList(principal.getName()));
			model.addAttribute("equiplist", equipService.equipList());
		} else {
			return "redirect:/";
		}
		return "member/equip";
	}
}
