package com.services.webservice.domain.Equipment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "EQUIPSTATE")
public class EquipState {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String state;

	@Builder
	public EquipState(Long id, String state) {
		this.id = id;
		this.state = state;
	}
}