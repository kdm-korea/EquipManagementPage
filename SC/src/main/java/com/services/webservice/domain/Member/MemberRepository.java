package com.services.webservice.domain.Member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long>{
	List<Member> findByName(String name);
	
	Member findByStudentNum(String studentNum);
	
	int countByStudentNum(String studentNum);
	
	@Modifying
	@Query("Update Member m Set m.password = :pw Where m.id = :id")
	int updatePw(@Param("pw") String pw, @Param("id")long id);
	
}
