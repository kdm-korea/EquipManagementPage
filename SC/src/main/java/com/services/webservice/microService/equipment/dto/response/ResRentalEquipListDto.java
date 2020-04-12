package com.services.webservice.microService.equipment.dto.response;

import java.time.LocalDateTime;

import com.services.webservice.domain.RentalLog.EquipRentalLog;
import com.services.webservice.library.dto.TimeFormatter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResRentalEquipListDto extends TimeFormatter{
	
	private long equipId;
	
	private String equipName;
	
	private LocalDateTime rentalTime;
	
	private  LocalDateTime predictReturnTime;
	
	private String reason;
	
	public ResRentalEquipListDto(EquipRentalLog log) {
		this.equipId = log.getEquip().getId();
		this.equipName = log.getEquip().getEquipName();
		this.rentalTime = log.getRentalTime();
		this.predictReturnTime = log.getPredictReturnTime();
		this.reason = log.getReason();
	}
}
