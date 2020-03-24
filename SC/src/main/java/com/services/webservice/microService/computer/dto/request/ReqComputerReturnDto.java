package com.services.webservice.service.dto.Computer.Request;

import java.time.LocalDateTime;

import com.services.webservice.library.TimeFormatter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqComputerReturnDto extends TimeFormatter {
	private long memberId;

	private long pcId;

	private LocalDateTime realReturnTime;

	@Builder
	public ReqComputerReturnDto(long memberId, long pcId, LocalDateTime realReturnTime) {
		super();
		this.memberId = memberId;
		this.pcId = pcId;
		this.realReturnTime = realReturnTime;
	}

	public void setRealReturnTime(String realReturnTime) {
		this.realReturnTime = LocalDateTime.parse(realReturnTime, formatter);
	}
}
