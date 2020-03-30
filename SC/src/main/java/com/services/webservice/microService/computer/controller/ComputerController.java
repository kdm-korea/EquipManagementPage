package com.services.webservice.microService.computer.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.services.webservice.microService.computer.dto.request.ReqComputerRentalDto;
import com.services.webservice.microService.computer.dto.request.ReqComputerReturnDto;
import com.services.webservice.microService.computer.dto.response.ResComputerListDto;
import com.services.webservice.microService.computer.service.ComputerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/member/computer")
public class ComputerController {
	
	@Autowired
	private ComputerService service; 
	
	@GetMapping("/list")
	public List<ResComputerListDto> computer(HttpSession session) {
		if(session != null) {
			
		}else {
//			return "redirect:/";
		}
		return service.pcList();
	}

	@PostMapping("/rent")
	public String computerRent(HttpSession session, ReqComputerRentalDto dto) {
		if(session != null) {
			service.pcRent(dto);
		}
		return "";
	}
	
	@PostMapping("return")
	public String computerReturn(HttpSession session, ReqComputerReturnDto dto) {
		if(session != null) {
			service.pcReturn(dto);
		}
		return "";
	}
}
