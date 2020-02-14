package com.services.webservice.service.dto.Equip;

import com.services.webservice.domain.Equipment.EquipState;
import com.services.webservice.domain.Equipment.Equipment;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ReqEquipListDto {

	private String equipName;
	
	private int equipSeqNum;
	
	private String equipNum;
	
	private EquipState equipStateId;
	
	private boolean isAvailable;

	@Builder
	public ReqEquipListDto(String equipName, int equipSeqNum, String equipNum, EquipState equipStateId,
			boolean isAvailable) {
		super();
		this.equipName = equipName;
		this.equipSeqNum = equipSeqNum;
		this.equipNum = equipNum;
		this.equipStateId = equipStateId;
		this.isAvailable = isAvailable;
	}

	public Equipment toEntity() {
		return Equipment.builder()
			.equipName(equipName)
			.equipNum(equipNum)
			.equipSeqNum(equipSeqNum)
			.equipStateId(equipStateId)
			.isAvailable(isAvailable)
			.build();
	}
}
