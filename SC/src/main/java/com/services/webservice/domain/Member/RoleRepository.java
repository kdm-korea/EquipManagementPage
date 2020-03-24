package com.services.webservice.domain.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByRole(String e);
}
