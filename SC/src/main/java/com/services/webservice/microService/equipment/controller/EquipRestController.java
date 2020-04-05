package com.services.webservice.microService.equipment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.webservice.library.dto.RestResponse;
import com.services.webservice.microService.equipment.dto.request.ReqEquipRentalDto;
import com.services.webservice.microService.equipment.dto.request.ReqEquipReturnDto;
import com.services.webservice.microService.equipment.service.EquipService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/member/equip")
public class EquipRestController {

	@Autowired
	private EquipService service;
	
	@PostMapping("/rent")
	public RestResponse<?> equipRent(@RequestBody @Valid ReqEquipRentalDto dto) throws Exception {
		if(service.equipRent(dto)) {
			return RestResponse.builder()
				.code(1)
				.msg("저장되었습니다.")
				.build();
		}else {
			return RestResponse.builder()
				.code(0)
				.msg("이미 같은 종류의 기자재를 빌리고 있습니다.")
				.build();
		}
	}

	@PostMapping("/return")
	public RestResponse<?> equipRetrun(@RequestBody @Valid ReqEquipReturnDto dto) {
		if(service.equipReturn(dto)) {
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
