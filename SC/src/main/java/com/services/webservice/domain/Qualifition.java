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

	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_user_ida"))
	private User userId;

	@Column(nullable = false)
	private LocalDateTime limiteStartDay;

	@Column(nullable = false)
	private LocalDateTime limiteEndDay;

	@Column(columnDefinition = "TEXT", nullable = true)
	private String reason;

	@Builder
	public Qualifition(Long id, User userId, LocalDateTime limiteStartDay, LocalDateTime limiteEndDay,
			String reason) {
		this.id = id;
		this.userId = userId;
		this.limiteStartDay = limiteStartDay;
		this.limiteEndDay = limiteEndDay;
		this.reason = reason;
	}
}
