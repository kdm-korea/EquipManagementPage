package com.services.webservice.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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

	@ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(foreignKey = @ForeignKey(name = "fk_user_to_role"))
	private Set<Role> roles;

	@Builder
	public User(Long id, String studentNum, String password, String name, String phoneNumber, Set<Role> roles) {
		this.id = id;
		this.studentNum = studentNum;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.roles = roles;
	}
}
