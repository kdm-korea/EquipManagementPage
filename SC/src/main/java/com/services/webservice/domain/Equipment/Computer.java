package com.services.webservice.domain.Equipment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.services.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Computer extends BaseTimeEntity {

	@Id
	@GeneratedValue
	private Long pcId;

	@Column(nullable = false)
	private String className;

	@Column(nullable = false)
	private int pcSeqNum;

	@Column(unique = true, nullable = false)
	private String equipNum;

	@ManyToOne(targetEntity = EquipState.class, fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_computer_to_equipState_id"))
	private EquipState equipStateId;
	
	@Column(columnDefinition = "boolean")
	private boolean isAvailable;

	@Column(columnDefinition = "TEXT", nullable = true)
	private String reason;
	
	@Builder
	public Computer(Long pcId, String className, int pcSeqNum, String equipNum, EquipState equipStateId, boolean isAvailable,
			String reason) {
		this.pcId = pcId;
		this.className = className;
		this.pcSeqNum = pcSeqNum;
		this.equipNum = equipNum;
		this.equipStateId = equipStateId;
		this.isAvailable = isAvailable;
		this.reason = reason;
	}
}
