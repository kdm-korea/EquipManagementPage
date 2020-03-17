package com.services.webservice.controller.Member;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.services.webservice.service.BoardService.BoardService;
import com.services.webservice.service.dto.Board.Request.ReqPostDetailDto;
import com.services.webservice.service.dto.Board.Request.ReqSavePostDto;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("member/board")
public class BoardController {

	@Autowired
	private BoardService service;

//	public void Test() {
//		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.
//	}
	
	@GetMapping("/list")
	public String postList(Model model) {
		service.list();
		return "";
	}
	
	@GetMapping("/post/{no}")
	public String detail(@PathVariable("no")long no, Model model) {
		service.detail(no);
		return "";
	}

	@PostMapping("/post/create")
	public String create(ReqSavePostDto dto) {
		service.save(dto);
		return "";
	}
	
	@PostMapping("/post/edit/{no}")
	public String update(ReqPostDetailDto dto) {
		service.update(dto);
		return "";
	}
	
	@PostMapping("/post/delete/{no}")
	public String delete(@PathVariable("no")long no) {
		service.delete(no);
		return "";
	}
}
