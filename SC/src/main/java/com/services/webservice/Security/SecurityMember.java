package com.services.webservice.Security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.services.webservice.domain.Member.Member;
import com.services.webservice.domain.Member.Role;

public class SecurityMember extends User {

	private static final String ROLE_PREFIX = "ROLE_";
	private static final long serialVersionUID = 1L;

	public SecurityMember(Member member) {
		super(member.getStudentNum(), member.getPassword(), makeGrantedAuthority(member.getRoleId()));
	}

	private static List<GrantedAuthority> makeGrantedAuthority(Role roles) {
		List<GrantedAuthority> grants = new ArrayList<GrantedAuthority>();
		grants.add(new SimpleGrantedAuthority(ROLE_PREFIX + roles.getRole()));
		return grants;
	}

}
