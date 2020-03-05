package com.services.webservice.controller.Member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("member/board")
public class BoardController {

	@GetMapping("")
	public String postList(Model model) {
		
		return "";
	}
}
