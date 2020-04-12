package com.services.webservice.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.services.webservice.domain.Member.Member;
import com.services.webservice.domain.Member.Role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDetail extends User {

	private static final String ROLE_PREFIX = "ROLE_";
	private static final long serialVersionUID = 1L;
	
	private long id;
	public String name;
	public String phoneNumber;

	public MemberDetail(Member member) {
		super(member.getStudentNum(), member.getPassword(), makeGrantedAuthority(member.getRole()));
		this.id = member.getId();
		this.name = member.getName();
		this.phoneNumber = member.getPhoneNumber();
	}

	private static List<GrantedAuthority> makeGrantedAuthority(Role roles) {
		List<GrantedAuthority> grants = new ArrayList<GrantedAuthority>();
		grants.add(new SimpleGrantedAuthority(ROLE_PREFIX + roles.getRole()));
		return grants;
	}

}
