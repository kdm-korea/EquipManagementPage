package com.services.webservice.domain.RentalLog;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PCRentalLogRepository extends JpaRepository<PCRentalLog, Long>{
	@Modifying
	@Query("Update PCRentalLog p set p.realReturnTime = :realReturnTime "
			+ "where p.memberId.id = :memberId "
			+ "and p.pcId.id = :pcId "
			+ "and p.realReturnTime = null")
	void updateReturnPC(@Param("memberId") long memberId, @Param("pcId") long pcId, @Param("realReturnTime") LocalDateTime realReturnTime);
	
	@Query("Select count(p) From PCRentalLog p "
			+ "where p.memberId.id = :memberId "
			+ "and p.realReturnTime = null")
	int findbyMemberRentalPCCount(@Param("memberId") long memberId);
	
	@Query("Select p From PCRentalLog p "
			+ "Where p.memberId.id = :memberId "
			+ "and p.pcId.id = :pcId "
			+ "and p.realReturnTime = null")
	List<EquipRentalLog> findbyMemberRentalSamePC(@Param("memberId") long memberId, @Param("pcId") long pcId);
}
