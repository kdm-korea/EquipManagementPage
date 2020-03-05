package com.services.webservice.service.dto.Equip.Save;

import java.time.LocalDateTime;

import com.services.webservice.domain.Equipment.Equipment;
import com.services.webservice.domain.Member.Member;
import com.services.webservice.domain.RentalLog.EquipRentalLog;
import com.services.webservice.service.dto.Equip.Save.SaveEquipRentalDto.SaveEquipRentalDtoBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveEquipReturnDto {
	private Member memberId;
	
	private Equipment equipId;
	
	private LocalDateTime rentalTime;
	
	private LocalDateTime predictReturnTime;
	
	private LocalDateTime realReturnTime;
	
	private String reason;

	@Builder
	public SaveEquipReturnDto(Member memberId, Equipment equipId, LocalDateTime rentalTime,
			LocalDateTime predictReturnTime, LocalDateTime realReturnTime, String reason) {
		super();
		this.memberId = memberId;
		this.equipId = equipId;
		this.rentalTime = rentalTime;
		this.predictReturnTime = predictReturnTime;
		this.realReturnTime = realReturnTime;
		this.reason = reason;
	}
	public EquipRentalLog toEntity() {
		return EquipRentalLog.builder()
			.memberId(memberId)
			.equipId(equipId)
			.rentalTime(rentalTime)
			.predictReturnTime(predictReturnTime)
			.realReturnTime(realReturnTime)
			.reason(reason)
			.build();
	}

	
}
