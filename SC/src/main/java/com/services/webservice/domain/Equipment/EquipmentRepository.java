package com.services.webservice.domain.Equipment;

import java.util.List;

import javax.transaction.Transactional;

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
	
	Equipment findByEquipNum(String equipNum);
	
	@Transactional
	@Modifying
	@Query("Update Equipment e set e.isAvailable = false, e.equipStateId = :equipState Where e.equipNum = :equipNum")
	void updatebyRentalEquip(@Param("equipNum") String equipNum, @Param("equipState")EquipState equipState);
}
