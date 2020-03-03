package com.services.webservice.domain.RentalLog;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EquipRentalLogRepository extends JpaRepository<EquipRentalLog, Long> {
	@Query("Select count(p) from EquipRentalLog p "
			+ "where p.equipId.equipName = :equipName "
			+ "and p.memberId.studentNum = :studentNum "
			+ "and p.isOverdue = false")
	int findbyMemberRentalSameEquipCount(@Param("studentNum") String studentNum, @Param("equipName") String equipName);
	
	@Query("Select p From EquipRentalLog p "
			+ "Where p.equipId.equipNum = :equipNum "
			+ "and p.memberId.studentNum = :studentNum "
			+ "and p.realReturnTime = null")
	List<EquipRentalLog> findbyMemberRentalSameEquip(@Param("studentNum") String studentNum, @Param("equipNum") String equipNum);
}
