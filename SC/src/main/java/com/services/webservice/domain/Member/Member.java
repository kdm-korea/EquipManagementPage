package com.services.webservice.domain.Member;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.services.webservice.library.entity.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
public class Member extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private Role role;

	@Builder
	public Member(Long id, String studentNum, String password, String name, String phoneNumber, Role role) {
		this.id = id;
		this.studentNum = studentNum;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}
}
