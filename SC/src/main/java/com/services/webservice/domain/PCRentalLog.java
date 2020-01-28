package com.services.webservice.domain;

import java.time.LocalDateTime;

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
@Entity
@Getter
@Table(name = "PCRENTALLOG")
public class PCRentalLog extends BaseTimeEntity {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_ide"))
	private User userId;

	@ManyToOne(targetEntity = Computer.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "computer_id",foreignKey = @ForeignKey(name = "fk_computer_idf"))
	private Computer pcId;

	@Column(nullable = false)
	private LocalDateTime rentalTime;

	@Column(nullable = false)
	private LocalDateTime predictReturnTime;

	@Column(nullable = true)
	private LocalDateTime realReturnTime;

	@Column(nullable = true)
	private String reason;

	@Column(columnDefinition = "boolean")
	private boolean isOverdue;

	@Builder
	public PCRentalLog(Long id, User userId, Computer pcId, LocalDateTime rentalTime, LocalDateTime predictReturnTime,
			LocalDateTime realReturnTime, String reason, boolean isOverdue) {
		this.id = id;
		this.userId = userId;
		this.pcId = pcId;
		this.rentalTime = rentalTime;
		this.predictReturnTime = predictReturnTime;
		this.realReturnTime = realReturnTime;
		this.reason = reason;
		this.isOverdue = isOverdue;
	}
}
