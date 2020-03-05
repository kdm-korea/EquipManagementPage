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
import javax.persistence.Table;

import com.services.webservice.domain.BaseTimeEntity;
import com.services.webservice.domain.Equipment.Computer;
import com.services.webservice.domain.Member.Member;

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

	@ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_ide"))
	private Member memberId;

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
	public PCRentalLog(Long id, Member memberId, Computer pcId, LocalDateTime rentalTime, LocalDateTime predictReturnTime,
			LocalDateTime realReturnTime, String reason, boolean isOverdue) {
		this.id = id;
		this.memberId = memberId;
		this.pcId = pcId;
		this.rentalTime = rentalTime;
		this.predictReturnTime = predictReturnTime;
		this.realReturnTime = realReturnTime;
		this.reason = reason;
		this.isOverdue = isOverdue;
	}
}
