package com.services.webservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.services.webservice.domain.Equipment.EquipmentRepository;
import com.services.webservice.domain.RentalLog.EquipRentalLogRepository;
import com.services.webservice.service.MemberService.EquipService.MemberEquipService;
import com.services.webservice.service.dto.Equip.Request.ReqEquipRentalDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class MemberEquipServiceTest {

	@Autowired
	private MemberEquipService memberEquipService;

	@Autowired
	private EquipmentRepository equipRepo;
	
	@Autowired
	private EquipRentalLogRepository rentalRepo;
	
	@Test
	public void saveEquipmentRentalLogfindByEquipNumTest() {
		ReqEquipRentalDto dto = ReqEquipRentalDto.builder()
				.equipName("VR기기")
				.equipNum("1234")
				.rentalTime(LocalDateTime.now())
				.predictReturnTime(LocalDateTime.now())
				.reason("수업시간에 필요함")
				.studentNum("2019631001")
				.build();
				
		memberEquipService.executeEquipRental(dto);
		assertEquals(equipRepo.findByEquipNum("1234").isAvailable(), false);
	}
	
	@Test
	public void saveEquipmentRentalLogSaveTest() {
		System.out.println("3");
		ReqEquipRentalDto dto = ReqEquipRentalDto.builder()
				.equipName("VR기기")
				.equipNum("1234")
				.rentalTime(LocalDateTime.now())
				.predictReturnTime(LocalDateTime.now())
				.reason("수업시간에 필요함")
				.studentNum("2019631001")
				.build();
		System.out.println("3");		
		memberEquipService.executeEquipRental(dto);
		System.out.println("5");
		assertEquals(rentalRepo.findAll().get(0).getReason(), "수업시간에 필요함");
	}
}
