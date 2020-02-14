package com.services.webservice.service.dto.Equip;

import com.services.webservice.domain.Equipment.EquipState;
import com.services.webservice.domain.Equipment.Equipment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResEquipListDto {

	private String equipName;

	private int equipSeqNum;

	private String equipNum;

	private String equipState;

	private boolean isAvailable;

	@Builder
	public ResEquipListDto(Equipment equip) {
		this.equipName = equip.getEquipName();
		this.equipSeqNum = equip.getEquipSeqNum();
		this.equipNum = equip.getEquipNum();
		this.equipState = equip.getEquipStateId().getState();
		this.isAvailable = equip.isAvailable();
	}
}
