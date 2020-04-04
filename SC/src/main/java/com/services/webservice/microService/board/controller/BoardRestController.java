package com.services.webservice.microService.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.services.webservice.library.dto.RestResponse;
import com.services.webservice.microService.board.dto.request.ReqPostDetailDto;
import com.services.webservice.microService.board.dto.request.ReqSavePostDto;
import com.services.webservice.microService.board.dto.response.ResBoardDetailDto;
import com.services.webservice.microService.board.dto.response.ResBoardListDto;
import com.services.webservice.microService.board.service.BoardService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("member/board")
public class BoardRestController {

	@Autowired
	private BoardService service;

	@PostMapping("/post")
	public Long create(@RequestBody @Valid ReqSavePostDto dto) {
		return service.save(dto);
	}
	
	@PutMapping("/post/{no}")
	public Long update(@RequestBody ReqPostDetailDto dto) {
		return service.update(dto);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/post/{no}")
	public void delete(@PathVariable("no")long no) throws Exception {
		service.delete(no);
	}
}
