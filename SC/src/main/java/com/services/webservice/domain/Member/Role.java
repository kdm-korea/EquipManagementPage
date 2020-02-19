package com.services.webservice.domain.Member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.services.webservice.domain.ERole;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Role {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true, nullable = false)
	@Enumerated(EnumType.STRING)
	private ERole role;
	
	@Builder
	public Role(Long id, ERole role) {
		this.id = id;
		this.role = role;
	}	
}
