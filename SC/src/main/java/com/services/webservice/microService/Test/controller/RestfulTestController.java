package com.services.webservice.microService.Test.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.webservice.exception.ExceptionClass.CustomNoArgsException;
import com.services.webservice.microService.Test.service.MemberInfo;
import com.services.webservice.microService.board.dto.request.ReqPostDetailDto;
import com.services.webservice.microService.board.dto.request.ReqSavePostDto;
import com.services.webservice.microService.board.dto.response.ResBoardDetailDto;
import com.services.webservice.microService.board.dto.response.ResBoardListDto;
import com.services.webservice.microService.board.service.BoardService;
import com.services.webservice.microService.equipment.dto.response.ResRentalEquipListDto;
import com.services.webservice.microService.equipment.service.EquipService;
import com.services.webservice.microService.signInUp.service.MemberService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/test")
public class RestfulTestController {
	@Autowired
	private BoardService service;
	
	@Autowired
	private EquipService equipService;
	
	@GetMapping()
	public List<ResBoardListDto> postList() {
		return service.list();
	}

	@GetMapping("/post/{no}")
	public ResBoardDetailDto detail(@PathVariable("no") long no) {
		return service.detail(no);
	}

	@PostMapping("/post")
	public String create(@RequestBody ReqSavePostDto dto) {
		System.out.println(dto.getMemberId());
		System.out.println(dto.getTitle());
		System.out.println(dto.getContents());
		service.save(dto);
		return "";
	}

	@PutMapping("/post/{no}")
	public String update(@PathVariable("no") long no, ReqPostDetailDto dto) {
		service.update(dto);
		return "redirect:/post/" + no;
	}

	@DeleteMapping("/post/{no}")
	public String delete(@PathVariable("no") long no) throws Exception {
		if(no < 1) {
			throw new CustomNoArgsException("없는 번호입니다.");
		}
		service.delete(no);
		return "";
	}
	
	@GetMapping("equip")
	public List<ResRentalEquipListDto> test() {
		return equipService.rentalEquipList("2019631002");
	}
}
