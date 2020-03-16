package com.services.webservice.service.dto.Equip.Dao;

import java.time.LocalDateTime;

import com.services.webservice.domain.Equipment.Equipment;
import com.services.webservice.domain.Member.Member;
import com.services.webservice.domain.RentalLog.EquipRentalLog;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EquipRentalDao {
	
	private Member memberId;
	
	private Equipment equipId;
	
	private LocalDateTime rentalTime;
	
	private LocalDateTime predictReturnTime;
	
	private LocalDateTime realReturnTime;
	
	private String reason;

	@Builder
	public EquipRentalDao(Member memberId, Equipment equipId, LocalDateTime rentalTime,
			LocalDateTime predictReturnTime, String reason) {
		super();
		this.memberId = memberId;
		this.equipId = equipId;
		this.rentalTime = rentalTime;
		this.predictReturnTime = predictReturnTime;
		this.reason = reason;
	}
	
	public EquipRentalLog toEntity() {
		return EquipRentalLog.builder()
				.member(memberId)
				.equip(equipId)
				.rentalTime(rentalTime)
				.predictReturnTime(predictReturnTime)
				.realReturnTime(null)
				.isOverdue(false)
				.reason(reason)
				.build();
	}
}
