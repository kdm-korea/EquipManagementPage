package com.services.webservice.service.dto.Equip.Request;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;

import com.services.webservice.library.TimeFormatter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqEquipReturnDto extends TimeFormatter{
	
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
