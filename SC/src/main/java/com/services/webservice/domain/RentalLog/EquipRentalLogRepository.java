package com.services.webservice.domain.RentalLog;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EquipRentalLogRepository extends JpaRepository<EquipRentalLog, Long> {
	@Modifying
	@Query("Update EquipRentalLog p set p.realReturnTime = :realReturnTime "
			+ "where p.member.id = :memberId "
			+ "and p.equip.id = :equipId "
			+ "and p.realReturnTime = null")
	int updateReturnEquip(@Param("memberId") long memberId, @Param("equipId") long equipId, @Param("realReturnTime") LocalDateTime realReturnTime);
	
	@Query("Select count(p) From EquipRentalLog p "
			+ "where p.equip.id = :equipId "
			+ "and p.member.id = :memberId "
			+ "and p.realReturnTime = null")
	int findbyMemberRentalSameEquipCount(@Param("memberId") long memberId, @Param("equipId") long equipId);
	
	@Query("Select p From EquipRentalLog p "
			+ "Where p.member.id = :memberId "
			+ "and p.realReturnTime = null")
	List<EquipRentalLog> findbyMemberRentalSameEquip(@Param("memberId") long memberId);
}
