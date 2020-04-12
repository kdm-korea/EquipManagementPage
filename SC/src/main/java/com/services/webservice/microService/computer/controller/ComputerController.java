package com.services.webservice.microService.computer.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.services.webservice.microService.computer.dto.request.ReqComputerRentalDto;
import com.services.webservice.microService.computer.dto.request.ReqComputerReturnDto;
import com.services.webservice.microService.computer.dto.response.ResComputerListDto;
import com.services.webservice.microService.computer.service.ComputerService;
import com.services.webservice.security.MemberDetail;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/member/computer")
public class ComputerController {

	@Autowired
	private ComputerService service;

	@GetMapping()
	public String computer(@AuthenticationPrincipal MemberDetail member, Model model) {
		
		if(member != null) {
			model.addAttribute("pcList", service.pcList());
			model.addAttribute("pcRentalList", service.rentalPcList(member.getId()));
		}
		return "computer/pc";
	}
}
