package com.services.webservice.domain.Equipment;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Equipment extends BaseTimeEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String equipName;

	@Column(nullable = false)
	private int equipSeqNum;
	
	@Column(unique = true, nullable = true)
	private String equipNum;
	
	@ManyToOne(targetEntity = EquipState.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "equipState_id", foreignKey = @ForeignKey(name = "fk_equipment_to_equipState_id"))
	private EquipState equipStateId;
	
	@Column(columnDefinition = "boolean")
	private boolean isAvailable;
	
	@Column(columnDefinition = "TEXT", nullable = true)
	private String reason;

	@Builder
	public Equipment(Long id, String equipName, int equipSeqNum, String equipNum, EquipState equipStateId,
			boolean isAvailable, String reason) {
		this.id = id;
		this.equipName = equipName;
		this.equipSeqNum = equipSeqNum;
		this.equipNum = equipNum;
		this.equipStateId = equipStateId;
		this.isAvailable = isAvailable;
		this.reason = reason;
	}
}
