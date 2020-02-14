package com.services.webservice.domain.Equipment;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EquipmentRepository extends JpaRepository<Equipment, Long>{
	@Query("SELECT p " +
            "FROM Equipment p " +
            "ORDER BY p.equipName DESC")
	List<Equipment> findAllbyOrderByDesc();
}
