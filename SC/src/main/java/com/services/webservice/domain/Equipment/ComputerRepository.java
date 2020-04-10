package com.services.webservice.domain.Equipment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ComputerRepository extends JpaRepository<Computer, Long>{
	@Query("SELECT c " +
            "FROM Computer c " +
			"WHERE c.isAvailable = 'true'")
	List<Computer> findAllbyAvailable();
	
	@Modifying
	@Query("Update Computer c set c.isAvailable = :isAvailable, c.equipState = :equipState Where c.id = :pcId")
	void updatebyRentalPC(@Param("pcId") long pcId, @Param("equipState")EquipState equipState, @Param("isAvailable") boolean isAvailable);
}
