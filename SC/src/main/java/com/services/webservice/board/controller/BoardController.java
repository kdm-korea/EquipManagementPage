package com.services.webservice.controller.Member;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.services.webservice.service.BoardService.BoardService;
import com.services.webservice.service.dto.Board.Request.ReqPostDetailDto;
import com.services.webservice.service.dto.Board.Request.ReqSavePostDto;
import com.services.webservice.service.dto.Board.Response.ResBoardDetailDto;
import com.services.webservice.service.dto.Board.Response.ResBoardListDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("member/boards")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping()
	public List<ResBoardListDto> postList() {
		return service.list();
	}
	
	@GetMapping("/post/{no}")
	public ResBoardDetailDto detail(@PathVariable("no")long no, Model model) {
		return service.detail(no);
	}

	@PostMapping("/post")
	public Long create(ReqSavePostDto dto) {
		return service.save(dto);
	}
	
	@PutMapping("/post/{no}")
	public Long update(ReqPostDetailDto dto) {
		return service.update(dto);
	}
	
	@DeleteMapping("/post/{no}")
	public Long delete(@PathVariable("no")long no) throws Exception {
		service.delete(no);
		return no;
	}
}
