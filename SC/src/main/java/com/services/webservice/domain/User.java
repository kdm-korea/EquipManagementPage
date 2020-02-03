package com.services.webservice.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

//	@ManyToOne(targetEntity = Equipment.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(foreignKey = @ForeignKey(name = "fk_equitment_id"))
	
	@ManyToOne(targetEntity = Role.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_role_id"))
	private Set<Role> roleId;

	@Builder
	public User(Long id, String studentNum, String password, String name, String phoneNumber, Set<Role> roleId) {
		this.id = id;
		this.studentNum = studentNum;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.roleId = roleId;
	}
}
