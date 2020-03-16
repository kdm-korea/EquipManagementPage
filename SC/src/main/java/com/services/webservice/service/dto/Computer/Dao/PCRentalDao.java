package com.services.webservice.service.dto.Computer.Dao;

import java.time.LocalDateTime;

import com.services.webservice.domain.Equipment.Computer;
import com.services.webservice.domain.Member.Member;
import com.services.webservice.domain.RentalLog.PCRentalLog;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PCRentalDao {
	private Member memberId;

	private Computer pcId;

	private LocalDateTime rentalTime;

	private LocalDateTime predictReturnTime;

	private String reason;

	@Builder
	public PCRentalDao(Member memberId, Computer pcId, LocalDateTime rentalTime, LocalDateTime predictReturnTime,
			String reason) {
		super();
		this.memberId = memberId;
		this.pcId = pcId;
		this.rentalTime = rentalTime;
		this.predictReturnTime = predictReturnTime;
		this.reason = reason;
	}

	public PCRentalLog toEntity() {
		return PCRentalLog.builder()
				.member(memberId)
				.pc(pcId)
				.rentalTime(rentalTime)
				.predictReturnTime(predictReturnTime)
				.realReturnTime(null)
				.reason(reason)
				.isOverdue(false)
				.build();
	}
	
}
