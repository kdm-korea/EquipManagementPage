package com.services.webservice.service.dto.Computer.Response;

import com.services.webservice.domain.Equipment.Computer;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResComputerListDto {

	private Long pcId;
	
	private String className;
	
	private int pcSeqNum;
	
	private String equipNum;
	
	private boolean isAvailable;

	@Builder
	public ResComputerListDto(Long pcId, String className, int pcSeqNum, String equipNum, boolean isAvailable) {
		super();
		this.pcId = pcId;
		this.className = className;
		this.pcSeqNum = pcSeqNum;
		this.equipNum = equipNum;
		this.isAvailable = isAvailable;
	}
	
	public ResComputerListDto(Computer entity) {
		this.pcId = entity.getId();
		this.className = entity.getClassName();
		this.pcSeqNum = entity.getPcSeqNum();
		this.equipNum = entity.getEquipNum();
		this.isAvailable = entity.isAvailable();
	}
}
