package com.services.webservice.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByName(String name);
	User findByStudentNum(Long studentNum);
}
