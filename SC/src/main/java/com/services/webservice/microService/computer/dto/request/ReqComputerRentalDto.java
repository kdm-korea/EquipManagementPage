package com.services.webservice.microService.computer.dto.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import com.services.webservice.library.dto.TimeFormatter;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ReqComputerRentalDto extends TimeFormatter {
	@NotEmpty
	private long memberId;

	@NotEmpty
	private long pcId;

	private LocalDateTime rentalTime;

	private LocalDateTime predictReturnTime;

	private String reason;

	@Builder
	public ReqComputerRentalDto(long memberId, long pcId, LocalDateTime rentalTime, LocalDateTime predictReturnTime,
			String reason) {
		super();
		this.memberId = memberId;
		this.pcId = pcId;
		this.rentalTime = rentalTime;
		this.predictReturnTime = predictReturnTime;
		this.reason = reason;
	}
	
	public void setRentalTime(String rentalTime) {
		this.rentalTime = LocalDateTime.parse(rentalTime, formatter);
	}

	public void setPredictReturnTime(String predictReturnTime) {
		this.predictReturnTime = LocalDateTime.parse(predictReturnTime, formatter);
	}	
}
