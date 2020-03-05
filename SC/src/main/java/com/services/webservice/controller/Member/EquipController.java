package com.services.webservice.controller.Member;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.services.webservice.domain.Member.Member;
import com.services.webservice.service.MemberService.MemberInfo;
import com.services.webservice.service.MemberService.EquipService.MemberEquipService;
import com.services.webservice.service.dto.Equip.Request.ReqChkAlreadyHaveEqiupDto;
import com.services.webservice.service.dto.Equip.Request.ReqEquipRentalDto;
import com.services.webservice.service.dto.Equip.Request.ReqEquipReturnDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/member/equip")
public class EquipController {

	@Autowired
	private MemberEquipService memberEquipService;
	
	@Autowired
	private MemberInfo memberInfo;
	
	@PostMapping("/rent")
	public String memberEquipRent(HttpSession session, ReqEquipRentalDto dto) {
		if(session != null) {
			memberEquipService.saveEquipRentalLog(dto);
		}
		return "";
	}

	@PostMapping("/return")
	public String memberEquipRetrun(HttpSession session, ReqEquipReturnDto dto) {
		if (session != null) {
			memberEquipService.saveEquipReturnLog(dto);
		}
		return "";
	}
	
	@GetMapping("/chkAlreadyHaveEquip")
	public String chkAlreadyHaveEquip(Principal principal, ReqChkAlreadyHaveEqiupDto dto, Model model) {
		System.out.println(memberInfo.findByMemeberInfo().getStudentNum()); 
		return "";
	}
	
}
