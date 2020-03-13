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
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
public class Computer extends BaseTimeEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String className;

	@Column(nullable = false)
	private int pcSeqNum;

	@Column(unique = true, nullable = false)
	private String equipNum;

	@ManyToOne(targetEntity = EquipState.class, fetch = FetchType.EAGER)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_computer_to_equipState_id"))
	private EquipState equipStateId;
	
	@Column(columnDefinition = "boolean")
	private boolean isAvailable;

	@Column(columnDefinition = "TEXT", nullable = true)
	private String reason;
	
	@Builder
	public Computer(Long id, String className, int pcSeqNum, String equipNum, EquipState equipStateId, boolean isAvailable,
			String reason) {
		this.id = id;
		this.className = className;
		this.pcSeqNum = pcSeqNum;
		this.equipNum = equipNum;
		this.equipStateId = equipStateId;
		this.isAvailable = isAvailable;
		this.reason = reason;
	}
	
	
}
