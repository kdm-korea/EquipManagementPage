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

import com.services.webservice.domain.Member.Member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Qualifition {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_Member_ida"))
	private Member memberId;

	@Column(nullable = false)
	private LocalDateTime limiteStartDay;

	@Column(nullable = false)
	private LocalDateTime limiteEndDay;

	@Column(columnDefinition = "TEXT", nullable = true)
	private String reason;

	@Builder
	public Qualifition(Long id, Member memberId, LocalDateTime limiteStartDay, LocalDateTime limiteEndDay,
			String reason) {
		this.id = id;
		this.memberId = memberId;
		this.limiteStartDay = limiteStartDay;
		this.limiteEndDay = limiteEndDay;
		this.reason = reason;
	}
}
