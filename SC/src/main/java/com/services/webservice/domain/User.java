package com.services.webservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
public class User extends BaseTimeEntity{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String studentNum;

	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = true)
	private String phoneNumber;

	@Builder
	public User(Long id, long studentNum, String name, String phoneNumber) {
		this.id = id;
		this.studentNum = studentNum;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
}
