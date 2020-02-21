package com.services.webservice.domain.RentalLog;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EquipRentalLogRepository extends JpaRepository<EquipRentalLog, Long> {
//	@Modifying
//	@Query(value = "Select * from EquipRentalLog "
//							+ "where select * from Equipment "
//												+ "where equipNum=:equipNum")
	
//	@Modifying
	@Transactional
	@Query("Select count(p) from EquipRentalLog p "
			+ "where p.equipId.equipName = :equipName and p.memberId.studentNum = :studentNum")
	int findByMemberRentalSameEquip(@Param("studentNum") String studentNum, @Param("equipName") String equipName);
}
