package com.services.webservice.domain.RentalLog;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.services.webservice.domain.BaseTimeEntity;
import com.services.webservice.domain.Equipment.Equipment;
import com.services.webservice.domain.Member.Member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "EQUIPRENTALLOG")
public class EquipRentalLog extends BaseTimeEntity {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, foreignKey = @ForeignKey(name = "fk_Member_to_equipRentalLog_id"))
	private Member memberId;

	@ManyToOne(targetEntity = Equipment.class, fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, foreignKey = @ForeignKey(name = "fk_equitment_id"))
	private Equipment equipId;

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
	public EquipRentalLog(Long id, Member memberId, Equipment equipId, LocalDateTime rentalTime,
			LocalDateTime predictReturnTime, LocalDateTime realReturnTime, boolean isOverdue, String reason) {
		this.id = id;
		this.memberId = memberId;
		this.equipId = equipId;
		this.rentalTime = rentalTime;
		this.predictReturnTime = predictReturnTime;
		this.realReturnTime = realReturnTime;
		this.isOverdue = isOverdue;
		this.reason = reason;
	}
}