package com.services.webservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	private String role;
	
	public void setRole(String role) {
		this.role = role.toUpperCase();
	}

	@Builder
	public Role(Long id, String role) {
		this.id = id;
		this.role = role;
	}	
}