package com.services.webservice.domain;

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

	@ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_user_to_equipRentalLog_id"))
	private User userId;

	@ManyToOne(targetEntity = Equipment.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_equitment_id"))
	private Equipment equipId;

	@Column(nullable = false)
	private LocalDateTime rentalTime;

	@Column(nullable = false)
	private LocalDateTime predictReturnTime;

	@Column(nullable = true)
	private LocalDateTime realReturnTime;

	@Column(columnDefinition = "boolean")
	private boolean isOverdue;

	@Column(columnDefinition = "TEXT", nullable = true)
	private String reason;

	@Builder
	public EquipRentalLog(Long id, User userId, Equipment equipId, LocalDateTime rentalTime,
			LocalDateTime predictReturnTime, LocalDateTime realReturnTime, boolean isOverdue, String reason) {
		this.id = id;
		this.userId = userId;
		this.equipId = equipId;
		this.rentalTime = rentalTime;
		this.predictReturnTime = predictReturnTime;
		this.realReturnTime = realReturnTime;
		this.isOverdue = isOverdue;
		this.reason = reason;
	}
}