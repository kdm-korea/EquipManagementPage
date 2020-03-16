package com.services.webservice.service.dto.Equip.Response;

import com.services.webservice.domain.Equipment.Equipment;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResEquipListDto {

	private long id;

	private String equipName;

	private int equipSeqNum;

	private String equipNum;

	private String equipState;

	@Builder
	public ResEquipListDto(Equipment equip) {
		this.id = equip.getId();
		this.equipName = equip.getEquipName();
		this.equipSeqNum = equip.getEquipSeqNum();
		this.equipNum = equip.getEquipNum();
		this.equipState = equip.getEquipState().getState();
	}
}
