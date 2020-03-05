package com.services.webservice.service.dto.Equip.Request;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqEquipReturnDto {
	private String studentNum;
	
	private String equipNum;
	
	private LocalDateTime realReturnTime;

	@Builder
	public ReqEquipReturnDto(String studentNum, String equipNum, LocalDateTime realReturnTime) {
		super();
		this.studentNum = studentNum;
		this.equipNum = equipNum;
		this.realReturnTime = realReturnTime;
	}
}
