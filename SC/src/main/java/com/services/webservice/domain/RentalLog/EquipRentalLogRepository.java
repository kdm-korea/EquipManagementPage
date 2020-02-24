package com.services.webservice.domain.RentalLog;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EquipRentalLogRepository extends JpaRepository<EquipRentalLog, Long> {
	@Transactional
	@Query("Select count(p) from EquipRentalLog p "
			+ "where p.equipId.equipName = :equipName "
			+ "and p.memberId.studentNum = :studentNum "
			+ "and p.isOverdue = false")
	int findByMemberRentalSameEquipCount(@Param("studentNum") String studentNum, @Param("equipName") String equipName);
}
