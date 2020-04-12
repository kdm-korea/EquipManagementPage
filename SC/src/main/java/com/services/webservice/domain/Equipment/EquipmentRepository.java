package com.services.webservice.domain.Equipment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EquipmentRepository extends JpaRepository<Equipment, Long>{
	@Query("SELECT p " +
            "FROM Equipment p " +
			"WHERE p.isAvailable = 'true'"+
            "ORDER BY p.equipName DESC")
	List<Equipment> findAllbyOrderByDesc();
	
	@Modifying
	@Query("Update Equipment e set e.isAvailable = :isAvailable, e.equipState = :equipState Where e.id = :equipId")
	void updatebyRentalEquip(@Param("equipId") long equipNum, @Param("equipState")EquipState equipState, @Param("isAvailable")boolean isAvailable);

	Equipment findByEquipNum(String equipNum);
}
