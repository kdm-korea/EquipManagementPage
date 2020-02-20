package com.services.webservice.domain.Equipment;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.services.webservice.domain.EState;

public interface EquipmentRepository extends JpaRepository<Equipment, Long>{
	@Modifying
	@Query("SELECT p " +
            "FROM Equipment p " +
			"WHERE p.isAvailable = 'true'"+
            "ORDER BY p.equipName DESC")
	List<Equipment> findAllbyOrderByDesc();
	
	Equipment findByEquipNum(String equipNum);
}
