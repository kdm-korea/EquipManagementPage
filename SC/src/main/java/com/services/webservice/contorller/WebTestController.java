package com.services.webservice.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class WebTestController {
	
	@GetMapping("/")
	public String main() {
		return "index";
	}
}
