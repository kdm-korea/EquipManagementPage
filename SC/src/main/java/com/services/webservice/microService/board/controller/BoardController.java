package com.services.webservice.microService.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.services.webservice.microService.board.dto.response.ResBoardDetailDto;
import com.services.webservice.microService.board.service.BoardService;
import com.services.webservice.security.MemberDetail;

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
	
	@GetMapping("/post")
	public String postPage(Model model) {
		return "board/post";
	}
	
	@GetMapping("/post/{no}")
	public String detail(@AuthenticationPrincipal MemberDetail member, @PathVariable("no")long no, Model model) {
		model.addAttribute("detail", service.detail(member.getUsername(), no));
		return "board/view";
	}
	
	@GetMapping("/modified/{no}")
	public String updateView(@AuthenticationPrincipal MemberDetail member, @PathVariable("no")long no, Model model) {
		model.addAttribute("detail", service.detail(member.getUsername(), no));
		return "board/update";
	}
}
