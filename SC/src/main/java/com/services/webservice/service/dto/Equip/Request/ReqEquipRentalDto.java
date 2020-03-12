package com.services.webservice.service.dto.Equip.Request;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.services.webservice.library.TimeFormatter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqEquipRentalDto extends TimeFormatter {
	
	private long memberId;
	
	private long equipId;
	
	private String reason;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime rentalTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime predictReturnTime;

	@Builder
	public ReqEquipRentalDto(long memberId, long equipId, String reason, LocalDateTime rentalTime,
			LocalDateTime predictReturnTime) {
		super();
		this.memberId = memberId;
		this.equipId = equipId;
		this.reason = reason;
		this.rentalTime = rentalTime;
		this.predictReturnTime = predictReturnTime;
	}
	
	public void setRentalTime(String rentalTime) {
		this.rentalTime = LocalDateTime.parse(rentalTime, formatter);
	}
	
	public void setPredictReturnTime(String predictReturnTime) {
		this.rentalTime = LocalDateTime.parse(predictReturnTime, formatter);
	}
}
