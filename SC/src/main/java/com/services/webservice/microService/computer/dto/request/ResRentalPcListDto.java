package com.services.webservice.microService.computer.dto.request;

import java.time.LocalDateTime;

import com.services.webservice.domain.RentalLog.PCRentalLog;

import lombok.Getter;

@Getter
public class ResRentalPcListDto {

	private long id;
	
	private String pcNum;
	
	private LocalDateTime rentalTime;
	
	private LocalDateTime predictReturnTime;
	
	private String reason;
	
	public ResRentalPcListDto(PCRentalLog log) {
		this.id = log.getPc().getId();
		this.pcNum = log.getPc().getClassName() + " " + log.getPc().getPcSeqNum();
		this.rentalTime = log.getRentalTime();
		this.predictReturnTime = log.getPredictReturnTime();
		this.reason = log.getReason();
	}
}
