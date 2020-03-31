package com.services.webservice.microService.computer.dto.request;

import java.time.LocalDateTime;

import com.services.webservice.library.dto.TimeFormatter;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
