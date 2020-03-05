package com.services.webservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class ErrorController {

	@GetMapping("/denied")
	public String denied() {
		return "redirect:/";
	}
}
