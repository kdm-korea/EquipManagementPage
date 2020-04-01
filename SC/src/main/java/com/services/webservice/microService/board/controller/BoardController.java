package com.services.webservice.microService.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.services.webservice.microService.board.service.BoardService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("member/board")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping()
	public String postList(Model model) {
		model.addAttribute("postList", service.list());
		return "board/board";
	}
}
