package com.services.webservice.controller.Member.Equipment;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.services.webservice.service.MemberService.MemberInfo;
import com.services.webservice.service.MemberService.EquipService.MemberEquipService;
import com.services.webservice.service.dto.Equip.Request.ReqEquipRentalDto;
import com.services.webservice.service.dto.Equip.Request.ReqEquipReturnDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@RequestMapping("/member/equip")
public class EquipController {

	private MemberEquipService memberEquipService;

	@PostMapping("/rent")
	public String memberEquipRent(HttpSession session, ReqEquipRentalDto dto, Model model) {
		if(session != null) {
			memberEquipService.executeEquipRental(dto);
		}
		return "";
	}

	@PostMapping("/return")
	public String memberEquipRetrun(HttpSession session, ReqEquipReturnDto dto, Model model) {
		if (session != null) {
			memberEquipService.executeEquipReturn(dto);
		}
		return "";
	}
}
