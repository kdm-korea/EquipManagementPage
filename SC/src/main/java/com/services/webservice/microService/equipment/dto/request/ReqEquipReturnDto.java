package com.services.webservice.microService.equipment.dto.request;

import java.time.LocalDateTime;

import com.services.webservice.library.dto.TimeFormatter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqEquipReturnDto extends TimeFormatter {
	
	private long memberId;
	
	private long equipId;
	
	private LocalDateTime realReturnTime;

	@Builder
	public ReqEquipReturnDto(long memberId, long equipId, String realReturnTime) {
		super();
		this.memberId = memberId;
		this.equipId = equipId;
		this.realReturnTime = LocalDateTime.parse(realReturnTime, formatter);
	}
		
	public void setRealReturnTime(String realReturnTime) {
		this.realReturnTime = LocalDateTime.parse(realReturnTime, formatter);
	}
}
