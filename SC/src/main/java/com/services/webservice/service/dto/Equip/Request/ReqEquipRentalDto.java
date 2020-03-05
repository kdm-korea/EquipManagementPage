package com.services.webservice.service.dto.Equip.Request;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqEquipRentalDto {
	
	private String studentNum;
	
	private String equipName;
	
	private String equipNum;
	
	private String reason;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime rentalTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime predictReturnTime;

	@Builder
	public ReqEquipRentalDto(String studentNum, String equipName, String equipNum, String reason,
			LocalDateTime rentalTime,  LocalDateTime predictReturnTime) {
		super();
		this.studentNum = studentNum;
		this.equipName = equipName;
		this.equipNum = equipNum;
		this.reason = reason;
		this.rentalTime = rentalTime;
		this.predictReturnTime = predictReturnTime;
	}
}
