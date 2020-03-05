package com.services.webservice.domain.Equipment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipStateRepository extends JpaRepository<EquipState, Long>{

	EquipState findByState(String state);
}
