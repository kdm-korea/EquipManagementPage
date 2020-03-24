package com.services.webservice.domain.RentalLog;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

import com.services.webservice.domain.Equipment.Equipment;
import com.services.webservice.domain.Member.Member;
import com.services.webservice.library.entity.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class EquipRentalLog extends BaseTimeEntity {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(targetEntity = Member.class, fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, foreignKey = @ForeignKey(name = "fk_Member_to_equipRentalLog_id"))
	private Member member;

	@ManyToOne(targetEntity = Equipment.class, fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, foreignKey = @ForeignKey(name = "fk_equitment_id"))
	private Equipment equip;

	@Column(nullable = true)
	private LocalDateTime rentalTime;

	@Column(nullable = true)
	private LocalDateTime predictReturnTime;

	@Column(nullable = true)
	private LocalDateTime realReturnTime;

	@Column(columnDefinition = "boolean")
	@ColumnDefault("false")
	private boolean isOverdue;

	@Column(columnDefinition = "TEXT", nullable = true)
	private String reason;

	@Builder
	public EquipRentalLog(Long id, Member member, Equipment equip, LocalDateTime rentalTime,
			LocalDateTime predictReturnTime, LocalDateTime realReturnTime, boolean isOverdue, String reason) {
		this.id = id;
		this.member = member;
		this.equip = equip;
		this.rentalTime = rentalTime;
		this.predictReturnTime = predictReturnTime;
		this.realReturnTime = realReturnTime;
		this.isOverdue = isOverdue;
		this.reason = reason;
	}
	
	@Override
	public String toString() {
		return "EquipRentalLog [ id:: " + this.id 
				+ ",  memberId:: " + this.member
				+ ",  memberId:: " + this.equip
				+ ",  rentalTime:: " + this.rentalTime
				+ ",  predictReturnTime:: " + this.predictReturnTime
				+ ",  realReturnTime:: " + this.realReturnTime
				+ ",  isOverdue:: " + this.isOverdue
				+ ",  reason:: " + this.reason;
				
	}
}