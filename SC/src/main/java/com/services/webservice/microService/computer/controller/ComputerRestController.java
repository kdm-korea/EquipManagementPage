package com.services.webservice.microService.computer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.webservice.library.dto.RestResponse;
import com.services.webservice.microService.computer.dto.request.ReqComputerRentalDto;
import com.services.webservice.microService.computer.dto.request.ReqComputerReturnDto;
import com.services.webservice.microService.computer.service.ComputerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/member/computer")
public class ComputerRestController {

	@Autowired
	private ComputerService service;

	@PostMapping("/rent")
	public RestResponse<?> computerRent(@RequestBody @Valid ReqComputerRentalDto dto) throws Exception {
		if (service.pcRent(dto)) {
			return RestResponse.builder()
					.code(1)
					.msg("저장되었습니다.")
					.build();
		} 
		else {
			return RestResponse.builder()
					.code(0)
					.msg("이미 같은 종류의 기자재를 빌리고 있습니다.")
					.build();
		}
	}

	@PostMapping("return")
	public RestResponse<?> computerReturn(@RequestBody @Valid ReqComputerReturnDto dto) {
		if(service.pcReturn(dto)) {
			return RestResponse.builder()
					.code(1)
					.msg("저장되었습니다.")
					.build();
		}
		else {
			return RestResponse.builder()
					.code(0)
					.msg("빌린 물품이 없습니다.")
					.build();
		}
	}
}
